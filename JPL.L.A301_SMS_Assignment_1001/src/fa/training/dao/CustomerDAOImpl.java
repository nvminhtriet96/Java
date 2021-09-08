package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.entities.Customer;
import fa.training.util.DBUtils;
import fa.training.util.SQLCommand;


public class CustomerDAOImpl implements CustomerDAO {
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;
	
	/**
	 * Execute a query to retrieve customer by its customer id.
	 * 
	 * @method findBillsByCustomerId
	 * @param customerId
	 * @return customer
	 * @throws SQLException
	 */
	public Customer findCustomerByCustomerId(final int customerId) throws SQLException {
		Customer customer = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.CUSTOMER_QUERY_FIND_BY_CUSTOMER_ID);
			preparedStatement.setInt(1, customerId);
			results = preparedStatement.executeQuery();
			while (results.next()) {
				customer = new Customer();

				customer.setCustomerId(results.getInt("customer_id"));
				customer.setCustomerName(results.getString("customer_name"));
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
		return customer;
	}
	
	@Override
	public boolean saveCustomer(Customer customer) throws SQLException {
		boolean check = false;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.CUSTOMER_QUERY_ADD);

			preparedStatement.setInt(1, customer.getCustomerId());
			preparedStatement.setString(2, customer.getCustomerName());
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
	
	@Override
	public List<Customer> getAll() throws SQLException {
		List<Customer> customers = new ArrayList<>();
		Customer customer = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.CUSTOMER_QUERY_FIND_ALL);
			results = preparedStatement.executeQuery();
			while (results.next()) {
				customer = new Customer();

				customer.setCustomerId(results.getInt("customer_id"));
				customer.setCustomerName(results.getString("customer_name"));
				customers.add(customer);
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
		return customers;
	}
	
	@Override
	public boolean updateCustomer(Customer customer) throws SQLException {
		boolean check = false;	
		
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.CUSTOMER_QUERY_UPDATE);
			
			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setInt(2, customer.getCustomerId());
			preparedStatement.executeUpdate();
			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
				check = true;
				System.out.println("An existing customer was updated successfully!");
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
	
	@Override
	public boolean deleteCustomers(final Customer customer) throws SQLException {
		boolean check = false;
		int i1  = 0;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.LINEITEM_QUERY_DELETE);
			preparedStatement.setInt(1, customer.getCustomerId());
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(SQLCommand.ORDER_ID_QUERY_DELETE);
			preparedStatement.setInt(1, customer.getCustomerId());
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(SQLCommand.CUSTOMER_QUERY_DELETE);
			preparedStatement.setInt(1, customer.getCustomerId());
			i1 = preparedStatement.executeUpdate();

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
		
		if (i1 > 0) {
			check = true;
		}
		return check;
	}

}
