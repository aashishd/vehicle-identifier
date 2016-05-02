package com.ashish.vehicleIdentifier.factory;

import com.ashish.vehicleIdentifier.manager.VehicleIdentifier;
import com.ashish.vehicleIdentifier.manager.impl.XMLVehicleIdentifierImpl;
import com.ashish.vehicleIdentifier.utility.Constants;

public class VehicleIdentifierFactory {
	
	public VehicleIdentifier getVehicleIdentifier(String extension)
	{
		if(Constants.ALLOWED_EXTENSIONS.contains(extension))
		{
			return new XMLVehicleIdentifierImpl();
		}
		if("CSV".equals(extension))
		{
			//TODO
			return null;
		}
		else{
			return null;
		}
	}
}