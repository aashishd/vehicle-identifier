package com.ashish.vehicleIdentifier.manager.impl;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ashish.vehicleIdentifier.exceptions.BusinessException;
import com.ashish.vehicleIdentifier.manager.ReportManager;
import com.ashish.vehicleIdentifier.utility.CommonUtil;
import com.ashish.vehicleIdentifier.utility.Constants;
import com.ashish.vehicleIdentifier.vehicles.Vehicle;
import com.ashish.vehicleIdentifier.vehicles.VehicleType;
import com.ashish.vehicleIdentifier.vehicles.Vehicles;


@Component
public class ReportManagerImpl implements ReportManager
{

    @Override
    public Map<VehicleType, List<Vehicle>> generateReport(Vehicles vehicles) throws BusinessException
    {

        Map<VehicleType, List<Vehicle>> typeVehicleMap = new LinkedHashMap<VehicleType, List<Vehicle>>();

        if (CommonUtil.isNotNull(vehicles) && CommonUtil.isNotEmpty(vehicles.getVehicles()))
        {
            for (Vehicle vehicle : vehicles.getVehicles())
            {
                VehicleType type = Constants.STANDARD_VEHICLES_MAP.get(vehicle);
                if (CommonUtil.isNull(type))
                {
                    type = VehicleType.UNKNOWN;
                }
                vehicle.setVehicleType(type);
                List<Vehicle> existingVehicles = null;
                if (typeVehicleMap.containsKey(type))
                {
                    existingVehicles = typeVehicleMap.get(type);
                }
                else
                {
                    existingVehicles = new ArrayList<Vehicle>();
                }
                existingVehicles.add(vehicle);
                typeVehicleMap.put(type, existingVehicles);
            }
        }
        return typeVehicleMap;
    }

}
