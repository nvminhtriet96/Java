package fn.entities;

import java.time.LocalDate;
import java.util.Date;

public class Apartment extends HouseForRent  {
	private String BedRoom;
	private String BadRoom;

	// constructor
	public Apartment() {
		super();
	}
	
	public Apartment(String Type, String HouseID, String Address, String Area, String RentalPrice,String phone, Date CreateDate, String status, String PrincipalFace, String NumberOfFloors, String BedRoom, String BadRoom) {
		super(Type,  HouseID,  Address,  Area,  RentalPrice, phone, CreateDate,  status);
		this.BedRoom = BedRoom;
		this.BadRoom = BadRoom;
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
	public void setCreateDate(Date createDate) {
		// TODO Auto-generated method stub
		super.setCreateDate(createDate);
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

	public String getBedRoom() {
		return BedRoom;
	}

	public void setBedRoom(String bedRoom) {
		BedRoom = bedRoom;
	}

	public String getBadRoom() {
		return BadRoom;
	}

	public void setBadRoom(String badRoom) {
		BadRoom = badRoom;
	}

	@Override
	public String ShowMyInfor() {
		return "Apartment [BedRoom=" + BedRoom + ", BadRoom=" + BadRoom + ", getType()=" + getType() + ", getHouseID()="
				+ getHouseID() + ", getAddress()=" + getAddress() + ", getArea()=" + getArea() + ", getRentalPrice()="
				+ getRentalPrice() + ", getPhone()=" + getPhone() + ", getCreateDate()=" + getCreateDate()
				+ ", getStatus()=" + getStatus() + ", getBedRoom()=" + getBedRoom() + ", getBadRoom()=" + getBadRoom()
				+ "]";
	}
}

	
