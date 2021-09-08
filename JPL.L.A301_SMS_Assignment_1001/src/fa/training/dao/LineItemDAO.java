package fa.training.dao;

import java.sql.SQLException;
import java.util.List;

import fa.training.entities.LineItem;

public interface LineItemDAO {
	
	/**
	 * Call a stored procedure to save a lineitem to database.
	 * 
	 * @method saveLineItem
	 * @param lineItem
	 * @return true if inserts success to database, else false
	 * @throws SQLException
	 */
	boolean saveLineItem(LineItem lineItem) throws SQLException;
	
	/**
	 * Execute a query to get all lineitems from database.
	 * 
	 * @method getAll
	 * @return list of lineitems
	 * @throws SQLException
	 */
	List<LineItem> getAll() throws SQLException;
	
	/**
	 * Execute a query to get total price from database.
	 * 
	 * @method getTotalPrice
	 * @return 
	 * @throws SQLException
	 */
	double getTotalPrice(int orderId) throws SQLException;

}
