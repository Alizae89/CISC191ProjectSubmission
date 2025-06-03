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

import javax.swing.*; //import library for overall swing components


import javax.swing.border.Border; //import library for border
import javax.swing.border.EtchedBorder; //import library for EtchedBorder

import java.awt.*; //import library for Abstract Window toolkit (creating graphical user interface GUIS)
import java.awt.event.ActionEvent; //import library that represents an event triggered due to clicking a button.
import java.awt.event.ActionListener; //import library that handles ActionEvent events. (user actions -> trigger a button). Functional interface with a single method.
import java.io.BufferedWriter; // import library for BufferedWriter class
import java.io.File; //import library For File class
import java.io.FileWriter; //import library for FileWriter class
import java.io.IOException; //import library for IOException.
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

	"FileNotFoundException (Java Platform SE 8 )." Moved, 5 Apr. 2025, docs.oracle.com/javase/8/docs/api/java/io/FileNotFoundException.html.
	
	Oracle. "File (Java Platform SE 8 )." getAbsoluteFile, 5 Apr. 2025, docs.oracle.com/javase/8/docs/api/java/io/File.html#getAbsoluteFile--. Accessed 2 June 2025.
	
	"Format (Java Platform SE 8 )." String.format, 5 Apr. 2025, docs.oracle.com/javase/8/docs/api/java/text/Format.html#format-java.lang.Object-. Accessed 2 June 2025.
	
	"Writing Table Data to Text and CSV Files in Java." CodeSignal, //codesignal.com/learn/courses/parsing-table-data-in-java/lessons/writing-table-data-to-text-and-csv-files-in-java. Accessed 2 June 2025.
	
	Baeldung. "Adding a Newline Character to a String in Java." Baeldung, www.baeldung.com/java-string-newline. Accessed 2 June 2025.
	
	Java Oracle. "How to Use Borders (The Java™ Tutorials > Creating a GUI With Swing > Using Swing Components)." Oracle, docs.oracle.com/javase/tutorial/uiswing/components/border.html. Accessed 1 June 2025.
	
	Oracle. "How to Use Text Areas (The Java™ Tutorials > Creating a GUI With Swing > Using Swing Components)." Moved, Java Oracle, docs.oracle.com/javase/tutorial/uiswing/components/textarea.html. Accessed 1 June 2025.


 */
//BudgetCalculatorInterface IS-A JFrame
//Extends JFrame to utilize the GUI components and import libraries
public class BudgetCalculatorInterface extends JFrame
{

	private final BudgetCalculatorDataSheet modelTheData; //create a BudgetCalculatorDataSheet object called modelTheData to implement entries in the data model. BudgetCalculatorInterface HAS-A modelTheData
	
	private final JTable dataTable; //a JTable called dataTable is created from Swing class to display 2D tables of cells. BudgetCalculatorInterface HAS-A dataTable.
	
	private final JTextField dateField; // a JTextField component is created called dataField, user can type data input. BudgetCalculatorInterface HAS-A dateField.
	
	private final JTextField descriptionField;// a JTextField component is created called descriptionField, user can type description input. BudgetCalculatorInterface HAS-A descriptionField.
	
	private final JTextField TransactionField; // a JTextField component is created called TransactionField, a user can type transaction input. BudgetCalculatorInterface HAS-A TransactionField.
	
	private final JComboBox<String> categoryBox; // a JComboBox component is created called categoryBox, a user can select from a drop down menu of two options: income or expense. BudgetCalculatorInterface HAS-A categoryBox
	
	private final JComboBox<String> expenseCategories; // a JComboBox component is created called expenseCategories, a user can select from a drop down menu of multiple options that describes expense/income. BudgetCalculatorInterface HAS-A expenseCategories
	
	private final JTextField monthlyBudget; //a JTextField component is created called monthlyBudget, user can enter the monthly budget. BudgetCalculatorInterface HAS-A monthlyBudget
	
	private final JButton addButton; // a JButton component is created called addButton, so the user can enter the entry in the data model. BudgetCalculatorInterface HAS-A addButton.
		
	private final JButton saveDataToFileButton; // a JButton component is created called SaveDataToFile, so the user can export their data into a text file. BudgetCalculatorInterface HAS-A SaveDataToFile.
	
