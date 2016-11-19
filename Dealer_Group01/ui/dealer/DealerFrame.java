package NEUSep16_Project.ui.dealer;

import java.awt.*;
import javax.swing.*;

import NEUSep16_Project.ui.BaseFrame;


public class DealerFrame extends BaseFrame{
	
	private String selectedDealer;
	private JLabel infoTitle;
	
	
	public DealerFrame(int width, int height,String selectedDealer) {
		super(width, height);		
		this.selectedDealer = selectedDealer;
		
	}
	

	@Override
	protected void create() {
		infoTitle = new JLabel("Create Dealer Info Here of " );
		
		
	}

	@Override
	protected void add() {
		Container con = this.getContentPane();
		con.setLayout(new FlowLayout());
		con.add(infoTitle);
		
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		
	}

}
