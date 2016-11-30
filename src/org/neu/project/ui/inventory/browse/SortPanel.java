package org.neu.project.ui.inventory.browse;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import org.neu.project.dto.Vehicle;

/**
 * @author Ruby Liao
 * Updated at 9pm 11/29/2016
 * SortUI in browse inventory page
 * FlowLayout to place title label and sort items horizontally
 * Pending sort by special
 */

class SortPanel extends JPanel
{
    private JComboBox<SortItems> sortList;
	private JLabel sortLabel;

	public SortPanel(BrowseInventory frame)
	{
		this.setLayout(new FlowLayout());
		sortList = new JComboBox<>();
		sortList.addItem(new SortItems("Select Sort By"));
		sortList.addItem(new SortItems("Price: High To Low", "Price", "DESC"));
		sortList.addItem(new SortItems("Price: Low To High", "Price", "ASC"));
		sortList.addItem(new SortItems("Year: High To Low", "Price", "DESC"));
		sortList.addItem(new SortItems("Year: Low To High", "Price", "ASC"));
		sortList.addItem(new SortItems("Model: A - Z", "Price", "ASC"));
		sortList.addItem(new SortItems("Model: Z - A", "Price", "DESC"));
		sortList.addItem(new SortItems("Specials", "Price", "DES"));
		sortLabel = new JLabel("Sort By:");
		add(sortLabel);
		add(sortList);
		sortList.addItemListener(new ItemChangeListener(frame));

		/**
		 * Can not implement due to data limitation
		 sortList.addItem(new SortItems("Mileage: High To Low"));
		 sortList.addItem(new SortItems("Mileage: Low To High"));
		 sortList.addItem(new SortItems("HWY MPG: High To Low"));
		 sortList.addItem(new SortItems("HWY MPG: Low To High"));
		 sortList.addItem(new SortItems("Exterior Color: A - Z"));
		 sortList.addItem(new SortItems("Exterior Color: Z - A"));
		 sortList.addItem(new SortItems("Certified"));
		 *
		 */
	}

}

class SortItems
{
	private String sortName;
	private String sortKey;
	private String sortOrder;
	private InventorySortControl sortControl;

	public SortItems(){}

	public SortItems(String sortName)
	{
		this.sortName = sortName;
	}

	public SortItems(String sortName, String sortKey, String sortOrder)
	{
		this.sortName = sortName;
		this.sortKey = sortKey;
		this.sortOrder = sortOrder;
	}

	public Collection<Vehicle> doSort(Collection<Vehicle> inv)
	{
		sortControl = new InventorySortControl();
		return sortControl.sort(inv, this.sortKey, this.sortOrder);
	}

	public String toString()
	{
		return this.sortName;
	}

	public boolean isSortable()
	{
		return this.sortKey != null && this.sortOrder != null;
	}

}

class ItemChangeListener implements ItemListener
{
	private BrowseInventory frame;

	public ItemChangeListener(BrowseInventory frame)
	{
		this.frame = frame;
	}

	@Override
	public void itemStateChanged(ItemEvent event)
	{
		if (event.getStateChange() == ItemEvent.SELECTED)
		{
			SortItems item = (SortItems) event.getItem();
			if (item.isSortable())
			{
				frame.setInventory(item.doSort(frame.getInventory()));
			}
		}
	}
}