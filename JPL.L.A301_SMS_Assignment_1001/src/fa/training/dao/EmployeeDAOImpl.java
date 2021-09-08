package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fa.training.entities.Employee;
import fa.training.util.DBUtils;
import fa.training.util.SQLCommand;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;
	
	/**
	 * Execute a query to retrieve employee by its employee id.
	 * 
	 * @method findEmployeeByEmployeeId
	 * @param employeeId
	 * @return employee
	 * @throws SQLException
	 */
	public Employee findEmployeeByEmployeeId(final int employeeId) throws SQLException {
		Employee employee = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.EMPLOYEE_QUERY_FIND_BY_ID);
			preparedStatement.setInt(1, employeeId);
			results = preparedStatement.executeQuery();
			while (results.next()) {
				employee = new Employee();

				employee.setEmployeeId(results.getInt("employee_id"));
				employee.setEmployeeName(results.getString("employee_name"));
				employee.setSalary(results.getDouble("salary"));
				employee.setSupervisorId(results.getInt("supervisor_id"));

			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employee;
	}
	
	@Override
	public boolean saveEmployee(Employee employee) throws SQLException {
		boolean check = false;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.EMPLOYEE_QUERY_ADD);

			preparedStatement.setInt(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getEmployeeName());
			preparedStatement.setDouble(3, employee.getSalary());
			preparedStatement.setInt(4, employee.getSupervisorId());
			results = preparedStatement.executeQuery();
			while (results.next()) {
				if (results.getInt(1) == 1) {
					check = true;
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}

}
