package com.address_book.address.service;

import com.address_book.address.entity.User;
import com.address_book.address.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id) {
        User searchedUser = new User();
        if (this.userRepository.findById(id).isPresent()) {
            searchedUser = this.userRepository.findById(id).get();
        }
        return searchedUser;
    }

    public User addUser(User user) {
        User newUser = new User();

        newUser.setRole(user.getRole());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setEmail(user.getEmail());
        newUser.setAddress(user.getAddress());
        newUser.setCreatedAt(user.getCreatedAt());

        return this.userRepository.save(newUser);
    }

    public User modifyUser(Long id, User modedUser) {
        User user = getUser(id);

        user.setRole(modedUser.getRole());
        user.setFirstName(modedUser.getFirstName());
        user.setLastName(modedUser.getLastName());
        user.setPhoneNumber(modedUser.getPhoneNumber());
        user.setEmail(modedUser.getEmail());
        user.setAddress(modedUser.getAddress());
        user.setCreatedAt(modedUser.getCreatedAt());

        return this.userRepository.save(user);
    }
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}
