package fn.entities;

import java.util.Date;
import java.time.LocalDate;

public class Store extends HouseForRent  {
	private String PrincipalFace;
	private String NumberOfFloors;
	
	// constructor
	public Store() {
		super();
	}
	
	public Store(String Type, String HouseID, String Address, String Area, String RentalPrice,String phone, Date CreateDate, String status, String PrincipalFace, String NumberOfFloors) {
		super(Type,  HouseID,  Address,  Area,  RentalPrice, phone, CreateDate,  status);
		this.PrincipalFace = PrincipalFace;
		this.NumberOfFloors = NumberOfFloors;
	}
	
	//getter, setter method
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return super.getType();
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		super.setType(type);
	}

	@Override
	public String getHouseID() {
		// TODO Auto-generated method stub
		return super.getHouseID();
	}

	@Override
	public void setHouseID(String houseID) {
		// TODO Auto-generated method stub
		super.setHouseID(houseID);
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return super.getAddress();
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		super.setAddress(address);
	}

	@Override
	public String getArea() {
		// TODO Auto-generated method stub
		return super.getArea();
	}

	@Override
	public void setArea(String area) {
		// TODO Auto-generated method stub
		super.setArea(area);
	}

	@Override
	public String getRentalPrice() {
		// TODO Auto-generated method stub
		return super.getRentalPrice();
	}

	@Override
	public void setRentalPrice(String rentalPrice) {
		// TODO Auto-generated method stub
		super.setRentalPrice(rentalPrice);
	}

	@Override
	public String getPhone() {
		// TODO Auto-generated method stub
		return super.getPhone();
	}

	@Override
	public void setPhone(String phone) {
		// TODO Auto-generated method stub
		super.setPhone(phone);
	}

	@Override
	public Date getCreateDate() {
		// TODO Auto-generated method stub
		return super.getCreateDate();
	}

	@Override
	public void setCreateDate(Date date) {
		// TODO Auto-generated method stub
		super.setCreateDate(date);
	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return super.getStatus();
	}

	@Override
	public void setStatus(String status) {
		// TODO Auto-generated method stub
		super.setStatus(status);
	}

	public String getPrincipalFace() {
		return PrincipalFace;
	}

	public void setPrincipalFace(String principalFace) {
		PrincipalFace = principalFace;
	}

	public String getNumberOfFloors() {
		return NumberOfFloors;
	}

	public void setNumberOfFloors(String numberOfFloors) {
		NumberOfFloors = numberOfFloors;
	}
	
	// display information of data
	@Override
	public String ShowMyInfor() {
		return "Store [PrincipalFace=" + PrincipalFace + ", NumberOfFloors=" + NumberOfFloors + ", getType()="
				+ getType() + ", getHouseID()=" + getHouseID() + ", getAddress()=" + getAddress() + ", getArea()="
				+ getArea() + ", getRentalPrice()=" + getRentalPrice() + ", getPhone()=" + getPhone()
				+ ", getCreateDate()=" + getCreateDate() + ", getStatus()=" + getStatus() + ", getPrincipalFace()="
				+ getPrincipalFace() + ", getNumberOfFloors()=" + getNumberOfFloors() + "]";
	}
//	@Override
//	public int compareTo(Store o) {
//		if (this.getGpa() == o.getGpa()) {
//			return this.getFullName().compareTo(o.getFullName());
//		}
//		if (this.getGpa() > o.getGpa()) {
//			return -1;
//		}
//		else {
//			return 1;
//		}
//	}
	
}

