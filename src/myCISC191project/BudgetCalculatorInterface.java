/**
* Lead Author(s):
* @author alizae; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-05-02
*/
package myCISC191project;

import javax.swing.*;


import com.formdev.flatlaf.FlatLightLaf;

import java.awt.*;
/**
 * Purpose: The reponsibility of BudgetCalculatorInterface is ...
 *
 * BudgetCalculatorInterface is-a ...
 * BudgetCalculatorInterface is ...
 */
public class BudgetCalculatorInterface extends JFrame
{

	private final BudgetCalculatorDataSheet modelTheData;
	private final JTable dataTable;
	private final JTextField dateField;
	private final JTextField descriptionField;
	private final JTextField TransactionField;
	private final JComboBox<String> categoryBox;
	private final JButton addButton;
	private final JLabel balanceLabel;
	private double balance;
	
	public BudgetCalculatorInterface()
	{
		/**
		try
		{
			UIManager.setLookAndFeel(new FlatLightLaf());
		}
		catch(Exception x)
		{
			System.out.println("Failed to initialize FlatLightLaf");
		}
		*/
		UIManager.put("TextField.forground", Color.RED);
		UIManager.put("TextField.background", Color.CYAN);
		UIManager.put("Textfield.caretForeground", Color.BLUE);
		UIManager.put("ComBox.foreground", Color.ORANGE);
		UIManager.put("ComboBox.selectionForeground", Color.RED);
		UIManager.put("ComboBox.selectionBackground", Color.YELLOW);
		UIManager.put("Button.foreground", Color.BLACK);
		UIManager.put("Button.background", Color.BLACK);
		UIManager.put("Label.foreground", Color.RED);
		
		balance = 0.0;
		modelTheData = new BudgetCalculatorDataSheet();
		dataTable = new JTable(modelTheData);
		JScrollPane scrollPane = new JScrollPane(dataTable);
		dataTable.setFillsViewportHeight(true);
		
		dateField = new JTextField(10);
		descriptionField = new JTextField(20);
		TransactionField = new JTextField(10);
		categoryBox = new JComboBox<>(new String[] {"Expense", "Income"});
		
		addButton = new JButton("Add");
		
		balanceLabel = new JLabel("Balance: $ " + balance);
		//button get an action listener add
		
		JPanel userInputInterface = new JPanel();
		
		JLabel date = new JLabel("Date");
		userInputInterface.add(date);
		userInputInterface.add(dateField);
		
		JLabel description = new JLabel("Description");
		userInputInterface.add(description);
		userInputInterface.add(descriptionField);
		
		JLabel transaction = new JLabel("Transaction");
		userInputInterface.add(transaction);
		userInputInterface.add(TransactionField);
		
		JLabel category = new JLabel("Category");
		userInputInterface.add(category);
		userInputInterface.add(categoryBox);
		
		
		userInputInterface.add(addButton);
		
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		southPanel.add(balanceLabel);
		
		setLayout(new BorderLayout());
		add(userInputInterface, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		setTitle("Budget Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
		
	}
	
	
}
