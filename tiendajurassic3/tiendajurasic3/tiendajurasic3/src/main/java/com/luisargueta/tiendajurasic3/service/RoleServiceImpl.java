package com.luisargueta.tiendajurasic3.service;

import com.luisargueta.tiendajurasic3.entity.Role;
import com.luisargueta.tiendajurasic3.exception.ResourceNotFoundException;
import com.luisargueta.tiendajurasic3.repository.RoleRepostory;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private final RoleRepostory roleRepostory;

    public RoleServiceImpl(RoleRepostory roleRepostory) {
        this.roleRepostory = roleRepostory;
    }


    @Override
    public List<Role> listRole() {
        return roleRepostory.findAll();
    }

    @Override
    public Role getById(Integer id) {
       return roleRepostory.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Rol with ID : " + id + " not found"));
    }

    @Override
    public Role create(Role role) {
        role.setIdRol(null);

        return roleRepostory.save(role);

    }

    @Override
    public Role update(Integer id, Role role) {

        Role roleExists = getById(id);

        roleExists.setRole(role.getRole());
        return roleExists;
    }

    @Override
    public void delete(Integer id) {
        if (!roleRepostory.existsById(id)) {
            throw new ResourceNotFoundException("Role with ID: " + id  + " not found");
        }

        roleRepostory.deleteById(id);
    }


}
