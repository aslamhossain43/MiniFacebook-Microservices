package com.renu.maintain.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renu.maintain.account.models.Account;
import com.renu.maintain.account.repositories.AccountRepository;
@CrossOrigin("*")
@RestController
@RequestMapping(value="/account")
public class CreateAccount {
private static final Logger LOGGER=LoggerFactory.getLogger(CreateAccount.class);

@Autowired
 AccountRepository accountRepository;

@PostMapping(value="/add")
public ResponseEntity<?>addAccount(@RequestBody Account account){
	LOGGER.info("From class CreateAccount,method : addAccount()");
	
	accountRepository.save(account);
	return ResponseEntity.ok().body(null);
}


}
