package fa.training.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import fa.training.entities.*;
import fa.training.utils.*;

public class FixedwingService {
	

		
	/**
	 * Input list of fixedwing
	 * 
	 * @param scanner
	 * @return
	 * @throws IOException 
	 * @throws Exception 
	 */
	public List<Fixedwing> createFixedwing(Scanner scanner) throws IOException {
		String loop, id, model, planeType, emptyWeight, maxTakeOffWeight;
		String id_ap, cruiseSpeed, minNeededRunAwaySize;
		String status, range;
		Fixedwing fixedwing;
		List<Fixedwing> fixedwings = new ArrayList<Fixedwing>();
		FixedwingService fixedwingService = new FixedwingService();
		
		List<Airport> airports = new ArrayList<Airport>();
		AirportService airportService = new AirportService();
		Airport airport;
		Set<String> id_Fixedwing = new HashSet<String>();
		
		Validator valid = new Validator();
		do {
			airport = new Airport();
			fixedwing = new Fixedwing();
			
			// Check airport id
			do {
				System.out.println("Enter airport id to add fixedwing:");
				id_ap = scanner.nextLine();
				if (valid.isExistedadd(id_ap)) {
					if (valid.isAirportId(id_ap)) {
						break;
					}
				}
				else {
					System.out.println("Airport is not match !!!");
				}
			} while(true);

			
			// Set fixedwing id
			do {
				System.out.println("Enter fixedwing id:");
				id = scanner.nextLine();
				id_Fixedwing.add(id);
				try {
					fixedwing.setID(id);
					id_Fixedwing.add(id); 
				} catch (InvalidIdException e) {
					System.out.println(e);
					continue;
				}
				break;
			} while (true);

			// Set fixedwing model
			do {
				System.out.println("Enter model:");
				model = scanner.nextLine();
				try {
					fixedwing.setModel(model);				
				} catch (InvalidModelException e1) {
					System.out.println(e1);
					continue;
				}
				break;
			} while (true);

			// Set plane type
			do {
				System.out.println("Enter plane type:");
				planeType = scanner.nextLine();
				try {
					fixedwing.setPlaneType(planeType);				
				} catch (InvalidPlaneTypeException e) {
					System.out.println(e);
					continue;
				}
				break;
			} while (true);
			
			// Set cruise speed
			System.out.println("Enter cruise speed:");
			cruiseSpeed = scanner.nextLine();
			fixedwing.setCruiseSpeed(Double.parseDouble(cruiseSpeed));
		
			// Set empty weight
			System.out.println("Enter empty weight:");
			emptyWeight = scanner.nextLine();
			fixedwing.setEmptyWeight(Double.parseDouble(emptyWeight));
			
			// Set max takeoff weight
			System.out.println("Enter max takeoff weight:");
			maxTakeOffWeight = scanner.nextLine();
			fixedwing.setMaxTakeOffWeight(Double.parseDouble(maxTakeOffWeight));
			
			// Set max takeoff weight
			int j = 1;
			do {
				System.out.println("Enter max takeoff weight:");
				minNeededRunAwaySize = scanner.nextLine();
				fixedwing.setMinNeededRunAwaySize(Double.parseDouble(minNeededRunAwaySize));
				airports = airportService.getAll();
				Double airportRunwaySize = 0.0;
				Double minNeededRunAwaySize1 = Double.parseDouble(minNeededRunAwaySize);
				for (Airport airport1 : airports) {
					if(airport1.getID().equals(id_ap)) {
						airportRunwaySize = airport1.getRunWaySize();
					}
				}
				if (minNeededRunAwaySize1 > airportRunwaySize) {
					System.out.println("The fixedwing min runway size does not excess the airport runway size!");
				}
				else {
					j = 0;
				}
			} while (j == 1);
			

			// Reader data from source file 
			try {
				fixedwings = fixedwingService.getAll();
			} catch (IOException e1) {
				System.out.println("Cannot get data from File!");				
			}
			
			// Add fixedwing to list
			fixedwings.add(fixedwing);
			
			// Save fixedwing to file
			try {
				status = fixedwingService.save(fixedwings);
				System.out.println("Save: " + status);
			} catch (Exception e) {
				System.out.println("Save Fail!");
			}
			
			airports = airportService.getAll();
			
			for (Airport ap : airports) {
				if(id_ap.equalsIgnoreCase(ap.getID())) {
					ap.setFixedwingsIDs(id_Fixedwing);
				}
			}
			// Save Airport to file
			try {
				status = airportService.save(airports);
				System.out.println("Save Airport: " + status);
			} catch (Exception e) {
				System.out.println("Save Airport Fail!");
			}


			// Do you want to continue?
			System.out.println("Do you want continue to input fixedwing (Y/N)?: ");
			loop = scanner.nextLine();
		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
		return fixedwings;
	}
	
	/**
	 * Save list of fixedwing to file
	 * 
	 * @param fixedwing
	 * @return
	 * @throws Exception
	 */
	public String save(List<Fixedwing> fixedwings) throws Exception {
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(Constant.FILE_PATH_3));
			objectOutputStream.writeObject(fixedwings);
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
	 * Get all the fixedwings in file
	 * 
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public List<Fixedwing> getAll() throws IOException {
		ObjectInputStream objectInputStream = null;
		List<Fixedwing> fixedwings;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(Constant.FILE_PATH_3));
			fixedwings = (List<Fixedwing>) objectInputStream.readObject();
		} catch (Exception exception) {
			throw new IOException();
		} finally {
			if (objectInputStream != null) {
				objectInputStream.close();
			}
		}
		return fixedwings;
	}


	
	// Remove
	public String remove(String id) throws Exception {
		boolean removed1 = false;
		List<Fixedwing> fixedwings = getAll();
		if (fixedwings == null) {
			throw new IOException();
		}
		Iterator<Fixedwing> iterator1 = fixedwings.iterator();
		while (iterator1.hasNext()) {
			Fixedwing fixedwing = iterator1.next();
			if (id.equalsIgnoreCase(fixedwing.getID())) {
				iterator1.remove();
				removed1 = true;
				break;
			}
		}

		if (removed1) {
			try {
				// update list
				save(fixedwings);
			} catch (Exception e) {
				throw new Exception();
			}

			return Constant.SUCCESS;
		}
		return Constant.FAIL;
	}
	
	/**
	 * Sort and display the fixedwing by id
	 * 
	 * @param list
	 */
	public void sortAndDisplay(List<Fixedwing> fixedwings) {

		Collections.sort(fixedwings, new FixedwingIdCompare());

		System.out.println("---------------FIXEDWING LIST-------------------");

		for (Fixedwing fixedwing : fixedwings) {
			System.out.println(fixedwing);
		}
	}

}