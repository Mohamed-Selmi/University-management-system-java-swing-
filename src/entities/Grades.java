package entities;

import exceptions.ExamGradeException;

public class Grades {
private Student student;
private Subject subject;
private float dsGrade;
private float examGrade;

public Grades(Student student, Subject subject, float dsGrade, float examGrade) throws ExamGradeException {
	super();
	if(dsGrade<=20 && examGrade<=20)
	{this.student = student;
	this.subject = subject;
	this.dsGrade = dsGrade;
	this.examGrade = examGrade;}
	else {
		throw new ExamGradeException("Grade must be under 20");
	}
}
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}
public Subject getSubject() {
	return subject;
}
public void setSubject(Subject subject) {
	this.subject = subject;
}
public float getDsGrade() {
	return dsGrade;
}
public void setDsGrade(float dsGrade) {
	this.dsGrade = dsGrade;
}
public float getExamGrade() {
	return examGrade;
}
public void setExamGrade(float examGrade) {
	this.examGrade = examGrade;
}
public double average() {
	return this.dsGrade*0.35+this.examGrade*0.65;
}
}
