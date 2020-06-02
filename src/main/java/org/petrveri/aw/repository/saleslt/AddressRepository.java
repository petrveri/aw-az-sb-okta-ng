package org.petrveri.aw.repository.saleslt;

import org.petrveri.aw.model.saleslt.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends PagingAndSortingRepository<Address, Integer> {
    List<Address> findByCustomers_customerID(Integer customerID);

    @Query("SELECT a FROM Address AS a JOIN a.customers AS c WHERE c.customerID = :customerID")
    List<Address> findAllByCustomerId(@Param("customerID") Integer customerID);

    @Query(value = "SELECT * FROM SalesLT.Address a JOIN SalesLT.CustomerAddress ca ON ca.AddressID = a.AddressID " +
                    "WHERE ca.CustomerID = :customerID", nativeQuery = true)
    List<Address> findAllByCustomerIdNative(@Param("customerID") Integer customerID);
}
