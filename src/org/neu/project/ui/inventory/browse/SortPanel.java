package org.neu.project.ui.inventory.browse;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import org.neu.project.dto.Vehicle;
import org.neu.project.service.InventorySortControl;


/**
 * @author Ruby Liao
 * Updated at 12/01/2016
 * SortUI in browse inventory page
 * FlowLayout to place title label and sort items horizontally
 * Pending sort by special
 */

class SortPanel extends JPanel
{
    // Components for sort UI
    private JComboBox<SortItems> sortList;
    private JLabel sortLabel;
    private SortItems currentItem;


    // Constructor with the consolidated frame for getting/setting inventory purpose
    public SortPanel(BrowseInventory frame)
    {
        this.setLayout(new FlowLayout());
        sortList = new JComboBox<>();
        sortList.addItem(new SortItems("Select Sort By"));
        sortList.addItem(new SortItems("Price: High To Low", InventorySortControl.SORT_BY_PRICE, InventorySortControl.ORDER_DESC));
        sortList.addItem(new SortItems("Price: Low To High", InventorySortControl.SORT_BY_PRICE, InventorySortControl.ORDER_ASC));
        sortList.addItem(new SortItems("Year: High To Low", InventorySortControl.SORT_BY_YEAR, InventorySortControl.ORDER_DESC));
        sortList.addItem(new SortItems("Year: Low To High", InventorySortControl.SORT_BY_YEAR, InventorySortControl.ORDER_ASC));
        sortList.addItem(new SortItems("Model: A - Z", InventorySortControl.SORT_BY_MODEL, InventorySortControl.ORDER_ASC));
        sortList.addItem(new SortItems("Model: Z - A", InventorySortControl.SORT_BY_MODEL, InventorySortControl.ORDER_DESC));
        sortList.addItem(new SortItems("Specials", "specials", InventorySortControl.ORDER_DESC));
        sortLabel = new JLabel("Sort By:");
        add(sortLabel);
        add(sortList);
        sortList.addItemListener(new ItemChangeListener(frame, this));

//		 Can not implement due to data limitation
//		 sortList.addItem(new SortItems("Mileage: High To Low"));
//		 sortList.addItem(new SortItems("Mileage: Low To High"));
//		 sortList.addItem(new SortItems("HWY MPG: High To Low"));
//		 sortList.addItem(new SortItems("HWY MPG: Low To High"));
//		 sortList.addItem(new SortItems("Exterior Color: A - Z"));
//		 sortList.addItem(new SortItems("Exterior Color: Z - A"));
//		 sortList.addItem(new SortItems("Certified"));

    }

    public Collection<Vehicle> sort(Collection<Vehicle> unsorted)
    {
        if(this.currentItem != null && this.currentItem.isSortable())
        {
            return this.currentItem.doSort(unsorted);
        }

        return unsorted;
    }

    public void setSortItem(SortItems sortItem)
    {
        this.currentItem = sortItem;
    }
}

//SortItems class to specify all the sort criterion
class SortItems
{
    private String sortName;
    private String sortKey;
    private boolean sortOrder;
    private InventorySortControl sortControl;

    public SortItems(){}

    public SortItems(String sortName)
    {
        this.sortName = sortName;
    }

    /**
     * Main constructor
     * @param sortName - content displayed in the sort ComboBox
     * @param sortKey - keyword for sort criterion - e.g. Price
     * @param sortOrder - desc or asc
     */
    public SortItems(String sortName, String sortKey, boolean sortOrder)
    {
        this.sortName = sortName;
        this.sortKey = sortKey;
        this.sortOrder = sortOrder;
        sortControl = new InventorySortControl();
    }

    /** Consolidate the sort function
     * @param inv - inventory passed from search result
     * @return sorted inventory list
     */
    public Collection<Vehicle> doSort(Collection<Vehicle> inv)
    {
        return this.sortControl.sort(inv, this.sortKey, this.sortOrder);
    }

    public String toString()
    {
        return this.sortName;
    }

    // Excluded the head item - "Select Sort By"
    public boolean isSortable()
    {
        return this.sortKey != null;
    }

}

// SortItems action listener to trigger related sort operation
class ItemChangeListener implements ItemListener
{
    private BrowseInventory frame;
    private SortPanel panel;

    public ItemChangeListener(BrowseInventory frame, SortPanel panel)
    {
        this.frame = frame;
        this.panel = panel;
    }

    @Override
    public void itemStateChanged(ItemEvent event)
    {
        if (event.getStateChange() == ItemEvent.SELECTED)
        {
            this.panel.setSortItem((SortItems)event.getItem());
            frame.setInventory(this.panel.sort(frame.getInventory()));
        }
    }
}