package controllers;

import java.sql.SQLException;
import java.util.List;

import entities.Groupe;
import entities.Subject;

public interface ISubjectController {
boolean addSubject(Subject s) throws SQLException,ClassNotFoundException;
boolean removeSubject(int subjectID) throws SQLException,ClassNotFoundException;
Subject getSubject(int subjectID) throws SQLException,ClassNotFoundException;
public List<Subject> displaySubjects() throws SQLException, ClassNotFoundException;
public List<Subject> displaySubjects(Groupe g) throws SQLException, ClassNotFoundException;
}
