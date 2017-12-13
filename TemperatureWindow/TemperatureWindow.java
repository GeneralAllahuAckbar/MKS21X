import javax.swing.*;
import java.awt.*;


public class TemperatureWindow extends JFrame implements ActionListener{
    private JButton toCel,toFar;
    private Container window;
    private JTextfield number;
    public static double FtoC (double farenheit) {
	return (farenheit - 32) * 5 / 9;
    }
    public static double CtoF (double celcius) {
	return celcius * 9 / 5 + 32;
    }
    public TemperatureWindow() {
	this.setTitle("Temperature Converter");
	this.setSize(1280,720);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	window = this.getContentPane();
	pane.setLayout(new FlowLayout());
	toCel = new JButton("Convert To Celcius");
	toFar = new JButton("Convert To Farenheit");
	number = new JTextField("");
	window.add(toFar);
	window.add(toCel);
	window.add(number);
	toFar.setActionCommand("tofarenheit");
	toCel.setActionCommand("tocelcius");
    }

    public void actionPerformed(ActionEvent e) {
	String s = e.getActionCommand();
	switch (s) {
	case s.equals("tofarenheit"):
	    t.setText(CtoF(Integer.parseInt(t.getText()));

	}
	


    }
    
}




