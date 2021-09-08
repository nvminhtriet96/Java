package fa.training.entities;

import java.io.Serializable;

import fa.training.utils.InvalidIdException;
import fa.training.utils.InvalidModelException;
import fa.training.utils.InvalidPlaneTypeException;
import fa.training.utils.Validator;

public class Fixedwing implements Serializable {
	private static final long serialVersionUID = 1L;  
	private String ID;
	private String model;
	private String planeType;
	private Double cruiseSpeed;
	private Double emptyWeight;
	private Double maxTakeOffWeight;
	private Double minNeededRunAwaySize;
	private static String flyMethod = "fixed wing";
	
	// Constructor
	public Fixedwing(String ID, String model, String planeType, Double cruiseSpeed, Double emptyWeight, Double maxTakeOffWeight, Double minNeededRunAwaySize, String flyMethod) {
		this.ID = ID;
		this.model = model;
		this.planeType = planeType;
		this.cruiseSpeed = cruiseSpeed;
		this.emptyWeight = emptyWeight;
		this.maxTakeOffWeight = maxTakeOffWeight;
		this.minNeededRunAwaySize = minNeededRunAwaySize;
	}
	public Fixedwing() {
	}
	
	// Getter, setter methods
	public String getID() {
		return ID;
	}
	public void setID(String iD) throws InvalidIdException {
        if ((Validator.isFixedwingId(iD)) && (Validator.isExisted3(iD))) {  
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
	public String getPlaneType() {
		return planeType;
	}
	public void setPlaneType(String planeType) throws InvalidPlaneTypeException {
        if (Validator.isPlaneType1(planeType) || Validator.isPlaneType2(planeType) || Validator.isPlaneType3(planeType)) {  
            this.planeType = planeType;  
        } else {  
            throw new InvalidPlaneTypeException("Plane type is invalid");  
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
	public Double getMaxTakeOffWeight() {
		return maxTakeOffWeight;
	}
	public void setMaxTakeOffWeight(Double maxTakeOffWeight) {
		this.maxTakeOffWeight = maxTakeOffWeight;
	}
	public Double getMinNeededRunAwaySize() {
		return minNeededRunAwaySize;
	}
	public void setMinNeededRunAwaySize(Double minNeededRunAwaySize) {
		this.minNeededRunAwaySize = minNeededRunAwaySize;
	}
	public String getFlyMethod() {
		return flyMethod;
	}
	public void setFlyMethod(String flyMethod) {
		this.flyMethod = flyMethod;
	}
	
	// toString method
	@Override
	public String toString() {
		return "Fixedwing [ID=" + ID + ", model=" + model + ", planeType=" + planeType + ", cruiseSpeed=" + cruiseSpeed
				+ ", emptyWeight=" + emptyWeight + ", maxTakeOffWeight=" + maxTakeOffWeight + ", minNeededRunAwaySize="
				+ minNeededRunAwaySize + ", flyMethod=" + flyMethod + "]";
	}
	
}