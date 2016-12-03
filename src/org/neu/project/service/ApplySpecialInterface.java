package org.neu.project.service;
import java.text.ParseException;
import java.util.TreeSet;
interface ApplySpecialInterface {
	double getLowestPrice() throws ParseException;
	TreeSet<CarSpecificSpecialList> getSplTree();
}
