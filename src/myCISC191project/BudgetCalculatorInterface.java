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


import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Purpose: The responsibility of BudgetCalculatorInterface is to create the GUI interface (labels, buttons, drop down menus, and textfields) and 
 * then add the code implementation in which the user can enter their for each entry.
 * Also, the program checks if monthly budget is over and balance becomes a negative.
 *

 * References:
 * 
	
	Oracle. (2025, April 5). UIManager (Java platform SE 8 ). https://docs.oracle.com/javase/8/docs/api/javax/swing/UIManager.html#put-java.lang.Object-java.lang.Object-
	
	Oracle. (2025, April 5). JFrame (Java platform SE 8 ). https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html
	
	Oracle. (n.d.). Lambda expressions (The Java™ tutorials > learning the Java language > classes and objects). https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
	
	Oracle. (n.d.). How to use BoxLayout (The Java™ tutorials > creating a GUI with swing > laying out components within a container). Moved. https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
	
	Thenewboston. (2015, March 4). JavaFX Java GUI Tutorial - 3 - Anonymous Inner Classes and Lambda Expressions [Video]. YouTube. https://www.youtube.com/watch?v=QGGE0WsUslc&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG&index=3
	
	Thenewboston. (2015, March 4). JavaFX Java GUI Design Tutorials [Video]. YouTube. https://www.youtube.com/playlist?list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG
 */
//BudgetCalculatorInterface IS-A JFrame
//Extends JFrame to utilize the GUI components and import libraries
public class BudgetCalculatorInterface extends JFrame
{

	private final BudgetCalculatorDataSheet modelTheData; //create a BudgetCalculatorDataSheet object called modelTheData to implement entries in the data model
	
	private final JTable dataTable; //a JTable called dataTable is created from Swing class to display 2D tables of cells
	
	private final JTextField dateField; // a JTextField component is created called dataField, user can type data input
	
	private final JTextField descriptionField;// a JTextField component is created called descriptionField, user can type description input
	
	private final JTextField TransactionField; // a JTextField component is created called TransactionField, a user can type transaction input
	
	private final JComboBox<String> categoryBox; // a JComboBox component is created called categoryBox, a user can select from a drop down menu of two options: income or expense
	
	private final JComboBox<String> expenseCategories; // a JComboBox component is created called expenseCategories, a user can select from a drop down menu of multiple options that describes expense/income
	
	private final JTextField monthlyBudget; //a JTextField component is created called monthlyBudget, user can enter the monthly budget 
	
	private final JButton addButton; // a JButton component is created called addButton, so the user can enter the entry in the data model
	
	private final JButton clickBudget; // a JButton component is created called clickBudget, so the user can enter their monthly budget and store the data in program
	
	private final JButton SaveDataToFile; // a JButton component is created called SaveDataToFile, so the user can export their data into a text file.
	
	private final JLabel balanceLabel; //a JLabel component is created called balanceLabel, so user knows the current balance
	
	private final JLabel counterExpense; // a JLabel component is created called counterExpense, user can see how many expenses in total
	
	private final JLabel counterIncome; // a JLabel component is created called counterIncome, user can see how many incomes in total
	
	private final JLabel expenseTrackerLabel; // a JLabel comoponent is created called expenseTrackerLabel, user can see the total expenses from the data model.
	
	private double balance; // a double variable called balance is created to add the income or expense to the user's balance.
	
	private int numberofExpense; //a counter variable called numberofExpense to tally the total number of expenses
	
	private int numberofIncome; // a counter variable called numberofIncome to tally the total number of incomes
	
