package org.neu.project.ui.inventory.browse;

import javax.swing.*;
import java.awt.*;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
/**
 * @author Ruby Liao
 * SortUI in browse inventory page
 * FlowLayout to place title label and sort items horizontally
 * Pending sort function
 */
class SortUI extends JPanel
{
	public SortUI()
	{
		this.setLayout(new FlowLayout());
		JComboBox<SortItems> sortList = new JComboBox<>();
		sortList.addItem(new SortItems("Select Sort By"));
		sortList.addItem(new SortItems("Price: High To Low"));
		sortList.addItem(new SortItems("Year: High To Low"));
		sortList.addItem(new SortItems("Year: Low To High"));
		sortList.addItem(new SortItems("Model: A - Z"));
		sortList.addItem(new SortItems("Model: Z - A"));
		sortList.addItem(new SortItems("Mileage: High To Low"));
		sortList.addItem(new SortItems("Mileage: Low To High"));
		sortList.addItem(new SortItems("HWY MPG: High To Low"));
		sortList.addItem(new SortItems("HWY MPG: Low To High"));
		sortList.addItem(new SortItems("Exterior Color: A - Z"));
		sortList.addItem(new SortItems("Exterior Color: Z - A"));
		sortList.addItem(new SortItems("Specials"));
		sortList.addItem(new SortItems("Certified"));
		JLabel sortLabel = new JLabel("Sort By:");
		add(sortLabel);
		add(sortList);

		sortList.addItemListener(new ItemChangeListener());
	}

}
class SortItems
{
	private String item;

	public SortItems(String item)
	{
		this.item = item;
	}

	public String toString()
	{
		return this.item;
	}
}
class ItemChangeListener implements ItemListener
{
	@Override
	public void itemStateChanged(ItemEvent event)
	{
		if (event.getStateChange() == ItemEvent.SELECTED)
		{
			Object item = event.getItem();
			System.out.println(item.toString());
			//result = result.sort(item.toString());
		}
	}
}