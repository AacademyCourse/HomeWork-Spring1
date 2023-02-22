package com.address_book.address.controller;

import com.address_book.address.entity.Address;
import com.address_book.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (path = "/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping(path = "/{id}")
    public Address getAddress(@PathVariable Long id) {
        return addressService.getAddress(id);
    }

    @PostMapping(path = "/add")
    public Address addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @PutMapping(path = "/{id}/modify")
    public Address modifyAddress(@PathVariable Long id, @RequestBody Address address) {
        return addressService.modifyAddress(id, address);
    }

    @DeleteMapping(path = "/{id}/delete")
    public String deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return String.format("Address with %s id is deleted", id);
    }
}
