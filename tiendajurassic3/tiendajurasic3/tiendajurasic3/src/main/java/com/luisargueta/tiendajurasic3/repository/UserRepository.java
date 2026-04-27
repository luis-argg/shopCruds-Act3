package com.luisargueta.tiendajurasic3.repository;

import com.luisargueta.tiendajurasic3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
