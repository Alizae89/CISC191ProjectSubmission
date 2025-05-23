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

import java.util.ArrayList;


import javax.swing.table.AbstractTableModel;

/**
 * Purpose: The reponsibility of BudgetCalculatorDataSheet is ...
 *
 * BudgetCalculatorDataSheet is-a ...
 * BudgetCalculatorDataSheet is ...
 */
public class BudgetCalculatorDataSheet extends AbstractTableModel
{
	private final ArrayList<ExpenseIncomeUserData> entries;
	
	private final String[] columnNames = {"Date", "Description", "Transaction", "Type", "Expenditure Type"};

	
	public BudgetCalculatorDataSheet()
	{
		entries = new ArrayList<>();
		
	}
	public void insertEntry(ExpenseIncomeUserData entry)
	{
		entries.add(entry);
		//From Abstract Table Model Java Swing
		//Notifies all listeners that rows in the range [firstRow, lastRow], inclusive, have been inserted.
		fireTableRowsInserted(entries.size()-1, entries.size()-1);
	}
	@Override
	public int getRowCount()
	{
		return entries.size();
	}
	
	@Override
	public String getColumnName(int column)
	{
		return columnNames[column];
	}

	@Override
	public int getColumnCount()
	{
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		ExpenseIncomeUserData entry = entries.get(rowIndex);
		
		// Return the information of column cell based on the column index.
		// The entry is the reference variable from class ExpenseIncomeUser Data that reaches
		// to any rowIndex. 
		switch(columnIndex)
		{
			case 0:
				return entry.retrieveDate();
			case 1:
				return entry.retrieveDescription();
			case 2:
				return entry.retrieveTransaction();
			case 3:
				return entry.retrieveType();
			case 4:
				return entry.retrieveExpenditureType();
			default: return null;
		}
	}
	
	
	
	
	
	
}


