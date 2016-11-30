package ui.vehicleView;
import java.util.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

public class SimilarPanel  extends BasePanel{
	private static final String SIMILAR_BORDER_TITLE = "Similar Vehicles"; 
	private static final String CATEGORY = "Category: ";
	private static final String MAKE = "Make: ";
	private static final String MODEL = "Model: ";
	private static final String YEAR = "Year: ";
	private static final String SALE = "Sale: ";
	JPanel similarShowPanel;
	int vehicleIndex = 0;
	List<Vehicle> vehicleList;
	List<Vehicle> vSimilarList;
	
    public SimilarPanel(Vehicle selectedVehicle) {
		this.selectedVehicle = selectedVehicle;
		vehicleList = Utility.getVehicleList();
		vSimilarList = getSimilarVehicleList();
		add();
		
	}
	
	
	private void add() {

		this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        
		this.add(getSimilarShowPanel());
		this.add(getArrowPanel());
		

	}
	
	private Component getSimilarPanel(){
		TitledBorder title = new TitledBorder(SIMILAR_BORDER_TITLE);
		title.setTitleJustification(TitledBorder.LEFT);
		title.setTitlePosition(TitledBorder.TOP);
		JPanel panel = new JPanel();
		panel.setBorder(title);
		
		Vehicle vehicle = vSimilarList.get(vehicleIndex);
		
		
		panel.setLayout(new GridLayout(6, 2));
		        //vehicle name
				JLabel vehicleName = new JLabel(vehicle.getTitle());
				JLabel vehicleL = new JLabel("");
				panel.add(vehicleName);
				panel.add(vehicleL);
		        // category
				JLabel category = new JLabel(CATEGORY);
				JLabel cateValue = new JLabel(vehicle.getCategory());
				panel.add(category);
				panel.add(cateValue);
				// make
				JLabel make = new JLabel(MAKE);
				JLabel makeValue = new JLabel(vehicle.getMake());
				panel.add(make);
				panel.add(makeValue);
				// model
				JLabel model = new JLabel(MODEL);
				JLabel modelValue = new JLabel(vehicle.getModel());
				panel.add(model);
				panel.add(modelValue);
				// year
				JLabel year = new JLabel(YEAR);
				JLabel yearValue = new JLabel(String.valueOf(vehicle.getYear()));
				panel.add(year);
				panel.add(yearValue);
				// sale
				JLabel sale = new JLabel(SALE);
				JLabel saleValue = new JLabel(String.valueOf(vehicle.getSale()));
				panel.add(sale);
				panel.add(saleValue);
		
		panel.setPreferredSize(new Dimension(700, 300));
        panel.setBackground(Color.WHITE);
	
	    return panel;
		
	}
	private Component getSimilarShowPanel() {
		similarShowPanel = new JPanel();
		similarShowPanel.setLayout(new BoxLayout(similarShowPanel, BoxLayout.Y_AXIS));
		similarShowPanel.add(getSimilarPanel());
		similarShowPanel.setPreferredSize(new Dimension(900, 400));
		similarShowPanel.setBackground(Color.WHITE);
		return similarShowPanel;
	}
	private Component getArrowPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		JButton goPre = new JButton(" << ");
		JButton goNext = new JButton(" >> ");
		
		goPre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vehicleIndex--;
				replaceSimilar();
				if (!goNext.isEnabled())
					goNext.setEnabled(true);
				if (vehicleIndex == 0) {
					goPre.setEnabled(false);
				}
			}
		});
		goNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vehicleIndex++;
				replaceSimilar();
				if (!goPre.isEnabled())
					goPre.setEnabled(true);
				if (vehicleIndex == (getSimilarVehicleList().size() - 1)) {
					goNext.setEnabled(false);
				}
			}
		});
		
		goPre.setEnabled(false);
		panel.add(goPre);
		panel.add(goNext);
		
		return panel;
		}
	private List<Vehicle> getSimilarVehicleList(){
		int index = 0; 
		while (index < vehicleList.size()) {
			 if(vehicleList.get(index).getSale()-1000 < selectedVehicle.getSale() 
				  && vehicleList.get(index).getSale()+1000 > selectedVehicle.getSale()
				  && vehicleList.get(index) != selectedVehicle){
				 vSimilarList.add(vehicleList.get(index));
				 index++;
		
			 }
			 else{
				 index++;
				 }
			
	}
		 return vSimilarList;
	}
	
	private void replaceSimilar() {
		similarShowPanel.removeAll();
		similarShowPanel.add(getSimilarPanel());
		
		similarShowPanel.updateUI();
		vehicleIndex++;

	}
	}
