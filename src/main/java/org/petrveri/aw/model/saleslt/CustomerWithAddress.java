package org.petrveri.aw.model.saleslt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Customer", schema = "SalesLT")
public class CustomerWithAddress {
    @Id
    @Column(name = "CustomerID")
    private Integer customerID;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

//    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "customers")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CustomerAddress", schema = "SalesLT", joinColumns = @JoinColumn(name = "CustomerID"),
        inverseJoinColumns = @JoinColumn(name = "AddressID"))
    Set<Address> addresses = new HashSet<>();
}
