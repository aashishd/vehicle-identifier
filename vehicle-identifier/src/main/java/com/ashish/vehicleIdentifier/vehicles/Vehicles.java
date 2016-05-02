package com.ashish.vehicleIdentifier.vehicles;
import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "vehicles")
public class Vehicles {
	
	@XmlElement(name = "vehicle")
	private List<Vehicle> vehicleList;

	public List<Vehicle> getVehicles() {
		return vehicleList;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicleList = vehicles;
	}

}
