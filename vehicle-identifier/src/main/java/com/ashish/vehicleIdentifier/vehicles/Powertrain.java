package com.ashish.vehicleIdentifier.vehicles;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.ashish.vehicleIdentifier.utility.CommonUtil;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "powertrain")
public class Powertrain
{
    //@XmlElements({ @XmlElement(name = "human"), @XmlElement(name = "abc"), @XmlElement(name = "def") })
    @XmlElement(name = "human")
    private String value1;

    @XmlElement(name = "bernoulli")
    private String value2;

    @XmlElement(name = "internal_combustion")
    private String value3;

    @XmlTransient
    private String type;

    public String getValue1()
    {
        return value1;
    }

    public void setValue1(String value1)
    {
        this.value1 = value1;
    }

    public String getValue2()
    {
        return value2;
    }

    public void setValue2(String value2)
    {
        this.value2 = value2;
    }

    public String getValue3()
    {
        return value3;
    }

    public void setValue3(String value3)
    {
        this.value3 = value3;
    }

    /**
     * Determines the type of powertrain
     * @return
     */
    public String getType()
    {
        if (CommonUtil.isEmpty(this.type))
        {
            if (CommonUtil.isNotNull(value1))
            {
                this.type = "Human";
            }
            else if (CommonUtil.isNotNull(value2))
            {
                this.type = "Bernoulli";
            }
            else if (CommonUtil.isNotNull(value3))
            {
                this.type = "Internal Combustion";
            }
        }
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    @Override
    public boolean equals(Object o)
    {
        if (CommonUtil.isNull(o))
        {
            return false;
        }
        if (!(o instanceof Powertrain))
        {
            return false;
        }
        Powertrain p = (Powertrain) o;
        return CommonUtil.areEqual(this.getType(), p.getType());
    }
}
