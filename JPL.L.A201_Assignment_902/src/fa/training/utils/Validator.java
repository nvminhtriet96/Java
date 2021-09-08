package fa.training.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fa.training.entities.Airport;
import fa.training.services.*;

public class Validator {

	private static final String VALID_FIXEDWING_ID_REGEX = "^FW([\\d]{5})";
	private static final String VALID_HELICOPTER_ID_REGEX = "^RW([\\d]{5})";
	private static final String VALID_AIRPORT_ID_REGEX = "^AP([\\d]{5})";
	private static final String VALID_MODEL_REGEX = "^.{1,40}$";
	private static final String VALID_PLANE_TYPE1_REGEX = "CAG";
	private static final String VALID_PLANE_TYPE2_REGEX = "LGR";
	private static final String VALID_PLANE_TYPE3_REGEX = "PRV";

	
	private static Set<String> idAirport = new HashSet<String>();
	private static Set<String> idHelicopter = new HashSet<String>();
	private static Set<String> idFixedwing = new HashSet<String>();
	
	/**
	 * Check helicopter id format is valid
	 * 
	 * @param id
	 * @return
	 */
	public static boolean isHelicopterId(String id) {
		Pattern pattern = Pattern.compile(VALID_HELICOPTER_ID_REGEX);
		Matcher matcher = pattern.matcher(id);
		return matcher.matches();
	}

	/**
	 * Check fixedwing id format is valid
	 * 
	 * @param id
	 * @return
	 */
	public static boolean isFixedwingId(String id) {
		Pattern pattern = Pattern.compile(VALID_FIXEDWING_ID_REGEX);
		Matcher matcher = pattern.matcher(id);
		return matcher.matches();
	}
	
	/**
	 * Check airport id format is valid
	 * 
	 * @param id
	 * @return
	 */
	public static boolean isAirportId(String id) {
		Pattern pattern = Pattern.compile(VALID_AIRPORT_ID_REGEX);
		Matcher matcher = pattern.matcher(id);
		return matcher.matches();
	}
	
	/**
	 * Check helicopter id format is valid
	 * 
	 * @param id
	 * @return
	 */
	public static boolean isModel(String model) {
		Pattern pattern = Pattern.compile(VALID_MODEL_REGEX);
		Matcher matcher = pattern.matcher(model);
		return matcher.matches();
	}
	
	/**
	 * Check if credit format is valid
	 * 
	 * @param credit
	 * @return
	 */
	public static double isCredit(String credit) {
		double doCredit = 0d;
		try {
			doCredit = Double.parseDouble(credit);
		} catch (NumberFormatException exception) {
			throw new NumberFormatException();
		}
		return doCredit;
	}

	/**
	 * Check if enrollment format is valid
	 * 
	 * @param enrollment
	 * @return
	 */
	public static int isEnrollment(String enrollment) {
		int intEnrollment = 0;
		try {
			intEnrollment = Integer.parseInt(enrollment);
		} catch (NumberFormatException exception) {
			throw new NumberFormatException();
		}
		return intEnrollment;
	}

	/**
	 * Check if an id airport exists or not
	 * 
	 * @param id
	 * @return
	 */
	public static boolean isExisted1(String id) {
		if (!idAirport.contains(id)) {
			idAirport.add(id);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Check if an id airport to be added is exists or not
	 * 
	 * @param id
	 * @return
	 * @throws IOException 
	 */
	public static boolean isExistedadd(String id) throws IOException {
		List<Airport> airports = new ArrayList<Airport>();
		AirportService airportService = new AirportService();
		
		airports = airportService.getAll();
		
		for (Airport airport : airports) {
			if (airport.getID().contains(id)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get the set id airport
	 * 
	 * @return
	 */
	public static Set<String> getIds1() {
		return idAirport;
	}

	/**
	 * Check if an id helicopter exists or not
	 * 
	 * @param id
	 * @return
	 */
	public static boolean isExisted2(String id) {
		if (!idHelicopter.contains(id)) {
			idHelicopter.add(id);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get the set id helicopter
	 * 
	 * @return
	 */
	public static Set<String> getIds2() {
		return idHelicopter;
	}
	
	/**
	 * Check if an id fixedwing exists or not
	 * 
	 * @param id
	 * @return
	 */
	public static boolean isExisted3(String id) {
		if (!idFixedwing.contains(id)) {
			idFixedwing.add(id);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get the set id fixedwing
	 * 
	 * @return
	 */
	public static Set<String> getIds3() {
		return idFixedwing;
	}
	
	/**
	 * Check fixedwing plane type 1 is valid
	 * 
	 * @param planeType
	 * @return
	 */
	public static boolean isPlaneType1(String planeType) {
		Pattern pattern = Pattern.compile(VALID_PLANE_TYPE1_REGEX);
		Matcher matcher = pattern.matcher(planeType);
		return matcher.matches();
	}
	
	/**
	 * Check fixedwing plane type 2 is valid
	 * 
	 * @param planeType
	 * @return
	 */
	public static boolean isPlaneType2(String planeType) {
		Pattern pattern = Pattern.compile(VALID_PLANE_TYPE2_REGEX);
		Matcher matcher = pattern.matcher(planeType);
		return matcher.matches();
	}
	
	/**
	 * Check fixedwing plane type 3 is valid
	 * 
	 * @param planeType
	 * @return
	 */
	public static boolean isPlaneType3(String planeType) {
		Pattern pattern = Pattern.compile(VALID_PLANE_TYPE3_REGEX);
		Matcher matcher = pattern.matcher(planeType);
		return matcher.matches();
	}
	
}