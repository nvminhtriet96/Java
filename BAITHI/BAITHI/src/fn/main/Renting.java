package fn.main;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import fn.dao.DAO;
import fn.entities.Apartment;
import fn.entities.HouseForRent;
import fn.entities.Office;
import fn.entities.Store;
import fn.utils.HouseComparator;
import fn.utils.InvalidDOBException;
import fn.utils.InvalidPrice;
import fn.utils.InvalidPhoneNumberException;

public class Renting {

	public static void main(String[] args) throws SQLException{
//		try {
			String choice;
			Scanner scanner = new Scanner(System.in);
			DAO dao = new DAO();

			do {
				getMenu();
				System.out.println("Enter your choice: ");
				choice = scanner.nextLine();

				switch (choice) {
				case "1":
					dao.insertFromCSV();

					break;
				case "2":
					dao.updateData();

					break;
				case "3":
					List<HouseForRent> listhouse = new ArrayList<>();
					listhouse = dao.getAll();
					Collections.sort(listhouse, new HouseComparator());
					System.out.println("Danh sach doi tuong HouseForRent");
					for(HouseForRent house : listhouse) {
						System.out.println(house.ShowMyInfor());
					}

					break;
				case "4":
					boolean kq = dao.delete();
					if (kq == true) {
						System.out.println("Xoa thanh cong du lieu");
					}
					else {
						System.out.println("Xoa that bai");
					}

					break;
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
			} while (true);
//		} catch (Exception e) {
//			System.out.println("input error..");
//		}
	}

	public static void getMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1. Doc file csv vao database ");
		System.out.println("2. Cap nhat gia tri vao database ");
		System.out.println("3. Yeu cau 3.1b ");
		System.out.println("4. Yeu cau 3.2 ");
		System.out.println("13. Exit");

	}

}
