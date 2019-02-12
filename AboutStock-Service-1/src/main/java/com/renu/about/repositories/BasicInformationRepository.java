package com.renu.about.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.about.models.BasicInformation;

public interface BasicInformationRepository extends JpaRepository<BasicInformation, Long>,JpaSpecificationExecutor<BasicInformation> {
	BasicInformation getById(Long id);
	// GET BY UID
	static final String getAllBasicInformationByUID ="FROM BasicInformation WHERE uid=:uid ORDER BY id DESC";
	@Query(getAllBasicInformationByUID)
	public List<BasicInformation>getAllBasicInformationByUID(@Param("uid")String uid);
}
