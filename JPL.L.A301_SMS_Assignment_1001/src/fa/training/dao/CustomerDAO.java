package fa.training.dao;

import java.sql.SQLException;
import java.util.List;

import fa.training.entities.Customer;

public interface CustomerDAO {
	
	/**
	 * Execute a query to get all customers from database.
	 * 
	 * @method getAll
	 * @return list of customers
	 * @throws SQLException
	 */
	List<Customer> getAll() throws SQLException;

	/**
	 * Call a stored procedure to save a customer to database.
	 * 
	 * @method saveCustomer
	 * @param customer
	 * @return true if inserts success to database, else false
	 * @throws SQLException
	 */
	boolean saveCustomer(Customer customer) throws SQLException;
	
	/**
	 * Call a stored procedure to update a customer to database.
	 * 
	 * @method updateCustomer
	 * @param customer
	 * @return true if inserts success to database, else false
	 * @throws SQLException
	 */
	boolean updateCustomer(Customer customer) throws SQLException;

	/**
	 * Execute a query to retrieve a customer by its id.
	 * 
	 * @method findCustomerByCustomerId
	 * @param customerId
	 * @return customer if found, else null
	 * @throws SQLException
	 */
	Customer findCustomerByCustomerId(int customerId) throws SQLException;
	
	/**
	 * This method is for deleting customers from the database, using batch.
	 * 
	 * @method deleteCustomers
	 * @param customers
	 * @return true if deletes success, else false
	 * @throws SQLException
	 */
	boolean deleteCustomers(Customer customers) throws SQLException;

}
