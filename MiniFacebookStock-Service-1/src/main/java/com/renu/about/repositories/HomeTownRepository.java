package com.renu.about.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.about.models.HomeTown;

public interface HomeTownRepository extends JpaRepository<HomeTown,Long>,JpaSpecificationExecutor<HomeTown> {
	HomeTown getById(Long id);
	// GET BY UID
	static final String getAllHomeTownByUID ="FROM HomeTown WHERE uid=:uid ORDER BY id DESC";
	@Query(getAllHomeTownByUID)
	public List<HomeTown>getAllHomeTownByUID(@Param("uid")String uid);
}
