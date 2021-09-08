package fn.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import fn.utils.DBUtils;
import fn.entities.GoodStudent;
import fn.utils.InvalidDOBException;
import fn.utils.InvalidFullNameException;
import fn.utils.InvalidPhoneNumberException;
import fn.utils.Validator;

public class GoodStudentDAO {
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;
	
	/**
	 * Read data from goodstudent.csv file
	 * 
	 * @method readAndDisplayGoodStudent
	 * @param 
	 * @return 
	 * @throws FileNotFoundException
	 */
	public void readAndDisplayGoodStudent() {
	BufferedReader br = null;
	String line;
	try {
		br = new BufferedReader(new FileReader("goodStudent.csv"));
		int i = 0;
		try {
			while ((line = br.readLine()) != null) {
				String cols[] = line.split(",");
			    System.out.println("Hoc sinh " + (i+1) + ": " + cols[0]+ ", "  + cols[1] + ", "  + cols[2]+ ", "  + cols[3]+ ", "  + cols[4]+ ", "  + cols[5]+ ", "  + cols[6]+ ", "  + cols[7]);
			    i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
			if (br != null) {
				br.close();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	  }
	}
	
	/**
	 * get data from goodstudent.csv file
	 * 
	 * @method getListFromCSV
	 * @param 
	 * @return 
	 * @throws InvalidDOBException, InvalidFullNameException, InvalidPhoneNumberException
	 */
	public static List<GoodStudent> getListFromCSV() throws InvalidDOBException, InvalidFullNameException, InvalidPhoneNumberException {
		FileReader fr = null;
		BufferedReader br = null;
		List<GoodStudent> listgt = new ArrayList<>();
		try {
			fr = new FileReader("goodStudent.csv");
			br = new BufferedReader(fr);
			String line = "";
			String[] infor;
			GoodStudent gt = new GoodStudent();
			while ((line = br.readLine()) != null) {
				infor = line.split(",");
				Date date = null;
				if (!Validator.isValidFullName(infor[0])) {
					throw new InvalidFullNameException("Sai full name !!!");
				}
				
				//check date
				try {
					if (!Validator.isValidDOB(infor[1])) {
						System.out.println(infor[1]);
						throw new InvalidDOBException("Sai dob !!!");
					}
					date = new SimpleDateFormat("dd/MM/yyyy").parse(infor[1]);
				} catch (ParseException e) {
					throw new InvalidDOBException("Sai dob !!!");
				}

				//check phone number
				if (!Validator.isValidPhoneNumber(infor[3])) {
					throw new InvalidPhoneNumberException("Sai phone number !!!");
				}
 				gt = new GoodStudent(infor[0], date, infor[2], infor[3], infor[4], infor[5], Double.parseDouble(infor[6]), infor[7]);
				listgt.add(gt);
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
	    return listgt;
	}
	
	/**
	 * save data to database
	 * 
	 * @method saveDb
	 * @param 
	 * @return 
	 * @throws ParseException 
	 * @throws SQLException
	 */
	public static void saveDb(List<GoodStudent> listgt) {
		try {
			Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO GoodStudent (fullName, doB, sex, phoneNumber, universityName, gradeLevel, gpa, bestRewardName) VALUES (?,?,?,?,?,?,?,?)");
			for (GoodStudent gst : listgt) {
//    			SimpleDateFormat javaDate = new SimpleDateFormat("dd/MM/YYYY");
//    			String date = javaDate.format(gst.getDoB());
				java.util.Date javaDate = new java.util.Date();
				javaDate = gst.getDoB();
				java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());

                stmt.setString(1, gst.getFullName());
                stmt.setDate(2, sqlDate);
                stmt.setString(3, gst.getSex());
                stmt.setString(4, gst.getPhoneNumber());
                stmt.setString(5, gst.getUniversityName());
                stmt.setString(6, gst.getGradeLevel());
                stmt.setDouble(7, gst.getGpa());
                stmt.setString(8, gst.getBestRewardName());
                stmt.addBatch();
			}
			stmt.executeBatch();
		} catch(SQLException e ) {
			e.printStackTrace();
		}
	}
	
	/**
	 * write data to csv file
	 * 
	 * @method writeToCSV
	 * @param 
	 * @return 
	 * @throws ParseException 
	 * @throws SQLException
	 */
	public static void writeToCSV(List<GoodStudent> list) {
		FileWriter fw = null;
	    BufferedWriter bw = null;
	    try {
	    	fw = new FileWriter("goodstuDent.tsv");
	    	bw = new BufferedWriter(fw);
	    	for (GoodStudent gst : list) {
	    		bw.append(gst.getFullName());
	    		bw.append("\t");
	    		bw.append(gst.getUniversityName());
	    		bw.append("\r\n");
	    	}
	    	bw.flush();
	    } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	
	/**
	 * get data from database
	 * 
	 * @method getAll
	 * @param 
	 * @return 
	 * @throws ParseException 
	 * @throws SQLException
	 */
	public List<GoodStudent> getAll() throws SQLException {
		List<GoodStudent> goodStudents = new ArrayList<>();
		GoodStudent goodStudent = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM GoodStudent");
			results = preparedStatement.executeQuery();
			while (results.next()) {
				goodStudent = new GoodStudent();

				goodStudent.setFullName(results.getString("fullName").trim());
				goodStudent.setDoB(results.getDate("doB"));
				goodStudent.setSex(results.getString("sex"));
				goodStudent.setPhoneNumber(results.getString("phoneNumber"));
				goodStudent.setUniversityName(results.getString("universityName"));
				goodStudent.setGradeLevel(results.getString("gradeLevel"));
				goodStudent.setGpa(results.getDouble("gpa"));
				goodStudent.setBestRewardName(results.getString("bestRewardName"));
				goodStudents.add(goodStudent);
			}
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
		return goodStudents;
	}

	/**
	 * save object data to database
	 * 
	 * @method savegoodStudent
	 * @return 
	 * @throws ParseException 
	 * @throws SQLException
	 */
	public boolean savegoodStudent(GoodStudent goodStudent) throws SQLException {
		boolean check = false;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO GoodStudent(fullName,doB,sex,phoneNumber,universityName ,gradeLevel,gpa,bestRewardName) VALUES(?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, goodStudent.getFullName());
			java.util.Date javaDate = new java.util.Date();
			javaDate = goodStudent.getDoB();
			java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());
			preparedStatement.setDate(2, sqlDate);
			preparedStatement.setString(3, goodStudent.getSex());
			preparedStatement.setString(4, goodStudent.getPhoneNumber());
			preparedStatement.setString(5, goodStudent.getUniversityName());
			preparedStatement.setString(6, goodStudent.getGradeLevel());
			preparedStatement.setDouble(7, goodStudent.getGpa());
			preparedStatement.setString(8, goodStudent.getBestRewardName());
			results = preparedStatement.executeQuery();
			while (results.next()) {
				if (results.getInt(1) == 1) {
					check = true;
				}
			}
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
		return check;
	}
	
	/**
	 * delete all data from database
	 * 
	 * @method deleteAll
	 * @param 
	 * @return 
	 * @throws ParseException 
	 * @throws SQLException
	 */
	public boolean deleteAll() throws SQLException {
		boolean check = false;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM GoodStudent");
			int k = preparedStatement.executeUpdate();
			if (k > 0) {
				check = true;
			}
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
		return check;
	}
	
	/**
	 * find data from database
	 * 
	 * @method findData
	 * @param 
	 * @return 
	 * @throws ParseException 
	 * @throws SQLException
	 */
	public List<GoodStudent> findData(int id) throws SQLException {
		List<GoodStudent> goodStudents = new ArrayList<>();
		GoodStudent goodStudent = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM GoodStudent WHERE student_id = ?");
			preparedStatement.setInt(1, id);
			results = preparedStatement.executeQuery();
			while (results.next()) {
				goodStudent = new GoodStudent();
				goodStudent.setFullName(results.getString("fullName").trim());
				goodStudent.setDoB(results.getDate("doB"));
				goodStudent.setSex(results.getString("sex"));
				goodStudent.setPhoneNumber(results.getString("phoneNumber"));
				goodStudent.setUniversityName(results.getString("universityName"));
				goodStudent.setGradeLevel(results.getString("gradeLevel"));
				goodStudent.setGpa(results.getDouble("gpa"));
				goodStudent.setBestRewardName(results.getString("bestRewardName"));
				goodStudents.add(goodStudent);
			}
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
		return goodStudents;
	}
	
	/**
	 * find list id from database
	 * 
	 * @method findAllId
	 * @param 
	 * @return 
	 * @throws ParseException 
	 * @throws SQLException
	 */
	public List<Integer> findAllId() throws SQLException {
		List<Integer> listid = new ArrayList<>();
		int id = 0;

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("SELECT student_id FROM GoodStudent");
			results = preparedStatement.executeQuery();
			while (results.next()) {
				id = results.getInt("student_id");
				listid.add(id);
			}
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
		return listid;
	}
	
	/**
	 * check id in list id from database
	 * 
	 * @method checkId
	 * @param 
	 * @return 
	 * @throws ParseException 
	 * @throws SQLException
	 */
	public boolean checkId(int idCheck) throws SQLException {
		List<Integer> listid = new ArrayList<>();
		int id = 0;

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("SELECT student_id FROM GoodStudent");
			results = preparedStatement.executeQuery();
			while (results.next()) {
				id = results.getInt("student_id");
				listid.add(id);
			}
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
		if(listid.contains(idCheck)) {
			return true;
		}
		return false;
	}
	
	
}
	
