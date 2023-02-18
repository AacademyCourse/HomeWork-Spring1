package com.address_book.address.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table (name = "roles")
public class Role {
        public enum RoleType {
               ADMIN,
               USER,
               CLIENT
        }
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column (name = "role")
        @Enumerated (value = EnumType.STRING)
        private RoleType role;

        @OneToMany (mappedBy = "role", fetch = FetchType.EAGER)
        @JsonBackReference
        private Set<User> users = new HashSet<>();
}