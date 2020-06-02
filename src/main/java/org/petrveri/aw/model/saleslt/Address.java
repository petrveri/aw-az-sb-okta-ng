package org.petrveri.aw.model.saleslt;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Address", schema = "SalesLT")
public class Address {
    @Id
    @Column(name = "AddressID")
    private Integer addressID;

    @Column(name = "AddressLine1")
    private String addressLine1;

    @Column(name = "City")
    private String city;

    @Column(name = "StateProvince")
    private String state;

    @Column(name = "CountryRegion")
    private String countryRegion;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CustomerAddress", schema = "SalesLT", joinColumns = @JoinColumn(name = "AddressID"),
            inverseJoinColumns = @JoinColumn(name = "CustomerID"))
    Set<Customer> customers = new HashSet<>();
}
