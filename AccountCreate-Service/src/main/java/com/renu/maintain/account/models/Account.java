package com.renu.maintain.account.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Entity
public class Account extends BaseAccount<Long>{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;


@NotBlank
private String firstName;

@NotBlank
private String lastName;


@NotBlank
private String phone;
@NotBlank
private String day;
@NotBlank
private String month;
@NotBlank
private String year;


@NotBlank
private String gender;

@NotBlank
private String password;
@NotBlank
private String confirmPassword;

public Account() {
	// TODO Auto-generated constructor stub
}



public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getDay() {
	return day;
}

public void setDay(String day) {
	this.day = day;
}

public String getMonth() {
	return month;
}

public void setMonth(String month) {
	this.month = month;
}

public String getYear() {
	return year;
}

public void setYear(String year) {
	this.year = year;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getConfirmPassword() {
	return confirmPassword;
}

public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}



@Override
public Long getId() {
	// TODO Auto-generated method stub
	return id;
}

}
