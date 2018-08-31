package edu.ksr.iet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import edu.ksr.edu.validate.ValidateInfo;
import edu.ksr.iet.util.DataBaseUtil;

public class ValidationImplementation extends ValidateInfo {

	
	
	public void validateData(String userid,String password){
		//System.out.println(employeeList);
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		int i=0;
		try {
			String sql = "select * from LoginInfo where UserID=? AND Password = ?";
				connection = DataBaseUtil.getConnection();
				prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setString(1,userid);
				prepareStatement.setString(2,password);
				prepareStatement.executeQuery();
				
		
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
				DataBaseUtil.close(connection, prepareStatement,null);
		}
			
		
	}
}
