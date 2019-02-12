package com.renu.about.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.about.models.FamilyMembers;

public interface FamilyMembersRepository extends JpaRepository<FamilyMembers,Long>,JpaSpecificationExecutor<FamilyMembers> {
  FamilyMembers	getById(Long id);
	// GET BY UID
	static final String getAllFamilyMembersByUID ="FROM FamilyMembers WHERE uid=:uid ORDER BY id DESC";
	@Query(getAllFamilyMembersByUID)
	public List<FamilyMembers>getAllFamilyMembersByUID(@Param("uid")String uid);
}
