package org.neu.project.service;
import org.neu.project.dto.*;
import java.text.*;
import java.util.*;
import org.neu.project.service.SpecialManagement;
public class ApplySpecial implements ApplySpecialInterface
{
private double specialledPrice;
private int i;
private int f;
private Special spl;
private Vehicle car;

public ApplySpecial(Vehicle c) throws ParseException
{   
	car=c;	
}

public ApplySpecial()
{
	throw new IllegalArgumentException("Pass the Vehicle object as parameter");
}

 void applySpecial() throws ParseException
{   car.splTree= new TreeSet<CarSpecificSpecialList>(new CompareByPrice());
    car.splTreeByExpiry =new TreeSet<CarSpecificSpecialList>(new CompareByExpiry());
	 SpecialManagement spm=new SpecialManagement(car.getWebId()+".txt",car.getWebId());
	for(i=0;i< (spm.getList()).size();i++)
	{   
		f=1;
		this.spl=getSpecial(spm.getList());
		checkCarYear();
		checkCarMake();
		checkCarModel();
		checkCarMinMaxPrice();
		checkValidity();
		setSplTree();
    }	 	
}
public Special getSpecial(ArrayList<Special> specialList) {
	 
	 spl=(specialList.get(i));
	 return spl;
}
boolean checkValidity() throws ParseException {
	DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date today;
	today=df.parse(df.format((new Date())));
	if(f==1 && ((spl.getSpecialEndDate()==null || spl.getSpecialStartDate()==null)||
			(spl.getSpecialEndDate().after(today))&&(spl.getSpecialStartDate()).before(today)))
		return true;
     else 
		f=0;
	return false;
}
boolean checkCarYear() {
	if(f==1 && (spl.getCarYear()==car.getYear()||spl.getCarYear()==1990))
		return true;
	else
		f=0;
	return false;
}
boolean checkCarMake() {
	if(f==1 && (spl.getCarMake().equalsIgnoreCase(car.getMake())||spl.getCarMake().equals(" ")))
	return true;
	else 
		f=0;
	return false;
}
boolean checkCarModel() {
	if(f==1 && (spl.getCarModel().equalsIgnoreCase(car.getModel())||spl.getCarModel().equals(" ")))
		return true;
	else
		f=0;
	return false;
}
boolean checkCarMinMaxPrice() {
	if(f==1 && (car.getPrice()>=spl.getCarMinPrice()&& car.getPrice()<=spl.getCarMaxPrice()))
		return true;
	else
		f=0;
	return false;
}
public void setSplTree() throws ParseException {
	if(f==1){
if(spl.getDiscountValue()!=0)
	specialledPrice=car.getPrice()-spl.getDiscountValue();
else
	specialledPrice=car.getPrice()-((spl.getDicountPercentage()/100.00)*car.getPrice());
	
car.splTree.add(new CarSpecificSpecialList(spl,specialledPrice,spl.getSpecialEndDate()));
car.splTreeByExpiry.add(new CarSpecificSpecialList(spl,specialledPrice,spl.getSpecialEndDate()));
}
}
 boolean checkForSpecialsUpdates() throws ParseException
 {    boolean updated=false;
	 for(CarSpecificSpecialList csse:car.splTreeByExpiry)
     {  
         DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         Date today;
         today=(df.parse(df.format((new Date()))));
         if(df.parse(df.format((csse.expiry))).after(today))
             updated=true;
     }
	 return updated;
 }

@Override
public double getLowestPrice() throws ParseException {
	        double lowest=car.getPrice();
                   if(checkForSpecialsUpdates())
                   {
	                for(CarSpecificSpecialList css:car.splTree)
	                {
	                    lowest=css.specialledPrice;
	                    break;
	                }
               	           
	            }else
	            {
	            (new ApplySpecial(car)).applySpecial();
	            (new ApplySpecial(car)).getLowestPrice();
	            }
     return lowest;	   
}

@Override
public TreeSet<CarSpecificSpecialList> getSplTree() {
	
	return car.splTree;
}
}
