package NEUSep16_Project;

import java.io.*;
import java.util.*;


/**
 * @author Yalin,Xiaoyue,Neha
 * 
 */

public class DealerPool {

	private Set<Dealer> dealers = new HashSet<Dealer>();	
	private List<String> dealerNameList = new ArrayList<String>();

	public DealerPool(){

		File dealerFile = new File("car-dealers.txt");
		ReadFile rf = new ReadFile() {

			@Override
			public void ReadFileLine(String line) {
				String[] dealerColumns = line.split("\\|");
				Dealer dealer = new Dealer(dealerColumns[0], dealerColumns[1], dealerColumns[2]);
				dealers.add(dealer);
				dealerNameList.add(dealerColumns[1]);

			}
		};
		rf.ReadFileHelper(dealerFile);
	}
	
	
	public void addDealer(Dealer d){
		dealers.add(d);
	}

	public void deleteDealer(Dealer d){
		dealers.remove(d);
	}

	public List<String> getDealerNameList(){
		return dealerNameList;
	}
}
