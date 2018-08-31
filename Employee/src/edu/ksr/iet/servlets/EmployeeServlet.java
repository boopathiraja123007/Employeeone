package edu.ksr.iet.servlets;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ksr.edu.cls.Employee;

import edu.ksr.iet.dao.EmployeeDao;
import edu.ksr.iet.dao.impl.EmployeeDaoImplementations;

@WebServlet(urlPatterns = "/first_serv")
public class EmployeeServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("Name");
		String age = req.getParameter("Age");
	    String dob = req.getParameter("DOB");
		String address = req.getParameter("Address");
		String salary = req.getParameter("Salary");
		String email = req.getParameter("Email");
		String phone = req.getParameter("Phone");
		ArrayList<String> employeeList = new ArrayList<String>();
		employeeList.add(name);
		employeeList.add(age);
		employeeList.add(dob);
		employeeList.add(address);
		employeeList.add(salary);
		employeeList.add(email);
		employeeList.add(phone);
		System.out.println(employeeList);
		System.out.println("in servlet");
		EmployeeDaoImplementations empEntry = new EmployeeDaoImplementations();
		empEntry.insertData(employeeList);
		RequestDispatcher rd = req.getRequestDispatcher("/NewFile.jsp");
		rd.forward(req, resp);
		
		
	}

	
	

}
