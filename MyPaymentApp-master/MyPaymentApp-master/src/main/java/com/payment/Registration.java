package com.payment;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		Connection con = Dbcon.getCon();
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String phno = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String uname = request.getParameter("userName");
		String password = request.getParameter("password");
		String query = "insert into user_details (first_name, last_name, phone_number, email, address, user_name, password) values (?,?,?,?,?,?,?)"; 
				
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,fName);
			ps.setString(2,lName);
			ps.setString(3, phno);
			ps.setString(4, email);
			ps.setString(5, address);
			ps.setString(6, uname);
			ps.setString(7, password);
			int i = ps.executeUpdate();
			if(i>0) {
//				pw.print("done");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			else{
//				pw.print("not done");
				response.setContentType("test/html");
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.include(request, response);
				pw.print("<h1>Registration Unsucessful</h1>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
