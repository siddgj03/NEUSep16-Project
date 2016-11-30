package org.neu.project.ui.special;

import NEU_Project.DTO.Special;
import NEU_Project.Service.SpecialManagement;
import NEU_Project.DAO.DateToString;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewSpecialsUI extends BaseFrameForViewSpecials {
  ArrayList<Special> list;

  //	String dealerid;
  public ViewSpecialsUI(String dealerid) {
    super(dealerid);
  }

  private JTable specialTable;
  private JTextField textField;
  private JTable table;
  //		private JSeparator separator_1;
//		private JSeparator separator;
  private JButton btnSearch;
  private JButton btnAdd;

  public void create() {
    System.out.println(dealerid);
  //²âÊÔÇ°¸ÄÂ·¾¶
    String filename = "C://Users//qiqi//IdeaProjects//NEU_Final_Project//src//" + dealerid + ".txt";
    SpecialManagement specials = new SpecialManagement(filename, dealerid);
    this.list = specials.getList();
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

//				btnAdd = new JButton("Delete");
//				btnAdd.setBounds(124, 6, 84, 29);
//				btnAdd.addActionListener(new buttonListener3());
//				getContentPane().add(btnAdd);

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

    table = new JTable(new SpecialTableModel(list));
    table.setPreferredScrollableViewportSize(new Dimension(1000,500));
    getContentPane().add(new JScrollPane(table));

  }

  public static void main(String args[]) {
    String windows = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
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

    new ViewSpecialsUI("gmps-xyz");
  }

  class buttonListener1 implements ActionListener {//add

    public void actionPerformed(ActionEvent e) {
      System.out.println("add");
      ViewSpecialsUI.this.dispose();
      JFrame frame = new JFrame();
      frame.add(new AddSpecialPanel(dealerid));
      frame.setSize(700, 300);
      frame.setVisible(true);
    }
  }

  class buttonListener4 implements ActionListener {//edit

    public void actionPerformed(ActionEvent e) {
      int selectedRow = table.getSelectedRow();

      if (selectedRow != -1) {
        ViewSpecialsUI.this.dispose();
        try {
          JFrame frame = new JFrame();
          frame.add(new EditSpecialPanel(list.get(selectedRow), dealerid));
          frame.setSize(700, 300);
          frame.setVisible(true);
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      } else
        JOptionPane.showMessageDialog(null, "please choose a special!");

    }
  }

  class buttonListener2 implements ActionListener {//search

    public void actionPerformed(ActionEvent e) {
      String search = textField.getText();
    }
  }
}

class SpecialTableModel implements TableModel {
  //JButton btnEdit = new JButton("edit");
  ArrayList<Special> list;

  public SpecialTableModel(ArrayList<Special> list) {
    //System.out.println(list.size());
    this.list = list;
  }

  @Override
  public int getRowCount() {
    return list.size();
  }

  @Override
  public int getColumnCount() {
    return 12;
  }

  @Override
  public String getColumnName(int columnIndex) {
    if (columnIndex == 0) {
      return " ";
    }
    if (columnIndex == 1) {
      return "Title";
    }
    if (columnIndex == 2) {
      return "Make";
    }
    if (columnIndex == 3) {
      return "Trim";
    }
    if (columnIndex == 4) {
      return "CarYear";
    }
    if (columnIndex == 5) {
      return "MaxPrice";
    }
    if (columnIndex == 6) {
      return "MinPrice";
    }
    if (columnIndex == 7) {
      return "Model";
    }
    if (columnIndex == 8) {
      return "Start Date";
    }
    if (columnIndex == 9) {
      return "End Date";
    }
    if (columnIndex == 10) {
      return "Discount";
    }
    if (columnIndex == 11) {
      return "Discount Percentage";
    }
    return null;
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
    System.out.println(rowIndex + "->" + columnIndex);
    Special s = (Special) list.get(rowIndex);
   // if (s.getSpecialID() == 0) return null;
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
      return s.getCarMaxPrice();
    }
    if (columnIndex == 6) {
      return s.getCarMinPrice();
    }
    if (columnIndex == 7) {
      return s.getCarModel();
    }
    if (columnIndex == 8) {
      return DateToString.dateToString(s.getSpecialStartDate());
    }
    if (columnIndex == 9) {
      return DateToString.dateToString(s.getSpecialEndDate());
    }
    if (columnIndex == 10) {
      return s.getDiscountValue();
    }
    if (columnIndex == 11) {
      return s.getDicountPercentage();
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
