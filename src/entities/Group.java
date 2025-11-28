package entities;

import java.util.List;

public class Group {
private int idGroup;
private String nameGroup;
private List<Student> students;
private List<Subject> subjects;
public List<Subject> getSubjects() {
	return subjects;
}
public void setSubjects(List<Subject> subjects) {
	this.subjects = subjects;
}
public String getNameGroup() {
	return nameGroup;
}
public void setNameGroup(String nameGroup) {
	this.nameGroup = nameGroup;
}
public List<Student> getStudents() {
	return students;
}
public void setStudents(List<Student> students) {
	this.students = students;
}
public int getIdGroup() {
	return idGroup;
}
public void setIdGroup(int idGroup) {
	this.idGroup = idGroup;
}


}
