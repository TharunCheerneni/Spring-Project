package com.taashee.SpringApplicationAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.taashee.SpringApplicationAssignment.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	UserDetails findByUsername(String username);

}
