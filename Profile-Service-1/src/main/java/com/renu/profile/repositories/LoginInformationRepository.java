package com.renu.profile.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.renu.profile.models.LoginInformationEntity;


public interface LoginInformationRepository extends JpaRepository<LoginInformationEntity,Long>,JpaSpecificationExecutor<LoginInformationEntity>{
	//---------------------------------------------------------------------------------------------------
		LoginInformationEntity getById(Long id);
	//---------------------------------------------------------------------------------------------------
	LoginInformationEntity getByUid(String uid);
	// ---------------------------------------------------------------------------------------------------
		static final String GET_ALL_LOGINFORMATION="FROM LoginInformationEntity ORDER BY id DESC";
		@Query(GET_ALL_LOGINFORMATION)
		List<LoginInformationEntity>getAllLogInformation();
	
}
