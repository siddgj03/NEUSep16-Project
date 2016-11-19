package org.neu.project.service;

import java.util.List;

import org.neu.project.dao.DealersDAO;
import org.neu.project.dao.DealersDAOImpl;
import org.neu.project.dto.Dealer;

public class DealerManagerImpl implements DealerManager {

	DealersDAO dealerDAO = new DealersDAOImpl();
	
	//@Autowired
	//DealersDAO dealerDAO;

	@Override
	public List<Dealer> getAllDealersInSystem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllDealerNamesInSystem() {
		List<Dealer> dealers = dealerDAO.readDealers();
		return null;
	}

}
