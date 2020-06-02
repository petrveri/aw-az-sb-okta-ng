package org.petrveri.aw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerWithAddressDTO {
    private Integer customerID;
    private String firstName;
    private String lastName;
    private Integer addressID;
    private String addressLine1;
    private String city;
    private String state;
    private String countryRegion;
}
