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
        Role roleType = new Role();
        if (this.roleRepository.findById(id).isPresent()) {
            roleType = this.roleRepository.findById(id).get();
        }
        return roleType;
    }

    public Role addRole(Role role) {
        return this.roleRepository.save(role);
    }

    public void deleteRole(Long id) {
        this.roleRepository.deleteById(id);
    }
}
