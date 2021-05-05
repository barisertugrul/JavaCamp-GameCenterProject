package javaGameCenterProject.Entities;

import java.time.LocalDate;

import javaGameCenterProject.Abstract.MernisValitadable;

public class Gamer extends User implements MernisValitadable {
	
	private int id;
	private int userId;
	private String firstName;
	private String lastName;
	private String nationalityId;
	private LocalDate DateOfBirth;

	public Gamer(int userId, LocalDate registerDate, String email, String password, String firstName,
			String lastName, String nationalityId, LocalDate dateOfBirth) {
		this(registerDate, email, password, firstName, lastName, nationalityId, dateOfBirth);
		this.userId = userId;
	}

	public Gamer(LocalDate registerDate, String email, String password, String firstName,
			String lastName, String nationalityId, LocalDate dateOfBirth) {
		super(registerDate, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		DateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firsName) {
		this.firstName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(String nationalityId) {
		this.nationalityId = nationalityId;
	}

	public LocalDate getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
}
