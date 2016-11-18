import javax.swing.*;

/**
 * Created by qiqi on 2016/11/16.
 */
public class BaseFrame {
    public static void main(String[] args) {
        try {
            Specials specials = new Specials("C://Users//qiqi//IdeaProjects//NEU_Final_Project//abc.txt");
            JFrame frame = new JFrame();
            frame.setTitle("Add Special");
            frame.add(new AddSpecialPanel());
            frame.setSize(700, 300);
            frame.setVisible(true);
            System.out.println(specials.getList());
        } catch (Exception e) {
            System.out.println("invalid file path");
        }

    }
}
