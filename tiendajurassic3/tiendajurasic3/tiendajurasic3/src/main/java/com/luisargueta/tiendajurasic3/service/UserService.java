package com.luisargueta.tiendajurasic3.service;

import com.luisargueta.tiendajurasic3.entity.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    User getById(Integer id);
    User create(User user);
    User update(Integer id, User user);
    void delete(Integer id);
}
