package fn.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import fn.dao.DAO;
import fn.entities.Person;
import fn.utils.InvalidDOBException;
import fn.utils.PersonComparator;
import fn.utils.InvalidPhoneNumberException;

public class AppMain {

	public static void main(String[] args) throws SQLException{
		try {
			String choice;
			Scanner sc = new Scanner(System.in);
			DAO dao = new DAO();

			do {
				getMenu();
				System.out.println("Enter your choice: ");
				choice = sc.nextLine();

				switch (choice) {
				case "1":
					dao.insertFromCSV();

					break;
				case "2":
					List<Person> listperson = new ArrayList<>();
					listperson = dao.getData();
					Collections.sort(listperson, new PersonComparator());
					System.out.println("Danh sach so nguoi da hoan thanh cach ly: ");
					for (Person person : listperson) {
						System.out.println(person.ShowMyInfor());
					}

					break;
				case "3":
					System.out.println("Nhap id nguoi bi nhiem virus: ");
					String id = sc.nextLine();
					if (dao.findID(id) == true) {
						System.err.println("ID " + id + "khong ton tai!");
						break;
					}
					System.out.println("Ngay phat hien nhiem: ");
					String ngay = sc.nextLine();
					boolean kq = dao.updateData(id, ngay);
					if(kq == true) {
						System.out.println("Cap nhat trang thai nguoi benh thanh cong !!!");
					}

					break;
				case "4":
					boolean kq2 = dao.delete();
					if (kq2 == true) {
						System.out.println("Da xoa du lieu nhung nguoi hoan thanh cach ly");
					}
					else {
						System.out.println("Khong co du lieu de xoa");
					}

					break;
				case "13":
					if (sc != null) {
						sc.close();
					}
					System.exit(0);
					break;
				default:
					System.out.println("Invalid input!");
					break;
				}
			} while (true);
		} catch (Exception e) {
			System.out.println("Program have an unexpected error occurred !!!");
		}
	}

	public static void getMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1. Doc file text vao database ");
		System.out.println("2. Lay danh sach tu database ");
		System.out.println("3. Update thon tin nguoi bi nhiem ");
		System.out.println("4. Xoa nguoi hoan thanh cach ly ");
		System.out.println("5. Exit");

	}

}
