package fn.entities;

import java.util.Date;

/**
 * java doc
 * 
 * @author Minh Triet
 * @birthday 11/10/1996
 */
public class PersonReturnProvince extends Person {
	
	private int SoNgayCachLy = 14;
	private String TinhThanh;
	private String PhuongTien;
	
	// constructor
	public PersonReturnProvince() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonReturnProvince(String iD, String hoTen, Date ngaySinh, Date ngayBatDauCachLy, String maPhongCachLy,
			boolean tinhTrang) {
		super(iD, hoTen, ngaySinh, ngayBatDauCachLy, maPhongCachLy, tinhTrang);
		// TODO Auto-generated constructor stub
	}
	public PersonReturnProvince(String iD, String hoTen, Date ngaySinh, Date ngayBatDauCachLy, String maPhongCachLy,
			boolean tinhTrang, int soNgayCachLy, String tinhThanh, String phuongTien) {
		super(iD, hoTen, ngaySinh, ngayBatDauCachLy, maPhongCachLy, tinhTrang);
		SoNgayCachLy = soNgayCachLy;
		TinhThanh = tinhThanh;
		PhuongTien = phuongTien;
	}
	
	//getter, setter method
	public int getSoNgayCachLy() {
		return SoNgayCachLy;
	}
	public void setSoNgayCachLy(int soNgayCachLy) {
		SoNgayCachLy = soNgayCachLy;
	}
	public String getTinhThanh() {
		return TinhThanh;
	}
	public void setTinhThanh(String tinhThanh) {
		TinhThanh = tinhThanh;
	}
	public String getPhuongTien() {
		return PhuongTien;
	}
	public void setPhuongTien(String phuongTien) {
		PhuongTien = phuongTien;
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return super.getID();
	}
	@Override
	public void setID(String iD) {
		// TODO Auto-generated method stub
		super.setID(iD);
	}
	@Override
	public String getHoTen() {
		// TODO Auto-generated method stub
		return super.getHoTen();
	}
	@Override
	public void setHoTen(String hoTen) {
		// TODO Auto-generated method stub
		super.setHoTen(hoTen);
	}
	@Override
	public Date getNgaySinh() {
		// TODO Auto-generated method stub
		return super.getNgaySinh();
	}
	@Override
	public void setNgaySinh(Date ngaySinh) {
		// TODO Auto-generated method stub
		super.setNgaySinh(ngaySinh);
	}
	@Override
	public Date getNgayBatDauCachLy() {
		// TODO Auto-generated method stub
		return super.getNgayBatDauCachLy();
	}
	@Override
	public void setNgayBatDauCachLy(Date ngayBatDauCachLy) {
		// TODO Auto-generated method stub
		super.setNgayBatDauCachLy(ngayBatDauCachLy);
	}
	@Override
	public String getMaPhongCachLy() {
		// TODO Auto-generated method stub
		return super.getMaPhongCachLy();
	}
	@Override
	public void setMaPhongCachLy(String maPhongCachLy) {
		// TODO Auto-generated method stub
		super.setMaPhongCachLy(maPhongCachLy);
	}
	@Override
	public boolean isTinhTrang() {
		// TODO Auto-generated method stub
		return super.isTinhTrang();
	}
	@Override
	public void setTinhTrang(boolean tinhTrang) {
		// TODO Auto-generated method stub
		super.setTinhTrang(tinhTrang);
	}
	
	// ghi de phuong thuc ShowMyInfor
	@Override
	public String ShowMyInfor() {
		return "PersonReturnProvince [SoNgayCachLy=" + SoNgayCachLy + ", TinhThanh=" + TinhThanh + ", PhuongTien="
				+ PhuongTien + ", getSoNgayCachLy()=" + getSoNgayCachLy() + ", getTinhThanh()=" + getTinhThanh()
				+ ", getPhuongTien()=" + getPhuongTien() + ", getID()=" + getID() + ", getHoTen()=" + getHoTen()
				+ ", getNgaySinh()=" + getNgaySinh() + ", getNgayBatDauCachLy()=" + getNgayBatDauCachLy()
				+ ", getMaPhongCachLy()=" + getMaPhongCachLy() + ", isTinhTrang()=" + isTinhTrang() + ", ShowMyInfor()="
				+ "]";
	}

}
