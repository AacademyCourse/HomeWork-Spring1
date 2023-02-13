package com.address_book.address.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    private Long id;

    @ManyToOne
    private Role role;
    @Column (name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    @Column (name = "phone_number")
    private String phoneNumber;
    @Column (name = "email")
    private String email;

    @ManyToMany (mappedBy = "user")
    @JsonManagedReference
    @JoinTable(
            name = "user_addresses",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")}
    )
    private Set<Address> addresses = new HashSet<>();

    @Column (name = "created_at")
    private Instant createdAt;

}
