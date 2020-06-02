package org.petrveri.aw.repository.saleslt;

import org.junit.jupiter.api.Test;
import org.petrveri.aw.model.saleslt.Address;
import org.petrveri.aw.model.saleslt.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testGetAddressesByCustomerIdMethodA(){
        List<Address> addresses = addressRepository.findByCustomers_customerID(29485);
        assertNotNull(addresses);
        assertTrue(addresses.size() > 0);
        assertEquals("California", addresses.get(0).getState());
    }

    @Test
    public void testGetAddressesByCustomerIdJpql(){
        List<Address> addresses = addressRepository.findAllByCustomerId(29485);
        assertNotNull(addresses);
        assertTrue(addresses.size() > 0);
        assertEquals("California", addresses.get(0).getState());
    }

    @Test
    public void testGetAddressesByCustomerIdNative(){
        List<Address> addresses = addressRepository.findAllByCustomerIdNative(29485);
        assertNotNull(addresses);
        assertTrue(addresses.size() > 0);
        assertEquals("California", addresses.get(0).getState());
    }
}
