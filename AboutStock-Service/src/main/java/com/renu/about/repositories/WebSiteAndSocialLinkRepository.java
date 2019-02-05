package com.renu.about.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.about.models.WebSiteAndSocialLink;

public interface WebSiteAndSocialLinkRepository    extends JpaRepository<WebSiteAndSocialLink,Long>,JpaSpecificationExecutor<WebSiteAndSocialLink> {

}
