package entities;

import java.util.Objects;

public class Administrator {
private int CIN;
private String firstName;
private String lastName;
private String password;
public Administrator(int CIN, String firstName, String lastName,String password) {
	super();
	this.CIN = CIN;
	this.firstName = firstName;
	this.lastName = lastName;
	this.password=password;
}
public int getCIN() {
	return CIN;
}
public void setCIN(int CIN) {
	this.CIN = CIN;
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
	Administrator other = (Administrator) obj;
	return CIN == other.CIN;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
