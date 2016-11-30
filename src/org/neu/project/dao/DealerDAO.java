package org.neu.project.dao;

import java.util.HashMap;
import java.util.Map;

import org.neu.project.dto.Dealer;
import org.neu.project.dao.ReadFile;
import org.neu.project.dao.PropertyReader;

public class DealerDAO {

	private String[] dealerColumns;
	private String dealerFile;

	public DealerDAO() {
		PropertyReader rp = new PropertyReader();
		//rp.readProperties();
		dealerFile = System.getProperty("user.dir") + rp.getString("dealerFile");	
		System.out.println(dealerFile);
	}

	public Map<String, Dealer> getDealerInfo(){ //get
		DealersParser dealersParser = new DealersParser();
		dealersParser.readFileHelper(dealerFile);
		return dealersParser.dealersPool;
	}

	class DealersParser extends ReadFile {
		HashMap<String, Dealer> dealersPool;

		DealersParser() {
			dealersPool = new HashMap<String, Dealer>();
		}

		@Override
		public void readFileLine(String line) {
			dealerColumns = line.split("\\|");
			readDealerData();

		}

		private void readDealerData() {
			Dealer dealer = new Dealer();
			dealer.setId(dealerColumns[0]);
			dealer.setName(dealerColumns[1]);
			dealer.setUrl(dealerColumns[2]);

			if (!dealersPool.containsKey(dealer.getName())) {
				dealersPool.put(dealer.getName(),dealer);
			}

		}
	}
}


