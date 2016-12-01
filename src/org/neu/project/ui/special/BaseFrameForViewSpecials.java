package org.neu.project.ui.special;

 
 
import javax.swing.*;

/*
 * add line 10.
 */
public abstract class BaseFrameForViewSpecials extends JFrame{
	String dealerid;
	protected String defaultPath=System.getProperty("user.dir")+"/SpecialData/";
	public abstract void create();
	public void setup(){
		setSize(1100,800);
		setVisible(true);
//		pack();
	}
	public BaseFrameForViewSpecials(String dealerID){
		this.dealerid=dealerID;
		create();
		setup();
	}
}