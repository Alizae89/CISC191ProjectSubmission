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
* Oracle. (2025, April 5). AbstractTableModel (Java platform SE 8 ). https://docs.oracle.com/javase/8/docs/api/javax/swing/table/AbstractTableModel.html#fireTableRowsInserted-int-int-

* Version: 2025-05-02
*/
package myCISC191project;

import java.util.ArrayList; //import library for ArrayList


import javax.swing.table.AbstractTableModel; // import library for TableModel interface 

/**
 * Purpose: The responsibility of BudgetCalculatorDataSheet is to create the table model for the app. 
 * The app will have 5 column names that will describe the entries in the list.
 * The class will also create an array list called entries that will store the entries in the data model every time the insertEntry method is called.
 *
 * BudgetCalculatorDataSheet is-a ...
 * BudgetCalculatorDataSheet is ...
 */
// BudgetCalculatorDataSheet IS-A AbstractTableModel
//Overrides the various methods from AbstractTableModel superclass like getRowCount(), getColumnName(), getColumnCount(), getValueAt()
public class BudgetCalculatorDataSheet extends AbstractTableModel
{ 
	//dynamic as adjusts to number of items inserted and will store the objects from the ExpenseIncomeUserData constructor.
	//establishes an new ArrayList object and names the reference variable entries. 
	private final ArrayList<ExpenseIncomeUserData> entries; // the ArrayList will store the ExpenseIncomeUserData objects (entries) in the data model.
	
	//String array called columnNames, display the column names of the data model. 
	//This will represent the description of each entry in the data model.
	private final String[] columnNames = {"Date", "Description", "Transaction", "Type", "Expenditure Type"};

	
	//Creates an constructor for BudgetCalculatorDataSheet and initializes the data model 
	public BudgetCalculatorDataSheet()
	{
		entries = new ArrayList<>();
		
	}
	 /**
	  * 
	  * Purpose: The method is insert a new entry to the data model. Passes the entry, a reference variable which contains
	  * the objects of ExpenseIncomeUserData as a parameter variable. Then the variable is add in the arraylist (entries).
	  * @param entry
	  * BudgetCalculatorDataSheet HAS-A insertEntry
	  */
	public void insertEntry(ExpenseIncomeUserData entry)
	{
		entries.add(entry); //the expense or income entry is added to the list as the last position.
		
		//From Abstract Table Model Java Swing
		//Notifies all listeners that rows in the range [firstRow, lastRow], inclusive, have been inserted.
		fireTableRowsInserted(entries.size()-1, entries.size()-1); //the table adds a new row at the end of the table model 
	}
	
	/**
	 * Purpose: The method returns the number of rows in the data model
	 * BudgetCalculatorDataSheet HAS-A getRowCount
	 */
	@Override
	public int getRowCount()
	{
		return entries.size(); //the size method, returns the number of elements ( ExpenseIncomeUserData objects) in the arraylist.
	}
	/**
	 * Purpose: The method returns the column name from the string array called columnNames based on the index value.
	 * BudgetCalculatorDataSheet HAS-A getColumnName
	 */
	@Override
	public String getColumnName(int column)
	{
		return columnNames[column]; // return the name of the column names in the data model.
	}

	/**
	 * Purpose: Returns the number of columns in the data model.
	 * BudgetCalculatorDataSheet HAS-A getColumnCount
	 */
	@Override
	public int getColumnCount()
	{
		return columnNames.length; // returns the size of the columnNames array using the .length field
	}

	/**
	 * Purpose: Acquires the entry based on the rowIndex and columnIndex values.
	 * BudgetCalculatorDataSheet HAS-A getValueAt
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		//The entry is the reference variable from class ExpenseIncomeUser object that reaches
		// to any rowIndex using the get method.
		ExpenseIncomeUserData entry = entries.get(rowIndex);
		
		// Return the information of column cell based on the column index.
		switch(columnIndex)
		{
			//if the column index is 0
			case 0:
				return entry.retrieveDate(); // returns the date of the entry
			//if the column index is 1
			case 1:
				return entry.retrieveDescription(); // returns the description of the entry
			//if the column index is 2
			case 2:
				return entry.retrieveTransaction(); // returns the transaction of the entry
			//if the column index is 3
			case 3:
				return entry.retrieveType(); // returns the type (income or expense) of the entry
			//if the column index is 4
			case 4:
				return entry.retrieveExpenditureType(); // return the expenditure type of the entry
			default: return null; //if column index doesn't equals to one of the values (0,1,2,3,4) then return null.
		}
	}
	
	
	
	
	
	
}


