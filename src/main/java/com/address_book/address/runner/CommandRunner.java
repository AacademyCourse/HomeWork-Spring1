package com.address_book.address.runner;

import com.address_book.address.entity.Address;
import com.address_book.address.entity.User;
import com.address_book.address.repository.AddressRepository;
import com.address_book.address.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.Instant;
import java.util.List;

@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public void run(String... args) throws Exception {
        createUsers();
    }
    public void createUsers() {
        User dimitar = new User();
        dimitar.setFirstName("Dimitar");
        dimitar.setLastName("Enev");
        dimitar.setPhoneNumber("0879385550");
        dimitar.setEmail("dreindead@abv.bg");
        dimitar.setCreatedAt(Instant.now(Clock.systemUTC()));

        User ivan = new User();
        ivan.setFirstName("Ivan");
        ivan.setLastName("Malchev");
        ivan.setPhoneNumber("08777777777");
        ivan.setEmail("abv@abv.bg");
        ivan.setCreatedAt(Instant.now(Clock.systemUTC()));

        User petar = new User();
        petar.setFirstName("Petar");
        petar.setLastName("Halvadzhiev");
        petar.setPhoneNumber("0888888888");
        petar.setEmail("bv@abv.bg");
        petar.setCreatedAt(Instant.now(Clock.systemUTC()));

        User mladen = new User();
        mladen.setFirstName("Mladen");
        mladen.setLastName("Karagiozov");
        mladen.setPhoneNumber("0999999999");
        mladen.setEmail("v@abv.bg");
        mladen.setCreatedAt(Instant.now(Clock.systemUTC()));

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

        addressRepository.saveAll(List.of(dimitarAddress,ivanAddress,petarAddress,mladenAddress));
    }

}
