package controllers;

import java.sql.SQLException;

import entities.Administrator;

public interface IAdminController {
public boolean addAdmin(Administrator a) throws SQLException, ClassNotFoundException;
public boolean removeAdmin(Administrator a) throws SQLException, ClassNotFoundException;
public Administrator getAdmin(int CIN) throws SQLException, ClassNotFoundException;
public boolean loginAdmin(int CIN,String password) throws SQLException, ClassNotFoundException;

}
