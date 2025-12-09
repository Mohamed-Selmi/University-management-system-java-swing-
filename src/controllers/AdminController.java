package controllers;

import java.sql.SQLException;

import dao.AdminDAO;
import entities.Administrator;

public class AdminController implements IAdminController{
	AdminDAO adminDAO;
	public AdminController() throws ClassNotFoundException, SQLException {
		adminDAO=new AdminDAO();
	}
	@Override
	public boolean addAdmin(Administrator a) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return adminDAO.addAdministrator(a);
	}

	@Override
	public boolean removeAdmin(Administrator a) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Administrator getAdmin(int CIN) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return adminDAO.getAdmin(CIN);
	}

	@Override
	public boolean loginAdmin(int CIN, String password) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return adminDAO.loginAdministrator(CIN, password);
	}

}
