package fn.dao;

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

import fn.entities.Apartment;
import fn.entities.HouseForRent;
import fn.entities.Office;
import fn.entities.Store;
import fn.utils.DBUtils;
import fn.utils.IDException;
import fn.utils.InvalidDOBException;
import fn.utils.InvalidPrice;
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

			fr = new FileReader("file.csv");
			br = new BufferedReader(fr);
			String line = "";
			String[] infor = new String[100];
			HouseForRent store = new Store();
			HouseForRent office = new Office();
			HouseForRent apartment = new Apartment();

			int count = 0;
			while ((line = br.readLine()) != null) {
				infor = line.split(" , ");
				boolean flag = true;
				count++;

//				test du lieu co chay on khong
				System.out.println(infor[0]);
				System.out.println(infor[1]);
				System.out.println(infor[2]);
				System.out.println(infor[3]);
				System.out.println(infor[4]);
				System.out.println(infor[5]);
				System.out.println(infor[6]);
				System.out.println(infor[7]);
				System.out.println(infor[8]);
				System.out.println(infor[9]);
				System.out.println(infor[10]);
				System.out.println(infor[11]);

				try {

					// validate
					if (infor[0].equals("1")) {
						double price = Double.parseDouble(infor[4]);
						if (price < 20000000) {
							flag = false;
							throw new InvalidPrice("Rental price must be more than or equal 20000000 !!!");
						}
					}
//					if (infor[0].equals("2")) {
//						double price = Double.parseDouble(infor[4]);
//						if (price < 20000000) {
//							flag = false;
//							throw new InvalidPrice("Rental price must be more than or equal 20000000 !!!");
//						}
//					}
//					if (infor[0].equals("3")) {
//						double price = Double.parseDouble(infor[4]);
//						if (price < 20000000) {
//							flag = false;
//							throw new InvalidPrice("Rental price must be more than or equal 20000000 !!!");
//						}
//					}
					if (!Validator.isValidPhoneNumber(infor[5])) {
						flag = false;
						throw new InvalidPhoneNumberException("Phone number must be....");
					}
					if (findData(infor[1])) {
						flag = false;
						throw new IDException(infor[1] + " has exist....");
					}

					// add kq vao database
					if (flag == true) {
						try {
							connection = DBUtils.getInstance().getConnection();
							preparedStatement = connection
									.prepareStatement("INSERT INTO House2 VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
							preparedStatement.setString(1, infor[0]);
							preparedStatement.setString(2, infor[1]);
							preparedStatement.setString(3, infor[2]);
							preparedStatement.setString(4, infor[3]);
							preparedStatement.setString(5, infor[4]);
							preparedStatement.setString(6, infor[5]);
							preparedStatement.setString(7, infor[6]);
							preparedStatement.setString(8, infor[7]);
							preparedStatement.setString(9, infor[8]);
							preparedStatement.setString(10, infor[9]);
							preparedStatement.setString(11, infor[10]);
							preparedStatement.setString(12, infor[11]);

							results = preparedStatement.executeUpdate();
							if (results == 1) {
								System.out.println("add data to database success !!!");
							}
						} catch (SQLException e) {
							e.printStackTrace();
						} finally {
							try {
								if (connection != null) {
									connection.close();
								}
								if (preparedStatement != null) {
									preparedStatement.close();
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}

//						if (flag == true) {
//							store = new Store(infor[0], infor[1], infor[2], infor[3], infor[4], infor[5], infor[6], "0",
//									infor[7], infor[8]);
//							System.out.println(store.ShowMyInfor());
//							listId.add(infor[1]);
//							try {
//								connection = DBUtils.getInstance().getConnection();
//								preparedStatement = connection.prepareStatement(
//										"INSERT INTO Store(Type,IDException,Address,Area,RetalPrice ,Phone,CreateDate,PrincipalFace,NumberOfFloor) VALUES(?,?,?,?,?,?,?,?)");
//								preparedStatement.setString(1, store.getType());
//								preparedStatement.setString(2, store.getHouseID());
//								preparedStatement.setString(3, store.getAddress());
//								preparedStatement.setDouble(4, store.getArea());
//								preparedStatement.setDouble(5, store.getRentalPrice());
//								preparedStatement.setString(6, store.getPhone());
//								preparedStatement.setString(7, store.getCreateDate());
//								preparedStatement.setDouble(8, store.getPrincipalFace());
//								preparedStatement.setDouble(9, store.getNumberOfFloors());
//								results = preparedStatement.executeQuery();
//								while (results.next()) {
//									if (results.getInt(1) == 1) {
//										System.out.println("add success !!!");
//									}
//								}
//							} finally {
//								try {
//									if (connection != null) {
//										connection.close();
//									}
//									if (preparedStatement != null) {
//										preparedStatement.close();
//									}
//								} catch (SQLException e) {
//									e.printStackTrace();
//								}
//							}
//						}
//
//					}

				} catch (InvalidPrice | InvalidPhoneNumberException | IDException e) {
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

	// update data from csv file to database
	public void updateData() throws SQLException {
		FileReader fr1 = null;
		BufferedReader br1 = null;
		FileReader fr2 = null;
		BufferedReader br2 = null;
		try {

			// Doc file 1
			fr1 = new FileReader("RentalPrice.txt");
			br1 = new BufferedReader(fr1);
			String line = "";
			String[] infor = new String[100];
			while ((line = br1.readLine()) != null) {
				infor = line.split(" , ");
//				System.out.println(infor[0]);
//				System.out.println(infor[1]);
//				System.out.println(infor[2]);
//				System.out.println(infor[3]);
//				System.out.println(infor[4]);
//				System.out.println(infor[5]);
//				System.out.println(infor[6]);
//				System.out.println(infor[7]);
//				System.out.println(infor[8]);
//				System.out.println(infor[9]);
			}

			// Doc file 2
			fr2 = new FileReader("file.csv");
			br2 = new BufferedReader(fr2);
			String line2 = "";
			String[] infor2 = new String[100];
			int count = 0;
			int index = 0;
			while ((line2 = br2.readLine()) != null) {
				infor2 = line2.split(" , ");
				boolean flag = true;
				count++;

//				test du lieu co chay on khong
//				System.out.println(infor2[0]);
//				System.out.println(infor2[1]);
//				System.out.println(infor2[2]);
//				System.out.println(infor2[3]);
//				System.out.println(infor2[4]);
//				System.out.println(infor2[5]);
//				System.out.println(infor2[6]);
//				System.out.println(infor2[7]);
//				System.out.println(infor2[8]);
//				System.out.println(infor2[9]);
//				System.out.println(infor2[10]);
//				System.out.println(infor2[11]);
				Double moi = new Double(Double.parseDouble(infor[index]));
				Double cu = new Double(Double.parseDouble(infor2[4]));
				if (!findData(infor2[1])) {
					continue;
				}
				if (moi > cu) {
					if (moi - cu > 0.2 * cu) {
						System.err.println("line " + count
								+ ":  Gia tri cho thue moi chenh lech qua 20% so voi gia cho thue cu !");
						continue;
					}
				}
				if (cu > moi) {
					if (cu - moi < 0.2 * cu) {
						System.err.println("line " + count
								+ ":  Gia tri cho thue moi chenh lech qua 20% so voi gia cho thue cu !");
						continue;
					}
				}

				// update
				try {
					connection = DBUtils.getInstance().getConnection();
					String sql = "update House2 Set RetalPrice = ? where HouseID = ?";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, infor[index]);
					preparedStatement.setString(2, infor2[1]);
					results = preparedStatement.executeUpdate();
					if (results == 1) {
						System.out.println("update data to database success !!!");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (connection != null) {
							connection.close();
						}
						if (preparedStatement != null) {
							preparedStatement.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				index++;

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br1 != null) {
					br1.close();
				}
				if (fr1 != null) {
					fr1.close();
				}
				if (br2 != null) {
					br2.close();
				}
				if (fr2 != null) {
					fr2.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// check id database
	public boolean findData(String id) throws SQLException {
		connection = DBUtils.getInstance().getConnection();
		preparedStatement = connection.prepareStatement("Select HouseID from House2 where HouseID = ?");
		preparedStatement.setString(1, id);
		ResultSet results2 = null;
		results2 = preparedStatement.executeQuery();
		while (results2.next()) {
			if (id.equals(results2.getString(1))) {
				return true;
			}
		}
		return false;
	}

	// get data from database
	public List<HouseForRent> getAll() throws SQLException {
		List<HouseForRent> listhouse = new ArrayList<>();
		ResultSet results3 = null;
		connection = DBUtils.getInstance().getConnection();
		preparedStatement = connection.prepareStatement("Select * from House2");
		results3 = preparedStatement.executeQuery();
		while (results3.next()) {
			if (results3.getString(1).equals("1")) {
				Store store = new Store();
				store.setType(results3.getString(1));
				store.setHouseID(results3.getString(2));
				store.setAddress(results3.getString(3));
				store.setArea(results3.getString(4));
				store.setRentalPrice(results3.getString(5));
				store.setPhone(results3.getString(6));
				store.setCreateDate(results3.getDate(7));
				listhouse.add(store);
			}
			if (results3.getString(1).equals("2")) {
				Office office = new Office();
				office.setType(results3.getString(1));
				office.setHouseID(results3.getString(2));
				office.setAddress(results3.getString(3));
				office.setArea(results3.getString(4));
				office.setRentalPrice(results3.getString(5));
				office.setPhone(results3.getString(6));
				office.setCreateDate(results3.getDate(7));
				listhouse.add(office);
			}
			if (results3.getString(1).equals("3")) {
				Apartment apartment = new Apartment();
				apartment.setType(results3.getString(1));
				apartment.setHouseID(results3.getString(2));
				apartment.setAddress(results3.getString(3));
				apartment.setArea(results3.getString(4));
				apartment.setRentalPrice(results3.getString(5));
				apartment.setPhone(results3.getString(6));
				apartment.setCreateDate(results3.getDate(7));
				listhouse.add(apartment);
			}
		}
		return listhouse;
	}
	
	// delete data from database
	public boolean delete() throws SQLException {
		int results4 = 5;
		connection = DBUtils.getInstance().getConnection();
		preparedStatement = connection.prepareStatement("delete from House2 where DATEDIFF(DAY,CreateDate,getdate()) > 90");
		results4 = preparedStatement.executeUpdate();
		if (results4 > 0) {
			System.out.println(results4);
			return true;
		}
		return false;
	}

}
