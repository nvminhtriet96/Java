package fn.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import fn.dao.GoodStudentDAO;
import fn.dao.NormalStudentDAO;
import fn.entities.GoodStudent;
import fn.entities.NormalStudent;
import fn.entities.Student;
import fn.utils.InvalidDOBException;
import fn.utils.InvalidFullNameException;
import fn.utils.InvalidPhoneNumberException;
import fn.utils.StudentComparator;


public class RecruitmentManagement {
	

	public static void main(String[] args) throws InvalidDOBException, InvalidFullNameException, InvalidPhoneNumberException, SQLException {
		String choice;
		Scanner scanner = new Scanner(System.in);
		GoodStudentDAO goodStudentDAO = new GoodStudentDAO();
		NormalStudentDAO normalStudentDAO = new NormalStudentDAO();



		
		do {
			getMenu();
		    System.out.println("Enter your choice: ");
		    choice = scanner.nextLine();
		    
		    switch(choice) {
		    case "1":
		    	System.out.println("----------LIST OF GOOD STUDENTS----------");
		    	goodStudentDAO.readAndDisplayGoodStudent();
		    	break;
		    case "2":
		    	System.out.println("----------LIST OF NORMAL STUDENTS----------");
		    	normalStudentDAO.readAndDisplayNormalStudent();
		    	break;
		    case "3":
		    	List<GoodStudent> goodStudents = new ArrayList<>();
		    	goodStudents = null;
		    	goodStudents = goodStudentDAO.getListFromCSV();
		    	goodStudentDAO.saveDb(goodStudents);
		    	//ghi vào file khác lại
		    	goodStudentDAO.writeToCSV(goodStudents);
		    	if (goodStudents != null) {
		    		System.out.println("Save success");
		    	} else {
		    		System.out.println("Save fail");
		    	}
		    	break;
		    case "4":
		    	List<NormalStudent> normalStudents = new ArrayList<>();
		    	normalStudents = null;
		    	normalStudents = normalStudentDAO.getListFromCSV();
		    	normalStudentDAO.saveDb(normalStudents);
		    	// ghi vào file khác lại
		    	normalStudentDAO.writeToCSV(normalStudents);
		    	if (normalStudents != null) {
	
		    		System.out.println("Save success");
		    	} else {
		    		System.out.println("Save fail");
		    	}
		    	break;
		    case "5":
		    	try {
					boolean del1 = goodStudentDAO.deleteAll();
					if(del1 == true) {
						System.out.println("Delete success");
					} else {
						System.out.println("Delete fail");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	break;
		    case "6":
		    	try {
					boolean del2 = normalStudentDAO.deleteAll();
					if(del2 == true) {
						System.out.println("Delete success");
					} else {
						System.out.println("Delete fail");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	break;
		    case "7":
		    	int total;
				List<Student> listStudents = new ArrayList<>();
				do {
		    	System.out.println("Enter total student you want recruitment");
		    	String total1 = scanner.nextLine();
		    	total = Integer.parseInt(total1);
		    	if ((total < 11) || (total >15)) {
					System.out.println("Total student between 11->15 students");
		    	} else {
		    		break;
		    	}
		    	} while ((total < 11) || (total >15));
		    	List<GoodStudent> goodStudents2 = new ArrayList<>();
		    	List<NormalStudent> normalStudents2 = new ArrayList<>();
		    	goodStudents2 = goodStudentDAO.getAll();
		    	normalStudents2 = normalStudentDAO.getAll();
		    	Collections.sort(goodStudents2);
		    	Collections.sort(normalStudents2);
		    	if (goodStudents2 != null && normalStudents2 != null) {
		    		int i = 0;
		    		int count = total - goodStudents2.size();
		    		if (count <= 0) {
		    			for (GoodStudent goodstudent : goodStudents2) {
		    				listStudents.add(goodstudent);
		    				i++;
		    				if (i == total) {
		    					break;
		    				}
		    			}	
		    		} else if (count > 0) {
		    			for (GoodStudent goodstudent : goodStudents2) {
		    				listStudents.add(goodstudent);
		    			}
		    			i = 0;
		    			for (NormalStudent normalstudent : normalStudents2) {
		    				listStudents.add(normalstudent);
		    				i++;
		    				if (i == count) {
		    					break;
		    				}
		    			}
		    		}
		    		for (Student student : listStudents) {
		    			if (student instanceof GoodStudent) {
		    				GoodStudent goodStudent = (GoodStudent) student;
							System.out.println(goodStudent.ShowMyInfor());
		    			}
		    			else {
		    				NormalStudent normalStudent = (NormalStudent) student;
							System.out.println(normalStudent.ShowMyInfor());
		    			}
		    		}
		    	}
		    	break;
			case "9":
		    	normalStudents2 = normalStudentDAO.getAll();
		    	Collections.sort(normalStudents2);
		    	for (NormalStudent normalStudent : normalStudents2) {
		    		System.out.println(normalStudent.ShowMyInfor());
		    	}
		    	break;	
			case "8":
		    	goodStudents2 = goodStudentDAO.getAll();
		    	Collections.sort(goodStudents2);
		    	for (GoodStudent goodStudent : goodStudents2) {
		    		System.out.println(goodStudent.ShowMyInfor());
		    	}
		    	break;	
			 case "10":
			    List<GoodStudent> goodStudents3 = new ArrayList<>();
			    List<NormalStudent> normalStudents3 = new ArrayList<>();
			    List<Student> listStudents3 = new ArrayList<>();
			    if (goodStudents3 != null) {
					goodStudents3.clear();
				}
				if (normalStudents3 != null) {
					normalStudents3.clear();
				}
				if (listStudents3 != null) {
					listStudents3.clear();
				}		    
				goodStudents3 = goodStudentDAO.getAll();
		    	normalStudents3 = normalStudentDAO.getAll();
    			for (GoodStudent goodstudent : goodStudents3) {
    				listStudents3.add(goodstudent);
    			}
    			for (NormalStudent normalstudent : normalStudents3) {
    				listStudents3.add(normalstudent);
    			}
		    	Collections.sort(listStudents3, new StudentComparator());
		    	for (Student student : listStudents3) {
		    		System.out.println(student.getFullName()+ " " +student.getPhoneNumber());
		    	}
		    	break;
			case "11":
			    List<GoodStudent> goodStudents4 = new ArrayList<>();
    			System.out.println("Enter student id:");
			    String ID = scanner.nextLine();
			    int id = Integer.parseInt(ID);
			    goodStudents4 = goodStudentDAO.findData(id);
	    		System.out.println("--------- GOODSTUDENT ---------");
		    	for (GoodStudent goodStudent : goodStudents4) {
		    		System.out.println(goodStudent.ShowMyInfor());
		    	}
		    	break;
			case "12":
//			    List<Integer> listid = new ArrayList<>();
//			    listid = goodStudentDAO.findAllId();
//	    		System.out.println(listid);
    			System.out.println("Enter student id:");
			    String idcheck = scanner.nextLine();
			    int id2 = Integer.parseInt(idcheck);
			    boolean kq = goodStudentDAO.checkId(id2);
			    if (kq == true) {
	    			System.out.println("found id !!!");
			    } else {
	    			System.out.println("not found id:");
			    }
		    	break;


/*		    	do {
		    		Employee employee = new Employee();
				    // Set employee id
		    		do {
		    			System.out.println("Enter employee id:");
					    employeeId = scanner.nextLine();
					    employee.setEmployeeId(Integer.parseInt(employeeId));
					    if (employeeDAO.findEmployeeByEmployeeId(employee.getEmployeeId()) == null) {
					    	break;
					    }
					    else {
						System.out.println("Please re-type valid employee id!");
						}
				    } while(true);
		    		System.out.println("Enter employee name:");
		            employee.setEmployeeName(scanner.nextLine());
		    		System.out.println("Enter salary:");
		    		salary = scanner.nextLine();
		            employee.setSalary(Double.parseDouble(salary));
	    			System.out.println("Enter supervisor id:");
				    supervisorId = scanner.nextLine();
				    employee.setSupervisorId(Integer.parseInt(supervisorId));
		            boolean check = employeeDAO.saveEmployee(employee);
		            if (check) {
		            System.out.println("Saved success!");
		            }
		            else {
			        System.out.println("Saved fail!");
		            }
					// Do you want to continue?
					System.out.println("Do you want continue to add a employee (Y/N)?: ");
					loop = scanner.nextLine();
				} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
				break;
*/
		    case "13":
		    	if (scanner != null) {
		    		scanner.close();
		    	}
		    	System.exit(0);
		    	break;
		    default:
		        System.out.println("Invalid input!");
		        break;
		    } 
		} while(true);

	}
	
	public static void getMenu() {
	    System.out.println("-----Menu-----");
	    System.out.println("1. Read and display information student from file goodStudent.csv");
	    System.out.println("2. Read and display information student from file normalStudent.csv");
	    System.out.println("3. Save list of goodstudents into database");
	    System.out.println("4. Save list of normalstudents into database");
	    System.out.println("5. Delete all list of goodstudents of database");
	    System.out.println("6. Delete all list of normalstudents of database");
	    System.out.println("7. Recruit 11-15 students");
	    System.out.println("8. Display all info goodstudents from database");
	    System.out.println("9. Display all info normalstudents from database");
	    System.out.println("10. Display all students from database");
	    System.out.println("11. Insert goodstudents number typing into database");
	    System.out.println("12. Insert goodstudents number typing into database");
	    System.out.println("13. Exit");
		
	}

}


