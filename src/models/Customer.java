package models;

import java.util.ArrayList;

public class Customer implements Comparable<Customer> {
	//Declaration of private variables 
	//Variable to hold customers first name
	private String firstName;
	//Variable to hold customers surname
	private String surname;
	//Variable to hold customers ID
	private String customerId;
	//Variable to hold customers phone number
	private String phoneNumber;
	//Variable to hold the sum of the duration of all the customers calls 
	private int sumOfCalls;
	//Declaration of the list of call records belonging to each customer
	private final ArrayList<CallRecord> callRecords = new ArrayList<>();
	/**
	 * Declaration of the constructor method
	 * @param firstName Parameter for setting customers first name
	 * @param surname Parameter for setting customers surname
	 * @param customerId Parameter for setting customers ID
	 * @param phoneNumber Parameter for setting customers phone number 
	 */
	public Customer(String firstName, String surname, String customerId, String phoneNumber) {
		//Calling method to check if the customers ID is valid
		isCustomerIdValid(customerId);
		//Calling method to check if the customers phone number is a valid length
		isPhoneNumberValidLength(phoneNumber);
		//Calling method to check if the customers phone number is in a valid format
		isPhoneNumberValidFormat(phoneNumber);
		//Setting the private variables to equal the values of the parameter
		this.firstName = firstName;
		this.surname = surname;
		this.customerId = customerId;
		this.phoneNumber = phoneNumber;
	}
	/**
	 * Method to check that the customers ID entered is of a valid length
	 *
	 * @param customerId Parameter to input customer ID
	 */
	public void isCustomerIdValid(String customerId) {
		//If statement to check if customerId is equal to 10
		if (customerId.length() == 10) {
			return;
		}
		//Throws an exception if the conditions of the if statement aren't met
		throw new IllegalArgumentException("Invalid Customer ID");
	}
	/**
	 * Method to check that the customers ID entered is of a valid format
	 * @param customerId Parameter to input customers ID
	 * @return Returns true if the conditions aren't met 
	 */
	public boolean isCustomerIdValidFormat(String customerId) {
		//For loop that iterates through each digit in the customer ID to ensure it is of valid format 
		for (int i = 0; i < customerId.length(); i++) {
			//If statement to check if a character in customer ID is not a digit
			if (!Character.isDigit(customerId.charAt(i))) {
				//Throws an exception if the conditions of the if statement are met
				throw new IllegalArgumentException("Number Invalid");
			}
		}
		return true;
	}
	/**
	 * Method to check that the customers phone number entered is of a valid length
	 *
	 * @param phoneNumber Parameter to input phone number
	 */
	public void isPhoneNumberValidLength(String phoneNumber) {
		//If statement to check if the phone number is less that 3 or more than 12
		if (phoneNumber.length() < 3 || phoneNumber.length() > 12) {
			//Throws an exception if the conditions of the if statement are met
			throw new IllegalArgumentException("Number Invalid");
		}
	}
	/**
	 * Method to check that the customers phone number entered is of a valid format
	 *
	 * @param phoneNumber Parameter to input phone number
	 */
	public void isPhoneNumberValidFormat(String phoneNumber) {
		//For loop that iterates through each digit in the phone number to ensure it is of valid format 
		for (int i = 0; i < phoneNumber.length(); i++) {
			//If statement to check if the phone number contains a character that isn't a digit
			if (!Character.isDigit(phoneNumber.charAt(i))) {
				//Throws an exception if the conditions of the if statement are met
				throw new IllegalArgumentException("Number Invalid");
			}
		}
	}
	/** 
	 * Getter method for the private variable first name 
	 * @return Returns customers first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Setter method for the private variable first name 
	 * @param firstName Parameter to input and set customers first name
	 */
	public void setFirstName(String firstName) {
		//Setting the private variable to equal the value of the parameter
		this.firstName = firstName;
	}
	/**
	 * Getter method for the private variable surname 
	 * @return Returns customers surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * Setter method for the private variable surname 
	 * @param surname Parameter to input and set customers first name
	 */
	public void setSurname(String surname) {
		//Setting the private variable to equal the value of the parameter
		this.surname = surname;
	}
	/**
	 * Getter method for the private variable first name and surname 
	 * @return Returns customers full name
	 */
	public String getFullName() {
		return firstName + " " + surname;
	}
	/**
	 * Getter method for the private variable customer ID 
	 * @return Returns customers ID
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * Setter method for the private variable customer ID
	 * @param customerId Parameter to input and set customers ID
	 */
	public void setCustomerId(String customerId) {
		//Calling method to check if the customers ID is valid
		isCustomerIdValid(customerId);
		//Setting the private variable to equal the value of the parameter
		this.customerId = customerId;

	}
	/**
	 * Getter method for the private variable phone number
	 * @return Returns customers phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * Setter method for the private variable phone number
	 * @param phoneNumber Parameter to input and set customers phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		//Calling method to check if the customers phone number is in a valid length
		isPhoneNumberValidLength(phoneNumber);
		//Calling method to check if the customers phone number is in a valid format
		isPhoneNumberValidFormat(phoneNumber);
		//Setting the private variable to equal the value of the parameter
		this.phoneNumber = phoneNumber;
	}
	/**
	 * Getter method for the private array list callRecords
	 * @return Returns customers call records as an array
	 */ 
	public ArrayList<CallRecord> getCallRecords() {
		return callRecords;
	}
	/**
	 * Setter method for the private array list callRecords
	 * @param callRecords Parameter to input and set customers call records 
	 */
	public void addCallRecord(CallRecord callRecords) {
		this.callRecords.add(callRecords);
	}
	/**
	 * Getter method for the private variable sumOfCalls
	 * @return Returns the sum of all the customers calls 
	 */
	public int getSumOfCalls() {
		return sumOfCalls;
	}
	/**
	 * Method to calculate the sum of the duration of all incoming calls on a customers call record 
	 * @param callRecords The array of call records that the method uses to calculate the sum of the duration
	 * @return returns The sum the calls once the loop has finished
	 */
	public int sumOfCalls(ArrayList<CallRecord> callRecords) {
		//Variable that stores the sum of the duration of the customers incoming calls  
		int sumOfCalls = 0;
		//For loop that iterates through the length of the array list 
		for (CallRecord callRecord : callRecords) {
			//If statement that verifies that the call within the call record is not an incoming call
			if (!callRecord.isIncomingCall()) {
				//Adds the duration of the incoming call to the sumOfCalls
				sumOfCalls += callRecord.getDuration();
			}
		}
		return sumOfCalls;
	}
	/**
	 * Method that converts seconds to minutes and rounds the number up
	 * @param seconds The seconds that are converted into minutes
	 * @return Returns number of minutes rounded up
	 */
	public int secondsToMinutes(double seconds) {
		return (int) Math.ceil(seconds / 60);
	}
	/**
	 * Method to calculate the price of all the customers calls 
	 * @return Returns the total price of all calls
	 */
	public double priceOfCalls() {
		return secondsToMinutes(sumOfCalls(this.callRecords)) * 0.09;
	}
	/**
	 * Method to compare the price of all calls of each customer to one another and sort them into ascending order
	 * @return Returns a value based of the outcome of the if statements 
	 */
	@Override
	public int compareTo(Customer customer) {
		//Returns the comparison of the price of calls of each customer to one another
		return Double.compare(customer.priceOfCalls(), this.priceOfCalls());
	}
}


