import java.util.ArrayList;

/**
 * Created by qiqi on 2016/11/15.
 */
public class Specials {
    private static ArrayList<Special> specialList = new ArrayList<>();

    public Specials(String inputFile) throws FileNotFoundException, IOException, Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File(inputFile)));
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            String[] info = line.split("|");
            Special newSpecial = new Special();
            newSpecial.setSpecialID(Integer.parseInt(info[0]));
            newSpecial.setDealerWebID(info[1]);
            newSpecial.setSpecialTitle(info[2]);
            newSpecial.setDiscountValue(Double.parseDouble(info[3]));
            newSpecial.setDicountPercentage(Double.parseDouble(info[4]));
            newSpecial.setSpecialStartDate(info[5]);
            newSpecial.setSpecialEndDate(info[6]);
            newSpecial.setCarYear(Integer.parseInt(info[7]));
            newSpecial.setCarMake(info[8]);
            newSpecial.setCarModel(info[9]);
            newSpecial.setTrim(info[10]);
            newSpecial.setCarMinPrice(Double.parseDouble(info[11]));
            newSpecial.setCarMaxPrice(Double.parseDouble(info[12]));
            specialList.add(newSpecial);
        }
      reader.close();
    }

    public Specials() {

    }

    public static void addSpeical(Special special) {
        special.setSpecialID(specialList.size());
        specialList.add(special);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Special s: specialList) {
            sb.append(s + "\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try{
            String inputFile = "a.txt";
            Specials specials = new Specials(inputFile);
        } catch (Exception ex) {
            System.out.println("invalid input file path");
        }
    }


}
