package org.petrveri.aw.controller.saleslt;

import org.petrveri.aw.dto.CustomerWithAddressDTO;
import org.petrveri.aw.model.saleslt.CustomerWithAddress;
import org.petrveri.aw.repository.saleslt.CustomerWithAddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/saleslt/customerswithaddress")
public class CustomerWithAddressController {
    private final Logger log = LoggerFactory.getLogger(CustomerWithAddressController.class);

    @Autowired
    private CustomerWithAddressRepository customerWithAddressRepository;

    @GetMapping("")
    Iterable<CustomerWithAddressDTO> getCustomers() {
        log.info("Request to retrieve all customers with addresses");
        Iterable<CustomerWithAddress> customers = customerWithAddressRepository.findAll();
        return StreamSupport.stream(customers.spliterator(), false)
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getCustomerWithAddressById(@PathVariable Integer id) {
        log.info("Request to retrieve a customer with addresses by id");
        Optional<CustomerWithAddress> optCustomerWA = customerWithAddressRepository.findById(id);
        return optCustomerWA.map(customerWA -> ResponseEntity.ok().body(convertToDto(customerWA)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private CustomerWithAddressDTO convertToDto(CustomerWithAddress customerWithAddress) {
        CustomerWithAddressDTO.CustomerWithAddressDTOBuilder builder =
            CustomerWithAddressDTO.builder().customerID(customerWithAddress.getCustomerID())
                .firstName(customerWithAddress.getFirstName())
                .lastName(customerWithAddress.getLastName());
        if (customerWithAddress.getAddresses() != null) {
            customerWithAddress.getAddresses().stream().findFirst().map(address ->
                    builder.addressID(address.getAddressID())
                            .addressLine1(address.getAddressLine1())
                            .city(address.getCity())
                            .state(address.getState())
                            .countryRegion(address.getCountryRegion()));
        }
        return builder.build();
    }
}
