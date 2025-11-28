package entities;
import java.util.*;
public abstract class Student {
private String registrationNumber;
private String firstName;
private String lastName;
private Date dateOfBirth;
private Group group;
private List<Grades> studentGrades;



public Student(String registrationNumber, String firstName, String lastName, Date dateOfBirth, Group group) {
	super();
	this.registrationNumber = registrationNumber;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.group = group;
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
public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public Group getGroup() {
	return group;
}
public void setGroup(Group group) {
	this.group = group;
}
public List<Grades> getStudentGrades() {
	return studentGrades;
}
public void setStudentGrades(List<Grades> studentGrades) {
	this.studentGrades = studentGrades;
}






}
