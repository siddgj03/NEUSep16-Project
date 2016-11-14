package ui.inventory.browse;

import ui.BaseFrame;

import javax.swing.*;
import java.awt.*;

public class BrowseInventory extends BaseFrame {
	private static final int scrWidth = 1020;
	private static final int scrHeight = 720;

	public BrowseInventory() {
		super(scrWidth, scrHeight);
	}

	@Override
	protected void create() {

	}

	@Override
	protected void add() {
		Container con = this.getContentPane();
		GroupLayout layout = new GroupLayout(con);
		con.setLayout(layout);

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

//		layout.setHorizontalGroup(
//				layout.createSequentialGroup()
//						.addComponent(c1)
//						.addComponent(c2)
//						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//								          .addComponent(c3)
//								          .addComponent(c4))
//		);
//		layout.setVerticalGroup(
//				layout.createSequentialGroup()
//						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//								          .addComponent(c1)
//								          .addComponent(c2)
//								          .addComponent(c3))
//						.addComponent(c4)
//		);
	}

	@Override
	protected void addListener() {

	}

	public static void main(String args[]) {
		new BrowseInventory();
	}
}
