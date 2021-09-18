//Anthony Lopez

//Cited Sources: 
//Java Swing: Simple Calculator. GeeksforGeeks. (2021, April 16). 
//Retrieved September 17, 2021, from https://www.geeksforgeeks.org/java-swing-simple-calculator/. 


import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class CalculatorGUI extends JFrame implements ActionListener {
	// create a frame
	static JFrame frame;

	// create a textfield to show calculations and results
	static JTextField textShown;

	// store operator and operands
	String s0, s1, s2;

	// default constructor
	CalculatorGUI()
	{
		s0 = s1 = s2 = "";
	}

	// main function
	public static void main(String args[])
	{
		// create a frame
		frame = new JFrame("Calculator");

		try {
			// set look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// create a object of class
		CalculatorGUI c = new CalculatorGUI();

		// create a textfield
		textShown = new JTextField(19);

		// set the textfield to non editable
		textShown.setEditable(false);

		// create number buttons and some operators
		JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, addBtn, minusBtn, divideBtn, multiplyBtn;

		// create number buttons
		btn0 = new JButton("0");
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");


		// create operator buttons
		addBtn = new JButton("+");
		minusBtn = new JButton("-");
		divideBtn = new JButton("/");
		multiplyBtn = new JButton("*");
		
		// create a panel
		JPanel panel = new JPanel();

		// add action listeners
		multiplyBtn.addActionListener(c);
		divideBtn.addActionListener(c);
		minusBtn.addActionListener(c);
		addBtn.addActionListener(c);
		btn9.addActionListener(c);
		btn8.addActionListener(c);
		btn7.addActionListener(c);
		btn6.addActionListener(c);
		btn5.addActionListener(c);
		btn4.addActionListener(c);
		btn3.addActionListener(c);
		btn2.addActionListener(c);
		btn1.addActionListener(c);
		btn0.addActionListener(c);
		

		// add elements to panel
		panel.add(textShown);
		panel.add(addBtn);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(minusBtn);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(multiplyBtn);
		panel.add(btn7);
		panel.add(btn8);
		panel.add(btn9);
		panel.add(divideBtn);
		panel.add(btn0);
		

	
		// add panel to frame
		frame.add(panel);

		frame.setSize(325, 250);
                frame.setResizable(false);
		frame.show();
	}
        //Algorithm calculation for all operations
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();

		// if the value is a number
		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9')) {
			// if operand is present then add to second no
			if (!s1.equals(""))
				s2 = s2 + s;
			else
				s0 = s0 + s;

			// set the value of text
			textShown.setText(s0 + s1 + s2);
		}
		else {
			// if there was no operand
			if (s1.equals("") || s2.equals(""))
				s1 = s;
			// else evaluate
			else {
				double t;

				// store the value in 1st
				if (s1.equals("+"))
					t = (Double.parseDouble(s0) + Double.parseDouble(s2));
				else if (s1.equals("-"))
					t = (Double.parseDouble(s0) - Double.parseDouble(s2));
				else if (s1.equals("/"))
					t = (Double.parseDouble(s0) / Double.parseDouble(s2));
				else
					t = (Double.parseDouble(s0) * Double.parseDouble(s2));

				// convert it to string
				s0 = Double.toString(t);

				// place the operator
				s1 = s;

				// make the operand blank
				s2 = "";
			}

			// set the value of text
			textShown.setText(s0 + s1 + s2);
		}
	}
}

