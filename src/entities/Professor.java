package entities;

import java.util.List;
import java.util.Objects;

public class Professor {
	private int CIN;
	private String firstName;
	private String lastName;
	private String password;
	
	private List<Groupe> taughtGroups;
	private List<Subject> taughtSubjects;
	public Professor(int CIN, String firstName, String lastName,String password) {
		super();
		this.CIN = CIN;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password=password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(CIN);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return CIN == other.CIN;
	}
	public int getCIN() {
		return CIN;
	}
	public void setCIN(int CIN) {
		CIN = CIN;
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
	public List<Groupe> getTaughtGroups() {
		return taughtGroups;
	}
	public void setTaughtGroups(List<Groupe> taughtGroups) {
		this.taughtGroups = taughtGroups;
	}
	public List<Subject> getTaughtSubjects() {
		return taughtSubjects;
	}
	public void setTaughtSubjects(List<Subject> taughtSubjects) {
		this.taughtSubjects = taughtSubjects;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
