package org.petrveri.aw.repository.saleslt;

import org.petrveri.aw.model.saleslt.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
}
