package com.luisargueta.tiendajurasic3.service;

import com.luisargueta.tiendajurasic3.entity.Rol;

import java.util.List;

public interface RolService {

    List<Rol> listRole();
    Rol getById(Integer id);
    Rol create(Rol role);
    Rol update(Integer id, Rol role);
    void delete(Integer id);

}
