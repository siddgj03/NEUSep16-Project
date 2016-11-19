package NEUSep16_Project.ui.dealer;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import NEUSep16_Project.DealerPool;
import NEUSep16_Project.ui.BaseFrame;

/**
@author Xiaoyue,Neha
 **/


public class AutomotiveMainFrame extends BaseFrame {

	// Static values
	private static int scrWidth = 1220;
	private static int scrHeight = 750;


	// Components
	private JLabel mainTitle,dealerTitle;
	
	private JButton consumerButton,dealerButton;
	private JComboBox<Object> dealersJBox;
	//private JPanel mainPanel, dealerPanel02;
	//private FlowLayout flowLayout = new FlowLayout();

	private List<String> dealerList;
	private String selectedDealer;

	public AutomotiveMainFrame() {
		super(scrWidth,scrHeight);
	}

	@Override
	protected void create() {
		
		mainTitle = new JLabel( "  Automobiles" , SwingConstants.LEFT);
		mainTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
		mainTitle.setForeground(Color.decode("#ffffff"));
		
		
		dealerTitle = new JLabel( "Select a Dealer  " , SwingConstants.RIGHT);
		dealerTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dealerTitle.setForeground(Color.BLACK);
		
		consumerButton = new JButton("CONSUMER");
		consumerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		consumerButton.setPreferredSize(new Dimension(100, 30));
		
		
		dealerButton = new JButton("DEALER");
		dealerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		dealerButton.setPreferredSize(new Dimension(100, 30));
		


		dealersJBox = new JComboBox<>();
		dealersJBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
		dealersJBox.setPreferredSize(new Dimension(300, 30));
		

		dealerList = new DealerPool().getDealerNameList();
		addDealersToComboBoxList(dealersJBox, dealerList);


	}

	private void addDealersToComboBoxList(JComboBox<Object> JComboBox, List<String> list) {
		for (String dealer : dealerList){
			dealersJBox.addItem(dealer);
		}

	}

	@Override
	protected void add() {
		Container con = this.getContentPane();
		//con.setLayout(new GridLayout(3, 2));
		con.setLayout(new BoxLayout(con,BoxLayout.Y_AXIS));
		
		//mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		// ToDo: GridLayout might not do it.. Controls are taking up the whole height

		JPanel dealerPanel03 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		dealerPanel03.setBackground(Color.decode("#3b5998"));
		
		
		//JPanel dealerPanel01 = new JPanel(new GridLayout(1,2,5,5));
		JPanel dealerPanel01 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		//dealerPanel01.setBackground(Color.GRAY);
		
		
		JPanel dealerPanel02 = new JPanel( new FlowLayout() );
		
		
		con.add(dealerPanel03);
		con.add(dealerPanel01);
		con.add(dealerPanel02);
		
		dealerPanel03.setSize(scrWidth,200);
		
		
		dealerPanel03.add(mainTitle);
		dealerPanel01.add(dealerTitle);
		dealerPanel01.add(dealersJBox);
		dealerPanel02.add(consumerButton);
		dealerPanel02.add(dealerButton);

		//mainPanel.add(dealerPanel01);
		/*	con.add(dealerTitle);
			con.add(dealersJBox);
			con.add(consumerButton);
			con.add(dealerButton);*/


	}

	@Override
	protected void addListener() {
		ComboBoxListener cbl = new ComboBoxListener();
		dealersJBox.addItemListener(cbl);
   
        DealerListener dl = new DealerListener();
        dealerButton.addActionListener(dl);
        
        ConsumerListener cl = new ConsumerListener();
        consumerButton.addActionListener(cl);

	}

	class ComboBoxListener implements ItemListener {


		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				selectedDealer =  dealersJBox.getSelectedItem().toString();
			}
			
		}  
	}

	class DealerListener implements ActionListener {


		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (selectedDealer != null) {
				System.out.println(selectedDealer);
				new DealerFrame(4000,900 , selectedDealer);
			}
			else{
				JOptionPane.showMessageDialog(null, "Please select a Dealer");
			}

		}
	}
	
	class ConsumerListener implements ActionListener {


		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (selectedDealer != null) {
				new ConsumerFrame(4000,900 , selectedDealer);
			}
			else{
				JOptionPane.showMessageDialog(null, "Please select a Dealer");
			}

		}
	}
	
	public static void main(String args[]) {
		new AutomotiveMainFrame();
	}
}






