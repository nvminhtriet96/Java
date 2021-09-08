package fn.entities;

import java.util.Date;

/**
 * java doc
 * 
 * @author Minh Triet
 * @birthday 11/10/1996
 */
public abstract class Person {
	// field
	private String ID;
	private String HoTen;
	private Date NgaySinh;
	private Date NgayBatDauCachLy;
	private String MaPhongCachLy;
	private boolean TinhTrang = false;
	
	//constructor
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String iD, String hoTen, Date ngaySinh, Date ngayBatDauCachLy, String maPhongCachLy,
			boolean tinhTrang) {
		super();
		ID = iD;
		HoTen = hoTen;
		NgaySinh = ngaySinh;
		NgayBatDauCachLy = ngayBatDauCachLy;
		MaPhongCachLy = maPhongCachLy;
		TinhTrang = tinhTrang;
	}

	//getter,setter method
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public Date getNgayBatDauCachLy() {
		return NgayBatDauCachLy;
	}

	public void setNgayBatDauCachLy(Date ngayBatDauCachLy) {
		NgayBatDauCachLy = ngayBatDauCachLy;
	}

	public String getMaPhongCachLy() {
		return MaPhongCachLy;
	}

	public void setMaPhongCachLy(String maPhongCachLy) {
		MaPhongCachLy = maPhongCachLy;
	}

	public boolean isTinhTrang() {
		return TinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		TinhTrang = tinhTrang;
	}

	// display information of person
	public abstract String ShowMyInfor();
	
	
}
