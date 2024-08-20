package fr.formation.exercice1registrationcorrection.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.exercice1registrationcorrection.dao.EmployeeDao;
import fr.formation.exercice1registrationcorrection.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private EmployeeDao employeeDao;
       
       public void init() {
    	   employeeDao = new EmployeeDao();
       }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("employeeregister.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName= request.getParameter("firstName");
		String lastName= request.getParameter("lastName");
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		String address= request.getParameter("address");
		String contact= request.getParameter("contact");
		
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setAddress(address);
		employee.setContact(contact);
		
		try {
			employeeDao.registerEmployee(employee);
			request.setAttribute("employee", employee); // j'ajoute l'employé à l'objet
			// transferer la requête 
			request.getRequestDispatcher("employeedetails.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("employeedetails.jsp");
	}

}
