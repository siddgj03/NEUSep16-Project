package org.neu.project.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

import org.neu.project.dto.CarSpecificSpecialList;

public class CompareByExpiry implements Comparator<CarSpecificSpecialList> {
	@Override
	public int compare(CarSpecificSpecialList o1, CarSpecificSpecialList o2) {
		int i = -1;
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			if ((df.parse(df.format(o1.getExpiry()))).after(df.parse(df.format(o2.getExpiry()))))
				i = 1;
			else
				i = -1;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return i;
	}
}
