package com.luisargueta.tiendajurasic3.service;

import com.luisargueta.tiendajurasic3.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> listRole();
    Role getById(Integer id);
    Role create(Role role);
    Role update(Integer id, Role role);
    void delete(Integer id);

}
