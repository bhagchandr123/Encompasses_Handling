package com.example.Encompasses_Handling.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String landmark;
    private String zipcode;
    private String district;
    private String state;
    private String country;

    public Address(Long id, String landmark, String zipcode, String district, String state, String country) {
        this.id = id;
        this.landmark = landmark;
        this.zipcode = zipcode;
        this.district = district;
        this.state = state;
        this.country = country;
    }

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Student student;
}
