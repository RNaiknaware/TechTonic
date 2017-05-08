package com.atmecs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atmecs.dao.LoginDao;
import com.atmecs.pojo.TechTalk;
import com.atmecs.pojo.User;

/**
 * Servlet implementation class StoreData
 */
@WebServlet("/StoreData")
public class StoreData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//LOGIN BUTTON will redirect to this method 
		PrintWriter out = response.getWriter();
		out.print("Say hello to Rushi !!");
		
		HttpSession session = request.getSession();
		
		try {
		String Email = request.getParameter("email");
		String Password = request.getParameter("password");
		
							System.out.println(Email + " , "+ Password);

								//check for admin validation
								if(LoginDao.validateAdmin(Email, Password)){
									
									System.out.println("valid Admin");
									//fetch data of admin , add it to session object and forward to Admin-Info to display.
									
									List<TechTalk> lst = LoginDao.fetchData();
									session.setAttribute("adminDataListObject", lst);
									
									RequestDispatcher rd = request.getRequestDispatcher("adminInfo.jsp");
									rd.forward(request, response);
							
							
								
								}else{
									System.out.println("not valid Admin");

									//check for user validation
									User usr = 	LoginDao.validateUser(Email, Password);
									
									if(usr != null){
										System.out.println("valid user");
										System.out.println(usr);
									
										
										//fetch data of user , add it to session object and forward to User-Info to display.
										List<TechTalk> lst = LoginDao.fetchData();
										session.setAttribute("userDataListObject", lst);
										session.setAttribute("userMail", Email);
										RequestDispatcher rd = request.getRequestDispatcher("userInfo.jsp");
										rd.forward(request, response);
									}else{
										System.out.println("not valid user");
										//RequestDispatcher rd = request.getRequestDispatcher("https://www.google.co.in/");
										//rd.forward(request, response);
									}
		
								}
			
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//SignUp button will redirect you to Storedata do post method
					System.out.println("post req of store data");
					String Email = request.getParameter("email");
					String Name = request.getParameter("name");
					String Password = request.getParameter("password");
					
					try {
						//register user into database, redirect to login page 
						LoginDao.registerUser(new User(Email,Name,Password));
						
						RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
						rd.forward(request, response);
		
						
					} catch (SQLException e) {
						e.printStackTrace();
					}

	}

}
