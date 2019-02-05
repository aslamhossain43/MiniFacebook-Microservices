package com.renu.about.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.about.models.BasicInformation;

public interface BasicInformationRepository extends JpaRepository<BasicInformation, Long>,JpaSpecificationExecutor<BasicInformation> {

}
