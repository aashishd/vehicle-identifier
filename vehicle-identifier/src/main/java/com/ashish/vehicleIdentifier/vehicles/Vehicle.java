package com.ashish.vehicleIdentifier.vehicles;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.ashish.vehicleIdentifier.utility.CommonUtil;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "vehicle")
public class Vehicle
{

    public Vehicle()
    {

    }

    public Vehicle(String frameMaterial, String powerTrain, List<Wheel> wheels)
    {
        //create new frame and set the material
        this.frame = new Frame();
        this.frame.setMaterial(frameMaterial);

        //create new powertrain
        this.powertrain = new Powertrain();
        this.powertrain.setType(powerTrain);

        //set the wheels
        this.wheelList = new Wheels();
        this.wheelList.setWheelList(wheels);
    }

    @XmlElement(name = "id")
    private String      id;

    @XmlElement(name = "frame")
    private Frame       frame;

    @XmlElement(name = "wheels")
    private Wheels      wheelList;

    @XmlTransient
    private VehicleType vehicleType;

    @XmlElement(name = "powertrain")
    private Powertrain  powertrain;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Frame getFrame()
    {
        return frame;
    }

    public void setFrame(Frame frame)
    {
        this.frame = frame;
    }

    public Wheels getWheelList()
    {
        return wheelList;
    }

    public void setWheelList(Wheels wheelList)
    {
        this.wheelList = wheelList;
    }

    public VehicleType getVehicleType()
    {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType)
    {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString()
    {
        return "Vehicle Id : "
                + this.id + "\nFrame : " + (frame != null ? frame.getMaterial() : "null") + "Wheels : " + getWheelsInString()
                + "Powertrain : " + (this.powertrain != null ? this.powertrain : "null");
    }

    private String getWheelsInString()
    {
        StringBuilder builder = new StringBuilder();
        if (null != this.wheelList && null != wheelList.getWheelList())
        {
            for (Wheel w : wheelList.getWheelList())
            {
                System.out.println("material inside wheels: " + w.getMaterial());
                builder.append("Material : ").append(w.getMaterial()).append("Position : ").append(w.getPosition());
            }
        }
        return builder.toString();
    }

    public Powertrain getPowertrain()
    {
        return powertrain;
    }

    public void setPowertrain(Powertrain powertrain)
    {
        this.powertrain = powertrain;
    }

    @Override
    public boolean equals(Object o)
    {
        if (CommonUtil.isNull(o))
        {
            return false;
        }
        if (!(o instanceof Vehicle))
        {
            return false;
        }
        Vehicle v = ((Vehicle) o);
        return CommonUtil.areEqual(this.getFrame(), v.getFrame())
                && CommonUtil.areEqual(this.getPowertrain(), v.getPowertrain())
                && CommonUtil.areEqual(this.getWheelList(), v.getWheelList());
    }

    @Override
    public int hashCode()
    {
        return CommonUtil.isNotNull(this.frame) && CommonUtil.isNotNull(this.frame.getMaterial()) ? this.frame
                .getMaterial().length() : 1;
    }

}
