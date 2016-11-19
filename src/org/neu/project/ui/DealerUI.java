package org.neu.project.ui;

import java.util.List;

import javax.swing.JComboBox;

import org.neu.project.service.DealerManager;
import org.neu.project.service.DummyDealerManager;

public class DealerUI {

	private JComboBox dealersCombo;

	public void create() {
		DealerManager dealerManager = getDealerManager();
		List<String> dealerNames = dealerManager.getAllDealerNamesInSystem();
		// dealersCombo =
	}

	private DealerManager getDealerManager() {
		return new DummyDealerManager();
	}

}
