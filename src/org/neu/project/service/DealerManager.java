package org.neu.project.service;

import java.util.List;

import org.neu.project.dto.Dealer;

public interface DealerManager {
	public List<Dealer> getAllDealersInSystem();

	public List<String> getAllDealerNamesInSystem();

}
