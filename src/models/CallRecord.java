package models;

public class CallRecord {
	// Declaration of private variables
	// Variable to hold call records direction
	private boolean incomingCall;
	// Variable to hold call records phone number
	private String phoneNumber;
	// Variable to hold call records duration of the call
	private int duration;

	// Variable to hold the direction of the call
	private static final String INCOMING = "Incoming";
	// Variable to hold the direction of the call
	private static final String OUTGOING = "Outgoing";

	/**
	 * Declaration of the constructor method
	 * @param phoneNumber Parameter for setting call records phone number
	 * @param incomingCall Parameter for setting call records direction
	 * @param duration Parameter for setting call records duration
	 */
	public CallRecord(String phoneNumber, String incomingCall, int duration) {
		// Validating inputs before setting the fields
		validatePhoneNumber(phoneNumber);
		validateDuration(duration);
		validateCallDirection(incomingCall);

		// Setting the private variables to the values of the parameters
		this.incomingCall = parseCallDirection(incomingCall);
		this.phoneNumber = phoneNumber;
		this.duration = duration;
	}

	/**
	 * Method to check that the call records phone number entered is of a valid length and format
	 *
	 * @param phoneNumber Parameter to input the call records phone number
	 */
	private void validatePhoneNumber(String phoneNumber) {
		if (phoneNumber.length() < 3 || phoneNumber.length() > 12) {
			throw new IllegalArgumentException("Number Invalid: Length should be between 3 and 12 characters");
		}

		for (int i = 0; i < phoneNumber.length(); i++) {
			if (!Character.isDigit(phoneNumber.charAt(i))) {
				throw new IllegalArgumentException("Number Invalid: Only digits are allowed");
			}
		}
	}

	/**
	 * Method to check that the duration of the call in the call record is a valid length
	 *
	 * @param duration Parameter to enter the duration of the call
	 */
	private void validateDuration(int duration) {
		if (duration < 0 || duration > 5_000_000) {
			throw new IllegalArgumentException("Call Duration Invalid: Must be between 0 and 5,000,000");
		}
	}

	/**
	 * Method that ensures the call direction entered is of a valid format
	 *
	 * @param callDirection Parameter used to set the value of the incoming call
	 */
	private void validateCallDirection(String callDirection) {
		if (!INCOMING.equalsIgnoreCase(callDirection) && !OUTGOING.equalsIgnoreCase(callDirection)) {
			throw new IllegalArgumentException("Invalid call direction: " + callDirection);
		}
	}

	/**
	 * Method to return the calls direction as a string
	 * @return Returns the direction as a string
	 */
	public String getCallDirectionString() {
		return isIncomingCall() ? INCOMING : OUTGOING;
	}

	/**
	 * Method to check a string for the direction of a customer's call and convert to a boolean value
	 * @param input Parameter to input string
	 * @return Returns true if the direction is incoming, false if outgoing
	 */
	public static boolean parseCallDirection(String input) {
		return INCOMING.equalsIgnoreCase(input);
	}

	/**
	 * Getter method that returns the private variable incomingCall
	 * @return Returns if a call is incoming or not as a boolean value
	 */
	public boolean isIncomingCall() {
		return incomingCall;
	}

	/**
	 * Setter method that sets the value of the private variable incoming call
	 * @param incomingCall Parameter used to set the value of the private variable incoming call
	 */
	public void setIncomingCall(String incomingCall) {
		validateCallDirection(incomingCall);
		this.incomingCall = parseCallDirection(incomingCall);
	}

	/**
	 * Getter method that returns the private variable phoneNumber
	 * @return Returns the phone number belonging to the call record
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Setter method for the private variable phoneNumber
	 * @param phoneNumber Parameter to input the call records phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		validatePhoneNumber(phoneNumber);
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Getter method that returns the private variable duration
	 * @return Returns the duration of the phone call belonging to the call record
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Setter method for the private variable duration
	 * @param duration Parameter to input the duration of the phone call belonging to the call records
	 */
	public void setDuration(int duration) {
		validateDuration(duration);
		this.duration = duration;
	}
}
