package com.ashish.vehicleIdentifier.manager.impl;


import java.io.InputStream;

import javax.xml.bind.JAXBException;

import com.ashish.vehicleIdentifier.exceptions.BusinessException;
import com.ashish.vehicleIdentifier.exceptions.ErrorCodes;
import com.ashish.vehicleIdentifier.manager.VehicleIdentifier;
import com.ashish.vehicleIdentifier.utility.CommonUtil;
import com.ashish.vehicleIdentifier.utility.VehicleUnmarshallar;
import com.ashish.vehicleIdentifier.vehicles.Vehicles;


/**
 * This class is used for getting the Vehicles object from the XML file
 * 
 * @author Ashish
 *
 */
public class XMLVehicleIdentifierImpl implements VehicleIdentifier
{

    public Vehicles read(InputStream stream) throws BusinessException
    {
        Vehicles vehicles = null;
        try
        {
            if (CommonUtil.isNotNull(stream))
            {
                vehicles = VehicleUnmarshallar.getInstance().unmarshalVehicle(stream);
            }
            else
            {
                throw new BusinessException(ErrorCodes.E002.name(), ErrorCodes.E002.getMessage());
            }
        }
        catch (JAXBException e)
        {
            throw new BusinessException(ErrorCodes.E001.name(), ErrorCodes.E001.getMessage());
        }
        catch (IllegalArgumentException e)
        {
            throw new BusinessException(ErrorCodes.E005.name(), ErrorCodes.E005.getMessage());
        }
        return vehicles;
    }
}
