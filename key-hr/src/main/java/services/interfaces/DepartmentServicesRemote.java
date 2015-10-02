package services.interfaces;

import javax.ejb.Remote;

import entities.Department;

@Remote
public interface DepartmentServicesRemote {
	Boolean assignEmployeeToDepartment(Integer idEmployee, Integer idDepartment);

	Boolean addDepartment(Department department);

	Boolean assignEmployeeToNewDepartment(Integer idEmployee,
			Department department);

	Department findDepartmentById(Integer id);

	Boolean assignEmployeeToDepartmentSlaveSide(Integer idEmployee,
			Integer idDepartment);

}
