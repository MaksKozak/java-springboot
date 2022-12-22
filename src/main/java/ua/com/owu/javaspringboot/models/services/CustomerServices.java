package ua.com.owu.javaspringboot.models.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.owu.javaspringboot.dao.CustomerDAO;
import ua.com.owu.javaspringboot.models.Customer;

@Service
@AllArgsConstructor
public class CustomerServices {
    private CustomerDAO customerDAO;
    public void save(Customer customer) {
        if (customer.getId()>0) {
            customerDAO.save(customer);
        }else {
            throw new RuntimeException("id menshe 0 debil");
        }
    }
}
