package fa.training.main;

import java.util.Scanner;

import fa.training.utils.*;
import fa.training.entities.*;
import fa.training.services.*;

import java.io.*;
import java.util.List;

public class EmployeeManagement {
	
	private static List<Airport> listNewAirport;
	private static List<Airport> listAirport;

	private static List<Helicopter> listNewHelicopter;
	private static List<Helicopter> listHelicopter;
	
	private static List<Fixedwing> listNewFixedwing;
	private static List<Fixedwing> listFixedwing;
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = null;
		String choice, status, helicopterId, fixedwingId;
		AirportService airportService = new AirportService();
		HelicopterService helicopterService = new HelicopterService();
		FixedwingService fixedwingService = new FixedwingService();
		try {
			scanner = new Scanner(System.in);
			do {
				System.out.println("---------------------MENU--------------------");
				System.out.println("1. Create new Airport" + "\n2. Add Helicopter to Airport" +
				"\n3. Remove Helicopter from Airport" + "\n4. Add Fixedwing from Airport\n" + "5. Remove Fixedwing from Airport\n" +
				"6. Display List of Helicopter Information" + "\n7. Display List of Fixedwing Information" + "\n8. Display List of Airport Information" 
				+"\n9. Exit");

//				"6. Change Fixedwing Airplane Infomation" + "\n7. Find Airport" + "\n8. Display Fixedwing Airplane" 
//				+"\n9. Display Helicopter" + "\n10.Exit");
				
				System.out.print("Select: ");
				choice = scanner.nextLine();
				choice = choice.trim();
				switch (choice) {
				//Create new airport
				case Constant.INPUT:
					if (listNewAirport != null) {
						listNewAirport.clear();
					}
					listNewAirport = airportService.createAirport(scanner);
					System.out.println("Input done!");
				break;
					
				//Create and add Helicopter to Airport
				case Constant.ADD1:
					if (listNewHelicopter != null) {
						listNewHelicopter.clear();
					}
					listNewHelicopter = helicopterService.createHelicopter(scanner);
					System.out.println("Add done!");
				break;
				
				// Remove a helicopter from airport
				case Constant.REMOVE1:
					System.out.println("Enter helicopter id to remove: ");
					helicopterId = scanner.nextLine();
					// remove helicopterId from airport list and then save the file
					airportService.saveandremoveid(helicopterId);

					try {
						status = helicopterService.remove(helicopterId);
						System.out.println("Remove: " + status);
					} catch (Exception e) {
						System.out.println("Remove Fail!");
					} 
				break;
				
				//Create and add fixedwing to Airport
				case Constant.ADD2:
					if (listNewFixedwing != null) {
						listNewFixedwing.clear();
					}
					listNewFixedwing = fixedwingService.createFixedwing(scanner);
					System.out.println("Add done!");
				break;
					
				// Remove a fixedwing from airport
				case Constant.REMOVE2:
					System.out.println("Enter fixedwing id to remove: ");
					fixedwingId = scanner.nextLine();
					// remove helicopterId from airport list and then save the file
					airportService.saveandremoveid(fixedwingId);

					try {
						status = helicopterService.remove(fixedwingId);
						System.out.println("Remove: " + status);
					} catch (Exception e) {
						System.out.println("Remove Fail!");
					} 
				break;			
					
				// Display list helicopter 
				case Constant.DISPLAY:
					if (listHelicopter != null) {
						listHelicopter.clear();
					}
					try {
						listHelicopter = helicopterService.getAll();
						if (listHelicopter == null) {
							throw new IOException();
						}
						helicopterService.sortAndDisplay(listHelicopter);
					} catch (IOException e) {
						System.out.println("No data");
					}
				break;
				
				// Display list fixedwing 
				case Constant.DISPLAY1:
					if (listFixedwing != null) {
						listFixedwing.clear();
					}
					try {
						listFixedwing = fixedwingService.getAll();
						if (listFixedwing == null) {
							throw new IOException();
						}
						fixedwingService.sortAndDisplay(listFixedwing);
					} catch (IOException e) {
						System.out.println("No data");
					}
				break;
						
				// Display list airport 
				case Constant.DISPLAY2:
					if (listAirport != null) {
						listAirport.clear();
					}
					try {
						listAirport = airportService.getAll();
						if (listAirport == null) {
							throw new IOException();
						}
						airportService.sortAndDisplay(listAirport);
					} catch (IOException e) {
						System.out.println("No data");
					}
				break;
					
					
					
				}
			} while (!choice.equalsIgnoreCase(Constant.EXIT));
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		
	}

}
