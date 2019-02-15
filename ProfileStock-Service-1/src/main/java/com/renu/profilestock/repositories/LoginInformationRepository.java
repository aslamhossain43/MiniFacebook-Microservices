package com.renu.profilestock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.profilestock.models.LoginInformationEntity;

public interface LoginInformationRepository extends JpaRepository<LoginInformationEntity,Long>,JpaSpecificationExecutor<LoginInformationEntity>{
	//---------------------------------------------------------------------------------------------------
		LoginInformationEntity getById(Long id);
	//---------------------------------------------------------------------------------------------------
	LoginInformationEntity getByUid(String uid);
	
}
