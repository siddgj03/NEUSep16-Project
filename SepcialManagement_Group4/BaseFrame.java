/**
 * Created by qiqi on 2016/11/16.
 */
public class BaseFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new AddSpecialPanel());
        frame.setSize(700, 300);
        frame.setVisible(true);
    }
}
