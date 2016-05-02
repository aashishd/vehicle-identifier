package com.ashish.vehicleIdentifier.vehicles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ashish.vehicleIdentifier.utility.CommonUtil;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Frame {

	@XmlElement(name = "material")
	private String material;

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(CommonUtil.isNull(o))
		{
			return false;
		}
		if(!(o instanceof Frame))
		{
			return false;
		}
		Frame f = (Frame)o;
		return CommonUtil.areEqual(this.getMaterial(), f.getMaterial());
	}
}
