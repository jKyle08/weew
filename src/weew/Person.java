package weew;

import java.time.LocalDate;

public class Person {
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String email;
	private String sex;

	public Person(String firstName, String lastName, LocalDate birthDate, String email, String sex) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
		this.sex = sex;
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}



	@Override
	public String toString() {
		return  firstName + " " + lastName +  " (" + sex + ") \n" +
				"Born on " + birthDate + " " + "\n"
				+ email;
	}
	
}
