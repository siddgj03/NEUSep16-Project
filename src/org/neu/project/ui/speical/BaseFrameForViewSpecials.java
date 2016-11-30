package org.neu.project.ui.special;

import javax.swing.*;

public abstract class BaseFrameForViewSpecials extends JFrame{
	String dealerid;
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