package com.renu.about.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.about.models.OtherPlacesLived;

public interface OtherPlacesLivedRepository extends JpaRepository<OtherPlacesLived, Long>,JpaSpecificationExecutor<OtherPlacesLived> {
	OtherPlacesLived getById(Long id);
	// GET BY UID
	static final String getAllOtherPlacesLivedByUID ="FROM OtherPlacesLived WHERE uid=:uid ORDER BY id DESC";
	@Query(getAllOtherPlacesLivedByUID)
	public List<OtherPlacesLived>getAllOtherPlacesLivedByUID(@Param("uid")String uid);
}
