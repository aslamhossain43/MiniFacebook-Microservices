package com.renu.about.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.about.models.ProfessionalSkill;

public interface ProfessionalSkillRepository extends JpaRepository<ProfessionalSkill,Long>,JpaSpecificationExecutor<ProfessionalSkill>{

}
