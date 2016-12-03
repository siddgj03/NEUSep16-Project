package org.neu.project.service;

import java.util.Comparator;

import org.neu.project.dto.CarSpecificSpecialList;
public class CompareByPrice implements Comparator<CarSpecificSpecialList>{
	@Override
	public int compare(CarSpecificSpecialList o1, CarSpecificSpecialList o2) 
	{
		if(o1.getSpecialledPrice()>=o2.getSpecialledPrice())
			    return 1 ;
			else
				return -1;	
	}
}

