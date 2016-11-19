package org.neu.project.service;

import java.util.ArrayList;
import java.util.List;

import org.neu.project.dto.Dealer;

public class DummyDealerManager implements DealerManager {

	@Override
	public List<Dealer> getAllDealersInSystem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllDealerNamesInSystem() {
		List<String> dealerNames = new ArrayList<String>();

		dealerNames.add("Priority Chevrolet");
		dealerNames.add("John's motors");
		return dealerNames;
	}

}
