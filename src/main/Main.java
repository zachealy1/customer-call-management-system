package main;

import models.CallRecord;
import models.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	//Declaration of new call record
	public static CallRecord call = new CallRecord("07503154154", "Outgoing", 210);
	//Declaration of new call record
	public static CallRecord call1 = new CallRecord("123", "Outgoing", 392);
	//Declaration of new call record
	public static CallRecord call2 = new CallRecord("1224", "Incoming", 992);
	//Declaration of new call record
	public static CallRecord call3 = new CallRecord("1224", "Outgoing", 819);
	//Declaration of new file to read customer data from
	public static File inputFile = new File("src/resources/CustomerData.txt");
	//Declaration of new customer array list to store the list of customers from the file
	public static ArrayList<Customer> customerRecordList = new ArrayList<>();
	//Declaration of new call record list to store the list of call records from the file
	public static ArrayList<CallRecord> callRecordList = new ArrayList<>();
	/**
	 * Method to test the call record class
	 */
	public static void testCallRecordClass() {
		//Printing of expected values verses actual values to ensure the call record class works properly 
		System.out.println("Expected call duration: 210 || Actual call duration: " + call.getDuration() + "s");
		System.out.println("Expected phone number: 07503154154 || Actual phone number: " + call.getPhoneNumber());
		System.out.println("Expected direction of call: Outgoing || Actual direction of call: " + call.getCallDirectionString());
		//Printing of new line for readability 
		System.out.println();
	}
	/**
	 * Method to check the customer class
	 */
	public static void testCustomerClass() {
		//Declaration of new customer used in testing
		Customer zac = new Customer("Zac", "Healy", "1234567890", "07503154154");
		//Addition of call records to the customer object declared as zac
		zac.addCallRecord(call);
		zac.addCallRecord(call1);
		zac.addCallRecord(call2);
		zac.addCallRecord(call3);
		//Printing of expected values verses actual values to ensure the customer class works properly 
		System.out.println("Expected first name: Zac || Actual first name: " + zac.getFirstName());
		System.out.println("Expected surname: Healy || Actual surname: " + zac.getSurname());
		System.out.println("Expected phone number: 07503154154 || Actual phone number: " + zac.getPhoneNumber());
		System.out.println("Expected customer ID: 1234567890 || Actual customer ID: " + zac.getCustomerId());
		//Printing of new line for readability 
		System.out.println();
		//Calling of call records print method on the object zac to ensure the call records match the customer
		getCallRecordsPrint(zac.getCallRecords());
		//Printing of expected values verses actual values to ensure the customer class works properly 
		System.out.println("Sum of calls duration in seconds expected: 2413s || Actual sum of all calls: "
				+ zac.sumOfCalls(zac.getCallRecords()) + "s");
		System.out.println("Sum of calls duration in minutes expected: 41 minutes || Actual sum of all calls: "
				+ zac.secondsToMinutes(zac.sumOfCalls(zac.getCallRecords())) + " minutes");
		System.out.printf("Price of calls expected: £3.69 || Actual price of calls: £%.2f", zac.priceOfCalls());
		//Printing of new line for readability 
		System.out.println();
	}
	/**
	 * Method that prints the call records of a customer
	 * @param callRecords Parameter to input the customers call records that need to be printed
	 */
	public static void getCallRecordsPrint(ArrayList<CallRecord> callRecords) {
		for (int i = 0; i < callRecords.size(); i++) {
			//Printing of the call number 
			System.out.println("----- Call Number " + (i + 1) + " -----");
			//Printing of the phone number associated with the call record 
			System.out.println("Call Number: " + callRecords.get(i).getPhoneNumber());
			//Printing of the duration associated with the call record 
			System.out.println("Call Duration: " + callRecords.get(i).getDuration() + "s");
			//Printing of the direction associated with the call record 
			System.out.println("Call Direction: " + callRecords.get(i).getCallDirectionString());
			//Printing of new line for readability 
			System.out.println();
		}
	}
	/**
	 * Method for testing the file readers function
	 */
	public static void testFileReader() {
		for (int i = 0; i < customerRecordList.size(); i++) {
			//Printing of new line for readability 
			System.out.println();
			//Printing of the customers number in the order of the file
			System.out.println("----- Customer Number " + (i + 1) + " -----");
			//Printing of the customers first name
			System.out.println("First Name: " + customerRecordList.get(i).getFirstName());
			//Printing of the customers surname
			System.out.println("Surname: " + customerRecordList.get(i).getSurname());
			//Printing of the customers ID
			System.out.println("Customer ID: " + customerRecordList.get(i).getCustomerId());
			//Printing of the customers phone number
			System.out.println("Customer Phone No.: " + customerRecordList.get(i).getPhoneNumber());
			//Calling of call records print method on the object at position i within the array customerRecordList to ensure the call records match the customer
			getCallRecordsPrint(customerRecordList.get(i).getCallRecords());
		}
	}

	/**
	 * Method used to read the file CustomerData.txt
	 * @throws FileNotFoundException In case the file isn't located
	 */
	public static void readFile() throws FileNotFoundException {
		// Scanner used to read the data from the file
		Scanner sc = new Scanner(inputFile);
		// Delimiter declared as "," to instruct scanner where to read the data between
		sc.useDelimiter(",");
		// Declaration of the iterators used to log the position of specific values
		int i = 0;
		int x = 0;
		// While loop that loops until the scanner has no data left to read
		while (sc.hasNext()) {
			// Adding new customer to the array list customerRecordList with the scanned
			// values as the parameters for the constructor
			customerRecordList.add(new Customer(sc.next(), sc.next(), sc.next(), sc.nextLine().replaceFirst(",", "")));
			// Value that the for loop uses to determine how many lines to read before
			// exiting
			int skip = Integer.parseInt(sc.nextLine());
			// For loop that loops a set number of lines to read the call record data
			for (int y = 0; y < skip; y++) {
				// Adding new call record to the array list callRecordList with the scanned
				// values as the parameters for the constructor
				callRecordList.add(new CallRecord(sc.next(), sc.next(),
						Integer.parseInt(sc.nextLine().replaceFirst(",", ""))));
				//Adding a call record at position x in the callRecordList a customer in the customerRecordList at position i
				customerRecordList.get(i).addCallRecord(callRecordList.get(x));
				//Iterating x
				x++;
			}
			//Iterating i
			i++;
		}
		sc.close();
	}
	/**
	 * Method that prints the customers names and their total bills
	 */
	public static void printCustomerBills() {
		//Printing of new line for readability 
		System.out.println();
		//Printing of title for readability
		System.out.println("------- Customer Bills -------");
		//For loop the iterates through each customer 
		for (Customer customer : customerRecordList) {
			System.out.println();
			//Printing of customers full name and their total bill
			System.out.printf(customer.getFullName() + " " + " £%.2f", customer.priceOfCalls());
		}
		//Printing of new line for readability 
		System.out.println();
	}
	/**
	 * Method that prints the customers names and their total bills in ascending order
	 */
	public static void printSortedCustomerBills() {
		//Calling of method that sorts the customers into ascending order by their total bills 
		Collections.sort(customerRecordList);
		//Printing of new line for readability 
		System.out.println();
		//Printing of title for readability
		System.out.println("------- Customer Bills In Order -------");
		//For loop the iterates through each customer 
		for (Customer customer : customerRecordList) {
			System.out.println();
			//Printing of customers full name and their total bill
			System.out.printf(customer.getFullName() + " " + " £%.2f", customer.priceOfCalls());
		}
		//Printing of new line for readability 
		System.out.println();
	}

	public static void main(String[] args) throws FileNotFoundException {
		//Calling the test testCallRecordClass method
//		testCallRecordClass();
		//Calling the test testCustomerClass method
//		testCustomerClass();
		//Calling the test readFile method
		readFile();
		//Calling the test testFileReader method
//		testFileReader();
		//Calling the test printCustomerBills method
		printCustomerBills();
		//Calling the test printSortedCustomerBills method
		printSortedCustomerBills();
	}
}
