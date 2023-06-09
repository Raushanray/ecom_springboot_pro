package com.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
