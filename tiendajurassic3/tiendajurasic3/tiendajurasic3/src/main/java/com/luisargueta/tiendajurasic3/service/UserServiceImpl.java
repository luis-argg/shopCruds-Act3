package com.luisargueta.tiendajurasic3.service;

import com.luisargueta.tiendajurasic3.entity.User;
import com.luisargueta.tiendajurasic3.exception.ResourceNotFoundException;
import com.luisargueta.tiendajurasic3.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
    }

    @Override
    public User create(User user) {
        user.setIdUser(null);
        return userRepository.save(user);
    }

    @Override
    public User update(Integer id, User user) {
        User userExists = getById(id);

        userExists.setFirstName(user.getFirstName());
        userExists.setLastName(user.getLastName());
        userExists.setActive(user.getActive());

        return userRepository.save(userExists);
    }

    @Override
    public void delete(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User with ID: " + id  + " not found");
        }

        userRepository.deleteById(id);
    }

}

