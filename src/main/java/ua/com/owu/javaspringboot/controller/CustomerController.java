package ua.com.owu.javaspringboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.javaspringboot.dao.CustomerDAO;
import ua.com.owu.javaspringboot.models.Customer;
import ua.com.owu.javaspringboot.models.DTO.CustomerDTO;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {


    private CustomerDAO customerDAO;

    @GetMapping("")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> getAll = customerDAO.findAll();
        return new ResponseEntity<>(getAll, HttpStatusCode.valueOf(200));
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCustomer(@RequestBody Customer customer) {
        customerDAO.save(customer);

    }

    @GetMapping("/{id}")
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



}









//        save,
//        get all ,
//        get by id,
//        patch by id,
//        delete by id
//        get all by name ,
//        get all by surname


