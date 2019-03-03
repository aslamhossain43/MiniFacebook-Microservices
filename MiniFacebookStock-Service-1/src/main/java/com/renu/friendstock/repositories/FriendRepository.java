package com.renu.friendstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.friendstock.models.Friends;

public interface FriendRepository extends JpaRepository<Friends, Long>,JpaSpecificationExecutor<Friends>{

}
