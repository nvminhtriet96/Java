package fn.entities;

import java.time.LocalDate;
import java.util.Date;

public abstract class HouseForRent {
	private String Type;
	private String HouseID;
	private String Address;
	private String Area;
	private String RentalPrice;
	private String phone;
	private Date CreateDate;
	private String status = "0";
	
	// constructor
	public HouseForRent() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public HouseForRent(String Type, String HouseID, String Address, String Area, String RentalPrice,String phone, Date CreateDate, String status) {
		super();
		this.Type = Type;
		this.HouseID = HouseID;
		this.Address = Address;
		this.Area = Area;
		this.RentalPrice = RentalPrice;
		this.phone = phone;
		this.CreateDate = CreateDate;
		this.status = status;
	}

	// getter, setter method
	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getHouseID() {
		return HouseID;
	}

	public void setHouseID(String houseID) {
		HouseID = houseID;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getRentalPrice() {
		return RentalPrice;
	}

	public void setRentalPrice(String rentalPrice) {
		RentalPrice = rentalPrice;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	// display information of house for rent
	public abstract String ShowMyInfor();
}
