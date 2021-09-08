package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.util.DBUtils;
import fa.training.entities.Order;
import fa.training.util.SQLCommand;

public class OrderDAOImpl implements OrderDAO {
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;
	
	@Override
	public Order findOrderByOrderId(final int orderId) throws SQLException {
		Order order = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.ORDER_QUERY_FIND_BY_ID);
			preparedStatement.setInt(1, orderId);
			results = preparedStatement.executeQuery();
			if (results.next()) {
				order = new Order();

				order.setOrderId(results.getInt("order_id"));
				order.setOrderDate(results.getDate("order_date"));
				order.setCustomerId(results.getInt("customer_id"));
				order.setEmployeeId(results.getInt("employee_id"));
				order.setTotal(results.getDouble("total"));
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
		return order;
	}
	
	@Override
	public boolean saveOrder(Order order) throws SQLException {
		boolean check = false;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.ORDER_QUERY_ADD);

			preparedStatement.setInt(1, order.getOrderId());
			java.util.Date javaDate = new java.util.Date();
			javaDate = order.getOrderDate();
			java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());

			preparedStatement.setDate(2, sqlDate);
			preparedStatement.setInt(3, order.getCustomerId());
			preparedStatement.setInt(4, order.getEmployeeId());
			preparedStatement.setDouble(5, order.getTotal());

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
	public List<Order> getAll() throws SQLException {
		List<Order> orders = new ArrayList<>();
		Order order = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.ORDER_QUERY_FIND_ALL);
			results = preparedStatement.executeQuery();
			while (results.next()) {
				order = new Order();

				order.setOrderId(results.getInt("order_id"));
				order.setOrderDate(results.getDate("order_date"));
				order.setCustomerId(results.getInt("customer_id"));
				order.setEmployeeId(results.getInt("employee_id"));
				order.setTotal(results.getDouble("total"));

				orders.add(order);
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
		return orders;
	}
	
	@Override
	public boolean updateOrder(Order order) throws SQLException {
		boolean check = false;	
		
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.ORDER_QUERY_UPDATE);
			java.util.Date javaDate = new java.util.Date();
			javaDate = order.getOrderDate();
			java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());
			preparedStatement.setDate(1, sqlDate);
			preparedStatement.setInt(2, order.getCustomerId());
			preparedStatement.setInt(3, order.getEmployeeId());
			preparedStatement.setDouble(4, order.getTotal());
			preparedStatement.setInt(5, order.getOrderId());

			preparedStatement.executeUpdate();
			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
				check = true;
				System.out.println("An existing order was updated successfully!");
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
