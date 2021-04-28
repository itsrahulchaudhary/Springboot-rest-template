package com.rest.template.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.template.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
