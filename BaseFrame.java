package javafinalproject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;

public abstract class BaseFrame extends JFrame{
	public abstract void create();
	public void setup(){
		setSize(700,500);
		setVisible(true);
	}
	public BaseFrame() throws FileNotFoundException, IOException, Exception {
		Specials specials = new Specials("src/javafinalproject/a.txt");
		create();
		setup();
	}
}