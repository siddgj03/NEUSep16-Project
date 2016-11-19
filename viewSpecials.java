package javafinalproject;
import java.awt.EventQueue;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;
public class viewSpecials extends BaseFrame{ 
		public viewSpecials() throws FileNotFoundException, IOException, Exception {
		super();
		// TODO Auto-generated constructor stub
	}
		private JTable specialTable;		
		private JTextField textField;
		private JTable table;
//		private JSeparator separator_1;
//		private JSeparator separator;
		private JButton btnSearch;
		private JButton btnAdd;	
		public void create(){
				setTitle("Specials");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 450, 300);
				getContentPane().setLayout(new FlowLayout());
				
				btnAdd = new JButton("Add");
				btnAdd.setBounds(6, 0, 54, 29);
				btnAdd.addActionListener(new buttonListener1());
				getContentPane().add(btnAdd);
				
				textField = new JTextField();
				textField.setBounds(16, 30, 121, 26);
				getContentPane().add(textField);
				textField.setColumns(10);
				
				btnSearch = new JButton("Search");
				btnSearch.setBounds(149, 30, 85, 29);
				btnSearch.addActionListener(new buttonListener2());
				getContentPane().add(btnSearch);
				
//				separator = new JSeparator();
//				separator.setBounds(6, 23, 438, 12);
//				getContentPane().add(separator);
//				
//				separator_1 = new JSeparator();
//				separator_1.setBounds(6, 50, 438, 12);
//				getContentPane().add(separator_1);
				
				table = new JTable(new SpecialTableModel());
				//table.setBounds(3, 83, 441, 200);
				//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//				for (int j = 0; j < table.getColumnCount(); j++) { 
//				      table.getColumnModel().getColumn(j).setPreferredWidth(10); 
//				  } 	
				getContentPane().add(new JScrollPane(table));
		
		}
		
        public static void main(String args[]) throws FileNotFoundException, IOException, Exception {
    		new viewSpecials();
    	}

        class buttonListener1 implements ActionListener {//add
        	public void actionPerformed(ActionEvent e){
        		System.out.println("add");
        		new AddSpecialPanel();
        	}
        }
        
        class buttonListener2 implements ActionListener {//search
        	public void actionPerformed(ActionEvent e){
        		String search=textField.getText();
        	}
        }
}

	class SpecialTableModel implements TableModel {
		List list=Specials.getList();
		
		@Override
		public int getRowCount() {
			return list.size();
					}
		@Override
		public int getColumnCount() {
			return 11;
		}
		@Override
		public String getColumnName(int columnIndex) {
			if (columnIndex == 0) {
				return " ";
			}
			if (columnIndex == 1) {
				return "Title";
			}
			if (columnIndex == 2){
			    return "Make";
			}
			if (columnIndex == 3){
				return "Trim";
			}
			if (columnIndex == 4){
				return "CarYear";
			}
			if (columnIndex == 5){
				return "Price";
			}
			if (columnIndex == 6){
				return "Discount";
			}
			if (columnIndex == 7){
				return "Start Date";
			}
			if (columnIndex == 8){
				return "End Date";
			}
			return null;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return java.lang.String.class;
		}
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			System.out.println(rowIndex + "->" + columnIndex);
			Special s = (Special)list.get(rowIndex);
			if (columnIndex == 0) {
				return s.getSpecialID();
			}
			if (columnIndex == 1) {
				return s.getSpecialTitle();
			}
			if (columnIndex == 2) {
				return s.getCarMake();
			}
			if (columnIndex == 3) {
				return s.getTrim();
			}
			if (columnIndex == 4) {
				return s.getCarYear();
			}
			if (columnIndex == 5) {
				return s.getDiscountValue();
			}
			if (columnIndex == 6) {
				return s.getDicountPercentage();
			}
			if (columnIndex == 7) {
				return s.getSpecialStartDate();
			}
			if (columnIndex == 8) {
				return s.getSpecialEndDate();
			}
			return null;
		}
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
		}
		@Override
		public void addTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
		}
		@Override
		public void removeTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
		}
	}
