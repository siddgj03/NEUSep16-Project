import java.util.ArrayList;

/**
 * Created by qiqi on 2016/11/15.
 */
public class Specials {
    public ArrayList<Special> specialList = new ArrayList<>();
    private int dealerId;

    public Specials(String inputFile, int dealId) throws FileNotFoundException, IOException, Exception {
    	setDealerId(dealId);
        BufferedReader reader = new BufferedReader(new FileReader(new File(inputFile)));
        while (true) {
            String line = reader.readLine();
            System.out.println(line);
            if (line == null || line.equals("")) break;
            specialList.add(StringToSpecial.toSpecial(line));

        }
        reader.close();
    }

    public Specials() {

    }

    public ArrayList<Special> getList() {
        return specialList;
    }

    public void addSpeical(Special special) {
        special.setSpecialID(specialList.size() + 1);
        specialList.add(special);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Special s: specialList) {
            sb.append(s + "\n");
        }
        return sb.toString();
    }

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

}