package org.neu.project.service;

import java.util.Set;
import org.neu.project.dao.DealerDAO;
import org.neu.project.dto.Dealer;


public class DealerManagerImpl implements DealerManager {

	DealerDAO dealerDAO = new DealerDAO();
	
	@Override
	public Set<String> getDealersName() {
		return dealerDAO.getDealerInfo().keySet();
	}

	@Override
	public String getDealerIDbyName(String name) {
		if (dealerDAO.getDealerInfo().containsKey(name)) {
			Dealer dealer = dealerDAO.getDealerInfo().get(name);
			return dealer.getId();
		}
		return null;
	}

}
