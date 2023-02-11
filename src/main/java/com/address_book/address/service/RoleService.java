package com.address_book.address.service;

import com.address_book.address.entity.Role;
import com.address_book.address.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRole(Long id) {
        Role searchedRole = new Role();
        if (this.roleRepository.findById(id).isPresent()) {
            searchedRole = this.roleRepository.findById(id).get();
        }
        return searchedRole;
    }

    public Role addRole(Role role) {
        Role newRole = new Role();
        newRole.setRole(role.getRole());
        return this.roleRepository.save(newRole);
    }

    public void deleteRole(Long id) {
        this.roleRepository.deleteById(id);
    }
}
