package org.neu.project.service;

import java.util.Set;

public interface DealerManager {
	
	public Set<String> getDealersName();

	public String getDealerIDbyName(String name);

}
