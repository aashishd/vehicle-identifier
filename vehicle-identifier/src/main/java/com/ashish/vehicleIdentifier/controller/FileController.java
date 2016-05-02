package com.ashish.vehicleIdentifier.controller;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ashish.vehicleIdentifier.exceptions.BusinessException;
import com.ashish.vehicleIdentifier.exceptions.ErrorCodes;
import com.ashish.vehicleIdentifier.factory.VehicleIdentifierFactory;
import com.ashish.vehicleIdentifier.manager.ReportManager;
import com.ashish.vehicleIdentifier.manager.VehicleIdentifier;
import com.ashish.vehicleIdentifier.utility.CommonUtil;
import com.ashish.vehicleIdentifier.utility.ValidatorEngine;
import com.ashish.vehicleIdentifier.vehicles.Vehicle;
import com.ashish.vehicleIdentifier.vehicles.VehicleType;
import com.ashish.vehicleIdentifier.vehicles.Vehicles;


@Controller
public class FileController
{

    @Autowired
    private ReportManager       reportManager;

    private static final Logger LOGGER = Logger.getLogger(VehicleIdentifier.class);

    @RequestMapping("/")
    public ModelAndView getIndex()
    {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return view;
    }

    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public ModelAndView plot(@RequestParam("myFile") MultipartFile file, HttpServletResponse response)
    {
        ModelAndView model = new ModelAndView();
        Vehicles vehicles = null;
        String errorMsg = null;
            try
            {
            	//Validate the input file
            	ValidatorEngine.validateFileInput(file);
                InputStream inputStream = file.getInputStream();
                VehicleIdentifierFactory factory = new   VehicleIdentifierFactory();
                
                //Getting correct vehicle identifier service
                VehicleIdentifier identifier = factory.getVehicleIdentifier(getFileExtension(file));
                vehicles = identifier.read(inputStream);
                
                //Calling report generation service
                Map<VehicleType, List<Vehicle>> map = reportManager.generateReport(vehicles);
                model.addObject("map", map);

            }
            catch (BusinessException e)
            {
                LOGGER.error(e.getMessage());
                errorMsg = e.getMessage();
            }
            catch (IOException e)
            {
                LOGGER.error(e.getMessage());
                errorMsg = ErrorCodes.E004.getMessage();
            }
            finally
            {
                if (CommonUtil.isNotEmpty(errorMsg))
                {
                    model.addObject("error", errorMsg);
                }
                model.setViewName("report");
            }
        return model;
    }
    
    private String getFileExtension(MultipartFile file)
    {
    	return file.getOriginalFilename().split("\\.")[1];
    }
}
