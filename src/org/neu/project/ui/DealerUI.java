package org.neu.project.ui;

import org.neu.project.service.DealerManager;
import org.neu.project.service.DummyDealerManager;

import javax.swing.*;
import java.util.List;

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
