package edu.ksr.iet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.ksr.edu.cls.Employee;
import edu.ksr.iet.dao.EmployeeDao;
import edu.ksr.iet.util.DataBaseUtil;

public class EmployeeDaoImplementations implements EmployeeDao{

	@Override
	public List<Employee> getEmployees(List<String> empList) {

		List<Employee> employeeList = new ArrayList<Employee>();
		String sql = "select * from students";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DataBaseUtil.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Employee employee = new Employee();
				employee.setEmployeeID(resultSet.getInt("employeeID"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getInt("age"));
				employee.setDob(resultSet.getString("dob"));
				employee.setAddress(resultSet.getString("address"));
				employee.setSalary(resultSet.getInt("salary"));
				employee.setEmail(resultSet.getString("email"));
				employee.setPhone(resultSet.getString("phone"));
				employeeList.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(connection, prepareStatement, resultSet);
		}
		return employeeList;
	
	}
	public void insertData(ArrayList<String> employeeList){
		System.out.println(employeeList);
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String employeeElements[] = new String[20];
		int i=0;
		try {
		for (String line : employeeList) {
			 employeeElements[i]=  line;
			 System.out.println(employeeElements[i]);
			 i++;
		}
			String sql = "insert into Employee(Name,Age,DOB,Address,Salary,Email,Phone) values(?,?,?,?,?,?,?)";
				connection = DataBaseUtil.getConnection();
				prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setString(1,employeeElements[0]);
				prepareStatement.setString(2,employeeElements[1]);
				prepareStatement.setString(3,employeeElements[2]);
				prepareStatement.setString(4, employeeElements[3]);
				prepareStatement.setString(5, employeeElements[4]);
				prepareStatement.setString(6,employeeElements[5]);
				prepareStatement.setString(7,employeeElements[6]);
				prepareStatement.executeUpdate();
		
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
				DataBaseUtil.close(connection, prepareStatement,null);
		}
			
		
	}
	

}
