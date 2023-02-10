import java.awt.Panel;
import java.awt.event.*;
import javax.swing.*;
import acm.gui.*;
import acm.program.*;

/**
 * JCalc GUI class: This class helps build a simulation of a physical 4-function
 * calculator
 * 
 *
 */

public class JCalcGUI extends Program {
	// Create new panel.
	Panel p1 = new Panel(new TableLayout(5, 4));
	Panel p2 = new Panel(new TableLayout(2, 1));
	// Private instance variables.
	private JTextField input;
	private JTextField output;

	/**
	 * Initialize the graphical user interface.
	 */
	public void init() {
		this.setLayout(new TableLayout(2, 1));
		this.setSize(230, 300);
		addButtons();
	}

	/**
	 * Add panels, buttons and label.
	 */
	public void addButtons() {
		add(p2);// Add panel 2
		add(p1);// Add panel 1

		input = new JTextField(18);
		p2.add(input);

		output = new JTextField(18);
		p2.add(output);

		// Type "enter" on keyboard to get result.
		input.setActionCommand("=");
		input.addActionListener(this);

		p1.add(new JLabel("Calculator"));

		JButton button1 = new JButton("1");
		p1.add(button1);
		button1.addActionListener(this);

		JButton button2 = new JButton("2");
		p1.add(button2);
		button2.addActionListener(this);

		JButton button3 = new JButton("3");
		p1.add(button3);
		button3.addActionListener(this);

		JButton buttonPlus = new JButton("+");
		p1.add(buttonPlus);
		buttonPlus.addActionListener(this);

		JButton button4 = new JButton("4");
		p1.add(button4);
		button4.addActionListener(this);

		JButton button5 = new JButton("5");
		p1.add(button5);
		button5.addActionListener(this);

		JButton button6 = new JButton("6");
		p1.add(button6);
		button6.addActionListener(this);

		JButton buttonMinus = new JButton("-");
		p1.add(buttonMinus);
		buttonMinus.addActionListener(this);

		JButton button7 = new JButton("7");
		p1.add(button7);
		button7.addActionListener(this);

		JButton button8 = new JButton("8");
		p1.add(button8);
		button8.addActionListener(this);

		JButton button9 = new JButton("9");
		p1.add(button9);
		button9.addActionListener(this);

		JButton buttonMultiply = new JButton("*");
		p1.add(buttonMultiply);
		buttonMultiply.addActionListener(this);

		JButton buttonDot = new JButton(".");
		p1.add(buttonDot);
		buttonDot.addActionListener(this);

		JButton button0 = new JButton("0");
		p1.add(button0);
		button0.addActionListener(this);

		JButton buttonEqual = new JButton("=");
		p1.add(buttonEqual);
		buttonEqual.addActionListener(this);

		JButton buttonDivide = new JButton("/");
		p1.add(buttonDivide);
		buttonDivide.addActionListener(this);

		JButton buttonLeft = new JButton("(");
		p1.add(buttonLeft);
		buttonLeft.addActionListener(this);

		JButton buttonRight = new JButton(")");
		p1.add(buttonRight);
		buttonRight.addActionListener(this);

		JButton buttonClear = new JButton("C");
		p1.add(buttonClear);
		buttonClear.addActionListener(this);
	}

	/**
	 * Listens for a button action.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		String equation = input.getText();// Get input expression.
		PostFix myPostFix = new PostFix();
		String str = "1234567890().+-*/";
		if (str.indexOf(cmd) != -1) {
			this.input.setText(equation + cmd);
		} else if ("C".equals(cmd)) {
			// Clear input expression and output result.
			input.setText("");
			output.setText("");
		} else if ("=".equals(cmd)) {
			Queue inputQueue = myPostFix.parse(equation);
			Queue in2PQueue = myPostFix.In2Post(inputQueue);
			this.output.setText("" + myPostFix.PostEval(in2PQueue));
		}
	}
}
