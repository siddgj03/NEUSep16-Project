/**
 * Created by qiqi on 2016/11/16.
 */
public class BaseFrame {
    public static void main(String[] args) {
        Specials specials = new Specials();
        JFrame frame = new JFrame();
        frame.setTitle("Add Special");
//        frame.add(new AddSpecialPanel());
        try {
            frame.add(new EditSpecialPanel(4, 2));
            frame.setSize(700, 300);
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println("invalid input");
        }

    }
}
