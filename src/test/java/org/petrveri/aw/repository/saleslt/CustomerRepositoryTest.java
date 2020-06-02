package org.petrveri.aw.repository.saleslt;

import org.junit.jupiter.api.Test;
import org.petrveri.aw.model.saleslt.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testFetchData(){
        Optional<Customer> customerA = customerRepository.findById(1);
        assertTrue(customerA.isPresent());
        assertNotNull(customerA.get());
        assertEquals("Orlando", customerA.get().getFirstName());
    }

}
