package com.student.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.student.project.util.DButil;

public class LoginDaoImpl implements LoginDao {

	private Connection connection;
	 ResultSet rs = null;
	 PreparedStatement  pst = null;
	public LoginDaoImpl() {
		connection = DButil.getConnection();
	}

	@SuppressWarnings("finally")
	@Override
	public boolean validate(String name, String pass) {
		
		boolean status = false;
		try {
			  pst = connection.prepareStatement("select * from admin where name=? and password=?");
			
			 pst.setString(1, name);
	            pst.setString(2, pass);

	           rs = pst.executeQuery();
	            status = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*finally
		{
			
			if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
		*/
		return status;
	//}
	}
}
