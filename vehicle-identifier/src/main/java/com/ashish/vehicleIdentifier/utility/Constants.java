package com.ashish.vehicleIdentifier.utility;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ashish.vehicleIdentifier.vehicles.Vehicle;
import com.ashish.vehicleIdentifier.vehicles.VehicleType;
import com.ashish.vehicleIdentifier.vehicles.Wheel;


public interface Constants
{

    List<String>              ALLOWED_EXTENSIONS = Collections.unmodifiableList(new ArrayList<String>()
                                                     {
                                                         {
                                                             add("xml");
                                                             add("XML");
                                                         }
                                                     });

    /**
     * This collection is configuation for different schemas
     */
    Map<Vehicle, VehicleType> STANDARD_VEHICLES_MAP       = Collections.unmodifiableMap(new HashMap<Vehicle, VehicleType>()
                                                     {
                                                         {
                                                             //Add Big Wheel
                                                             Wheel w1 = new Wheel("plastic", "front");
                                                             Wheel w2 = new Wheel("plastic", "right rear");
                                                             Wheel w3 = new Wheel("plastic", "left rear");
                                                             List<Wheel> wList = new ArrayList<Wheel>();
                                                             wList.add(w1);
                                                             wList.add(w2);
                                                             wList.add(w3);
                                                             Vehicle v1 = new Vehicle("plastic", "Human", wList);
                                                             put(v1, VehicleType.BIG_WHEEL);

                                                             //Add bicycle
                                                             w1 = new Wheel("metal", "front");
                                                             w2 = new Wheel("metal", "rear");
                                                             wList = new ArrayList<Wheel>();
                                                             wList.add(w1);
                                                             wList.add(w2);
                                                             Vehicle v2 = new Vehicle("metal", "Human", wList);
                                                             put(v2, VehicleType.BICYCLE);

                                                             //Add motorcycle
                                                             w1 = new Wheel("metal", "front");
                                                             w2 = new Wheel("metal", "rear");
                                                             wList = new ArrayList<Wheel>();
                                                             wList.add(w1);
                                                             wList.add(w2);
                                                             Vehicle v3 = new Vehicle("metal", "Internal Combustion", wList);
                                                             put(v3, VehicleType.MOTORCYCLE);

                                                             //Add Car
                                                             w1 = new Wheel("metal", "front right");
                                                             w2 = new Wheel("metal", "rear right");
                                                             w3 = new Wheel("metal", "rear left");
                                                             Wheel w4 = new Wheel("metal", "front left");
                                                             wList = new ArrayList<Wheel>();
                                                             wList.add(w1);
                                                             wList.add(w2);
                                                             wList.add(w3);
                                                             wList.add(w4);
                                                             Vehicle v4 = new Vehicle("metal", "Internal Combustion", wList);
                                                             put(v4, VehicleType.CAR);

                                                             Vehicle v5 = new Vehicle("plastic", "Bernoulli", null);
                                                             put(v5, VehicleType.HANG_GLIDER);
                                                         }
                                                     });
    
    String DOT_SEPARATOR = ".";

}
