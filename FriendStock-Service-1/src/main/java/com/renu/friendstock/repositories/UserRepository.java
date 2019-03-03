package com.renu.friendstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.friendstock.models.User;

public interface UserRepository extends JpaRepository<User, Long>,JpaSpecificationExecutor<User>{

}
