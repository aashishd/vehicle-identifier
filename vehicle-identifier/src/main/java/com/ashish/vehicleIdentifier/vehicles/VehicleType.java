package com.ashish.vehicleIdentifier.vehicles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlEnum
public enum VehicleType {
	BIG_WHEEL,BICYCLE,MOTORCYCLE,CAR,HANG_GLIDER,UNKNOWN
}
