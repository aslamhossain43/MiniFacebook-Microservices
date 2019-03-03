package com.renu.zuul.friends.models;

public class UserFriends {
User users;
Friends friends;

public UserFriends() {}

public User getUsers() {
	return users;
}

public void setUsers(User users) {
	this.users = users;
}

public Friends getFriends() {
	return friends;
}

public void setFriends(Friends friends) {
	this.friends = friends;
}

}
