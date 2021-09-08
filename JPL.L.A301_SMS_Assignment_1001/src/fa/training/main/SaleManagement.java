package fa.training.main;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import fa.training.dao.*;
import fa.training.entities.*;
import fa.training.dao.CustomerDAO;
import fa.training.dao.CustomerDAOImpl;

public class SaleManagement {
	
	static CustomerDAO customerDAO = new CustomerDAOImpl();
	static OrderDAO orderDAO = new OrderDAOImpl();
	static EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	static LineItemDAO lineItemDAO = new LineItemDAOImpl();
	static ProductDAO productDAO = new ProductDAOImpl();


	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
	    String choice = "";
	    String customerId, loop, orderId, employeeId, total, salary, supervisorId;
	    String productId, price, quantity, productName, listPrice;
	    List<Customer> customers = new ArrayList<>();
	    List<Order> orders = new ArrayList<>();
	    List<LineItem> lineItems = new ArrayList<>();


		do {
			getMenu();
		    System.out.println("Enter your choice:");
		    choice = scanner.nextLine();
		    
		    switch(choice) {
		    case "1":
		    	do {
		    		Customer customer = new Customer();
				    // Set customer id
		    		do {
		    			System.out.println("Enter customer id:");
					    customerId = scanner.nextLine();
					    customer.setCustomerId(Integer.parseInt(customerId));
					    if (customerDAO.findCustomerByCustomerId(customer.getCustomerId()) == null) {
					    	break;
					    }
					    else {
						System.out.println("Please re-type valid customer id!");
						}
				    } while(true);
		    		System.out.println("Enter customer name:");
		            customer.setCustomerName(scanner.nextLine());
		            boolean check = customerDAO.saveCustomer(customer);
		            if (check) {
		            System.out.println("Saved success!");
		            }
		            else {
			        System.out.println("Saved fail!");
		            }
					// Do you want to continue?
					System.out.println("Do you want continue to add a customer (Y/N)?: ");
					loop = scanner.nextLine();
				} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
		    	break;  	
		    case "2":
		    	customers = customerDAO.getAll();
		    	if (customers.isEmpty()) {
			          System.out.println("No customer found!");
		    	} else {
			          System.out.println("---List of customers---");
			          customers.stream().sorted(Comparator.comparingInt(Customer::getCustomerId)).forEach(System.out::println);
		    	}
		    	break;	
		    case "3":
		    	do {
		    		Employee employee = new Employee();
				    // Set employee id
		    		do {
		    			System.out.println("Enter employee id:");
					    employeeId = scanner.nextLine();
					    employee.setEmployeeId(Integer.parseInt(employeeId));
					    if (employeeDAO.findEmployeeByEmployeeId(employee.getEmployeeId()) == null) {
					    	break;
					    }
					    else {
						System.out.println("Please re-type valid employee id!");
						}
				    } while(true);
		    		System.out.println("Enter employee name:");
		            employee.setEmployeeName(scanner.nextLine());
		    		System.out.println("Enter salary:");
		    		salary = scanner.nextLine();
		            employee.setSalary(Double.parseDouble(salary));
	    			System.out.println("Enter supervisor id:");
				    supervisorId = scanner.nextLine();
				    employee.setSupervisorId(Integer.parseInt(supervisorId));
		            boolean check = employeeDAO.saveEmployee(employee);
		            if (check) {
		            System.out.println("Saved success!");
		            }
		            else {
			        System.out.println("Saved fail!");
		            }
					// Do you want to continue?
					System.out.println("Do you want continue to add a employee (Y/N)?: ");
					loop = scanner.nextLine();
				} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
		    	break;  		
		    case "4":
		    	do {
		    		Order order = new Order();
				    // Set order id
		    		do {
		    			System.out.println("Enter order id:");
					    orderId = scanner.nextLine();
					    order.setOrderId(Integer.parseInt(orderId));
					    if (orderDAO.findOrderByOrderId(order.getOrderId()) == null) {
					    	break;
					    }
					    else {
						System.out.println("Please re-type valid order id!");
						}
				    } while(true);
		    		// Set order date
			        order.setOrderDate(getCurrentDate(scanner));
				    // Set customer id
		    		Customer customer = new Customer();
		    		do {
		    			System.out.println("Enter customer id:");
					    customerId = scanner.nextLine();
					    customer.setCustomerId(Integer.parseInt(customerId));
					    order.setCustomerId(Integer.parseInt(customerId));
					    if (customerDAO.findCustomerByCustomerId(customer.getCustomerId()) != null) {
					    	break;
					    }
					    else {
						System.out.println("Please re-type valid customer id!");
						}
				    } while(true);
				    // Set employee id
		    		Employee employee = new Employee();
		    		do {
		    			System.out.println("Enter employee id:");
					    employeeId = scanner.nextLine();
					    employee.setEmployeeId(Integer.parseInt(employeeId));
					    order.setEmployeeId(Integer.parseInt(employeeId));
					    if (employeeDAO.findEmployeeByEmployeeId(employee.getEmployeeId()) != null) {
					    	break;
					    }
					    else {
						System.out.println("Please re-type valid employee id!");
						}
				    } while(true);
		    		// Set total
		    		System.out.println("Enter total:");
		    		total = scanner.nextLine();
		            order.setTotal(Double.parseDouble(total));
		            boolean check = orderDAO.saveOrder(order);
		            if (check) {
		            System.out.println("Saved success!");
		            }
		            else {
			        System.out.println("Saved fail!");
		            }
					// Do you want to continue?
					System.out.println("Do you want continue to add a order (Y/N)?: ");
					loop = scanner.nextLine();
				} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
		    	break;	
		    case "5":
		    	System.out.println("Enter customer id on list of orders:");
			    String customerIdFinal1 = scanner.nextLine();
			    final int customerIdFinal2 = Integer.parseInt(customerIdFinal1);
		    	orders = orderDAO.getAll();
		    	if (orders.isEmpty()) {
			          System.out.println("No order found!");
			          break;
		    	} else {
		    		if (orders.stream().anyMatch((Order order) -> customerIdFinal2 == order.getCustomerId())) {
		    			System.out.println("---List of orders from customer id---");
		    			for (Order order1: orders) {
		    				if(order1.getCustomerId() == customerIdFinal2) {
		    					System.out.println(order1);
		    				} 
		    			}
		    		} else {
				        System.out.println("No order found!");
		    		}
		    	  }
		    	break;
		    case "6":
		    	do {
		    		LineItem lineItem = new LineItem();
				    // Set order id
		    		do {
		    			System.out.println("Enter order id:");
					    orderId = scanner.nextLine();
					    lineItem.setOrderId(Integer.parseInt(orderId));
					    if (orderDAO.findOrderByOrderId(lineItem.getOrderId()) == null) {
					    	break;
					    }
					    else {
						System.out.println("Please re-type valid order id!");
						}
				    } while(true);
				    // Set product id
		    		do {
		    			System.out.println("Enter product id:");
					    productId = scanner.nextLine();
					    lineItem.setProductId(Integer.parseInt(productId));
					    if (productDAO.findProductByProductId(lineItem.getProductId()) == null) {
					    	break;
					    }
					    else {
						System.out.println("Please re-type valid product id!");
						}
				    } while(true);
		    		// Set quantity
		    		System.out.println("Enter quantity:");
		    		quantity = scanner.nextLine();
		    		lineItem.setQuantity(Integer.parseInt(quantity));
		    		// Set price
		    		System.out.println("Enter price:");
		    		price = scanner.nextLine();
		    		lineItem.setPrice(Double.parseDouble(price));
		            boolean check = lineItemDAO.saveLineItem(lineItem);
		            if (check) {
		            System.out.println("Saved success!");
		            }
		            else {
			        System.out.println("Saved fail!");
		            }
					// Do you want to continue?
					System.out.println("Do you want continue to add a item (Y/N)?: ");
					loop = scanner.nextLine();
				} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
		    	break;
		    case "7":
		    	do {
		    		Product product = new Product();
				    // Set product id
		    		do {
		    			System.out.println("Enter product id:");
					    productId = scanner.nextLine();
					    product.setProductId(Integer.parseInt(productId));
					    if (productDAO.findProductByProductId(product.getProductId()) == null) {
					    	break;
					    }
					    else {
						System.out.println("Please re-type valid product id!");
						}
				    } while(true);
				    // Set product name
		    		System.out.println("Enter product name:");
					productName = scanner.nextLine();
					product.setProductName(productName.trim());
		    		// Set list price
		    		System.out.println("Enter list price:");
		    		listPrice = scanner.nextLine();
		    		product.setListPrice(Double.parseDouble(listPrice));
		            boolean check = productDAO.saveProduct(product);
		            if (check) {
		            System.out.println("Saved success!");
		            }
		            else {
			        System.out.println("Saved fail!");
		            }
					// Do you want to continue?
					System.out.println("Do you want continue to add a product (Y/N)?: ");
					loop = scanner.nextLine();
				} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
		    	break;
		    case "8":
		    	System.out.println("Enter order id on list of lineitems:");
			    String orderIdFinal1 = scanner.nextLine();
			    final int orderIdFinal2 = Integer.parseInt(orderIdFinal1);
		    	lineItems = lineItemDAO.getAll();
		    	if (lineItems.isEmpty()) {
			          System.out.println("Error: Cannot found!");
			          break;
		    	} else {
		    		if (lineItems.stream().anyMatch((LineItem lineItem) -> orderIdFinal2 == lineItem.getOrderId())) {
		    			System.out.println("---List of lineitems from order id---");
		    			for (LineItem lineItem1: lineItems) {
		    				if(lineItem1.getOrderId() == orderIdFinal2) {
		    					System.out.println(lineItem1);
		    				} 
		    			}
		    		} else {
				        System.out.println("No lineitem found!");
		    		}
		    	  }
		    	break;
		    case "9":
		    	do {
		    		LineItem lineItem = new LineItem();
		    		do {
		    			System.out.println("Enter order id on list of lineitems:");
					    orderId = scanner.nextLine();
					    lineItem.setOrderId(Integer.parseInt(orderId));
					    if (orderDAO.findOrderByOrderId(lineItem.getOrderId()) != null) {
					    	break;
					    }
					    else {
						System.out.println("Please re-type valid order id!");
						}
				    } while(true);
				    final int orderIdFinal3 = Integer.parseInt(orderId);
				    Double result = lineItemDAO.getTotalPrice(orderIdFinal3);
				    System.out.println("The total price of lineitems has order id " + orderIdFinal3 + " is: " + result);
					System.out.println("Do you want continue to calculate total price of lineitems (Y/N)?: ");
					loop = scanner.nextLine();
				} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
		    	break;
		    case "10":
		    	if (!customers.isEmpty()) {
		    		customers.clear();
		    	}
		    	loop = "";
		    	do {
		    		Customer customer = new Customer();
		    		do {
	    			System.out.println("Delete a customer:");
	    			System.out.println("Enter customer id:");
				    customerId = scanner.nextLine();
				    customer.setCustomerId(Integer.parseInt(customerId));
				    if (customerDAO.findCustomerByCustomerId(customer.getCustomerId()) != null) {
				    	break;
				    }
				    else {
					System.out.println("Please re-type a customer id on the list!");
					}
			        } while(true);
		            //customers.add(customer);
			    	boolean checkDelete = customerDAO.deleteCustomers(customer);
		            if (checkDelete) {
		            System.out.println("Delete success!");
		            }
		            else {
			        System.out.println("Delete fail!");
		            }
		            System.out.println("Do you want to continue deleting (Y|N)?");
		            loop = scanner.nextLine();
		    	} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
			    break; 	
		    case "11":
		    	do {
		    		Customer customer = new Customer();
		    		loop ="";
		    		do {
		    			System.out.println("Update a customer:");
		    			System.out.println("Enter customer id:");
					    customerId = scanner.nextLine();
					    customer.setCustomerId(Integer.parseInt(customerId));
					    if (customerDAO.findCustomerByCustomerId(customer.getCustomerId()) != null) {
					    	break;
					    }
					    else {
						System.out.println("Please re-type a customer id on the list!");
						}
				    } while(true);
		    		System.out.println("Enter customer name to change:");
		            customer.setCustomerName(scanner.nextLine());
		            boolean check = customerDAO.updateCustomer(customer);
		            if (check) {
		            System.out.println("Update success!");
		            }
		            else {
			        System.out.println("Update fail!");
		            }
					// Do you want to continue?
					System.out.println("Do you want continue to update a customer (Y/N)?: ");
					loop = scanner.nextLine();
				} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
		    	break;
		    case "12":
		    	do {
		    		Order order = new Order();
		    		loop ="";
		    		do {
		    			System.out.println("Update an order:");
		    			System.out.println("Enter order id:");
					    orderId = scanner.nextLine();
					    order.setOrderId(Integer.parseInt(orderId));
					    if (orderDAO.findOrderByOrderId(order.getOrderId()) != null) {
					    	break;
					    }
					    else {
						System.out.println("Please re-type an order id on the list!");
						}
				    } while(true);
		    		System.out.println("Enter order date to change:");
			        order.setOrderDate(getCurrentDate(scanner));
				    // Set customer id
		    		Customer customer = new Customer();
		    		do {
		    			System.out.println("Enter customer id:");
					    customerId = scanner.nextLine();
					    customer.setCustomerId(Integer.parseInt(customerId));
					    order.setCustomerId(Integer.parseInt(customerId));
					    if (customerDAO.findCustomerByCustomerId(customer.getCustomerId()) != null) {
					    	break;
					    }
					    else {
						System.out.println("Please re-type valid customer id!");
						}
				    } while(true);
				    // Set employee id
		    		Employee employee = new Employee();
		    		do {
		    			System.out.println("Enter employee id:");
					    employeeId = scanner.nextLine();
					    employee.setEmployeeId(Integer.parseInt(employeeId));
					    order.setEmployeeId(Integer.parseInt(employeeId));
					    if (employeeDAO.findEmployeeByEmployeeId(employee.getEmployeeId()) != null) {
					    	break;
					    }
					    else {
						System.out.println("Please re-type valid employee id!");
						}
				    } while(true);
		    		// Set total
		    		System.out.println("Enter total:");
		    		total = scanner.nextLine();
		            order.setTotal(Double.parseDouble(total));			      			        
		            boolean check = orderDAO.updateOrder(order);
		            if (check) {
		            System.out.println("Update success!");
		            }
		            else {
			        System.out.println("Update fail!");
		            }
					// Do you want to continue?
					System.out.println("Do you want continue to update an order (Y/N)?: ");
					loop = scanner.nextLine();
				} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
		    	break;
		    case "13":
		    	if (scanner != null) {
		    		scanner.close();
		    	}
		    	System.exit(0);
		    	break;
		    default:
		        System.out.println("Invalid input!");
		        break;
		    } 
		} while(true);
	}
	
	public static void getMenu() {
	    System.out.println("-----Menu-----");
	    System.out.println("1. Create new customer");
	    System.out.println("2. Display all customers, sorted by customer id");
	    System.out.println("3. Create new employee");
	    System.out.println("4. Create new order");
	    System.out.println("5. Display one or more order(s) from a customer");
	    System.out.println("6. Create new lineitem");
	    System.out.println("7. Create new product");
	    System.out.println("8. Display one or more lineitem(s) from a order");
	    System.out.println("9. Display the total price of lineitem from a order");
	    System.out.println("10. Delete a customer from database");
	    System.out.println("11. Update a customer from database");
	    System.out.println("12. Update an order from database");
	    System.out.println("13. Exit");
		
	}
	
	public static Date getCurrentDate(Scanner scanner) {
	    String orderdate;
	    Date date = new Date();
		System.out.println("Enter order date:");
	    orderdate = scanner.nextLine();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = format.parse(orderdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
