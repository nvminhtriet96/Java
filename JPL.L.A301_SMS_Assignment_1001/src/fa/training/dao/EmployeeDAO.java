package fa.training.dao;

import java.sql.SQLException;

import fa.training.entities.Employee;

public interface EmployeeDAO {
	
	/**
	 * Call a stored procedure to save a employee to database.
	 * 
	 * @method saveEmployee
	 * @param employee
	 * @return true if inserts success to database, else false
	 * @throws SQLException
	 */
	boolean saveEmployee(Employee employee) throws SQLException;
	
	/**
	 * Execute a query to retrieve a employee by its id.
	 * 
	 * @method findEmployeeByEmployeeId
	 * @param employeeId
	 * @return employee if found, else null
	 * @throws SQLException
	 */
	Employee findEmployeeByEmployeeId(int employeeId) throws SQLException;

}
