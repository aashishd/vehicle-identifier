package com.ashish.vehicleIdentifier.manager;
import java.util.*;

import org.springframework.stereotype.Component;

import com.ashish.vehicleIdentifier.exceptions.BusinessException;
import com.ashish.vehicleIdentifier.vehicles.Vehicle;
import com.ashish.vehicleIdentifier.vehicles.VehicleType;
import com.ashish.vehicleIdentifier.vehicles.Vehicles;

@Component
public interface ReportManager {

	Map<VehicleType, List<Vehicle>> generateReport(Vehicles vehicles) throws BusinessException;
	
}
