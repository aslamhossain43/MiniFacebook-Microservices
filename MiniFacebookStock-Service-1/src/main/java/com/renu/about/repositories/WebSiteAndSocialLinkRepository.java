package com.renu.about.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.about.models.WebSiteAndSocialLink;

public interface WebSiteAndSocialLinkRepository    extends JpaRepository<WebSiteAndSocialLink,Long>,JpaSpecificationExecutor<WebSiteAndSocialLink> {
	WebSiteAndSocialLink getById(Long id);
	// GET BY UID
	static final String getAllWebSiteAndSocialLinkByUID ="FROM WebSiteAndSocialLink WHERE uid=:uid ORDER BY id DESC";
	@Query(getAllWebSiteAndSocialLinkByUID)
	public List<WebSiteAndSocialLink>getAllWorkplacesByUID(@Param("uid")String uid);
}
