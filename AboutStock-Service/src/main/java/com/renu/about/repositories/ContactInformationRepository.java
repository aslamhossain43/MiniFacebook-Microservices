package com.renu.about.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.about.models.ContactInformation;

public interface ContactInformationRepository extends JpaRepository<ContactInformation,Long>,JpaSpecificationExecutor<ContactInformation> {

}
