package com.address_book.address.runner;

import com.address_book.address.entity.Address;
import com.address_book.address.entity.Role;
import com.address_book.address.entity.RoleType;
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
        createAddresses();
    }
    public void createUsers() {
        Role admin = new Role();
        admin.setRole(RoleType.ADMIN);
        roleService.addRole(admin);
        Role client = new Role();
        client.setRole(RoleType.CLIENT);
        roleService.addRole(client);
        Role user = new Role();
        user.setRole(RoleType.USER);
        roleService.addRole(user);

        User dimitar = new User();
        dimitar.setFirstName("Dimitar");
        dimitar.setLastName("Enev");
        dimitar.setPhoneNumber("0879385550");
        dimitar.setEmail("dreindead@abv.bg");
        dimitar.setCreatedAt(Instant.now(Clock.systemUTC()));
        dimitar.setRole(roleService.getRole(1L));
        userService.addUser(dimitar);

        User ivan = new User();
        ivan.setFirstName("Ivan");
        ivan.setLastName("Malchev");
        ivan.setPhoneNumber("08777777777");
        ivan.setEmail("abv@abv.bg");
        ivan.setCreatedAt(Instant.now(Clock.systemUTC()));
        ivan.setRole(roleService.getRole(2L));
        userService.addUser(ivan);

        User petar = new User();
        petar.setFirstName("Petar");
        petar.setLastName("Halvadzhiev");
        petar.setPhoneNumber("0888888888");
        petar.setEmail("bv@abv.bg");
        petar.setCreatedAt(Instant.now(Clock.systemUTC()));
        petar.setRole(roleService.getRole(3L));
        userService.addUser(petar);

        User mladen = new User();
        mladen.setFirstName("Mladen");
        mladen.setLastName("Karagiozov");
        mladen.setPhoneNumber("0999999999");
        mladen.setEmail("v@abv.bg");
        mladen.setCreatedAt(Instant.now(Clock.systemUTC()));
        petar.setRole(roleService.getRole(3L));
        userService.addUser(mladen);
    }

    public void createAddresses() {
        Address dimitarAddress = new Address();
        dimitarAddress.setCountry("Bulgaria");
        dimitarAddress.setCity("Varna");
        dimitarAddress.setStreet("Tsar Osvoboditel");
        dimitarAddress.setStreetNumber(253);
        Set<User> dimitarAddresses = Set.of(userService.getUser(1L));
        dimitarAddress.setUser(dimitarAddresses);
        addressService.addAddress(dimitarAddress);

        Address ivanAddress = new Address();
        ivanAddress.setCountry("Bulgaria");
        ivanAddress.setCity("Dobrich");
        ivanAddress.setStreet("Tsar Osvoboditel");
        ivanAddress.setStreetNumber(23);
        Set<User> ivanAddresses = Set.of(userService.getUser(2L));
        ivanAddress.setUser(ivanAddresses);
        addressService.addAddress(ivanAddress);

        Address petarAddress = new Address();
        petarAddress.setCountry("Bulgaria");
        petarAddress.setCity("Burgas");
        petarAddress.setStreet("Tsar Kaloyan");
        petarAddress.setStreetNumber(4);
        Set<User> petarAddresses = Set.of(userService.getUser(3L));
        petarAddress.setUser(petarAddresses);
        addressService.addAddress(petarAddress);

        Address mladenAddress = new Address();
        mladenAddress.setCountry("Romania");
        mladenAddress.setCity("Constanta");
        mladenAddress.setStreet("Decebal");
        mladenAddress.setStreetNumber(34);
        Set<User> mladenAddresses = Set.of(userService.getUser(4L));
        mladenAddress.setUser(mladenAddresses);
        addressService.addAddress(mladenAddress);
    }

}