	double expenseTracker = 0.0;
	
	
	/**
	 * 
	 * Purpose: Implements the code to show the GUI configurations and add entries to the data sheet. The data sheet is a table that
	 * models the data based on the user's data. The application window will view and insert the data.
	 */
	private void addEntryToDataSheet()
	{
		String date = dateField.getText(); //String variable called date retrieves the text contained in the dateField's text field.
		
		String description = descriptionField.getText(); //String variable called description retrieves the text contained in the descriptionField's text field.
		
		String userTransaction = TransactionField.getText(); //String variable called userTransaction retrieves the text contained in the transactionField's text field.
		
		String category = (String) categoryBox.getSelectedItem(); //String variable called category stores the selected item from the categoryBox's JComboBox (dropdown menu).
		
		String monthlyBudgetData = monthlyBudget.getText(); //String variable called monthlyBudgetData retrieves the text contained in the monthlyBudget's text field.
		
		String expenditureType = (String) expenseCategories.getSelectedItem(); // String variable called expenditureType stores the selected item from the expenseCategories's JComboBox (dropdown menu).
		
		double userInputTransaction = 0.0;  // double variable called userInputTransaction stores in the transaction into a decimal value
		
		double monthlyBudgetUserInput = 0.0; // double variable called monthlyBudgetUserInput stores in the monthly budget into a decimal value.
		
		
		//try-catch block
			try 
			{
			//the try clause will execute when a value is entered in the monthlyBudgetUserInput variable, if number format exception then error message will pop up.
		
				//the if statement verifies if the monthly budget's textfield is empty and user presses the add budget button, then shows an error message, otherwise proceeds to next lines of code
				if(monthlyBudgetData.isBlank())
				{
					JOptionPane.showMessageDialog(this, "Enter the value in the textbox monthly budget", "Error Message: ", JOptionPane.ERROR_MESSAGE );
				}
				//otherwise, stores the value in the variable as a decimal value.
				else
					monthlyBudgetUserInput = Double.parseDouble(monthlyBudgetData);
	
	
			}
			//catch clause will only execute if the statement in the try clause throws an exception, exception is a NumberFormat exception then program shows the error message.
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(this, "Invalid Budget Entered ", "Error Message: ", JOptionPane.ERROR_MESSAGE );
			}
	
		
		try //try-catch block
		{
			// try clause will execute when a value is entered in the userInputTransaction variable, if number format exception then error message will pop up.
	
				//the if statement verifies if the transaction's textfield is empty, if empty then shows an error, otherwise proceeds to next lines of code
				if(userTransaction.isBlank())
				{
					JOptionPane.showMessageDialog(this, "Enter the value in the textbox transaction", "Error Message: ", JOptionPane.ERROR_MESSAGE );
				}
				//otherwise, stores the value in the variable as a decimal value.
				else
					userInputTransaction = Double.parseDouble(userTransaction);

				//if the user selects Expense from the drop down menu, then multiple things process:
				if(category.equals("Expense"))
				{
					expenseTracker += userInputTransaction; //adds up the total expenses every time user enters the transaction as expense.
					expenseTrackerLabel.setText("Total Expenses: " + expenseTracker); // the label will show the text of Total Expenses and accumulates the total expenses
					userInputTransaction *= -1; //after adding the expense in the counter (expenseTracker), the transaction will become a negative value to show a decrease in balance.
					numberofExpense+=1; //adds 1 to the counter (numberofExpense), tallies the expenses so far.
					counterExpense.setText("Number of Expenses Added: " + numberofExpense); //the label will show text of Number of Expenses Added (counter print on screen).
					
				}
				//if the user selects Income from the drop down menu, then multiple things process:
				if(category.equals("Income"))
				{
					numberofIncome+=1; //adds 1 to the counter (numberofIncome), tallies the incomes so far.
					counterIncome.setText("Number of Incomes Added: " + numberofIncome); //the label will show text of Number of Incomes Added (counter print on screen).
				}
				
				//Create a new entry (ExpenseIncomeUserData object) and utilize the values in the constructor 
				ExpenseIncomeUserData entry = new ExpenseIncomeUserData(date, description, userInputTransaction, category, expenditureType);
				modelTheData.insertEntry(entry); // modelTheData (BudgetCalculatorDataSheet object) invokes the insertEntry method to insert the user defined entry in the data model.
				balance += userInputTransaction; //every time an income or expense transaction is stored in the data model, balance will increase and decrease depending on the type.
				balanceLabel.setText("Balance: $" + balance); //the label will show text of total Balance of the account.
				
				//if expenses is higher than the monthly budget (negative cash flow), then alerts the user to do more savings (pop up message)
				if(monthlyBudgetUserInput < expenseTracker)
				{
					JOptionPane.showMessageDialog(this, "You crossed your Monthly Budget!, Negative Cash Flow, Do more savings!", "Warning: ", JOptionPane.ERROR_MESSAGE);
				}
				//if the balance gets into a negative value, then alerts the user to do more savings and negative balance (pop up  message).
				else if(balance < 0)
				{
					JOptionPane.showMessageDialog(this, "Balance is too low, Negative balance!, more savings!", "Warning: ", JOptionPane.ERROR_MESSAGE);

				}
			}
			//catch clause will only execute if the statement in the try clause throws an exception, exception is a NumberFormat exception then program shows the error message.
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(this, "Invalid Amount Entered ", "Error Message: ", JOptionPane.ERROR_MESSAGE );
	
			}
	
			clearUserInputFields(); //every time the user adds an entry to the, the method clearUserInputFields is called and clears the text boxes.
	}
		
		
		
	/**
	 * 
	 * Purpose: This method will clear the text fields of date, description, and transaction after an entry is added to the data model.
	 */
	private void clearUserInputFields()
	{
		//empties the input lines with empty string
		dateField.setText(""); 
		descriptionField.setText("");
		TransactionField.setText("");
	}
	public BudgetCalculatorInterface()
	{
		//https://docs.oracle.com/javase/8/docs/api/index.html?javax/swing/UIManager.html
		UIManager.put("TextField.foreground", Color.BLACK);
		UIManager.put("TextField.background", Color.lightGray);
		UIManager.put("ComboBox.foreground", Color.BLUE);
		UIManager.put("ComboBox.selectionForeground", Color.GREEN);
		UIManager.put("ComboBox.selectionBackground", Color.BLUE);
		UIManager.put("Button.foreground", Color.BLACK);
		UIManager.put("Button.background", Color.BLACK);
		UIManager.put("Label.foreground", Color.BLUE);
	
		balance = 0.0;
		modelTheData = new BudgetCalculatorDataSheet();
		
		dataTable = new JTable(modelTheData);
		JScrollPane scrollPane = new JScrollPane(dataTable);
		dataTable.setFillsViewportHeight(true);
		dataTable.setFont(new Font("Monospaced", Font.ROMAN_BASELINE, 14));
		dataTable.setBackground((Color.LIGHT_GRAY));
		
		dateField = new JTextField(5);
		descriptionField = new JTextField(5);
		TransactionField = new JTextField(5);
		categoryBox = new JComboBox<>(new String[] {"Expense", "Income"});
		expenseCategories = new JComboBox<>(new String[] {"Salary", "Food", "Transportation", "Utilities", "Entertainment", "Clothing", "Insurance"});
		
		addButton = new JButton("Add");
		
		clickBudget = new JButton("Add Budget");
		
		SaveDataToFile = new JButton("Click To Save Data into File");
		
		balanceLabel = new JLabel("Balance: $ " + balance);
		balanceLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		
		counterExpense = new JLabel("Number of Expenses Added: " + numberofExpense);
		
		counterIncome = new JLabel("Number of Incomes Added: " + numberofIncome);
		
		expenseTrackerLabel = new JLabel("Total Expenses: " + expenseTracker);
		
	
		JLabel monthlyBudgetLabel = new JLabel("Enter your Monthly Budget: ");
		monthlyBudget = new JTextField(10);
		
		
		
		//button invokes the addActionListener 
		//create event listeners to process events like clicking a button
		//the user clicks on add button to register the information into the data table.
		// event listeners need to implement an interface called ActionListener and contains a actionPerformed method 
		//using Lambda expressions to pass the method addEntryToDataSheet() to the actionPerformed method
		//makes code concise as the ActionListner is a interface that has only one method (anonymous inner classes).
		
		addButton.addActionListener(event -> addEntryToDataSheet()); //perform action of adding the user-defined entry in the data model 
		clickBudget.addActionListener(event -> addEntryToDataSheet()); //once the user enters their monthly budget, the budget will be saved in the program and verify if the user crosses the monthly budget 

		//TODO: Citations
		//https://codesignal.com/learn/courses/parsing-table-data-in-java/lessons/writing-table-data-to-text-and-csv-files-in-java
		//https://docs.oracle.com/javase/8/docs/api/java/io/File.html#getAbsoluteFile--
		//https://docs.oracle.com/javase/8/docs/api/java/text/Format.html#format-java.lang.Object-
		//https://docs.oracle.com/javase/8/docs/api/java/io/FileNotFoundException.html
		//the button called SaveDataToFile invokes the method addActionListener and defines an anonymous inner class called ActionListener inside the method 
		SaveDataToFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//try-catch block
				try // try runs only if there is no FileNotFoundException and IOException.
				{
					//Create a File object called file to represent the file and add data.
					File file = new File("/Users/alizae/Downloads/CISC191Project_WritingContentsToFile"); //the pathname of the file.
		
				
					//FileWriter provides an output stream in order to retrieve access to the file, inside the FileWriter constructor, the file variable invokes the .getAbsolute file.
					// the .getAbsoluteFile method returns the absolute form of the pathname.
					//appends data to an existing file.
					FileWriter contentsOfDataTable = new FileWriter(file.getAbsoluteFile());
					
					//The BufferedWriter is able to converting text to a character-output stream. Buffering strings and numeric values.
					//passes the FileWriter object called contentsOfDataTable to the BufferedWriter constructor.
					BufferedWriter writer = new BufferedWriter(contentsOfDataTable);
					
					//Since the data model is a 2D table, a nested loop is required to access the cell's row and column number.
					//The dataTable variable represents a JTable 2D model that contains data of all the entries.
					for(int rowIndex = 0; rowIndex < dataTable.getRowCount(); rowIndex++) //for loop goes from 1st row the last row of the data table.
					{
						for(int colIndex = 0; colIndex < dataTable.getColumnCount(); colIndex++) //the 2nd loop goes from 1st column to the last column of the data table.
						{
							writer.write((String) dataTable.getModel().getValueAt(rowIndex, colIndex)); // the BufferedWriter object invokes the write method from Writer class to write the data of each entry.
							//each value of the entry is retrieved from the row index and column index.
							//converts the text into a string output due to the cast (String)
						}
						writer.write(String.format("\n*_______________________*\n")); //format the string 
						
					}
					writer.close(); //closes the BufferedWriter
					contentsOfDataTable.close(); //closes the FileWriter
					
				} 
				//catch clause runs if there is an exception in the try block, this exception is due if failed/interrupted because if I/O operations
				//the FileNotFoundException is a subclass of IO Exception superclass, because of polymorphism the 
				catch (IOException fileE)
				{
					fileE.printStackTrace();
				}
				// This block of code closes the file (important!).
				// for resource cleanup to ensure that the resources are properly closed.
				/**
				finally
				{
					
					writer.close();
					contentsOfDataTable.close();
				}
				 */
				
				
			
				
			}
			
			
		});
		
		
		Font appFont;
		appFont = new Font("Italic", Font.ROMAN_BASELINE, 18);
		Font labelFont = new Font("Italic", Font.ROMAN_BASELINE, 20);
		Font textfieldFont = new Font("Monospaced", Font.ROMAN_BASELINE, 80);
		UIManager.put("Label.font", labelFont);
		UIManager.put("TextField.font", textfieldFont);
		UIManager.put("ComboBox.font", appFont);
		UIManager.put("Button.font", appFont);
		balanceLabel.setFont(labelFont);
		monthlyBudgetLabel.setFont(labelFont);
		counterExpense.setFont(labelFont);
		counterIncome.setFont(labelFont);
		expenseTrackerLabel.setFont(labelFont);


		
		//TODO: Citations 
		//https://docs.oracle.com/javase/tutorial/uiswing/components/border.html
		Border raisedbevel = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		Border matteBorder = BorderFactory.createMatteBorder(3,3,3,3,Color.GREEN);
		
		
		
		
		JPanel userInputInterface = new JPanel();
		
		userInputInterface.setLayout(new BoxLayout(userInputInterface, BoxLayout.Y_AXIS));
		userInputInterface.setBorder(BorderFactory.createEmptyBorder(0,5,5,0));
		userInputInterface.add(Box.createHorizontalGlue());
		userInputInterface.add(Box.createRigidArea(new Dimension(50,50)));
		
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
		
		//TODO: Citations
		//https://docs.oracle.com/javase/tutorial/uiswing/components/textarea.html
		JTextArea textInstructions = new JTextArea("Welcome to the Budget Calculator App!\n "
				+ "To use the app, first enter your monthly budget for the month then:\n "
				+ " 1) Enter the Date of the transaction\n "
				+ " 3) Enter the Description of the transaction\n "
				+ " 4) Enter the amount\n "
				+ " 5) The cash flow means the transaction is either income or expenditure\n"
				+ " 6) If expenditure, then select the category that matches with the expenditure "
				+ "However, if income is selected  then chosose salary\n "
				+ " 7) After selection finished, then press add.\n"
				+ " The information selected/entered should print out on the screen.\n"
				+ " Enjoy!"
			);
		textInstructions.setFont(new Font("Italic", Font.ROMAN_BASELINE, 14));
		textInstructions.setWrapStyleWord(true);
		textInstructions.setLineWrap(true);
		JScrollPane instructionsArea = new JScrollPane(textInstructions);
		instructionsArea.setPreferredSize(new Dimension(400,50));
		
		
		userInputInterface.add(BudgetingCategories);
		userInputInterface.add(expenseCategories);
		
		
		userInputInterface.add(addButton);
		
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		southPanel.add(balanceLabel);
		southPanel.add(monthlyBudgetLabel);
		southPanel.add(monthlyBudget);
		southPanel.setBorder(raisedbevel);
		southPanel.setBorder(matteBorder);
		southPanel.add(clickBudget);
		southPanel.add(SaveDataToFile);
		southPanel.add(expenseTrackerLabel);
		
		JPanel counterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		counterPanel.add(counterIncome);
		counterPanel.add(counterExpense);
		
		setLayout(new BorderLayout());
		add(userInputInterface, BorderLayout.WEST);
		add(scrollPane, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		add(counterPanel, BorderLayout.NORTH);
		add(instructionsArea, BorderLayout.EAST);
		
		

		
		setTitle("Budget Calculator: Manage Your Finances Wisely!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
		
	}
	
	
}
