package javaGameCenterProject.Entities;

import java.time.LocalDate;

import javaGameCenterProject.Abstract.Entity;

public class User implements Entity {
	private int id;
	private LocalDate registerDate;
	private String email;
	private String password;

	public User(LocalDate registerDate, String email, String password) {
		super();
		this.registerDate = registerDate;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
