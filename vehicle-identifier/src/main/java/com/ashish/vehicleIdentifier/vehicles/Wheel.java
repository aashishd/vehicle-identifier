package com.ashish.vehicleIdentifier.vehicles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ashish.vehicleIdentifier.utility.CommonUtil;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wheel")
public class Wheel {

	public Wheel()
	{
		
	}
	
	public Wheel(String material,String position)
	{
		this.material = material;
		this.position = position;
	}
	
	@XmlElement(name = "position")
	private String position;
	
	@XmlElement(name = "material")
	private String material;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

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
		if(!(o instanceof Wheel))
		{
			return false;
		}
		Wheel w = (Wheel)o;
		return CommonUtil.areEqual(this.getMaterial(), w.getMaterial()) && CommonUtil.areEqual(this.getPosition(), w.getPosition());
	}
	
	@Override
	public int hashCode() {
		int hashcode = 0;
		hashcode += CommonUtil.isNotEmpty(this.material) ? this.material.length() : 1;
		hashcode += CommonUtil.isNotEmpty(this.position) ? this.position.length() : 1;
		return hashcode;
	}
}
