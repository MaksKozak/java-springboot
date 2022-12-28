package ua.com.owu.javaspringboot.security.filter;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import ua.com.owu.javaspringboot.dao.CustomerDAO;
import ua.com.owu.javaspringboot.models.Customer;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

public class CustomFilter extends OncePerRequestFilter {

    public CustomFilter(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    private CustomerDAO customerDAO;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Bearer ")) {
            String token = authorization.replace("Bearer ", "");

            String subject = Jwts.parser()
                    .setSigningKey("okten".getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

            Customer customerByLogin = customerDAO.findCustomerByLogin(subject);

            if (customerByLogin != null) {
                SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(
                                customerByLogin.getLogin(),
                                customerByLogin.getPassword(),
                                Collections.singletonList(new SimpleGrantedAuthority(customerByLogin.getRole())
                                )
                        ));

            }


        }


        filterChain.doFilter(request, response);
    }
}
