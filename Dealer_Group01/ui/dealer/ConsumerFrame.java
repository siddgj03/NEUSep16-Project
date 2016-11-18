package NEUSep16_Project.ui.dealer;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JLabel;

import NEUSep16_Project.ui.BaseFrame;

public class ConsumerFrame extends BaseFrame {
	
	private String selectedDealer;
	private JLabel infoTitle;

	public ConsumerFrame(int width, int height,String selectedDealer) {
		super(width, height);
		this.selectedDealer = selectedDealer;
	}

	@Override
	protected void create() {
		infoTitle = new JLabel("Create Consumer Info Here of " + selectedDealer);
		
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
