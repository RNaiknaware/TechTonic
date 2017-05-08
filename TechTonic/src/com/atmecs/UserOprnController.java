package com.atmecs;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atmecs.dao.UserDao;
import com.atmecs.pojo.RequestTechTalk;

/**
 * Servlet implementation class UserOprnController
 */
@WebServlet("/UserOprnController")
public class UserOprnController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserOprnController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int operation	= Integer.parseInt(request.getParameter("op"));
		
		HttpSession session= request.getSession();					

		switch(operation)
		{			
		case 1:
			int tid=Integer.parseInt(request.getParameter("tid"));
			String email=(String) session.getAttribute("userMail");
			
			System.out.println(" tid : "+tid + " email : "+email);
			
			if(email!=null)
			{
			UserDao.RegisterTechTalk(tid ,email);
			
			RequestDispatcher rd=request.getRequestDispatcher("userInfo.jsp");  
			rd.forward(request, response);
		}
		else
		{
	        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
	        rd.include(request, response);
		}
			
		break;
		
		case 2:
			
			String title = request.getParameter("Title");
			String description = request.getParameter("Description");
			String speaker = request.getParameter("Speaker");
			String date = request.getParameter("Date");
			String time = request.getParameter("Time");
			DateFormat sdf = new SimpleDateFormat("hh:mm");
		
			Date time2;
			try {
				time2 = sdf.parse(time);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				

				RequestTechTalk tt3=new RequestTechTalk(title,description,speaker,new SimpleDateFormat("yyyy-MM-dd").parse(date),new Time(time2.getTime()));
				
				UserDao.requestTechTalk(tt3);
				
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
			RequestDispatcher rd3=request.getRequestDispatcher("userInfo.jsp");
			rd3.forward(request,response);
			
			break;
			
		case 3:
			request.getSession().invalidate();
			RequestDispatcher rd4=request.getRequestDispatcher("index.jsp");
			rd4.forward(request,response);
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
