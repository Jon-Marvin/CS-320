

package Service;

import java.util.ArrayList;	

public class ContactService {
	
	// Variables for creating objects of Contact class
	public static String publicId;
	public String publicFirstName;
	public String publicLastName;
	public String publicPhone;
	public String publicAddress;
	
	// Create a list of contacts
	public static ArrayList<Contact> contactList = new ArrayList<Contact>(0);
	
	// Generate unique contact ID
	public static String generateUniqueId() {
		// Placeholder string
		String uniqueId;
		if (contactList.isEmpty()) {
			publicId = "1000000001";
		}
		else {
			int arraySize = contactList.size();
			publicId = contactList.get(arraySize - 1).getId();
		}
		// Convert string to int for iteration
		int tempInt = Integer.valueOf(publicId);
		// Increase value by 1
		tempInt += 1;
		// Convert back to string to store
		uniqueId = Integer.toString(tempInt);
		return uniqueId;
	}
	
	// Creating contact object and adding to ArrayList
	public static void addContact(String firstName, String lastName, String phone, String address) {
		String ID = generateUniqueId();
		Contact Contact1 = new Contact(ID, firstName, lastName, phone, address);
		contactList.add(Contact1);
	}
	// add a contact as a whole manually for testing 
	public static void addContact(Contact newContact) {
		String tempId = newContact.getId();
		for (int i = 0; i < contactList.size(); i++) {
			if (tempId.equals(contactList.get(i).getId())) {
				throw new IllegalArgumentException("Contact ID Must Be Unique");
			}
		}
		contactList.add(newContact);
	}
	
	// Update methods
	public static void updateFirstName(String uniqueId, String publicFirstName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
			contactList.get(i).setFirstName(publicFirstName);
			}
		}
	}
	public static void updateLastName(String uniqueId, String publicLastName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
			contactList.get(i).setLastName(publicLastName);
			}
		}
	}
	public static void updatePhoneNum(String uniqueId, String publicPhone) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
			contactList.get(i).setPhone(publicPhone);
			}
		}
	}
	public static void updateAddress(String uniqueId, String publicAddress) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
			contactList.get(i).setAddress(publicAddress);
			}
		}
	}
	// Delete contact
	public static void deleteContact(String uniqueId) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
				int position = i;
				contactList.remove(position);
			}
		}
	}
	// Testing search function
	public static int searchContact(String uniqueId) {
		int result = 0;
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
				result = 1;
			}
			else {
				result = 2;
			}
		}
		return result;
	}
	// Testing index search function
	public static int findIndex(String uniqueId) {
		int result = 0;
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
				result = i;
			}
		}
		return result;
	}
		
}