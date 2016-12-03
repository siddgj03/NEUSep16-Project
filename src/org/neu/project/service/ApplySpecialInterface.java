package org.neu.project.service;

import java.text.ParseException;
import java.util.TreeSet;

import org.neu.project.dto.CarSpecificSpecialList;

interface ApplySpecialInterface {
	double getLowestPrice() throws ParseException;

	TreeSet<CarSpecificSpecialList> getSplTree();
}
