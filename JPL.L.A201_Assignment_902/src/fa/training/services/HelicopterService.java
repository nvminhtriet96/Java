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

public class HelicopterService {
	

		
	/**
	 * Input list of helicopter
	 * 
	 * @param scanner
	 * @return
	 * @throws IOException 
	 * @throws Exception 
	 */
	public List<Helicopter> createHelicopter(Scanner scanner) throws IOException {
		String loop, id, model, cruiseSpeed, emptyWeight, maxTakeOffWeight;
		String id_ap;
		String status, range;
		Helicopter helicopter;
		List<Helicopter> helicopters = new ArrayList<Helicopter>();
		HelicopterService helicopterService = new HelicopterService();
		
		List<Airport> airports = new ArrayList<Airport>();
		AirportService airportService = new AirportService();
		Airport airport;
		Set<String> id_Helicopter = new HashSet<String>();
		
		Validator valid = new Validator();
		do {
			airport = new Airport();
			helicopter = new Helicopter();
			
			// Check airport id
			do {
				System.out.println("Enter airport id to add helicopter:");
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

			
			// Set helicopter id
			do {
				System.out.println("Enter helicopter id:");
				id = scanner.nextLine();
				id_Helicopter.add(id);
				try {
					helicopter.setID(id);
					id_Helicopter.add(id); 
				} catch (InvalidIdException e) {
					System.out.println(e);
					continue;
				}
				break;
			} while (true);

			// Set helicopter model
			do {
				System.out.println("Enter model:");
				model = scanner.nextLine();
				try {
					helicopter.setModel(model);				
				} catch (InvalidModelException e) {
					System.out.println(e);
					continue;
				}
				break;
			} while (true);

			
			// Set cruise speed
			System.out.println("Enter cruise speed:");
			cruiseSpeed = scanner.nextLine();
			helicopter.setCruiseSpeed(Double.parseDouble(cruiseSpeed));
		
			// Set empty weight
			System.out.println("Enter empty weight:");
			emptyWeight = scanner.nextLine();
			helicopter.setEmptyWeight(Double.parseDouble(emptyWeight));
			
			// Set min needed runway size
			int j = 1;
			do {
				System.out.println("Enter min needed runway size:");
				maxTakeOffWeight = scanner.nextLine();
				helicopter.setMaxTakeoffWeight(Double.parseDouble(maxTakeOffWeight));
				double MaxTakeoffWeight2 = Double.parseDouble(maxTakeOffWeight); 	
				double EmptyWeight2 = Double.parseDouble(emptyWeight); 
				if (MaxTakeoffWeight2 > 1.50*EmptyWeight2) {
					System.out.println("The max takeoff weight of helicopter does not excess 1.5 times of its empty weight !!!");
				}
				else {
					j = 0;
				}
			} while (j == 1);
			
			// Set range
			System.out.println("Enter range:");
			range = scanner.nextLine();
			helicopter.setRange(Double.parseDouble(range));

			// Reader data from source file 
			try {
				helicopters = helicopterService.getAll();
			} catch (IOException e1) {
				System.out.println("Cannot get data from File!");				
			}
			
			// Add helicopter to list
			helicopters.add(helicopter);
			
			// Save helicopter to file
			try {
				status = helicopterService.save(helicopters);
				System.out.println("Save: " + status);
			} catch (Exception e) {
				System.out.println("Save Fail!");
			}
			
			airports = airportService.getAll();
			
			for (Airport ap : airports) {
				if(id_ap.equalsIgnoreCase(ap.getID())) {
					ap.setHelicoptersIDs(id_Helicopter);
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
			System.out.println("Do you want continue to input helicopter (Y/N)?: ");
			loop = scanner.nextLine();
		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
		return helicopters;
	}
	
	/**
	 * Save list of helicopter to file
	 * 
	 * @param Helicopter
	 * @return
	 * @throws Exception
	 */
	public String save(List<Helicopter> helicopters) throws Exception {
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(Constant.FILE_PATH_2));
			objectOutputStream.writeObject(helicopters);
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
	 * Get all the helicopters in file
	 * 
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public List<Helicopter> getAll() throws IOException {
		ObjectInputStream objectInputStream = null;
		List<Helicopter> helicopters;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(Constant.FILE_PATH_2));
			helicopters = (List<Helicopter>) objectInputStream.readObject();
		} catch (Exception exception) {
			throw new IOException();
		} finally {
			if (objectInputStream != null) {
				objectInputStream.close();
			}
		}
		return helicopters;
	}


	
	// Remove
	public String remove(String id) throws Exception {
		boolean removed1 = false;
		List<Helicopter> helicopters = getAll();
		if (helicopters == null) {
			throw new IOException();
		}
		Iterator<Helicopter> iterator1 = helicopters.iterator();
		while (iterator1.hasNext()) {
			Helicopter helicopter = iterator1.next();
			if (id.equalsIgnoreCase(helicopter.getID())) {
				iterator1.remove();
				removed1 = true;
				break;
			}
		}

		if (removed1) {
			try {
				// update list
				save(helicopters);
			} catch (Exception e) {
				throw new Exception();
			}

			return Constant.SUCCESS;
		}
		return Constant.FAIL;
	}
	
	/**
	 * Sort and display the helicopter by id
	 * 
	 * @param list
	 */
	public void sortAndDisplay(List<Helicopter> helicopters) {

		Collections.sort(helicopters, new HelicopterIdCompare());

		System.out.println("---------------HELICOPTER LIST-------------------");

		for (Helicopter helicopter : helicopters) {
			System.out.println(helicopter);
		}
	}

}
