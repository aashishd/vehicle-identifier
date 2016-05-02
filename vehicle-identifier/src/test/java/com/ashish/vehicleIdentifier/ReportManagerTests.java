package com.ashish.vehicleIdentifier;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ashish.vehicleIdentifier.exceptions.BusinessException;
import com.ashish.vehicleIdentifier.manager.ReportManager;
import com.ashish.vehicleIdentifier.manager.impl.ReportManagerImpl;
import com.ashish.vehicleIdentifier.utility.VehicleUnmarshallar;
import com.ashish.vehicleIdentifier.utils.TestUtility;
import com.ashish.vehicleIdentifier.vehicles.Vehicle;
import com.ashish.vehicleIdentifier.vehicles.VehicleType;
import com.ashish.vehicleIdentifier.vehicles.Vehicles;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VehicleIdentifierApplication.class)
@WebAppConfiguration
public class ReportManagerTests
{

    private static ReportManager       reportManager;

    private static VehicleUnmarshallar unmarshallar;

    @BeforeClass
    public static void setUp()
    {
        reportManager = new ReportManagerImpl();
        unmarshallar = VehicleUnmarshallar.getInstance();
    }

    @AfterClass
    public static void tearDown()
    {
        unmarshallar = null;
    }

    @Test
    public void testForNormalCase()
    {
        Vehicles vehicles = getVehiclesData();
        Map<VehicleType, List<Vehicle>> map = null;
        try
        {
            map = reportManager.generateReport(vehicles);
        }
        catch (BusinessException e)
        {
            fail("We should not get any exception in this case.");
        }
        assertNotNull("We will have a vaild map as output.", map);
        assertNotNull("We will have the entry object", map.entrySet());
        assertNotNull("Keys will be present.", map.keySet());
    }

    @Test
    public void testWithNullVehicleList()
    {
        try
        {
            reportManager.generateReport(null);
        }
        catch (BusinessException e)
        {
            fail("We should not get any exception in this case.");
        }
    }

    /**
     * Returns the correct data of vehicles
     * @return
     */
    private Vehicles getVehiclesData()
    {
        File f = new File(TestUtility.LOCAL_FILE_PATH);
        InputStream stream = null;
        Vehicles vehicles = null;
        try
        {
            stream = new FileInputStream(f);
        }
        catch (FileNotFoundException e)
        {
            fail("File should not have failed");
        }
        try
        {
            vehicles = unmarshallar.unmarshalVehicle(stream);
        }
        catch (IllegalArgumentException | JAXBException e)
        {
            fail("The test case should not have failed");
        }
        return vehicles;
    }
}
