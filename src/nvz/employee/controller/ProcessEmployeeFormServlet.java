package nvz.employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nvz.employee.form.EmployeeForm;
import nvz.employee.model.Employee;

// Extract and process data from employeeregister.jsp.

public class ProcessEmployeeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context;
		RequestDispatcher dispatch;
		EmployeeForm employeeForm;
		Employee employee;
		
		/* Extract data and insert error messages if needed */
		employeeForm = new EmployeeForm(request);
		employee = employeeForm.getEmployee();
		
		if (employee == null) {
			/* The form contained invalid data, transfer control back to original form */
			context = getServletContext();
			request.setAttribute("employeeFormData", employeeForm);
			dispatch = context.getRequestDispatcher("employeeregister.jsp");
			dispatch.forward(request, response);
			return;
		} 
		
	}

}