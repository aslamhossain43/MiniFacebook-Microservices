package com.renu.about.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.about.models.HighSchool;

public interface HighSchoolRepository extends JpaRepository<HighSchool, Long>,JpaSpecificationExecutor<HighSchool>{
	HighSchool getById(Long id);
	// GET BY UID
	static final String getAllHighSchoolByUID ="FROM HighSchool WHERE uid=:uid ORDER BY id DESC";
	@Query(getAllHighSchoolByUID)
	public List<HighSchool>getAllHighSchoolByUID(@Param("uid")String uid);

}
