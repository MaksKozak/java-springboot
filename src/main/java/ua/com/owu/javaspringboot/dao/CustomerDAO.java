package ua.com.owu.javaspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.owu.javaspringboot.models.Customer;

import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {



    @Query("select c from Customer c where c.name=:name")
    List<Customer> getAllByName(@Param("name") String name);


}
