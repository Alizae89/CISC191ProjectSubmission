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

import java.awt.*;
/**
 * Purpose: The reponsibility of BudgetCalculatorInterface is ...
 *
 * BudgetCalculatorInterface is-a ...
 * BudgetCalculatorInterface is ...
 * 
 * References:
 * 
 *  Oracle. (2025, April 5). AbstractTableModel (Java platform SE 8 ). https://docs.oracle.com/javase/8/docs/api/javax/swing/table/AbstractTableModel.html#fireTableRowsInserted-int-int-
	
	Oracle. (2025, April 5). UIManager (Java platform SE 8 ). https://docs.oracle.com/javase/8/docs/api/javax/swing/UIManager.html#put-java.lang.Object-java.lang.Object-
	
	Oracle. (2025, April 5). JFrame (Java platform SE 8 ). https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html
	
	Oracle. (n.d.). Lambda expressions (The Java™ tutorials > learning the Java language > classes and objects). https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
	
	Oracle. (n.d.). How to use BoxLayout (The Java™ tutorials > creating a GUI with swing > laying out components within a container). Moved. https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
	
	Thenewboston. (2015, March 4). JavaFX Java GUI Tutorial - 3 - Anonymous Inner Classes and Lambda Expressions [Video]. YouTube. https://www.youtube.com/watch?v=QGGE0WsUslc&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG&index=3
	
	Thenewboston. (2015, March 4). JavaFX Java GUI Design Tutorials [Video]. YouTube. https://www.youtube.com/playlist?list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG
 */
public class BudgetCalculatorInterface extends JFrame
{

	private final BudgetCalculatorDataSheet modelTheData;
	private final JTable dataTable;
	private final JTextField dateField;
	private final JTextField descriptionField;
	private final JTextField TransactionField;
	private final JComboBox<String> categoryBox;
	private final JComboBox<String> pieCategories;
	private final JTextField monthlyBudget;
	private final JButton addButton;
	private final JLabel balanceLabel;
	private final JLabel counterExpense;
	private final JLabel counterIncome;
	private double balance;
	private int numberofExpense;
	private int numberofIncome;
	
