package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.DepartmentServicesRemote;
import services.interfaces.EmployeeServicesRemote;
import entities.Department;
import entities.Employee;

public class InitDb {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/key-hr/EmployeeServices!services.interfaces.EmployeeServicesRemote";
		EmployeeServicesRemote employeeServicesRemote = (EmployeeServicesRemote) context
				.lookup(jndiName);

		DepartmentServicesRemote departmentServicesRemote = (DepartmentServicesRemote) context
				.lookup("/key-hr/DepartmentServices!services.interfaces.DepartmentServicesRemote");

		Employee employee = new Employee("heny");
		Employee employee2 = new Employee("bounje7");
		Employee employee3 = new Employee("mongia");

		employeeServicesRemote.addEmployee(employee);
		employeeServicesRemote.addEmployee(employee2);
		employeeServicesRemote.addEmployee(employee3);

		Department department = new Department();
		department.setId(1);
		department.setName("physique");

		departmentServicesRemote.addDepartment(department);

	}

}
