package ua.com.owu.javaspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.javaspringboot.models.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {

    Customer findCustomerByLogin(String login);
}
