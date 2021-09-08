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
import java.util.List;

import fn.entities.NormalStudent;
import fn.utils.DBUtils;
import fn.utils.InvalidDOBException;
import fn.utils.InvalidFullNameException;
import fn.utils.InvalidPhoneNumberException;
import fn.utils.Validator;


public class NormalStudentDAO {
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;
	
	/**
	 * Read data from normalstudent.csv file
	 * 
	 * @method readAndDisplayNormalStudent
	 * @param 
	 * @return 
	 * @throws FileNotFoundException
	 */
	public static void readAndDisplayNormalStudent() {
	String line;
	try {
		BufferedReader br = new BufferedReader(new FileReader("normalStudent.csv"));
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
	}
	}
	
	
	/**
	 * get data from normalstudent.csv file
	 * 
	 * @method getListFromCSV
	 * @param 
	 * @return 
	 * @throws InvalidDOBException, InvalidFullNameException, InvalidPhoneNumberException
	 */
	public static List<NormalStudent> getListFromCSV() throws InvalidDOBException, InvalidFullNameException, InvalidPhoneNumberException {
		FileReader fr = null;
		BufferedReader br = null;
		List<NormalStudent> listnt = new ArrayList<>();
		try {
			fr = new FileReader("normalStudent.csv");
			br = new BufferedReader(fr);
			String line = "";
			String[] infor;
			NormalStudent nt = new NormalStudent();
			while ((line = br.readLine()) != null) {
				infor = line.split(",");
				Date date = null;
				if (!Validator.isValidFullName(infor[0])) {
					System.out.println(infor[0]);
					throw new InvalidFullNameException("Sai fullname !!!");
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
 				nt = new NormalStudent(infor[0], date, infor[2], infor[3], infor[4], infor[5], Integer.parseInt(infor[6]),Double.parseDouble(infor[7]));
				listnt.add(nt);
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
	    return listnt;
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
	public static void saveDb(List<NormalStudent> listnt) {
		try {
			Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO NormalStudent (fullName, doB, sex, phoneNumber, universityName, gradeLevel, englishScore, entryTestScore) VALUES (?,?,?,?,?,?,?,?)");
			for (NormalStudent nst : listnt) {
    			//SimpleDateFormat javaDate = new SimpleDateFormat("dd/MM/YYYY");
    			//String date = javaDate.format(gst.getDoB());
				java.util.Date javaDate = new java.util.Date();
				javaDate = nst.getDoB();
				java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());

                stmt.setString(1, nst.getFullName());
                stmt.setDate(2, sqlDate);
                stmt.setString(3, nst.getSex());
                stmt.setString(4, nst.getPhoneNumber());
                stmt.setString(5, nst.getUniversityName());
                stmt.setString(6, nst.getGradeLevel());
                stmt.setInt(7, nst.getEnglishScore());
                stmt.setDouble(8, nst.getEntryTestScore());
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
	public static void writeToCSV(List<NormalStudent> list) {
		FileWriter fw = null;
	    BufferedWriter bw = null;
	    try {
	    	fw = new FileWriter("normalstuDent.tsv");
	    	bw = new BufferedWriter(fw);
	    	for (NormalStudent nst : list) {
	    		bw.append(nst.getFullName());
	    		bw.append("\t");
	    		bw.append(nst.getUniversityName());
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
	public List<NormalStudent> getAll() throws SQLException {
		List<NormalStudent> normalStudents = new ArrayList<>();
		NormalStudent normalStudent = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM NormalStudent");
			results = preparedStatement.executeQuery();
			while (results.next()) {
				normalStudent = new NormalStudent();

				normalStudent.setFullName(results.getString("fullName").trim());
				normalStudent.setDoB(results.getDate("doB"));
				normalStudent.setSex(results.getString("sex"));
				normalStudent.setPhoneNumber(results.getString("phoneNumber"));
				normalStudent.setUniversityName(results.getString("universityName"));
				normalStudent.setGradeLevel(results.getString("gradeLevel"));
				normalStudent.setEnglishScore(results.getInt("englishScore"));
				normalStudent.setEntryTestScore(results.getDouble("entryTestScore"));
				normalStudents.add(normalStudent);
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
		return normalStudents;
	}

	/**
	 * save object data to database
	 * 
	 * @method savenormalStudent
	 * @param 
	 * @return 
	 * @throws ParseException 
	 * @throws SQLException
	 */
	public boolean savenormalStudent(NormalStudent normalStudent) throws SQLException {
		boolean check = false;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO NormalStudent(fullName,doB,sex,phoneNumber,universityName ,gradeLevel,englishScore,entryTestScore) VALUES(?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, normalStudent.getFullName());
			java.util.Date javaDate = new java.util.Date();
			javaDate = normalStudent.getDoB();
			java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());
			preparedStatement.setDate(2, sqlDate);
			preparedStatement.setString(3, normalStudent.getSex());
			preparedStatement.setString(4, normalStudent.getPhoneNumber());
			preparedStatement.setString(5, normalStudent.getUniversityName());
			preparedStatement.setString(6, normalStudent.getGradeLevel());
			preparedStatement.setInt(7, normalStudent.getEnglishScore());
			preparedStatement.setDouble(8, normalStudent.getEntryTestScore());
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
			preparedStatement = connection.prepareStatement("DELETE FROM NormalStudent");
			int k = preparedStatement.executeUpdate();
			if (k > 0) {
				check = true;
			};
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

}
