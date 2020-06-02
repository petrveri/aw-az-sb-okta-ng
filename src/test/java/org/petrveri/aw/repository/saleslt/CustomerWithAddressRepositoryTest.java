package org.petrveri.aw.repository.saleslt;

import org.junit.jupiter.api.Test;
import org.petrveri.aw.model.saleslt.Address;
import org.petrveri.aw.model.saleslt.CustomerWithAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CustomerWithAddressRepositoryTest {
    @Autowired
    private CustomerWithAddressRepository customerWithAddressRepository;

    @Test
    public void testFetchData(){
        Optional<CustomerWithAddress> optCustomerWithAddress = customerWithAddressRepository.findById(29485);
        assertTrue(optCustomerWithAddress.isPresent());
        CustomerWithAddress customerWithAddress = optCustomerWithAddress.get();
        assertNotNull(customerWithAddress);
        assertEquals("Catherine", customerWithAddress.getFirstName());
        Set<Address> addresses = customerWithAddress.getAddresses();
        assertNotNull(addresses);
        assertFalse(addresses.isEmpty());
        assertEquals("California", addresses.iterator().next().getState());
    }

}
