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
* Version: 2025-04-26
*/
package myCISC191project;

/**
 * Purpose: The responsibility of ExpenseIncomeUserData is to create the entries for the budget calculator
 *
 * ExpenseIncomeUserData is-a ...
 * ExpenseIncomeUserData is ...
 * 
 */
//The class will create an constructor that initializes the variables, create getter methods to return the variables.
// The entries will describe the user data of either expense and income.
public class ExpenseIncomeUserData
{
	private String date; //instance variable called date. ExpenseIncomeUserData HAS-A date
	private String description; //instance variable called description. ExpenseIncomeUserData HAS-A description
	private Double transaction; //instance variable called transaction. ExpenseIncomeUserData HAS-A transaction
	private String type; //instance variable called type (expense or income). ExpenseIncomeUserData HAS-A type
	private String expenditureType; //instance variable called expenditureType. ExpenseIncomeUserData HAS-A expenditureType
	//List of choices that user will pick that will describe the transaction.
	
	
	//A single entry in the data model will have a date, description, transaction, type, and expenditureType
	//The constructor initializes the variables and passes them as parameters to establish an object for ExpenseIncomeUserData
	public ExpenseIncomeUserData(String date, String description, double transaction, String type, String expenditureType)
	{
		this.date = date; //this keyword, to initializes the variable date
		this.description = description; //this keyword, to initializes the variable description
		this.transaction = transaction; //this keyword, to initializes the variable transaction
		this.type = type; //this keyword, to initializes the variable type
		this.expenditureType = expenditureType; // this keyword, to initializes the variable expenditureType
	}
	/**
	 * 
	 * Purpose: The getter method returns the date of the entry.
	 * @return date
	 * ExpenseIncomeUserData HAS-A retrieveDate
	 */
	public String retrieveDate()
	{
		return date;

	}
	
	/**
	 * 
	 * Purpose: The getter method returns the description of the entry.
	 * @return description
	 * ExpenseIncomeUserData HAS-A retrieveDescription
	 */
	public String retrieveDescription()
	{
		return description;

	}

	/**
	 * 
	 * Purpose: The getter method returns the transaction of the entry.
	 * @return transaction
	 * ExpenseIncomeUserData HAS-A retrieveTransaction
	 */
	public double retrieveTransaction()
	{
		return transaction;
	}
	/**
	 * 
	 * Purpose: The getter method returns type (income or expenditure) of the entry.
	 * @return type
	 * ExpenseIncomeUserData HAS-A retrieveType
	 */
	public String retrieveType() 
	{
		return type;
	}
	/**
	 * 
	 * Purpose: The getter method returns expenditure type of the entry.
	 * @return
	 * ExpenseIncomeUserData HAS-A retrieveExpenditureType
	 */
	public String retrieveExpenditureType()
	{
		return expenditureType;
	}
	

}
