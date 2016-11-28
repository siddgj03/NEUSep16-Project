
package src.org.neu.project.dao;

import java.util.List;

import org.neu.project.dto.Dealer;

import NeHa_Group02.FileManager;

public class DealersDAOImpl implements DealersDAO {

    @Override
    public List<Dealer> readDealers() {
        // TODO Auto-generated method stub
        return null;
    }

    class DealersParser extends FileManager {

        @Override
        public void ReadFileLine(String line) {
            // TODO Auto-generated method stub

        }

    }
}
