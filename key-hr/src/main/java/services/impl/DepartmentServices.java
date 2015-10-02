package services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.DepartmentServicesRemote;
import services.interfaces.EmployeeServicesLocal;
import entities.Department;
import entities.Employee;

/**
 * Session Bean implementation class DepartmentServices
 */
@Stateless
public class DepartmentServices implements DepartmentServicesRemote {

	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private EmployeeServicesLocal employeeServicesLocal;

	/**
	 * Default constructor.
	 */
	public DepartmentServices() {
	}

	@Override
	public Boolean assignEmployeeToDepartment(Integer idEmployee,
			Integer idDepartment) {
		Boolean b = false;
		try {
			Employee employeeFound = employeeServicesLocal
					.findEmployeeById(idEmployee);
			Department departmentFound = entityManager.find(Department.class,
					idDepartment);

			employeeFound.setDepartment(departmentFound);

			entityManager.merge(employeeFound);
			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}

	@Override
	public Boolean addDepartment(Department department) {
		Boolean b = false;
		try {
			entityManager.persist(department);
			b = true;
		} catch (Exception e) {
			System.err.println("problem adding department ...");
		}
		return b;
	}

	@Override
	public Boolean assignEmployeeToNewDepartment(Integer idEmployee,
			Department department) {
		Boolean b = false;
		try {
			Employee employeeFound = employeeServicesLocal
					.findEmployeeById(idEmployee);
			employeeFound.setDepartment(department);
			entityManager.merge(employeeFound);
			b = true;
		} catch (Exception e) {
			System.err.println("problem ...");
		}
		return b;
	}

	@Override
	public Department findDepartmentById(Integer id) {
		return entityManager.find(Department.class, id);
	}

	@Override
	public Boolean assignEmployeeToDepartmentSlaveSide(Integer idEmployee,
			Integer idDepartment) {
		Boolean b = false;
		try {
			Employee employeeFound = employeeServicesLocal
					.findEmployeeById(idEmployee);
			Department departmentFound = entityManager.find(Department.class,
					idDepartment);
			List<Employee> employees = new ArrayList<>();
			employees.add(employeeFound);

			departmentFound.setEmployees(employees);

			entityManager.merge(departmentFound);

			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}

}
