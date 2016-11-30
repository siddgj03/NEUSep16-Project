package org.neu.project.service;

import java.util.List;

import org.neu.project.dto.Dealer;

public interface DealerManager {
	public Set<String> getDealersName();

	public String getDealerIDbyName(String name);

}
