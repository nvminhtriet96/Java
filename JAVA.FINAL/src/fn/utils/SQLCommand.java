package fn.utils;

public class SQLCommand {
	public static String CUSTOMER_QUERY_FIND_ALL = "SELECT customer_id, customer_name\n" + "FROM Customer";
	public static String CUSTOMER_QUERY_ADD = "INSERT INTO Customer(customer_id, customer_name) "+ " VALUES (?, ?)\n"
			+ "SELECT @@ROWCOUNT";
	public static String CUSTOMER_QUERY_UPDATE = "UPDATE Customer SET customer_name = ? WHERE customer_id = ?";
	public static String ORDER_QUERY_UPDATE = "UPDATE Orders SET order_date = ?, customer_id = ?, employee_id = ?, total = ? WHERE order_id = ?";
	public static String CUSTOMER_QUERY_DELETE = "DELETE FROM Customer WHERE customer_id = ?";
	public static String ORDER_QUERY_DELETE = "DELETE FROM Orders WHERE customer_id = ?";
	public static String ORDER_ID_QUERY_DELETE = "DELETE FROM Orders WHERE customer_id = ?";
	public static String LINEITEM_QUERY_DELETE = "DELETE FROM LineItem WHERE order_id IN (SELECT order_id FROM Orders WHERE customer_id = ?)";
	public static String PRODUCT_QUERY_DELETE = "DELETE FROM Product WHERE product_id = ?";
	public static String ORDER_QUERY_FIND_BY_ID = "SELECT order_id, order_date, customer_id, employee_id, total\n" + "FROM Orders\n"
			+ "WHERE order_id = ?";
	public static String EMPLOYEE_QUERY_FIND_BY_ID = "SELECT employee_id, employee_name, salary, supervisor_id\n" + "FROM Employee\n"
			+ "WHERE employee_id = ?";
	public static String ORDER_QUERY_ADD = "INSERT INTO Orders(order_id, order_date, customer_id, employee_id, total)"
			+ "VALUES (?, ?, ?, ?, ?)\n" + "SELECT @@ROWCOUNT";
	public static String EMPLOYEE_QUERY_ADD = "INSERT INTO Employee(employee_id, employee_name, salary, supervisor_id)"
			+ "VALUES (?, ?, ?, ?)\n" + "SELECT @@ROWCOUNT";
	public static String ORDER_QUERY_FIND_ALL = "SELECT order_id, order_date, customer_id, employee_id, total\n" + "FROM Orders";
	public static String PRODUCT_QUERY_FIND_BY_ID = "SELECT product_id, product_name, list_price\n" + "FROM Product\n"
			+ "WHERE product_id = ?";
	public static String LINEITEM_QUERY_ADD = "INSERT INTO LineItem(order_id, product_id, quantity, price) "+ " VALUES (?, ?, ?, ?)\n"
			+ "SELECT @@ROWCOUNT";
	public static String PRODUCT_QUERY_ADD = "INSERT INTO Product(product_id, product_name, list_price)"
			+ "VALUES (?, ?, ?)\n" + "SELECT @@ROWCOUNT";
	public static String LINEITEM_QUERY_FIND_ALL = "SELECT order_id, product_id, quantity, price\n" + "FROM LineItem";
	public static String LINEITEM_QUERY_FIND_TOTAL_PRICE = "SELECT SUM(quantity * price) AS total_price\n" + "FROM LineItem\n" 
	        + "WHERE order_id = ?\n" + "GROUP BY order_id\n"; 
	public static String CUSTOMER_QUERY_FIND_BY_CUSTOMER_ID = "SELECT customer_id, customer_name\n" + "FROM Customer\n"
			+ "WHERE customer_id = ?";
}