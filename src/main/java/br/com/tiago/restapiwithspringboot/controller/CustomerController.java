package br.com.tiago.restapiwithspringboot.controller;

import br.com.tiago.restapiwithspringboot.entity.Customer;
import br.com.tiago.restapiwithspringboot.exception.ResponseGenericException;
import br.com.tiago.restapiwithspringboot.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/customer")
@Api(value = "Api Rest for Customer Management")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/list")
    @Operation(summary = "List all the customers")
    public ResponseEntity<Object> getInfoCustomer() {
        List<Customer> result = customerService.getInfoCustomer();
        return ResponseEntity.ok().body(ResponseGenericException.response(result));
    }

    @PostMapping(value = "/create")
    @Operation(summary = "Create customer")
    public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer){
        Customer result = customerService.saveCustomer(customer);
        return ResponseEntity.ok().body(ResponseGenericException.response(result));
    }

    @DeleteMapping(value = "/delete/{idCustomer}")
    @Operation(summary = "Delete customer")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Long idCustomer) {
        HashMap<String, Object> result = customerService.deleteCustomer(idCustomer);
        return ResponseEntity.ok().body(ResponseGenericException.response(result));
    }

    @GetMapping(value = "/findCustomerById/{idCustomer}")
    @Operation(summary = "Find customer by Id")
    public ResponseEntity<Object> findCustomerById(@PathVariable Long idCustomer) {
        Customer result = customerService.findCustomerById(idCustomer);
        return ResponseEntity.ok().body(ResponseGenericException.response(result));
    }

    @PutMapping(value = "/updateCustomer/{idCustomer}")
    @Operation(summary = "Update customer")
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer) {
        Customer result =  customerService.updateCustomer(customer);
        return ResponseEntity.ok().body(ResponseGenericException.response(result));
    }

}
