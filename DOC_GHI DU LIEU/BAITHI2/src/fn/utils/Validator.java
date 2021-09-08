package fn.utils;
/**
 * java doc
 * 
 * @author Minh Triet
 * @birthday 11/10/1996
 */
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Pattern;



public class Validator {

	
	public static boolean isValidDate(String date) {
		LocalDate d = LocalDate.now();
		String d1 = d.toString();
		String[] infor1 = new String[10];
		String[] infor2 = new String[10];
		infor1 = date.split("-");
		infor2 = d1.split("-");

		int ngay1 = Integer.parseInt(infor1[2]);
		int thang1 = Integer.parseInt(infor1[1]);
		int nam1 = Integer.parseInt(infor1[0]);
		int ngay2 = Integer.parseInt(infor2[2]);
		int thang2 = Integer.parseInt(infor2[1]);
		int nam2 = Integer.parseInt(infor2[0]);
		
		System.out.println(nam1);
		System.out.println(nam2);
		System.out.println(ngay1);
		System.out.println(ngay2);

		if (nam1 >= nam2) {
			return true;
		}
		if (ngay1 >= ngay2 && nam1 >= nam2) {
			return true;
		}
		return false;
	}

}
