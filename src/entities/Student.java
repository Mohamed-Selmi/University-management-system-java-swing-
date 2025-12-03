package entities;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
public class Student {
private String registrationNumber;
private String firstName;
private String lastName;
private Object dateOfBirth;
private String password;
private Groupe groupe;
private List<Grades> studentGrades;


public Student(String registrationNumber, String firstName, String lastName, Object dateOfBirth,String password) {
	this.registrationNumber = registrationNumber;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.password=password;
}
public Student(String registrationNumber, String firstName, String lastName, LocalDate dateOfBirth,String password, Groupe groupe) {
	super();
	this.registrationNumber = registrationNumber;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.groupe = groupe;
	this.password=password;
}

public String getRegistrationNumber() {
	return registrationNumber;
}
public void setRegistrationNumber(String registrationNumber) {
	this.registrationNumber = registrationNumber;
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
public Object getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public Groupe getGroup() {
	return groupe;
}
public void setGroup(Groupe groupe) {
	this.groupe = groupe;
}
public List<Grades> getStudentGrades() {
	return studentGrades;
}
public void setStudentGrades(List<Grades> studentGrades) {
	this.studentGrades = studentGrades;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}






}
