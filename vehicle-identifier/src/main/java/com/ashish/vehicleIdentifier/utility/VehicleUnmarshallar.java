package com.ashish.vehicleIdentifier.utility;


import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.ashish.vehicleIdentifier.vehicles.Vehicles;


public class VehicleUnmarshallar
{

    private static VehicleUnmarshallar unmarshallar;

    private VehicleUnmarshallar()
    {

    }

    public static VehicleUnmarshallar getInstance()
    {
        if (unmarshallar == null)
        {
            unmarshallar = new VehicleUnmarshallar();
        }
        return unmarshallar;
    }

    public Vehicles unmarshalVehicle(InputStream stream) throws JAXBException, IllegalArgumentException
    {
        Vehicles v = null;
        JAXBContext jc;
        jc = JAXBContext.newInstance(Vehicles.class);
        Unmarshaller u = jc.createUnmarshaller();
        v = (Vehicles) u.unmarshal(stream);
        return v;
    }

}
