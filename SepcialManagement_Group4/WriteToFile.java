import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by qiqi on 2016/11/26.
 */
public class WriteToFile {
    public static void addToFile(ArrayList<Special> specials, String output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output)));
        for (Special special : specials) {
            writer.write(special.toString());
            writer.newLine();
        }
        writer.close();
    }
}
