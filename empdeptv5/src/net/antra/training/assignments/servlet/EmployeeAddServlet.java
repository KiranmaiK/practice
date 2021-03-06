package net.antra.training.assignments.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.antra.training.assignments.entity.Employee;
import net.antra.training.assignments.service.EmployeeService;

/**
 * Servlet implementation class EmployeeAddServlet
 */
@WebServlet("/EmployeeAddServlet")
public class EmployeeAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAddServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	try {

	    EmployeeService employeeService = (EmployeeService) getServletConfig().getServletContext().getAttribute("employeeService");

	    List<Employee> employees = employeeService.getEmployees();
	    request.setAttribute("employees", employees);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/employee-add.jsp");
	    dispatcher.include(request, response);
	} catch (Exception e) {
	    e.printStackTrace();
	    request.setAttribute("isError", "true");
	}

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
