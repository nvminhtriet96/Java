package fa.training.dao;

import java.sql.SQLException;
import java.util.List;

import fa.training.entities.Order;


public interface OrderDAO {
	
	/**
	 * Execute a query to retrieve a order by its id.
	 * 
	 * @method findOrderByOrderId
	 * @param orderId
	 * @return order if found, else null
	 * @throws SQLException
	 */
	Order findOrderByOrderId(int orderId) throws SQLException;
	
	/**
	 * Call a stored procedure to save a order to database.
	 * 
	 * @method saveOrder
	 * @param order
	 * @return true if inserts success to database, else false
	 * @throws SQLException
	 */
	boolean saveOrder(Order order) throws SQLException;
	
	/**
	 * Execute a query to get all orders from database.
	 * 
	 * @method getAll
	 * @return list of customers
	 * @throws SQLException
	 */
	List<Order> getAll() throws SQLException;

	/**
	 * Call a stored procedure to update an order to database.
	 * 
	 * @method updateOrder
	 * @param order
	 * @return true if inserts success to database, else false
	 * @throws SQLException
	 */
	boolean updateOrder(Order order) throws SQLException;	
}
