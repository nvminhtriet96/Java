package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.entities.LineItem;
import fa.training.util.DBUtils;
import fa.training.util.SQLCommand;

public class LineItemDAOImpl implements LineItemDAO {
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;
	
	@Override
	public boolean saveLineItem(LineItem lineItem) throws SQLException {
		boolean check = false;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.LINEITEM_QUERY_ADD);

			preparedStatement.setInt(1, lineItem.getOrderId());
			preparedStatement.setInt(2, lineItem.getProductId());
			preparedStatement.setInt(3, lineItem.getQuantity());
			preparedStatement.setDouble(4, lineItem.getPrice());

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
	public List<LineItem> getAll() throws SQLException {
		List<LineItem> lineItems = new ArrayList<>();
		LineItem lineItem = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.LINEITEM_QUERY_FIND_ALL);
			results = preparedStatement.executeQuery();
			while (results.next()) {
				lineItem = new LineItem();

				lineItem.setOrderId(results.getInt("order_id"));
				lineItem.setProductId(results.getInt("product_id"));
				lineItem.setQuantity(results.getInt("quantity"));
				lineItem.setPrice(results.getDouble("price"));

				lineItems.add(lineItem);
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
		return lineItems;
	}
	
	public double getTotalPrice(int orderId) throws SQLException {
		double total_price = 0.0;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.LINEITEM_QUERY_FIND_TOTAL_PRICE);
			preparedStatement.setInt(1, orderId);
			results = preparedStatement.executeQuery();
			results.next();
			String result = results.getString(1);
			total_price = Double.parseDouble(result);
			}
		finally {
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
		return total_price;
	}
}
