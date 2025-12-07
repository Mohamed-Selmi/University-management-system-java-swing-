package entities;

import java.util.List;
//I have added an e because Group is a reserved variable in mysql
public class Groupe {
private int idGroup;
private String nameGroup;
private List<Student> students;
private List<Subject> subjects;


public Groupe(int idGroup, String nameGroup) {
	super();
	this.idGroup = idGroup;
	this.nameGroup = nameGroup;
}
public Groupe(int idGroup, String nameGroup,List<Student> students) {
	super();
	this.idGroup = idGroup;
	this.nameGroup = nameGroup;
	this.students=students;
}
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
@Override
public String toString() {
	return "Groupe [idGroup=" + idGroup + ", nameGroup=" + nameGroup + "]";
}


}
