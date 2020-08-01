package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId) {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @PutMapping({"/{customerId}"})
    public ResponseEntity handleUpdate(@PathVariable UUID customerId, @RequestBody CustomerDto customer) {

        customerService.updateCustomer(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {

        CustomerDto savedDto = customerService.saveNewCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable UUID customerId) {
        customerService.deleteById(customerId);
    }

}
