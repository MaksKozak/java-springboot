package ua.com.owu.javaspringboot.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.javaspringboot.dao.CustomerDAO;
import ua.com.owu.javaspringboot.models.Customer;
import ua.com.owu.javaspringboot.models.dto.CustomerDTO;
import ua.com.owu.javaspringboot.models.services.CustomerServices;
import ua.com.owu.javaspringboot.models.views.Views;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {


    private CustomerDAO customerDAO;

    private CustomerServices customerServices;

    @GetMapping("")
    @JsonView(Views.Client.class)
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> getAll = customerDAO.findAll();
        return new ResponseEntity<>(getAll, HttpStatusCode.valueOf(200));
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCustomer(@RequestBody Customer customer) {
//        customerDAO.save(customer);
        customerServices.save(customer);

    }

    @GetMapping("/{id}")
    @JsonView(Views.Admin.class)
    public ResponseEntity<Customer> getById(@PathVariable int id) {
        Customer customer = customerDAO.findById(id).get();
        return new ResponseEntity<>(customer, HttpStatusCode.valueOf(200));
    }

    @PatchMapping("/{id}")
    public void patchById(@PathVariable int id, @RequestBody CustomerDTO customerDTO) {
        Customer customer = customerDAO.findById(id).get();
        customer.setName(customerDTO.getUsername());
        customerDAO.save(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        customerDAO.deleteById(id);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Customer>> getAllByName(@PathVariable String name) {
        return new ResponseEntity<>(customerDAO.getAllByName("Maks"), HttpStatusCode.valueOf(200));
    }


    @GetMapping("/activate/{id}")
    public void activateCustomer(@PathVariable int id) {
        Customer customer = customerServices.getCustomerById(id);
        customer.setActivated(true);
        customerServices.updateCustomer(customer);
    }

}