	private final JLabel balanceLabel; //a JLabel component is created called balanceLabel, so user knows the current balance. BudgetCalculatorInterface HAS-A balanceLabel.
	
	private final JLabel counterExpense; // a JLabel component is created called counterExpense, user can see how many expenses in total. BudgetCalculatorInterface HAS-A counterExpense.
	
	private final JLabel counterIncome; // a JLabel component is created called counterIncome, user can see how many incomes in total. BudgetCalculatorInterface HAS-A counterIncome.
	
	private final JLabel expenseTrackerLabel; // a JLabel component is created called expenseTrackerLabel, user can see the total expenses from the data model. BudgetCalculatorInterface HAS-A expenseTrackerLabel.
	
	private final JLabel monthlyBudgetLabel; // a JLabel component is created called monthlyBudgetLabel, user can see the monthly budget entered. BudgetCalculatorInterface HAS-A monthlyBudgetLabel.
	
	
	private double balance; // a double variable called balance is created to add the income or expense to the user's balance. BudgetCalculatorInterface HAS-A balance.
	
	private int numberofExpense; //a counter variable called numberofExpense to tally the total number of expenses. BudgetCalculatorInterface HAS-A numberofExpense.
	
	private int numberofIncome; // a counter variable called numberofIncome to tally the total number of incomes. BudgetCalculatorInterface HAS-A numberofIncome.
	
