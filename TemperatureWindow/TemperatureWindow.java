import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class TemperatureWindow extends JFrame implements ActionListener{
    private JButton toCel,toFar;
    private Container window;
    private JTextField number;
    public static double FtoC (double farenheit) {
	return (farenheit - 32) * 5 / 9;
    }
    public static double CtoF (double celcius) {
	return celcius * 1.8 + 32;
    }
    public TemperatureWindow() {
	this.setTitle("Temperature Converter");
	this.setSize(1280,720);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	window = this.getContentPane();
	window.setLayout(new FlowLayout());
	toCel = new JButton("Convert To Celcius");
	toFar = new JButton("Convert To Farenheit");
	number = new JTextField(32);
	window.add(toFar);
	window.add(number);
	window.add(toCel);	
	toFar.setActionCommand("tofarenheit");
	toCel.setActionCommand("tocelcius");
	toFar.addActionListener(this);
	toCel.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
	System.out.println(e.getActionCommand());
	String s = e.getActionCommand();
	try {
	    switch (s) {
	    case "tocelcius":
	       	number.setText("" +(float) CtoF(Double.parseDouble(number.getText())));
		break;
	    case "tofarenheit":
		number.setText("" +(float) FtoC(Double.parseDouble(number.getText())));
		break;
	    }
	} catch(NumberFormatException event) {
	    number.setText("Please enter a value");
	}
    }

    public static void main(String[] args) {
	TemperatureWindow g=  new TemperatureWindow();
	g.setVisible(true);


    }
}




