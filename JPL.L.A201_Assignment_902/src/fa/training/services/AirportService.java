package fa.training.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.*;
import fa.training.utils.*;

public class AirportService {
	
	/**
	 * Input list of airport
	 * 
	 * @param scanner
	 * @return
	 */
	public List<Airport> createAirport(Scanner scanner) {
		String loop, id, name, runWaySize, maxFixedWingParkingPlace, maxRotatedWingParkingPlace;
		String status;
		Airport airport;
		List<Airport> airports = new ArrayList<Airport>();
		AirportService airportService = new AirportService();

		do {
			airport = new Airport();
			// Set airport id
			do {
				System.out.println("Enter airport id:");
				id = scanner.nextLine();
				try {
					airport.setID(id);
				} catch (InvalidIdException e) {
					System.out.println(e);
					continue;
				} catch (IOException ioe) {
					// TODO Auto-generated catch block
					System.out.println(ioe);
				}
				break;
			} while (true);

			// Set airport name
			System.out.println("Enter airport name:");
			name = scanner.nextLine();
	        airport.setName(name);

			// Set runway size
			System.out.println("Enter runway size:");
			runWaySize = scanner.nextLine();
			airport.setRunWaySize(Double.parseDouble(runWaySize));
		
			// Set maxFixedWingParkingPlace size
			System.out.println("Enter max fixed wing parking place:");
			maxFixedWingParkingPlace = scanner.nextLine();
			airport.setMaxFixedWingParkingPlace(Double.parseDouble(maxFixedWingParkingPlace));

			// Set maxFixedWingParkingPlace size
			System.out.println("Enter max rotated wing parking place:");
			maxRotatedWingParkingPlace = scanner.nextLine();
			airport.setMaxRotatedWingParkingPlace(Double.parseDouble(maxRotatedWingParkingPlace));
			
			// Reader data from source file 
			try {
				airports = airportService.getAll();
			} catch (IOException e1) {
				System.out.println("Cannot get data from File!");				
			}

			// Add airport to list
			airports.add(airport);
			
			// Save airport to file
			try {
				status = airportService.save(airports);
				System.out.println("Save: " + status);
			} catch (Exception e) {
				System.out.println("Save Fail!");
			}

			// Do you want to continue?
			System.out.println("Do you want continue to input airport (Y/N)?: ");
			loop = scanner.nextLine();
		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
		return airports;
	}
	
	/**
	 * Save list of airport to file
	 * 
	 * @param airport
	 * @return
	 * @throws Exception
	 */
	public String save(List<Airport> airports) throws Exception {
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(Constant.FILE_PATH));
			objectOutputStream.writeObject(airports);
		} catch (Exception exception) {
			throw new Exception();
		} finally {
			if (objectOutputStream != null) {
				objectOutputStream.close();
			}
		}
		return Constant.SUCCESS;
	}

	/**
	 * Get all the airports in file
	 * 
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public List<Airport> getAll() throws IOException {
		ObjectInputStream objectInputStream = null;
		List<Airport> airports;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(Constant.FILE_PATH));
			airports = (List<Airport>) objectInputStream.readObject();
		} catch (Exception exception) {
			throw new IOException();
		} finally {
			if (objectInputStream != null) {
				objectInputStream.close();
			}
		}
		return airports;
	}
	
	/**
	 * Sort and display the airport by id
	 * 
	 * @param list
	 */
	public void sortAndDisplay(List<Airport> airports) {

		Collections.sort(airports, new AirportIdCompare());

		System.out.println("---------------AIRPORT LIST-------------------");

		for (Airport airport : airports) {
			System.out.println(airport);
		}
	}
	
	/**
	 *  save file and remove helicopterId from airport list
	 * 
	 * @param list
	 * @throws IOException 
	 */
	public void saveandremoveid(String id) throws IOException {
	// Open Airport file
	List<Airport> airports = new ArrayList<Airport>();
	AirportService airportService = new AirportService();
	String status;

	airports = airportService.getAll();

	for (Airport ap : airports) {
		if (ap.getHelicoptersIDs() == null) {
			ap.setHelicoptersIDs(new HashSet<String>());
		}
		else if (ap.getHelicoptersIDs().contains(id)) {
			ap.getHelicoptersIDs().remove(id);
		}
	}

	try {
		status = airportService.save(airports);
		System.out.println("Save Airport: " + status);
	} catch (Exception e) {
		System.out.println("Save Airport Fail!");
	}
	}


}
