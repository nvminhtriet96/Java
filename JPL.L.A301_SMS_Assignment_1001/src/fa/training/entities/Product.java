package fa.training.entities;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	private int productId; 
	private String productName; 
	private double listPrice;
	
	public Product() {
		super();
	}
	
	public Product(int productId, String productName, double listPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.listPrice = listPrice;
	}
	
	// getter and setter
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	// overide toString() method
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", listPrice=" + listPrice + "]";
	}
	
}
