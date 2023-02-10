package com.address_book.address.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    private User user;
}
