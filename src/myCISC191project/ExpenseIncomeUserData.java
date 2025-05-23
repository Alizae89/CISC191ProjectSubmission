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
 * Purpose: The reponsibility of ExpenseIncomeUserData is ...
 *
 * ExpenseIncomeUserData is-a ...
 * ExpenseIncomeUserData is ...
 * 
 */
public class ExpenseIncomeUserData
{
	private String date;
	private String description;
	private Double transaction;
	private String type;
	private String expenditureType;
	
	
	public ExpenseIncomeUserData(String date, String description, double transaction, String type, String expenditureType)
	{
		this.date = date;
		this.description = description;
		this.transaction = transaction;
		this.type = type;
		this.expenditureType = expenditureType;
	}
	public String retrieveDate()
	{
		return date;

	}
	
	public String retrieveDescription()
	{
		return description;

	}

	public double retrieveTransaction()
	{
		return transaction;
	}

	public String retrieveType() 
	{
		return type;
	}
	
	public String retrieveExpenditureType()
	{
		return expenditureType;
	}
	

}
