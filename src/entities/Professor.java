package entities;

import java.util.Objects;

public class Professor {
	private int CIN;
	private String firstName;
	private String lastName;
	
	public Professor(int CIN, String firstName, String lastName) {
		super();
		this.CIN = CIN;
		this.firstName = firstName;
		this.lastName = lastName;
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
	
}
