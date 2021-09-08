package fn.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;



public class Validator {
	public static boolean isValidFullName(String name) {
		return Pattern.matches("^[a-z A-Z]{10,50}$", name);
//		if(Pattern.matches("^[a-z A-Z]{10,50}$", name))
//			return true;
//		else throw new InvalidFullNameException("abc");
	}
	
	public static boolean isValidPhoneNumber(String phonenumber) {
		return Pattern.matches("^0[0-9]{9}$", phonenumber);
	}
	
	public static boolean isValidDOB(String dob) {
		if (Pattern.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}", dob)) {
			String date[] = dob.split("/");
			if(Integer.parseInt(date[0]) <= 31 && Integer.parseInt(date[1]) <= 12 && Integer.parseInt(date[2]) >= 1900) {
				return true;
			}
		}
		return false;
	}

	
	
//	@SuppressWarnings("finally")
//	public static boolean isValidDOB(String dob) throws InvalidDOBException {	
//		Date date = new Date();
//		boolean check = true;
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
//		try {
//			date = dateFormat.parse(dob);
//		} catch(java.text.ParseException e) {
//			check = false;
//			throw new InvalidDOBException("Input files have unknown errors !!!");
//		} finally {
//			return check;
//		}
//	}

}
