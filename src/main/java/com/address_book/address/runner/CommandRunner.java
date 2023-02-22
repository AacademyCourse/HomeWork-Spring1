package com.address_book.address.runner;

import com.address_book.address.entity.Address;
import com.address_book.address.entity.Role;
import com.address_book.address.entity.User;
import com.address_book.address.service.AddressService;
import com.address_book.address.service.RoleService;
import com.address_book.address.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.Instant;
import java.util.Set;

@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    @Autowired
    private RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        createUsers();
    }

    public void createUsers() {
        Role admin = new Role();
        admin.setRole(Role.RoleType.ADMIN);
        Role client = new Role();
        client.setRole(Role.RoleType.CLIENT);
        Role user = new Role();
        user.setRole(Role.RoleType.USER);

        User dimitar = new User();
        dimitar.setFirstName("Dimitar");
        dimitar.setLastName("Enev");
        dimitar.setPhoneNumber("0879385550");
        dimitar.setEmail("dreindead@abv.bg");
        dimitar.setCreatedAt(Instant.now(Clock.systemUTC()));
        dimitar.setRole(admin);

        User ivan = new User();
        ivan.setFirstName("Ivan");
        ivan.setLastName("Malchev");
        ivan.setPhoneNumber("08777777777");
        ivan.setEmail("abv@abv.bg");
        ivan.setCreatedAt(Instant.now(Clock.systemUTC()));
        ivan.setRole(client);

        User petar = new User();
        petar.setFirstName("Petar");
        petar.setLastName("Halvadzhiev");
        petar.setPhoneNumber("0888888888");
        petar.setEmail("bv@abv.bg");
        petar.setCreatedAt(Instant.now(Clock.systemUTC()));
        petar.setRole(user);

        User mladen = new User();
        mladen.setFirstName("Mladen");
        mladen.setLastName("Karagiozov");
        mladen.setPhoneNumber("0999999999");
        mladen.setEmail("v@abv.bg");
        mladen.setCreatedAt(Instant.now(Clock.systemUTC()));
        mladen.setRole(user);

        Address dimitarAddress = new Address();
        dimitarAddress.setCountry("Bulgaria");
        dimitarAddress.setCity("Varna");
        dimitarAddress.setStreet("Tsar Osvoboditel");
        dimitarAddress.setStreetNumber(253);
        dimitarAddress.setUser(dimitar);

        Address ivanAddress = new Address();
        ivanAddress.setCountry("Bulgaria");
        ivanAddress.setCity("Dobrich");
        ivanAddress.setStreet("Tsar Osvoboditel");
        ivanAddress.setStreetNumber(23);
        ivanAddress.setUser(ivan);

        Address petarAddress = new Address();
        petarAddress.setCountry("Bulgaria");
        petarAddress.setCity("Burgas");
        petarAddress.setStreet("Tsar Kaloyan");
        petarAddress.setStreetNumber(4);
        petarAddress.setUser(petar);

        Address mladenAddress = new Address();
        mladenAddress.setCountry("Romania");
        mladenAddress.setCity("Constanta");
        mladenAddress.setStreet("Decebal");
        mladenAddress.setStreetNumber(34);
        mladenAddress.setUser(mladen);

        dimitarAddress.setUsers(Set.of(dimitar));
        ivanAddress.setUsers(Set.of(ivan));
        petarAddress.setUsers(Set.of(petar));
        mladenAddress.setUsers(Set.of(mladen));

        dimitar.setAddress(Set.of(dimitarAddress));
        ivan.setAddress(Set.of(ivanAddress));
        petar.setAddress(Set.of(petarAddress));
        mladen.setAddress(Set.of(mladenAddress));

        roleService.addRole(admin);
        roleService.addRole(client);
        roleService.addRole(user);

        // It's adding addresses without Users and can't use it for users!
//        addressService.addAddress(dimitarAddress);
//        addressService.addAddress(ivanAddress);
//        addressService.addAddress(petarAddress);
//        addressService.addAddress(mladenAddress);

        userService.addUser(dimitar);
        userService.addUser(petar);
        userService.addUser(mladen);
        userService.addUser(ivan);
    }

}
