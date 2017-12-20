import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class Test extends JFrame{
    private Container window;
    private MyCanvas canvas = new MyCanvas();
    public Test() {
	setTitle("TesTR");
	setSize(1280,720);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	window = getContentPane();
	add("Center",canvas);
    }

    private class MyCanvas extends Canvas {
	public void paint(Graphics g) {
	    Image ahaha = new ImageIcon("logo.png").getImage();
	    g.drawImage(ahaha, 200, 200, this);
	}


	
    }
    public static void main(String[] args){
	Test woah = new Test();
	woah.setVisible(true);
    }

}
