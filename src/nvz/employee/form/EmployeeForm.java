package nvz.employee.form;

import javax.servlet.http.HttpServletRequest;

import nvz.employee.model.Employee;

// EmployeeForm class

public class EmployeeForm {
	private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String address;
    private String contact;
	private Employee employee;
	private final static String fieldCannotBeLeftEmptyMsg = "This field cannot be left empty";
	private final static String fieldHasToMatchFormatMsg = "The input must be 10 digits";
	
	
	public EmployeeForm(HttpServletRequest request) {
		employee = extractFormData(request);
	}

	public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getContact() {
        return contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public Employee getEmployee() {
		return employee;
	}

	private String validationMsgForName(String name) {
		if (name.length() == 0) {
			return fieldCannotBeLeftEmptyMsg;
		}
		return null;
	}
	
	private String validationMsgForContact(String name) {
		if (name.length() != 10) {
			return fieldHasToMatchFormatMsg;
		}
		return null;
	}
	
	public Employee extractFormData(HttpServletRequest request) {
		String validationMsg;
		boolean formDataValid = true;
		
		lastName = request.getParameter("LastName");
		firstName = request.getParameter("FirstName");
		
		validationMsg = validationMsgForName(firstName);
		if (validationMsg != null) {
			request.setAttribute("errorInFirstNameMsg", validationMsg);
			formDataValid = false;
		}
		
		validationMsg = validationMsgForName(lastName);
		if (validationMsg != null) {
			request.setAttribute("errorInLastNameMsg", validationMsg);
			formDataValid = false;
		}
		
		validationMsg = validationMsgForName(username);
		if (validationMsg != null) {
			request.setAttribute("errorInUserNameMsg", validationMsg);
			formDataValid = false;
		}
		
		validationMsg = validationMsgForName(password);
		if (validationMsg != null) {
			request.setAttribute("errorInPasswordMsg", validationMsg);
			formDataValid = false;
		}
		
		validationMsg = validationMsgForName(address);
		if (validationMsg != null) {
			request.setAttribute("errorInAddressMsg", validationMsg);
			formDataValid = false;
		}
		
		validationMsg = validationMsgForContact(contact);
		if (validationMsg != null) {
			request.setAttribute("errorInContactMsg", validationMsg);
			formDataValid = false;
		}
		
		if (!formDataValid) {
			/* Can't create the employee object, data is bad */
			return null;
		}
		
		employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setAddress(address);
		employee.setContact(contact);
		return employee;
	}

}
