package fa.training.dao;

import java.sql.SQLException;

import fa.training.entities.Product;

public interface ProductDAO {

	/**
	 * Execute a query to retrieve a product by its id.
	 * 
	 * @method findProductByProductId
	 * @param productId
	 * @return product if found, else null
	 * @throws SQLException
	 */
	Product findProductByProductId(int productId) throws SQLException;
	
	/**
	 * Call a stored procedure to save a product to database.
	 * 
	 * @method saveProduct
	 * @param product
	 * @return true if inserts success to database, else false
	 * @throws SQLException
	 */
	boolean saveProduct(Product product) throws SQLException;
}
