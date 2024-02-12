package org.mmefta.springbatchexample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "CUSTOMER_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @Generated
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String contactNo;
    private String country;
    private String dob;
}
