package com.renu.about.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.about.models.CurrentCity;

public interface CurrentCityRepository extends JpaRepository<CurrentCity,Long>,JpaSpecificationExecutor<CurrentCity> {
	CurrentCity getById(Long id);
	// GET BY UID
	static final String getAllCurrentCityByUID ="FROM CurrentCity WHERE uid=:uid ORDER BY id DESC";
	@Query(getAllCurrentCityByUID)
	public List<CurrentCity>getAllCurrentCityByUID(@Param("uid")String uid);
}
