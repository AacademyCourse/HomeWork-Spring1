package com.address_book.address.controller;

import com.address_book.address.entity.Role;
import com.address_book.address.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (path = "/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping(path = "/{id}")
    public Role getRole(@PathVariable Long id) {
        return roleService.getRole(id);
    }

    @PostMapping(path = "/add")
    public Role addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @DeleteMapping(path = "/{id}/delete")
    public String deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return String.format("Role with %s id is deleted", id);
    }
}