	private double expenseTracker = 0.0; //counts the total number of expenses and displays the amount of spendings on the calculator. BudgetCalculatorInterface HAS-A expenseTracker.
	
	
	/**
	 * 
	 * Purpose: Implements the code to show the GUI configurations and add entries to the data sheet. The data sheet is a table that
	 * models the data based on the user's data. The application window will view and insert the data.
	 * BudgetCalculatorInterface HAS-A addEntryToDataSheet
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
		try //try block will execute when a value is entered unless their is an exception of NumberFormat or empty field then an error message will pop up.
		{
			//the if statement verifies if the monthly budget's textfield is empty and user presses the add budget button, then shows an error message, otherwise proceeds to next lines of code
			if(monthlyBudgetData.isBlank())
			{
				throw new IllegalArgumentException("Monthly Budget Field is empty"); //Explicitly throws the exception with message (under catch block).
			}
			monthlyBudgetUserInput = Double.parseDouble(monthlyBudgetData); //Otherwise, stores the value in the variable as a decimal value.
			
			if(userTransaction.isBlank())
			{
				throw new IllegalArgumentException("Transaction Field is empty"); //Explicitly throws the exception with message (under catch block).
			}
			userInputTransaction = Double.parseDouble(userTransaction); //Otherwise, stores the value in the variable as a decimal value.
			
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
			else if(category.equals("Income"))
			{
				numberofIncome+=1; //adds 1 to the counter (numberofIncome), tallies the incomes so far.
				counterIncome.setText("Number of Incomes Added: " + numberofIncome); //the label will show text of Number of Incomes Added (counter print on screen).
			}
			//Create a new entry (ExpenseIncomeUserData object) and set variables of BudgetCalculatorInterface (date, description, userInputTransaction, category, expenditureType) as objects in the constructor 
			ExpenseIncomeUserData entry = new ExpenseIncomeUserData(date, description, userInputTransaction, category, expenditureType);
			
			modelTheData.insertEntry(entry); // modelTheData (BudgetCalculatorDataSheet object) invokes the insertEntry method to insert the user defined entry in the arraylist of entries
			
			balance += userInputTransaction; //every time an income or expense transaction is stored in the data model, balance will increase and decrease depending on the type.
			
			balanceLabel.setText("Balance: $" + balance); //the label will show text of total Balance of the account.
			
			//if expenses is higher than the monthly budget (negative cash flow), then alerts the user to do more savings (pop up message)
			if(monthlyBudgetUserInput < expenseTracker)
			{
				JOptionPane.showMessageDialog(this, "You crossed your Monthly Budget!, Negative Cash Flow, Do more savings!", "Warning: ", JOptionPane.WARNING_MESSAGE);
				if(balance < 0)
				{
					JOptionPane.showMessageDialog(this, "Balance is too low, Negative balance!, more savings!", "Warning: ", JOptionPane.WARNING_MESSAGE);
				}
			}
			//if the balance gets into a negative value, then alerts the user to do more savings and negative balance (pop up  message).
			else if(balance < 0)
			{
				JOptionPane.showMessageDialog(this, "Balance is too low, Negative balance!, more savings!", "Warning: ", JOptionPane.WARNING_MESSAGE);

			}
			
		}
		//catch clause will only execute if the statement in the try clause throws an exception, exception is a NumberFormat exception then program shows the error message.
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(this, "Invalid Amount Entered ", "Error Message: ", JOptionPane.ERROR_MESSAGE );

		}
		//catch clause will only execute if the statement in the try clause throws an exception, occurs when an empty field shows up (no data entered) then program shows the error message.
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "Something went wrong: " + e.getMessage(), "Error: ", JOptionPane.ERROR_MESSAGE);
		}
		//Regardless of an exception or not, the input field will be cleared so the user can entered again or start fresh for a new entry.
		finally
		{
			clearUserInputFields(); //every time the user adds an entry to the, the method clearUserInputFields is called and clears the text boxes.

		}

	}
		
		
		
	/**
	 * 
	 * Purpose: This method will clear the text fields of date, description, and transaction after an entry is added to the data model.
	 * BudgetCalculatorInterface HAS-A clearUserInputFields
	 */
	private void clearUserInputFields()
	{
		//empties the input lines with empty string
		dateField.setText(""); 
		descriptionField.setText("");
		TransactionField.setText("");
	}
	/**
	 * 
	 * Purpose: This constructor will create the entire interface of the budget calculator including GUI configurations and accessible to contents of the entries.
	 */
	public BudgetCalculatorInterface()
	{
		//https://docs.oracle.com/javase/8/docs/api/index.html?javax/swing/UIManager.html
		/**
		 * UIManager.put method allows to set the Color for each JComponent's foreground and background
		 * TextField, ComboBox, Button, and Label.
		 */
		UIManager.put("TextField.foreground", Color.BLACK);
		UIManager.put("TextField.background", Color.lightGray);
		UIManager.put("ComboBox.foreground", Color.BLUE);
		UIManager.put("ComboBox.selectionForeground", Color.GREEN);
		UIManager.put("ComboBox.selectionBackground", Color.BLUE);
		UIManager.put("Button.foreground", Color.BLUE);
		UIManager.put("Label.foreground", Color.BLUE);
	
		balance = 0.0; //set the balance variable 
		modelTheData = new BudgetCalculatorDataSheet(); //initializes the modelTheData as a new object of BudgetCalculatorDataSheet, contains all of the entries.
		
		dataTable = new JTable(modelTheData); // store the modelTheData in JTable constructor and initialize the dataTable as the JTable (2D table).
		JScrollPane scrollPane = new JScrollPane(dataTable); //Create a new JScrollPane object called scrollPane and pass the dataTable object in the constructor (a view component)
		dataTable.setFillsViewportHeight(true); //adjusts the size of the table to fill in the viewPoint 
		dataTable.setFont(new Font("Monospaced", Font.ROMAN_BASELINE, 14)); //set the font of data model based on the configurations (creates a new Font constructor)
		dataTable.setBackground((Color.LIGHT_GRAY)); //set the background color to light Gray
		
		dateField = new JTextField(5); //initializes the dateField as JTextField and passes the size equal to 5.
		descriptionField = new JTextField(5); //Initializes the descriptionField as JTextField and passes the size equal to 5.
		TransactionField = new JTextField(5); //initializes the TransactionField as JTextField and passes the size equal to 5
		categoryBox = new JComboBox<>(new String[] {"Expense", "Income"}); //Initializes the categoryBox as JComboBox and add a new string array object with two values, Expense and Income inside the constructor (combo box)
		expenseCategories = new JComboBox<>(new String[] {"Salary", "Food", "Transportation", "Utilities", "Entertainment", "Clothing", "Insurance"}); //Initializes the expenseCategories as JComboBox and inserts a new string array of objects with 7 values, 
		//Salary, Food, Transportation, Utilities, Entertainment, Clothing, and Insurance inside the constructor (combo box)
		
		addButton = new JButton("Add"); //Initializes the addButton as JButton with text, user clicks the button to add entries on the table.
		
		saveDataToFileButton = new JButton("Click To Save Data into File"); //Initializes the SaveDataToFile as JButton with text, user can append data to a text file.
		
		balanceLabel = new JLabel("Balance: $ " + balance); // Initializes the balanceLabel as JLabel with text, represents text and value (balance)
		balanceLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2)); //set the border around label, balance, specified color and width.
		
		counterExpense = new JLabel("Number of Expenses Added: " + numberofExpense); //Initializes as JLabel with text, represents text and value (counter expense)
		
		counterIncome = new JLabel("Number of Incomes Added: " + numberofIncome); //Initializes as JLabel with text, represents the text and value (counter incomes)
		
		expenseTrackerLabel = new JLabel("Total Expenses: " + expenseTracker); //Initializes as JLabel with text, represents the text and value (expenseTracker, total expenses in the table).
		
	
		monthlyBudgetLabel = new JLabel("Enter your Monthly Budget: "); //Initializes as JLabel with text, represents the text.
		monthlyBudget = new JTextField(10); //Initializes the monthlyBudget as JTextField and passes the size equal to 10.
		
		
		/**
		Registers an ActionListener to a button using a lambda expression.T he user clicks on add button to register the information into the data table,
		it triggers an ActionEvent which calls the addEntryToDataSheet method
		event listeners need to implement an interface called ActionListener and contains a actionPerformed method 
		Using Lambda expressions to pass the method addEntryToDataSheet() to the actionPerformed method. makes code concise as 
		the ActionListener is a interface that has only one method (anonymous inner classes).
		*/
		
		addButton.addActionListener(event -> addEntryToDataSheet()); //perform action of adding the user-defined entry in the data model 

		
		//the button called saveDataToFileButton registers with the method addActionListener and defines an anonymous inner class called ActionListener inside the method 
		saveDataToFileButton.addActionListener(new ActionListener() { // the ActionListener()  handles ActionEvent events. (user actions -> trigger a button). Functional interface with a single method
			public void actionPerformed(ActionEvent e) //user clicks on save data to file button, the event to processes and display data on a file. The actionPerformed method is called
			{
				BufferedWriter writer = null;
				//try-catch block
				try // try runs only if there is no FileNotFoundException and IOException.
				{
					//Create a File object called file to represent the file and add data.
					File file = new File("/Users/alizae/Downloads/CISC191Project_WritingContentsToFile.txt"); //the pathname of the file.
		
				
					//FileWriter provides an output stream in order to retrieve access to the file, inside the FileWriter constructor, the file variable invokes the .getAbsolute file.
					// the .getAbsoluteFile method returns the absolute form of the pathname.
					//appends data to an existing file.
					
					//The BufferedWriter is able to converting text to a character-output stream. Buffering strings and numeric values.
					//passes the FileWriter object called contentsOfDataTable to the BufferedWriter constructor.
					writer = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
					
					//Since the data model is a 2D table, a nested loop is required to access the cell's row and column number.
					//The dataTable variable represents a JTable 2D model that contains data of all the entries.
					writer.write(String.format("Date\t|\tDescription\t|\tTransaction\t|\tCategory\t|\tExpenditureType\n")); //format the string 
					for(int rowIndex = 0; rowIndex < dataTable.getRowCount(); rowIndex++) //for loop goes from 1st row the last row of the data table.
					{
						for(int colIndex = 0; colIndex < dataTable.getColumnCount(); colIndex++) //the 2nd loop goes from 1st column to the last column of the data table.
						{
							writer.write(dataTable.getModel().getValueAt(rowIndex, colIndex).toString()); // the BufferedWriter object invokes the write method from Writer class to write the data of each entry.
							writer.write(String.format("\t|\t"));
							//each value of the entry is retrieved from the row index and column index.
							//converts the text into a string output with the .toString() (string representation of the object).
						}
						writer.write(String.format("\n*___________________________________________________________________________*\n")); //format the string as a divider for each entry.
						
					}
					
				} 
				//catch clause runs if there is an exception in the try block.
				//the FileNotFoundException IS-A IO Exception, because of polymorphism.
				//
				catch (Exception fileE)
				{
					JOptionPane.showMessageDialog(null, "The file didn't save the data: " + fileE.getMessage(), "Error: ", JOptionPane.ERROR_MESSAGE);
				}
				// This block of code closes the file (important!).
				// for resource cleanup to ensure that the resources are properly closed.
				finally
				{
					
					try //try block will only execute when there is no exception closes the writer and shows the message that the file has been successfully saved.
					{
						writer.close(); //closes the BufferedWriter
						JOptionPane.showMessageDialog(null, "The file has been successfully saved!");

					}
					catch (IOException e1) //the catch block will execute if an exception has been caught by the program.
					{
						//Show an error message that the file didn't close properly, this exception is due if failed/interrupted because if I/O operations
						JOptionPane.showMessageDialog(null, "File didn't close properly: " + e1.getMessage(), "Error: ", JOptionPane.ERROR_MESSAGE);
					} 
				}
		
			
			}
			
			
		});
		
		/**
		 * Create three different font objects from Font class, appFont, labelFont, textfieldFont
		 */
		Font appFont = new Font("Italic", Font.ROMAN_BASELINE, 18);
		
		Font labelFont = new Font("Italic", Font.ROMAN_BASELINE, 20);
		
		Font labelFont2 = new Font("Italic", Font.ROMAN_BASELINE, 16);
		
		Font textfieldFont = new Font("Monospaced", Font.ROMAN_BASELINE, 20);
		
		UIManager.put("Label.font", labelFont); // UIManager.put method allows to set the font for each JLabel in the program. 

		/**
		 * The .setFont() method sets the font for following JComponent's JLabel, JComboBox, and JTextField. 
		 */
		balanceLabel.setFont(labelFont);
		
		monthlyBudgetLabel.setFont(labelFont);
		
		counterExpense.setFont(labelFont);
		
		counterIncome.setFont(labelFont);
		
		expenseTrackerLabel.setFont(labelFont);
		
		categoryBox.setFont(appFont);
		
		expenseCategories.setFont(appFont);		
		
		
		dateField.setFont(textfieldFont);
		
		descriptionField.setFont(textfieldFont);
		
		TransactionField.setFont(textfieldFont);
		
		addButton.setFont(labelFont);
				
		saveDataToFileButton.setFont(labelFont);
		

		
	
		
		//Establishes boundaries around the southPanel with etchedBorder raised and matte green border 
		Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED); //A Border object called etchedBorder is initialized and BorderFactory is invoked to create EtchedBorder around the southPanel.
		Border matteBorder = BorderFactory.createMatteBorder(5,3,5,3,Color.GREEN); //A Border object called matteBorder is initialized and BorderFactory is invoked to create MatteBorder around the southPanel.
		
		
		
		
		JPanel userInputInterface = new JPanel(); //Create a JPanel called userInputInterface and initialize to create user interface for the app.
		
		userInputInterface.setLayout(new GridLayout(6,3));
		
		JLabel date = new JLabel("Date: "); //Create a JLabel called date and initialize with a specific text
		date.setHorizontalAlignment(SwingConstants.CENTER);
		userInputInterface.add(date); //add the label to the JPanel userInputInterface.
		userInputInterface.add(dateField); //add the dateField (textfield) to the JPanel userInputInterface. 

		
		JLabel description = new JLabel("Description: "); //Create a JLabel called description and initialize with a specific text
		description.setHorizontalAlignment(SwingConstants.CENTER);
		userInputInterface.add(description); // add the label to the JPanel userInputInterface
		userInputInterface.add(descriptionField); //add the descriptionField (text field) to the JPanel userInputInterface
		
		JLabel transaction = new JLabel("Transaction: "); //Create a JLabel called transaction and initialize with a specific text
		transaction.setHorizontalAlignment(SwingConstants.CENTER);
		userInputInterface.add(transaction); //add the label to the JPanel userInputInterface
		userInputInterface.add(TransactionField); //add the TransactionField (text field) to the JPanel userInputInterface
		
		JLabel category = new JLabel("<html>Cash Flow <br>(Income or Expenditure)</html>: "); //Create a JLabel called category and initialize with a specific text
		category.setFont(labelFont2);
		category.setHorizontalAlignment(SwingConstants.CENTER);
		userInputInterface.add(category); //add the label to the JPanel userInputInterface
		userInputInterface.add(categoryBox); //add the categoryBox (drop down menu) to the JPanel userInputInterface.
		
		JLabel BudgetingCategories = new JLabel("Expenses Categories: "); //Create a JLabel called BudgetingCategories and initialize with a specific text
		BudgetingCategories.setFont(labelFont2);
		BudgetingCategories.setHorizontalAlignment(SwingConstants.CENTER);
		userInputInterface.add(BudgetingCategories); //add the label to the JPanel
		userInputInterface.add(expenseCategories); //add the expenseCategories (drop down menu) to the JPanel

		
		userInputInterface.add(addButton); //add the button so the user can add the entry to the table model
		
		userInputInterface.setPreferredSize(new Dimension(400,50)); //set the size of the JTextArea to 400 x 50.


		//Create a JTextArea called textInstructions from Swing class called JTextArea that display multi-line area of text for the user to read
		JTextArea textInstructions = new JTextArea("Welcome to the Budget Calculator App!           " //displays instructions for the user.
				+ "\n"
				+"  To use the app, first enter your monthly budget for the month then:\n "
				+ " 1) Enter the Date of the transaction\n "
				+ " 3) Enter the Description of the transaction\n "
				+ " 4) Enter the amount\n "
				+ " 5) The cash flow means the transaction is either income or expenditure\n"
				+ " 6) If expenditure, then select the category that matches with the expenditure "
				+ " However, if income is selected  then chosose salary\n "
				+ " 7) After selection finished, then press add.\n"
				+ " The information selected/entered should print out on the screen.\n"
				+ " Total expenses can be seen at the bottom right of the screen, produce total spending for the month.\n"
				+ " **************************************"
				+ "\nYou can also save your data to a file and keep a digital copy of your monthly spending and savings."
				+ "                                             Enjoy!!!"
			);
		
		textInstructions.setFont(new Font("Italic", Font.BOLD, 14)); //The JTextArea sets an customize font 
		textInstructions.setWrapStyleWord(true); //the lines in the component will be wrapped at word boundaries
		textInstructions.setLineWrap(true); //the lines will be wrapped if they are too long to fit within the allocated width.
		JScrollPane instructionsArea = new JScrollPane(textInstructions); //Create a JScrollPane called instructionsArea and initialize the object and pass the textInstructions in the constructor. 
		instructionsArea.setPreferredSize(new Dimension(300,50)); //set the size of the JTextArea to 400 x 50.
		
			
				
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); //create a JPanel called southPanel and initialize the object and set the components of the panel to center using the FlowLayout
		
		southPanel.add(balanceLabel); // add the balance label, to view the balance 
		southPanel.add(monthlyBudgetLabel); //add the monthlyBudget label, to view the monthly budget
		southPanel.add(monthlyBudget); //add the text field of the monthly budget so the user can add their value.
		southPanel.setBorder(etchedBorder); //invoke the setBorder on the JPanel to establish the etchedBorder.
		southPanel.setBorder(matteBorder); //invoke the setBorder on the JPanel to establish the matteBorder.
		southPanel.add(saveDataToFileButton); //add the saveDataToFile so the user can click on the button and append their data to the file.
		southPanel.add(expenseTrackerLabel); //add the expenseTracker label so the user can see their total expenses.
		
		JPanel counterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); //create a JPanel called counterPanel and initialize the object and set the components of the panel to center using the FlowLayout
		counterPanel.add(counterIncome); //add the counterIncome label, user can see how many incomes added to the table model.
		counterPanel.add(counterExpense); //add the counterExpense label, user can see how many expenses added the table model.
		
		setLayout(new BorderLayout()); //create a layout manager for all of the panels created and using BorderLayout
		add(userInputInterface, BorderLayout.WEST); //set the userInputInterface to the west portion of the GUI interface
		add(scrollPane, BorderLayout.CENTER);//set the scrollPane to the Center portion of the GUI interface
		add(southPanel, BorderLayout.SOUTH); //set the southPanel to the south portion of the GUI interface
		add(counterPanel, BorderLayout.NORTH); //set the counterPanel to the north portion of the GUI interface
		add(instructionsArea, BorderLayout.EAST); //set the instructionsArea to the east portion of the GUI interface
		
		
		setTitle("Budget Calculator: Manage Your Finances Wisely!"); //set the title of the application window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when the user wants to close the the frame (window)
		pack(); //window to be resized for preferred size and layouts of the subcomponents
		setVisible(true); //shows the window.
		
		
	}
	
	
}
