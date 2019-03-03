package com.renu.about.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.about.models.ContactInformation;

public interface ContactInformationRepository extends JpaRepository<ContactInformation,Long>,JpaSpecificationExecutor<ContactInformation> {
	ContactInformation getById(Long id);
	// GET BY UID
	static final String getAllContactInformationByUID ="FROM ContactInformation WHERE uid=:uid ORDER BY id DESC";
	@Query(getAllContactInformationByUID)
	public List<ContactInformation>getAllContactInformationByUID(@Param("uid")String uid);
}
