package org.neu.project.ui.vehicleView;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.neu.project.dto.Rating;
import org.neu.project.dto.Vehicle;
import org.neu.project.ui.vehicleView.common.DetailViewBasePanel;

public class RatingPanel extends DetailViewBasePanel {
	private static final long serialVersionUID = 1L;
	private ButtonGroup group;
	public RatingPanel(Vehicle selectedVehicle) {
		this.selectedVehicle = selectedVehicle;
		this.setLayout(new FlowLayout());
		add();
		
	}
	@Override
	protected void add() {
		
		JPanel aveRatingPanel = (JPanel)getAveRatingPanel();
		add(aveRatingPanel);
		JPanel voteNumPanel = (JPanel)getVoteNumPanel();
		add(voteNumPanel);
	    JPanel opinionPanel =(JPanel)getOpinionPanel(); 
		add(opinionPanel);
		add(getSubmitPanel(this,aveRatingPanel,voteNumPanel));
	}

	private Component getVoteNumPanel() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(900,100));
		JLabel totalVote = new JLabel("Total Vote:");
		JLabel voteNum = new JLabel(selectedVehicle.getRating().getVoteCount()+"");
		panel.add(totalVote);
		panel.add(voteNum);
		return panel;
	}
	private Component getSubmitPanel(JPanel parentPanel,JPanel aveRatingPanel,JPanel voteNumPanel) {
	    JButton submit = new JButton("Submit");
	    submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			     String newRating = group.getSelection().getActionCommand();
			     Rating rating = selectedVehicle.getRating();
			     int oldVoteCount = rating.getVoteCount();
			     rating.setVoteCount(rating.getVoteCount()+1);
			     rating.setAverRate(calculateNewAverate(rating,oldVoteCount,newRating));
			     parentPanel.removeAll();
			     add();
			}
			private float calculateNewAverate(Rating rating, int oldVoteCount, String newRating) {
				float totalRating = rating.getAverRate()*oldVoteCount+Float.parseFloat(newRating);
				float newAveRating = totalRating/rating.getVoteCount();
				return newAveRating;
			}    	
	    });
	    submit.setPreferredSize(new Dimension(200,50));
		return submit;
	}

	private Component getOpinionPanel() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(900,100));
		JLabel label = new JLabel("Give your opinion:");
	    JRadioButton opinion1 = new JRadioButton("1");
	    opinion1.setActionCommand("1");
	    JRadioButton opinion2 = new JRadioButton("2");
	    opinion2.setActionCommand("2");
	    JRadioButton opinion3 = new JRadioButton("3");
	    opinion3.setActionCommand("3");
	    JRadioButton opinion4 = new JRadioButton("4");
	    opinion4.setActionCommand("4");
	    JRadioButton opinion5 = new JRadioButton("5");
	    opinion5.setActionCommand("5");
	    opinion5.setSelected(true);
	    group = new ButtonGroup();
	    group.add(opinion1);
	    group.add(opinion2);
	    group.add(opinion3);
	    group.add(opinion4);
	    group.add(opinion5);
	    
	    panel.add(label);
	    panel.add(opinion1);
	    panel.add(opinion2);
	    panel.add(opinion3);
	    panel.add(opinion4);
	    panel.add(opinion5);
		return panel;
	}

	private Component getAveRatingPanel() {
	    JPanel panel = new JPanel();
	    JLabel aveRating = new JLabel("Average Rating:");
	    JLabel label = new JLabel(selectedVehicle.getRating().getAverRate()+"");
	    panel.setPreferredSize(new Dimension(700,100));
	    panel.add(aveRating);
	    panel.add(label);
	    
		return panel;
	}

}
