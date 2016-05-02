package com.ashish.vehicleIdentifier;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ashish.vehicleIdentifier.exceptions.BusinessException;
import com.ashish.vehicleIdentifier.exceptions.ErrorCodes;
import com.ashish.vehicleIdentifier.manager.VehicleIdentifier;
import com.ashish.vehicleIdentifier.manager.impl.XMLVehicleIdentifierImpl;
import com.ashish.vehicleIdentifier.utils.TestUtility;
import com.ashish.vehicleIdentifier.vehicles.Vehicles;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VehicleIdentifierApplication.class)
@WebAppConfiguration
public class VehicleIdentifierTests
{

    private static VehicleIdentifier vehicleIdentifier;

    @BeforeClass
    public static void setUp()
    {
        vehicleIdentifier = new XMLVehicleIdentifierImpl();
    }

    @AfterClass
    public static void tearDown()
    {
        vehicleIdentifier = null;
    }

    @Test
    public void contextLoads()
    {
    }

    @Test
    public void testUnmarshallarWithCorrectFile()
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
            vehicles = vehicleIdentifier.read(stream);
        }
        catch (BusinessException e)
        {
            fail("The test case should not have failed");
        }
        assertNotNull("Vehicles cannot be null", vehicles);
        assertNotNull("List of vehicles can't be null", vehicles.getVehicles());
        //Check for first vehicle
        TestUtility.assertNotNullVehicle(vehicles.getVehicles().get(0));
    }

    @Test
    public void testWithNullInputStream()
    {
        InputStream stream = null;
        try
        {
            vehicleIdentifier.read(stream);
        }
        catch (BusinessException e)
        {
            Assert.assertTrue("We should get an exception with null stream", true);
            Assert.assertEquals(e.getMessage(), ErrorCodes.E002.getMessage());
        }
    }

    /**
     * The input file here is an .docx file renamed as extention of .xml 
     */
    @Test
    public void testWithDirtyInputFile()
    {
        File f = new File(TestUtility.DIRTY_FILE_PATH);
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
            vehicles = vehicleIdentifier.read(stream);
        }
        catch (BusinessException e)
        {
            Assert.assertTrue("We should get an exception with the dirty input file", true);
        }
        Assert.assertNull("Vehicles will not be marshalled", vehicles);
    }

    @Test
    public void testWithEmptyInputFile()
    {
        File f = new File(TestUtility.EMPTY_FILE_PATH);
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
            vehicles = vehicleIdentifier.read(stream);
        }
        catch (BusinessException e)
        {
            Assert.assertTrue("We should get an exception here", true);
        }
        Assert.assertNull("Vehicles will not be marshalled", vehicles);
    }
}
