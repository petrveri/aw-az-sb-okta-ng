package org.petrveri.aw.repository.saleslt;

import org.petrveri.aw.model.saleslt.CustomerWithAddress;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerWithAddressRepository extends PagingAndSortingRepository<CustomerWithAddress, Integer> {

//    SELECT c.CustomerID, c.FirstName, c.LastName, a.AddressLine1, a.City, a.StateProvince AS State, a.CountryRegion
//    FROM SalesLT.Customer AS c
//    JOIN SalesLT.CustomerAddress AS ca ON ca.CustomerID = c.CustomerID
//    JOIN SalesLT.Address AS a ON a.AddressID = ca.AddressID
//    ORDER BY c.CustomerID;

}
