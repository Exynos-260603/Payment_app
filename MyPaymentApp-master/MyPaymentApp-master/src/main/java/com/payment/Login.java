package com.payment;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter pw = response.getWriter();
		 Connection con = Dbcon.getCon();
		 String uName = request.getParameter("userName");
		 String pass = request.getParameter("password");
		 String query = "select * from user_details where user_name = ? and password = ?";
		 try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,uName);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				HttpSession hs = request.getSession();
				hs.setAttribute("fName", rs.getString(4));
				hs.setAttribute("lName", rs.getString(5));
			    hs.setAttribute("phno",rs.getString(6));
				hs.setAttribute("email", rs.getString(7));
				hs.setAttribute("address",rs.getString(8));
				RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
				rd.forward(request, response);
			}
			else {
				response.setContentType("text/html");
				pw.print("<h2 style='text-align:center;'>LOGIN UNSUCCESSFUL!</h2>");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
