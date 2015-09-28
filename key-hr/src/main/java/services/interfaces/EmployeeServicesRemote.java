package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Employee;

@Remote
public interface EmployeeServicesRemote {
	Boolean addEmployee(Employee employee);

	Boolean deleteEmployeeById(Integer id);

	Employee findEmployeeById(Integer id);

	Boolean updateEmployee(Employee employee);

	Boolean deleteEmployee(Employee employee);

	List<Employee> findAllEmployees();

}
