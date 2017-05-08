package com.atmecs;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atmecs.dao.AdminDao;
import com.atmecs.dao.LoginDao;
import com.atmecs.pojo.TechTalk;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Redirected by click link on adminInfo page 	
			System.out.println("do Get method of AdminController ");

			String Op	=	request.getParameter("op");
			System.out.println("op = "+Op);
			int op	=	Integer.parseInt(Op);
		
			HttpSession session = request.getSession();
			
			int etid = 0;
			switch(op)
			{
				case 1:
					String Deleteable = request.getParameter("deleteable");
				//delete techtalk corresponding to tid clicked on link(Deleteable) and Redirect to adminInfo again
					int deltid = Integer.parseInt(Deleteable);
				AdminDao.deleteRecord(deltid);
				System.out.println("deleted successfully ");
	
				//fetch data of admin , add it to session object and forward to Admin-Info to display.
			
				
				List<TechTalk> lst = null;
				try {
					lst = LoginDao.fetchData();
				} catch (Exception e) {
					e.printStackTrace();
				}
				session.setAttribute("adminDataListObject", lst);
				
				RequestDispatcher rd = request.getRequestDispatcher("adminInfo.jsp");
				rd.forward(request, response);
				
				break;
				
				case 2:		//edit link for finding record and populating into form editDetails
					String e1 = request.getParameter("editable");
					
					etid = Integer.parseInt(e1);	
					TechTalk tt = AdminDao.fetchRecord(etid);
					
					RequestDispatcher rd2=request.getRequestDispatcher("editDetails.jsp");  
			        request.setAttribute("dataObj", tt);
					rd2.forward(request, response); 
					break;
				
				
				case 3:		//fetching data from editDetails form and saving the changes into database
		              
					int tid = Integer.parseInt(request.getParameter("Tid")) ;
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
						

						TechTalk tt2=new TechTalk(tid,title,description,speaker,new SimpleDateFormat("yyyy-MM-dd").parse(date),new Time(time2.getTime()));
						AdminDao.saveRecord(tt2);
					} catch (ParseException e) {
						
						e.printStackTrace();
					}
					
					RequestDispatcher rd3=request.getRequestDispatcher("adminInfo.jsp");
					//HttpSession session= request.getSession();
					try {
						//session.removeAttribute("adminDataListObject");
						session.setAttribute("adminDataListObject",LoginDao.fetchData());
					} catch (Exception e) {
						e.printStackTrace();
					}
					rd3.forward(request, response); 
			 			
					System.out.println("edit button successfully implemented!!");
					break;
				case 4:
					
					int tid1 =Integer.parseInt(request.getParameter("Tid")) ;
					String title1 = request.getParameter("Title");
					String description1 = request.getParameter("Description");
					String speaker1 = request.getParameter("Speaker");
					String date1 = request.getParameter("Date");
					String time1 = request.getParameter("Time");
					DateFormat sdf1 = new SimpleDateFormat("hh:mm");
                    /*Important date conversion*/
					try {
					   Date	time3 = sdf1.parse(time1);
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						

						TechTalk tt2=new TechTalk(tid1,title1,description1,speaker1,new SimpleDateFormat("yyyy-MM-dd").parse(date1),new Time(time3.getTime()));
						AdminDao.addTechTalk(tt2);
					} catch (ParseException e) {
						
						e.printStackTrace();
					}
					
					RequestDispatcher rd4=request.getRequestDispatcher("adminInfo.jsp");
				
					try {
						
						//session.removeAttribute("adminDataListObject");
						session.setAttribute("adminDataListObject",LoginDao.fetchData());
						
					} catch (Exception e) {
						
						e.printStackTrace();
					}
					
					rd4.forward(request, response); 
					
					System.out.println("add button successfully implemented!!");
					break;
				case 5://Requested TechTalk
					RequestDispatcher rd5=request.getRequestDispatcher("RegisteredEmployees.jsp");
					session.setAttribute("requestList",AdminDao.requestedTechTalk());
				     rd5.forward(request, response);
				     
				     break;
				case 6: //Regisrered TechTalk Employees
					int tid2 =Integer.parseInt(request.getParameter("tid"));
				   List list=AdminDao.registeredEmployees(tid2);
				   session.setAttribute("EList", list);
				   RequestDispatcher rd6=request.getRequestDispatcher("RegisteredTechTalks.jsp");
				   rd6.forward(request, response);
				    break;
				    
				case 7:	
					request.getSession().invalidate();
					RequestDispatcher rd7=request.getRequestDispatcher("index.jsp");
					rd7.forward(request,response);
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
