package com.ashish.vehicleIdentifier.utils;


import static org.junit.Assert.assertNotNull;

import com.ashish.vehicleIdentifier.vehicles.Vehicle;
import com.ashish.vehicleIdentifier.vehicles.Wheel;


@SuppressWarnings("unused")
public class TestUtility
{
    public static final String LOCAL_FILE_PATH = "./src/test/resources/vehicles.xml";

    public static final String EMPTY_FILE_PATH = "./src/test/resources/vehicles_empty.xml";

    public static final String DIRTY_FILE_PATH = "./src/test/resources/vehicles_dirty.xml";

    /**
     * Checkes if the vehicle is not null
     * @param vehicle
     */
    public static void assertNotNullVehicle(Vehicle vehicle)
    {
        assertNotNull(vehicle.getFrame());
        assertNotNull(vehicle.getFrame().getMaterial());
        assertNotNull(vehicle.getPowertrain().getType());
        assertNotNull(vehicle.getWheelList());
        assertNotNull(vehicle.getWheelList().getWheelList());
        for (Wheel w : vehicle.getWheelList().getWheelList())
        {
            assertNotNull(w.getMaterial());
            assertNotNull(w.getPosition());
        }
    }
}
