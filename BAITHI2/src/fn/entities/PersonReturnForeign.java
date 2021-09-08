package fn.entities;

import java.util.Date;

/**
 * java doc
 * 
 * @author Minh Triet
 * @birthday 11/10/1996
 */
public class PersonReturnForeign extends Person {
	
	private int SoNgayCachLy = 21;
	private String QuocGia;
	private String MaChuyenBay;
	
	// constructor
	public PersonReturnForeign() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonReturnForeign(String iD, String hoTen, Date ngaySinh, Date ngayBatDauCachLy, String maPhongCachLy,
			boolean tinhTrang) {
		super(iD, hoTen, ngaySinh, ngayBatDauCachLy, maPhongCachLy, tinhTrang);
		// TODO Auto-generated constructor stub
	}
	public PersonReturnForeign(String iD, String hoTen, Date ngaySinh, Date ngayBatDauCachLy, String maPhongCachLy,
			boolean tinhTrang, int soNgayCachLy, String quocGia, String maChuyenBay) {
		super(iD, hoTen, ngaySinh, ngayBatDauCachLy, maPhongCachLy, tinhTrang);
		SoNgayCachLy = soNgayCachLy;
		QuocGia = quocGia;
		MaChuyenBay = maChuyenBay;
	}
	
	//getter, setter method
	public int getSoNgayCachLy() {
		return SoNgayCachLy;
	}
	public void setSoNgayCachLy(int soNgayCachLy) {
		SoNgayCachLy = soNgayCachLy;
	}
	public String getQuocGia() {
		return QuocGia;
	}
	public void setQuocGia(String quocGia) {
		QuocGia = quocGia;
	}
	public String getMaChuyenBay() {
		return MaChuyenBay;
	}
	public void setMaChuyenBay(String maChuyenBay) {
		MaChuyenBay = maChuyenBay;
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
		return "PersonReturnForeign [SoNgayCachLy=" + SoNgayCachLy + ", QuocGia=" + QuocGia + ", MaChuyenBay="
				+ MaChuyenBay + ", getSoNgayCachLy()=" + getSoNgayCachLy() + ", getQuocGia()=" + getQuocGia()
				+ ", getMaChuyenBay()=" + getMaChuyenBay() + ", getID()=" + getID() + ", getHoTen()=" + getHoTen()
				+ ", getNgaySinh()=" + getNgaySinh() + ", getNgayBatDauCachLy()=" + getNgayBatDauCachLy()
				+ ", getMaPhongCachLy()=" + getMaPhongCachLy() + ", isTinhTrang()=" + isTinhTrang() + ", ShowMyInfor()="
				+ "]";
	}

}
