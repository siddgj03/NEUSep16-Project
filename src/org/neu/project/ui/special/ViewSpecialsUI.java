package org.neu.project.ui.special;
 
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.neu.project.dto.Special;
import org.neu.project.service.SpecialManagement;

import org.neu.project.utils.DateToString;
 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ViewSpecialsUI extends BaseFrameForViewSpecials {
	    ArrayList<Special> list;
		public ViewSpecialsUI(String dealerid){
			super(dealerid);
	    }
		private JTable specialTable;		
		private JTextField textField;
		private JTable table;
		private JButton btnSearch;
		private JButton btnAdd;	
		public void create(){
			String filename=defaultPath +dealerid+".txt";
			SpecialManagement specials = new SpecialManagement(filename, dealerid);
			this.list=specials.getList();
			setTitle("Specials");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setBackground(new Color(51, 153, 204));
			setBounds(100, 100, 500, 300);
			getContentPane().setLayout(new FlowLayout());
				
			btnAdd = new JButton("Add");
			btnAdd.setBounds(6, 6, 54, 29);
			btnAdd.setForeground(new Color(204, 51, 102));
			btnAdd.setFont(new Font("Klee", Font.BOLD, 13));
			btnAdd.addActionListener(new buttonListener1());
			getContentPane().add(btnAdd);
				
				btnAdd = new JButton("Edit");
				btnAdd.setBounds(55, 6, 75, 29);
				btnAdd.setForeground(new Color(0, 153, 51));
				btnAdd.setFont(new Font("Klee", Font.BOLD, 13));
				btnAdd.addActionListener(new buttonListener4());
				getContentPane().add(btnAdd);
				
				textField = new JTextField();
				textField.setBounds(252, 6, 121, 26);
				getContentPane().add(textField);
				textField.setColumns(10);
				
				btnSearch = new JButton("Search");
				btnSearch.setBounds(385, 6, 85, 29);
				btnSearch.setForeground(new Color(218, 165, 32));
				btnSearch.setFont(new Font("Klee", Font.BOLD, 13));
				btnSearch.addActionListener(new buttonListener2());
				getContentPane().add(btnSearch);
				
				Object[][] data = getTableData(list);
				List<String> columnNames = Arrays.asList("Title","Make","Trim","Car Year","Max Price","Min Price","Model","Start Date","End Date","Discount","Discount Percentage");
				SpecialTableModel specialTable = new SpecialTableModel(columnNames, data);
			    table = new JTable(specialTable); 
			    table.setPreferredScrollableViewportSize(new Dimension(900, 400));
//			    table.getColumnModel().getColumn(0).setPreferredWidth(40);
			    table.getColumnModel().getColumn(0).setPreferredWidth(80);
			    table.getColumnModel().getColumn(1).setPreferredWidth(80);
			    table.getColumnModel().getColumn(2).setPreferredWidth(70);
			    table.getColumnModel().getColumn(3).setPreferredWidth(70);
			    table.getColumnModel().getColumn(4).setPreferredWidth(80);
			    table.getColumnModel().getColumn(5).setPreferredWidth(70);
			    table.getColumnModel().getColumn(6).setPreferredWidth(80);
			    table.getColumnModel().getColumn(7).setPreferredWidth(90);
			    table.getColumnModel().getColumn(8).setPreferredWidth(90);
			    table.getColumnModel().getColumn(9).setPreferredWidth(70);
			    table.getColumnModel().getColumn(10).setPreferredWidth(150);
			    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			    table.setGridColor(Color.black);
			    getContentPane().add(new JScrollPane(table));
			    
			    table.setAutoCreateRowSorter(true);
			    RowSorter<SpecialTableModel> sorter = new TableRowSorter<>(specialTable);
			    table.setRowSorter(sorter);
			    table.updateUI();
		}
	
		private Object[][] getTableData(ArrayList<Special> input) {
			Object[][] result = new Object[input.size()][11];
			for(int i = 0; i < input.size(); i++) {
				for(int j = 0; j < 11; j++) {
					switch (j) {
//					case 0:
//						result[i][0] = input.get(i).getSpecialID();
//						
//						break;
					case 0:
						result[i][0] = input.get(i).getSpecialTitle();
						break;
					case 1:
						result[i][1] = input.get(i).getCarMake();
						break;
					case 2:
						result[i][2] = input.get(i).getTrim();
						break;
					case 3:
						result[i][3] = String.valueOf(input.get(i).getCarYear());
						break;
					case 4:
						result[i][4] = String.valueOf(input.get(i).getCarMaxPrice());
						break;
					case 5:
						result[i][5] = String.valueOf(input.get(i).getCarMinPrice());
						break;
					case 6:
						result[i][6] = input.get(i).getCarModel();
						break;
					case 7:
						result[i][7] = DateToString.dateToString(input.get(i).getSpecialStartDate());
						break;
					case 8:
						result[i][8] = DateToString.dateToString(input.get(i).getSpecialEndDate());
						break;
					case 9:
						result[i][9] = String.valueOf(input.get(i).getDiscountValue());
						break;
					case 10:
						result[i][10] = String.valueOf(input.get(i).getDicountPercentage());
						break;
					}
				}
			}
			return result;
		}
		
        public static void main(String args[]){
        	String windows="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        	try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 
    		new ViewSpecialsUI("gmps-curry"); 		
    	}

        class buttonListener1 implements ActionListener {//add
        	public void actionPerformed(ActionEvent e){
        		System.out.println("add");
        		JFrame frame = new JFrame("Add special");
        		frame.add(new AddSpecialPanel(dealerid));
        		frame.setSize(700, 300);
        		frame.setVisible(true);
        	}
        }
        
        class buttonListener4 implements ActionListener {//edit
        	public void actionPerformed(ActionEvent e){
        		int selectedRow = table.getSelectedRow();
        	
                if(selectedRow!=-1)
                {
                    try {
						JFrame frame = new JFrame("Edit/Delete special");
		        		frame.add(new EditSpecialPanel(list.get(selectedRow), dealerid));
		        		frame.setSize(700, 300);
		        		frame.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
                }else
                	JOptionPane.showMessageDialog(null, "please choose a special!");
                	
        	}
        }
        
        class buttonListener2 implements ActionListener {//search
        	public void actionPerformed(ActionEvent e){
        		String search=textField.getText();
        		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
        		table.setRowSorter(rowSorter);
        		rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + search));
        	}
        }
}


class SpecialTableModel extends AbstractTableModel {	
	
	private Object[][] data;
	private List<String> columnNames;
	
	public SpecialTableModel(List<String> columnNames, Object[][] data) {
		this.columnNames = columnNames;
		this.data = data;
	}

@Override
  public int getRowCount() {
    return data.length;
        }
  @Override
  public int getColumnCount() {
    return 11;
  }
  @Override
  public String getColumnName(int columnIndex) {
	  return columnNames.get(columnIndex);
  }  
  @Override
  public Class<?> getColumnClass(int columnIndex) {
    return String.class;
  }
  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    // TODO Auto-generated method stub
    return false;
  }
  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
	  return data[rowIndex][columnIndex];
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