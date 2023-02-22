package com.address_book.address.service;

import com.address_book.address.entity.Address;
import com.address_book.address.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address getAddress(Long id) {
        Address searchedAddress = new Address();
        if (this.addressRepository.findById(id).isPresent()) {
            searchedAddress = this.addressRepository.findById(id).get();
        }
        return searchedAddress;
    }

    public Address addAddress(Address address) {
        Address newAddress = new Address();

        newAddress.setCountry(address.getCountry());
        newAddress.setCity(address.getCity());
        newAddress.setStreet(address.getStreet());
        newAddress.setStreetNumber(address.getStreetNumber());
        newAddress.setUsers(address.getUsers());

        return this.addressRepository.save(newAddress);
    }

    public Address modifyAddress(Long id, Address modedAddress) {
        Address address = getAddress(id);

        address.setId(modedAddress.getId());
        address.setCountry(modedAddress.getCountry());
        address.setCity(modedAddress.getCity());
        address.setStreet(modedAddress.getStreet());
        address.setStreetNumber(modedAddress.getStreetNumber());
        address.setUsers(modedAddress.getUsers());

        return this.addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        this.addressRepository.deleteById(id);
    }
}
