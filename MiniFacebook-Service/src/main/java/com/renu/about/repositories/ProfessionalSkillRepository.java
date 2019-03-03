package com.renu.about.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.about.models.ProfessionalSkill;

public interface ProfessionalSkillRepository extends JpaRepository<ProfessionalSkill,Long>,JpaSpecificationExecutor<ProfessionalSkill>{
	ProfessionalSkill getById(Long id);
	// GET BY UID
	static final String getAllProfessionalSkillsByUID ="FROM ProfessionalSkill WHERE uid=:uid ORDER BY id DESC";
	@Query(getAllProfessionalSkillsByUID)
	public List<ProfessionalSkill>getAllProfessionalSkillsByUID(@Param("uid")String uid);
}
