package com.ashish.vehicleIdentifier.vehicles;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ashish.vehicleIdentifier.utility.CommonUtil;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wheels")
public class Wheels {
	
	@XmlElement(name = "wheel")
	List<Wheel> wheelList;
	
	public List<Wheel> getWheelList() {
		return wheelList;
	}

	public void setWheelList(List<Wheel> wheelList) {
		this.wheelList = wheelList;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(CommonUtil.isNull(o))
		{
			return false;
		}
		if(!(o instanceof Wheels))
		{
			return false;
		}
		Wheels w = (Wheels)o;
		Set<Wheel> thisWheelSet = new HashSet<Wheel>();
		if(CommonUtil.isNotEmpty(this.getWheelList()))
		{
			thisWheelSet.addAll(this.getWheelList());
		}
		Set<Wheel> thatWheelSet = new HashSet<Wheel>();
		if(CommonUtil.isNotEmpty(w.getWheelList()))
		{
			thatWheelSet.addAll(w.getWheelList());
		}
		return CommonUtil.areEqual(thisWheelSet, thatWheelSet);
	}

}
