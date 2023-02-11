package com.address_book.address.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "country")
    private String country;
    @Column (name = "city")
    private String city;
    @Column (name = "street")
    private String street;
    @Column (name = "street_number")
    private int streetNumber;

    @ManyToMany (mappedBy = "addresses")
    private Set<User> user = new HashSet<>();
}
