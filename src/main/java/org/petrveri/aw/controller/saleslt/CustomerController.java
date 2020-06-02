package org.petrveri.aw.controller.saleslt;

import org.petrveri.aw.model.saleslt.Address;
import org.petrveri.aw.model.saleslt.Customer;
import org.petrveri.aw.repository.saleslt.AddressRepository;
import org.petrveri.aw.repository.saleslt.CustomerRepository;
import org.petrveri.aw.repository.saleslt.CustomerWithAddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/saleslt/customers")
public class CustomerController {
    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerWithAddressRepository customerWithAddressRepository;
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("")
    Iterable<Customer> getCustomers() {
        log.info("Request to retrieve all customers");
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getCustomerById(@PathVariable Integer id) {
        log.info("Request to retrieve a customer by id");
        Optional<Customer> optCustomer = customerRepository.findById(id);
        return optCustomer.map(customer -> ResponseEntity.ok().body(customer))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}/addresses")
    Iterable<Address> getAddressesByCustomerId(@PathVariable Integer id, @RequestParam(required = false) boolean jpql,
                                               @RequestParam(required = false) boolean nativeQuery) {
        if (jpql) {
            log.info("Request to retrieve addresses of a customer by id with jpql");
            return addressRepository.findAllByCustomerId(id);
        } else if (nativeQuery) {
            log.info("Request to retrieve addresses of a customer by id with native query");
            return addressRepository.findAllByCustomerIdNative(id);
        } else {
            log.info("Request to retrieve addresses of a customer by id");
            return addressRepository.findByCustomers_customerID(id);
        }
    }
}
