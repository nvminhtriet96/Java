package fa.training.entities;

import fa.training.utils.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;

public class Airport implements Serializable {
    
	private static final long serialVersionUID = 1L;  
	private String ID;
	private String name;
    private	Double runWaySize;
    private	Double maxFixedWingParkingPlace;
    private Double maxRotatedWingParkingPlace;
    private Set<String> fixedwingsIDs;
    private Set<String> helicoptersIDs;
     
	// Constructor
	public Airport(String ID, String name, Double runWaySize, Double maxFixedWingParkingPlace, Set<String> fixedwingsIDs, Double maxRotatedWingParkingPlace, Set<String> helicoptersIDs) {
		this.ID = ID;
		this.name = name;
		this.runWaySize = runWaySize;
		this.maxFixedWingParkingPlace = maxFixedWingParkingPlace;
		this.maxRotatedWingParkingPlace = maxRotatedWingParkingPlace;
		this.fixedwingsIDs = fixedwingsIDs;
		this.helicoptersIDs = helicoptersIDs;
	}
	public Airport() {
	}
	
	// Getter, setter methods
	public String getID() {
		return ID;
	}
	public void setID(String iD) throws InvalidIdException, IOException {
        if ((Validator.isAirportId(iD)) && (Validator.isExisted1(iD)) && (!Validator.isExistedadd(iD))) {  
            this.ID = iD;  
        } else {  
            throw new InvalidIdException("Id is invalid");  
        }
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getRunWaySize() {
		return runWaySize;
	}
	public void setRunWaySize(Double runWaySize) {
		this.runWaySize = runWaySize;
	}
	public Double getMaxFixedWingParkingPlace() {
		return maxFixedWingParkingPlace;
	}
	public void setMaxFixedWingParkingPlace(Double maxFixedWingParkingPlace) {
		this.maxFixedWingParkingPlace = maxFixedWingParkingPlace;
	}
	public Double getMaxRotatedWingParkingPlace() {
		return maxRotatedWingParkingPlace;
	}
	public void setMaxRotatedWingParkingPlace(Double maxRotatedWingParkingPlace) {
		this.maxRotatedWingParkingPlace = maxRotatedWingParkingPlace;
	}
	public Set<String> getFixedwingsIDs() {
		return fixedwingsIDs;
	}
	public void setFixedwingsIDs(Set<String> fixedwingsIDs) {
		this.fixedwingsIDs = fixedwingsIDs;
	}
	public Set<String> getHelicoptersIDs() {
		return helicoptersIDs;
	}
	public void setHelicoptersIDs(Set<String> helicoptersIDs) {
		this.helicoptersIDs = helicoptersIDs;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Airplane [ID=" + ID + ", name=" + name + ", runAwaySize=" + runWaySize + ", maxFixedWingParkingPlace="
				+ maxFixedWingParkingPlace + ", maxRotatedWingParkingPlace=" + maxRotatedWingParkingPlace
				+ ", fixedwingsIDs=" + fixedwingsIDs + ", helicoptersIDs=" + helicoptersIDs + "]";
	}
	
	

}
