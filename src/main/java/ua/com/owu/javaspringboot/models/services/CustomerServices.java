package ua.com.owu.javaspringboot.models.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.owu.javaspringboot.dao.CustomerDAO;
import ua.com.owu.javaspringboot.models.Customer;

@Service
@AllArgsConstructor
public class CustomerServices {
    private CustomerDAO customerDAO;

    private MailServices mailServices;

    public void save(Customer customer) {
        customerDAO.save(customer);
        mailServices.send(customer);
    }

    public Customer getCustomerById(int id) {
        return customerDAO.findById(id).get();
    }
    public void updateCustomer (Customer customer) {
        customerDAO.save(customer);
    }

}
