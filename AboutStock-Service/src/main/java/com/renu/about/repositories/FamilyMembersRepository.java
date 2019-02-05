package com.renu.about.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.about.models.FamilyMembers;

public interface FamilyMembersRepository extends JpaRepository<FamilyMembers,Long>,JpaSpecificationExecutor<FamilyMembers> {

}
