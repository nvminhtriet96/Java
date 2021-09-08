package fn.dao;

/**
 * java doc
 * 
 * @author Minh Triet
 * @birthday 11/10/1996
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fn.entities.Person;
import fn.entities.PersonReturnForeign;
import fn.entities.PersonReturnProvince;
import fn.utils.DBUtils;
import fn.utils.DataNotMatchException;
import fn.utils.DateInvalidException;
import fn.utils.IDException;
import fn.utils.InvalidDOBException;
import fn.utils.PersonDuplicateException;
import fn.utils.InvalidPhoneNumberException;
import fn.utils.Validator;

public class DAO {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private int results;

	// insert data from csv file to database
	public void insertFromCSV() throws SQLException {
		FileReader fr = null;
		BufferedReader br = null;
		try {

			fr = new FileReader("data.txt");
			br = new BufferedReader(fr);
			String line = "";
			String[] infor = new String[100];
			
			List<String> list = new ArrayList<>();
			list.add("1");
			list.add("2");

			int count = 0;
			while ((line = br.readLine()) != null) {
				infor = line.split(",");
				boolean flag = true;
				count++;
				try {

					// validate
					if (!findID(infor[1])) {
						flag = false;
						throw new PersonDuplicateException("ID " + infor[1] + " da bi trung lap voi truoc do");
					}
					if (!list.contains(infor[0])) {
						flag = false;
						throw new DataNotMatchException("Input sai thong tin loai nguoi cach ly!!!");
					} 
					if (!Validator.isValidDate(infor[4])) {
						flag = false;
						throw new DateInvalidException("Ngay sinh/Ngay cach ly khong hop le!!");
					}

					// add kq vao database
					if (flag == true) {
						
							connection = DBUtils.getInstance().getConnection();
							preparedStatement = connection
									.prepareStatement("INSERT INTO Person VALUES(?,?,?,?,?,?,?,?,?,?)");
							if(infor[0].equals("1")) {
								preparedStatement.setString(1, infor[0]);
								preparedStatement.setString(2, infor[1]);
								preparedStatement.setString(3, infor[2]);
								preparedStatement.setString(4, infor[3]);
								preparedStatement.setString(5, infor[4]);
								preparedStatement.setString(6, infor[5]);
								preparedStatement.setString(7, infor[6]);
								preparedStatement.setString(8, infor[7]);
								preparedStatement.setInt(9, 14);
								preparedStatement.setInt(10, 0);
							}
							if(infor[0].equals("2")) {
								preparedStatement.setString(1, infor[0]);
								preparedStatement.setString(2, infor[1]);
								preparedStatement.setString(3, infor[2]);
								preparedStatement.setString(4, infor[3]);
								preparedStatement.setString(5, infor[4]);
								preparedStatement.setString(6, infor[5]);
								preparedStatement.setString(7, infor[6]);
								preparedStatement.setString(8, infor[7]);
								preparedStatement.setInt(9, 21);
								preparedStatement.setInt(10, 0);
							}
							results = preparedStatement.executeUpdate();
							if (results == 1) {
								System.out.println("add data to database success !!!");
							}
						
					}

				} catch (DataNotMatchException | DateInvalidException | PersonDuplicateException e) {
					System.err.println("line " + count + ": " + e.getMessage());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// check id database
	public boolean findID(String id) throws SQLException {
		connection = DBUtils.getInstance().getConnection();
		preparedStatement = connection.prepareStatement("Select ID from Person where ID = ?");
		preparedStatement.setString(1, id);
		ResultSet results2 = null;
		results2 = preparedStatement.executeQuery();
		while (results2.next()) {
			if (id.equals(results2.getString(1))) {
				return false;
			}
		}
		return true;
	}

	// get data from database
	public List<Person> getData() throws SQLException {
		List<Person> listperson = new ArrayList<>();
		ResultSet results3 = null;
		connection = DBUtils.getInstance().getConnection();
		preparedStatement = connection.prepareStatement("Select * from Person where TinhTrang = 0 and DATEDIFF(DAY,NgayBatDauCachLy,getdate()) >= 14");
		results3 = preparedStatement.executeQuery();
		while (results3.next()) {
			if (results3.getString(1).equals("1")) {
				PersonReturnProvince nguoivn = new PersonReturnProvince();
				nguoivn.setID(results3.getString(2));
				nguoivn.setHoTen(results3.getString(3));
				nguoivn.setNgaySinh(results3.getDate(4));
				nguoivn.setNgayBatDauCachLy(results3.getDate(5));
				nguoivn.setMaPhongCachLy(results3.getString(6));
				nguoivn.setTinhThanh(results3.getString(7));
				nguoivn.setPhuongTien(results3.getString(8));
				nguoivn.setSoNgayCachLy(results3.getInt(9));
				nguoivn.setTinhTrang(results3.getBoolean(10));
				listperson.add(nguoivn);
			}
			if (results3.getString(1).equals("2")) {
				PersonReturnForeign nguoing = new PersonReturnForeign();
				nguoing.setID(results3.getString(2));
				nguoing.setHoTen(results3.getString(3));
				nguoing.setNgaySinh(results3.getDate(4));
				nguoing.setNgayBatDauCachLy(results3.getDate(5));
				nguoing.setMaPhongCachLy(results3.getString(6));
				nguoing.setQuocGia(results3.getString(7));
				nguoing.setMaChuyenBay(results3.getString(8));
				nguoing.setSoNgayCachLy(results3.getInt(9));
				nguoing.setTinhTrang(results3.getBoolean(10));
				listperson.add(nguoing);
			}

		}
		return listperson;
	}
	
	// update thong tin benh nhan vao database
	public boolean updateData(String id , String date) throws SQLException {
		connection = DBUtils.getInstance().getConnection();
		String sql = "update Person TinhTrang = ? where ID = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, 1);
		preparedStatement.setString(2, id);
		results = preparedStatement.executeUpdate();
		if (results == 1) {
			return true;
		}
		return false;
	}

	// delete data  benh nhan hoan thanh cach ly from database
	public boolean delete() throws SQLException {
		int results4 = 0;
		connection = DBUtils.getInstance().getConnection();
		preparedStatement = connection
				.prepareStatement("Delete * from Person where TinhTrang = 0 and DATEDIFF(DAY,NgayBatDauCachLy,getdate()) >= 14");
		results4 = preparedStatement.executeUpdate();
		if (results4 > 0) {
			return true;
		}
		return false;
	}
	

}
