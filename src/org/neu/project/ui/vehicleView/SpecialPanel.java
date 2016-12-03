package org.neu.project.ui.vehicleView;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.neu.project.dto.Special;
import org.neu.project.dto.Vehicle;
import org.neu.project.service.ApplySpecial;
import org.neu.project.dto.CarSpecificSpecialList;
import org.neu.project.ui.vehicleView.common.DetailViewBasePanel;
import org.neu.project.utils.DateToString;


public class SpecialPanel extends DetailViewBasePanel {
	private static final String SPECIAL_APPLIED = "Special Applied";
	private static final String DESCRIPTION = "Special Title:";
	private static final String CATERIA = "Criteria:";
	private static final String SPLPRICE = "Special Price:";
	private static final String EXPIRES = "Expire Date:";
	private static final String DEFAULT = "Select an Special";
 
	public SpecialPanel(Vehicle selectedVehicle) {
		this.selectedVehicle = selectedVehicle;
		add();
	}

	protected void add() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel selectionPanel;
		try {
			selectionPanel = (JPanel) getSelectionPanel();

		add(Box.createVerticalStrut(80));
		add(getBriefDescPanel());
		add(Box.createVerticalStrut(60));
		add(selectionPanel);
		add(Box.createVerticalStrut(60));
		add(getSpecialDetailPanel(selectionPanel));
		add(Box.createVerticalStrut(230));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Component getSpecialDetailPanel(JPanel selectionPanel) {

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2, 30, 30));
		JComboBox selectionComb = (JComboBox) selectionPanel.getComponent(1);

		//create Label
		JLabel description = new JLabel(DESCRIPTION);
		JLabel cateria = new JLabel(CATERIA);
		JLabel specialPrice = new JLabel(SPLPRICE);
		JLabel expires = new JLabel(EXPIRES);
		JLabel desContent = new JLabel("");
		JLabel cateriaContent = new JLabel("");
		JLabel price = new JLabel("");
		JLabel expiresDate = new JLabel("");
		
		//add listender
		selectionComb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String selectedSpecial = selectionComb.getSelectedItem().toString();
				if(selectedSpecial.equals(DEFAULT)){
					desContent.setText("");
					cateriaContent.setText("");
					price.setText("");					
					expiresDate.setText("");	
					return;
				}
				Iterator<CarSpecificSpecialList> i = selectedVehicle.getSplTree().iterator();
				while(i.hasNext()) {
					CarSpecificSpecialList carspl=i.next();
					if(carspl.getSpecial().getSpecialTitle().equals(selectedSpecial)){
						desContent.setText(carspl.getSpecial().getSpecialTitle());
						//get special detail
						cateriaContent.setText(getSpecialCateriaDetail(carspl.getSpecial()));
						
						price.setText(carspl.getSpecialledPrice()+"");					
						
						expiresDate.setText(DateToString.dateToString(carspl.getExpiry()));
						break;
					}
				}
			}
		});


		panel.add(description);
		panel.add(desContent);
		panel.add(cateria);
		panel.add(cateriaContent);
		panel.add(specialPrice);
		panel.add(price);
		panel.add(expires);
		panel.add(expiresDate);

		return panel;
	}

	//component for choosing the selected special 
	private Component getSelectionPanel() throws ParseException {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

		JLabel specialApplied = new JLabel(SPECIAL_APPLIED);
		JComboBox specialSelection = new JComboBox();
		specialSelection.addItem(DEFAULT);

		// get special list
		ApplySpecial appl = new ApplySpecial(selectedVehicle);
		appl.applySpecial();
		TreeSet<CarSpecificSpecialList> splTree = appl.getSplTree();	
		
		Iterator<CarSpecificSpecialList> i = splTree.iterator();
		while(i.hasNext()) {
			specialSelection.addItem(i.next().getSpecial().getSpecialTitle());
		}
		panel.add(specialApplied);
		panel.add(specialSelection);
		return panel;
	}

	
	//component for Description
	private Component getBriefDescPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 0));
		JLabel briefDesc = new JLabel("There are " + selectedVehicle.getSplTree().size() + " special currently applied to this car.");
		panel.add(briefDesc);
		return panel;
	}

	private String getSpecialCateriaDetail(Special special){
		String sql="";
		if(special.getDiscountValue() != null){
			sql.concat(special.getDiscountValue()+"");
		}else{
			sql.concat(special.getDicountPercentage()+"%");
		}
		sql.concat(" OFF FROM THE ORIGINAL PRICE.");
		sql.concat(" This special starts at "+DateToString.dateToString(special.getSpecialStartDate()));
		if(!DateToString.dateToString(special.getSpecialEndDate()).equals("2099/12/31")){
			sql.concat(", ends at "+DateToString.dateToString(special.getSpecialEndDate()));
		}
		sql.concat("CRITERIA: Car's");
		if(special.getCarYear() != null){
			sql.concat(" Production year is "+special.getCarYear());
		}
		if(special.getCarMake() != null){
			sql.concat(" Maker is "+special.getCarMake());
		}
		if(special.getCarModel() != null){
			sql.concat(" Model is "+special.getCarModel());
		}
		
		if(special.getCarMaxPrice() != null ||special.getCarMinPrice() != null){
			sql.concat(" Price range is");
			if(special.getCarMaxPrice() != null){
				sql.concat(" under USD"+special.getCarMaxPrice());
			}
			if(special.getCarMinPrice() != null){
				sql.concat(" over USD"+special.getCarMaxPrice());
			}
		}
		
		return sql;
	}
	
}
