package edu.ksr.edu.validate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ksr.iet.dao.impl.ValidationImplementation;

@WebServlet(urlPatterns="/validation")
public class ValidateInfo extends HttpServlet{
         
	ValidationImplementation val = new ValidationImplementation();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userID = req.getParameter("userid");
		String password = req.getParameter("password");
		val.validateData(userID,password);
		
	}
}
