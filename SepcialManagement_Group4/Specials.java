import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by qiqi on 2016/11/15.
 */
public class Specials {
    private ArrayList<Special> specialList = new ArrayList<>();

    public Specials(String inputFile) throws FileNotFoundException, IOException, Exception {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        while (true) {
            String line = reader.readLine();
            String[] info = line.split("|");
            Special newSpecial = new Special(Integer.parseInt(info[0]), info[1], info[2], Double.parseDouble(info[3]), Double.parseDouble(info[4]), info[5], info[6], Integer.parseInt(info[7]), info[8], info[9], info[10], Double.parseDouble(info[11]), Double.parseDouble(info[12]));
            specialList.add(newSpecial);
        }
    }

    public void addSpeical(Special special) {
        specialList.add(special);
        special.setSpecialID(specialList.size());
    }


}
