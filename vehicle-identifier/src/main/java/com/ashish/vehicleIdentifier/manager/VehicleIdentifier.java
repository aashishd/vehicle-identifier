package com.ashish.vehicleIdentifier.manager;

import java.io.InputStream;

import com.ashish.vehicleIdentifier.exceptions.BusinessException;
import com.ashish.vehicleIdentifier.vehicles.Vehicles;


public interface VehicleIdentifier {
	
	Vehicles read(InputStream stream) throws BusinessException;
	
}

