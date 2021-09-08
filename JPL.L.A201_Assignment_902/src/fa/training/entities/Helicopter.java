package fa.training.entities;

import java.io.Serializable;

import fa.training.utils.*;

public class Helicopter implements Serializable {
	private static final long serialVersionUID = 1L;  
	private String ID;
	private String model;
    private	Double cruiseSpeed;
	private Double emptyWeight;
	private Double maxTakeoffWeight;
	private Double range;
	private static String flyMethod = "rotated wing";
	
	// Constructor
	public Helicopter(String ID, String model, Double cruiseSpeed, Double emptyWeight, Double maxTakeoffWeight, Double range, String flyMethod) {
		this.ID = ID;
		this.model = model;
		this.cruiseSpeed = cruiseSpeed;
		this.emptyWeight = emptyWeight;
		this.maxTakeoffWeight = maxTakeoffWeight;
		this.range = range;
	}
	public Helicopter() {
	}
	
	// Getter, setter methods
	public String getID() {
		return ID;
	}
	public void setID(String iD) throws InvalidIdException {
        if ((Validator.isHelicopterId(iD)) && (Validator.isExisted2(iD))) {  
            this.ID = iD;  
        } else {  
            throw new InvalidIdException("Id is invalid");  
        } 
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) throws InvalidModelException {
        if ((Validator.isModel(model))) {  
            this.model = model;  
        } else {  
            throw new InvalidModelException("Model is invalid");  
        }
	}
	public Double getCruiseSpeed() {
		return cruiseSpeed;
	}
	public void setCruiseSpeed(Double cruiseSpeed) {
		this.cruiseSpeed = cruiseSpeed;
	}
	public Double getEmptyWeight() {
		return emptyWeight;
	}
	public void setEmptyWeight(Double emptyWeight) {
		this.emptyWeight = emptyWeight;
	}
	public Double getRange() {
		return range;
	}
	public void setRange(Double range) {
		this.range = range;
	}
	public Double getMaxTakeoffWeight() {
		return maxTakeoffWeight;
	}
	public void setMaxTakeoffWeight(Double maxTakeoffWeight) {
		this.maxTakeoffWeight = maxTakeoffWeight;
	}
	public static String getFlyMethod() {
		return flyMethod;
	}
	public static void setFlyMethod(String flyMethod) {
		Helicopter.flyMethod = flyMethod;
	}
	
	@Override
	public String toString() {
		return "Helicopter [ID=" + ID + ", model=" + model + ", cruiseSpeed=" + cruiseSpeed + ", emptyWeight="
				+ emptyWeight + ", maxTakeoffWeight=" + maxTakeoffWeight + ", range=" + range + ", FlyMethod= " + Helicopter.getFlyMethod() + "]";
	}

}