	private void addEntryToDataSheet()
	{
		String date = dateField.getText();
		String description = descriptionField.getText();
		String userTransaction = TransactionField.getText();
		String category = (String) categoryBox.getSelectedItem();
		String monthlyBudgetData = monthlyBudget.getText();
		String expenditureType = (String) pieCategories.getSelectedItem();
		double userInputTransaction = 0.0;
		double monthlyBudgetUserInput = 0.0;
		
		if(userTransaction.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Enter the Transaction", "Error Message: ", JOptionPane.ERROR_MESSAGE );
		}
		else 
		{
			try {
				userInputTransaction = Double.parseDouble(userTransaction);
				monthlyBudgetUserInput = Double.parseDouble(monthlyBudgetData);
				if(category.equals("Expense"))
				{
					userInputTransaction *= -1;
					numberofExpense+=1;
					counterExpense.setText("Number of Expenses Added: " + numberofExpense);
					
				}
				if(category.equals("Income"))
				{
					numberofIncome+=1;
					counterIncome.setText("Number of Incomes Added: " + numberofIncome);
				}
				
				
				ExpenseIncomeUserData entry = new ExpenseIncomeUserData(date, description, userInputTransaction, category, expenditureType);
				modelTheData.insertEntry(entry);
				balance += userInputTransaction;
				balanceLabel.setText("Balance: $" + balance);
				
				if(balance < monthlyBudgetUserInput)
				{
					JOptionPane.showMessageDialog(this, "Balance is too low, You crossed your Monthly Budget!, more savings!", "Warning: ", JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(this, "Invalid Amount Entered ", "Error Message: ", JOptionPane.ERROR_MESSAGE );
	
			}
		}
		
		
		
		
		clearUserInputFields();
	}
	
	private void clearUserInputFields()
	{
		dateField.setText("");
		descriptionField.setText("");
		TransactionField.setText("");
	}
	public BudgetCalculatorInterface()
	{
	
		UIManager.put("TextField.foreground", Color.BLUE);
		UIManager.put("TextField.background", Color.WHITE);
		UIManager.put("Textfield.caretForeground", Color.BLUE);
		UIManager.put("ComboBox.foreground", Color.BLACK);
		UIManager.put("ComboBox.selectionForeground", Color.CYAN);
		UIManager.put("ComboBox.selectionBackground", Color.BLACK);
		UIManager.put("Button.foreground", Color.BLACK);
		UIManager.put("Button.background", Color.BLACK);
		UIManager.put("Label.foreground", Color.BLUE);
	
		balance = 0.0;
		modelTheData = new BudgetCalculatorDataSheet();
		
		dataTable = new JTable(modelTheData);
		JScrollPane scrollPane = new JScrollPane(dataTable);
		dataTable.setFillsViewportHeight(true);
		
		dateField = new JTextField(5);
		descriptionField = new JTextField(5);
		TransactionField = new JTextField(5);
		categoryBox = new JComboBox<>(new String[] {"Expense", "Income"});
		pieCategories = new JComboBox<>(new String[] {"Salary", "Food", "Transportation", "Utilities", "Savings", "Entertainment", "Clothing", "Insurance"});
		
		addButton = new JButton("Add");
		
		balanceLabel = new JLabel("Balance: $ " + balance);
		
		counterExpense = new JLabel("Number of Expenses Added: " + numberofExpense);
		
		counterIncome = new JLabel("Number of Incomes Added: " + numberofIncome);
		
	
		JLabel monthlyBudgetLabel = new JLabel("\n Please enter your Monthly Budget and press enter: ");
		monthlyBudget = new JTextField(5);
		
		
		
		//button get an action listener add
		//create event listeners to process events like clicking a button
		//the user clicks on add button to register the information into the data table.
		// even listeners need to implement an interface called ActionListener and contains a actionPerformed method 
		//using Lambda expressions to pass the method addEntryToDataSheet() to the actionPerformed method
		//makes code concise 
		addButton.addActionListener(event -> addEntryToDataSheet());
		
		
		Font appFont;
		appFont = new Font("Times New Roman", Font.BOLD, 18);
		UIManager.put("Label.font", appFont);
		UIManager.put("TextField.font", appFont);
		UIManager.put("ComboBox.font", appFont);
		UIManager.put("Button.font", appFont);

		

		
		
		
		
		
		JPanel userInputInterface = new JPanel();
		
		userInputInterface.setLayout(new BoxLayout(userInputInterface, BoxLayout.Y_AXIS));
		userInputInterface.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
		userInputInterface.add(Box.createHorizontalGlue());
		userInputInterface.add(Box.createRigidArea(new Dimension(10,0)));
		
		JLabel date = new JLabel("Date");
		date.setVerticalAlignment(SwingConstants.CENTER);
		userInputInterface.add(date);
		userInputInterface.add(dateField);
		
		JLabel description = new JLabel("Description");
		description.setVerticalAlignment(SwingConstants.CENTER);

		userInputInterface.add(description);
		userInputInterface.add(descriptionField);
		
		JLabel transaction = new JLabel("Transaction");
		transaction.setVerticalAlignment(SwingConstants.CENTER);

		userInputInterface.add(transaction);
		userInputInterface.add(TransactionField);
		
		JLabel category = new JLabel("Cash Flow (Income or Expenditure)");
		category.setVerticalAlignment(SwingConstants.CENTER);

		userInputInterface.add(category);
		userInputInterface.add(categoryBox);
		
		JLabel BudgetingCategories = new JLabel("Expenses Categories");
		BudgetingCategories.setVerticalAlignment(SwingConstants.CENTER);

		userInputInterface.add(BudgetingCategories);
		userInputInterface.add(pieCategories);
		
		
		userInputInterface.add(addButton);
		
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		southPanel.add(balanceLabel);
		southPanel.add(monthlyBudgetLabel);
		southPanel.add(monthlyBudget);
		
		JPanel counterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		counterPanel.add(counterIncome);
		counterPanel.add(counterExpense);
		
		setLayout(new BorderLayout());
		add(userInputInterface, BorderLayout.WEST);
		add(scrollPane, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		add(counterPanel, BorderLayout.NORTH);
		
		

		
		setTitle("Budget Calculator: Manage Your Finances Wisely!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
		
	}
	
	
}
