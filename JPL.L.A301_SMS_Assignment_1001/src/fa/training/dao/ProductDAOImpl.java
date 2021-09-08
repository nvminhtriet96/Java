package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fa.training.entities.Product;
import fa.training.util.DBUtils;
import fa.training.util.SQLCommand;

public class ProductDAOImpl implements ProductDAO {
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;
	
	@Override
	public Product findProductByProductId(final int productId) throws SQLException {
		Product product = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.PRODUCT_QUERY_FIND_BY_ID);
			preparedStatement.setInt(1, productId);
			results = preparedStatement.executeQuery();
			if (results.next()) {
				product = new Product();

				product.setProductId(results.getInt("product_id"));
				product.setProductName(results.getString("product_name"));
				product.setListPrice(results.getDouble("list_price"));
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
		return product;
	}
	
	@Override
	public boolean saveProduct(Product product) throws SQLException {
		boolean check = false;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.PRODUCT_QUERY_ADD);

			preparedStatement.setInt(1, product.getProductId());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setDouble(3, product.getListPrice());

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
