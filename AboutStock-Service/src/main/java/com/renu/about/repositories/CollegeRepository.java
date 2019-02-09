package com.renu.about.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.about.models.College;

public interface CollegeRepository extends JpaRepository<College,Long>,JpaSpecificationExecutor<College> {
	College getById(Long id);
	// GET BY UID
	static final String getAllCollegesByUID ="FROM College WHERE uid=:uid ORDER BY id DESC";
	@Query(getAllCollegesByUID)
	public List<College>getAllCollegesByUID(@Param("uid")String uid);
}
