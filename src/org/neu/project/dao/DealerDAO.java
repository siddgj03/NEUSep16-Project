package src.org.neu.project.dao;


import java.util.List;

import org.neu.project.dto.Dealer;

import NeHa_Group02.BufferedReader;
import NeHa_Group02.DealerPool;
import NeHa_Group02.File;
import NeHa_Group02.FileNotFoundException;
import NeHa_Group02.FileReader;
import NeHa_Group02.IOException;
import NeHa_Group02.String;
import src.org.neu.project.dto.DealerManager;

public class DealersDAO {

    DealerManager pool;
    public DealerDAO(String dealerFilePath) {
        // read file
        // call readDealerData(File file) here
        // store the dealerManager object you created to pool;
        
    }
    
    private void readDealerData(File file) {

        
    }
    
    public DealerManager getDealerManager() {
        return pool;
    }
}
