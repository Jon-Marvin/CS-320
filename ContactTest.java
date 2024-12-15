

package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Service.Contact;


class ContactTest {
	
	// Test to ensure contact is created correctly
	@Test
	void testContactCalss() {
		Contact contact = new Contact("1001", "Jim", "Test", "1232343456", 
				"10 Test Street");
		assertTrue(contact.getFirstName().equals("Jim"));
		assertTrue(contact.getLastName().equals("Test"));
		assertTrue(contact.getId().equals("1001"));
		assertTrue(contact.getPhone().equals("1232343456"));
		assertTrue(contact.getAddress().equals("10 Test Street"));
	}
	// Test for contact ID that exceeds requirements
	@Test
	void testContactClassIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10000000000", "Jim", "Test", "1232343456", 
				"10 Test Street");
		});
	}
	// Test for null contact ID
	@Test
	void testContactClassIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Jim", "Test", "1232343456", 
					"10 Test Street");
		});
	}
	// Test for first name that exceeds requirements
	@Test
	void testContactClassFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Jimalimalong", "Test", "1232343456", 
					"10 Test Street");
		});
	}
	// Test for null first name
	@Test
	void testContactClassFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", null, "Test", "1232343456",
					"10 Test Street");
		});
	}
	// Test for last name that exceeds requirements
	@Test
	void testContactClassLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Jim", "Testorabillinfobble", "1232343456", 
					"10 Test Street");
		});
	}
	// Test for null last name
	@Test
	void testContactClassLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Jim", null, "1232343456", 
					"10 Test Street");
		});
	}
	// Test for phone number outside of 10 characters
	@Test
	void testContactClassPhoneNot10() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Jim", "Test", "123234345", 
					"10 Test Street");
		});
	}
	// Test for null phone number
	@Test
	void testContactCalssPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Jim", "Test", null, 
					"10 Test Street");
		});
	}
	// Test for address that exceeds requirements
	@Test
	void testContactClassAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Jim", "Test", "1232343456", 
					"10 Test Street Hamptershire Michigan");
		});
	}
	// Test for null address
	@Test
	void testContactClassAddressnull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Jim", "Test", "1232343456", 
					null);
		});
	}
	// Test first name setter method
	@Test
	void testContactClassSetFirstName() {
		Contact newContact = new Contact("845", "Matt", "Tester", "1232343450", "new address");
		newContact.setFirstName("Jonesy");
		assertTrue(newContact.getFirstName().equals("Jonesy"));
	}
	@Test
	void testContactClassSetFirstNameTooLong() {
		Contact newContact = new Contact("845", "Matt", "Tester", "1232343450", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName("JonesyTooLong");
		});
	}
	@Test
	void testContactClassSetFirstNameNull() {
		Contact newContact = new Contact("845", "Matt", "Tester", "1232343450", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName(null);
		});
	}
	// Test last name setter method
	@Test
	void testContactClassSetLastName() {
		Contact newContact = new Contact("845", "Matt", "Tester", "1232343450", "new address");
		newContact.setLastName("Testerton");
		assertTrue(newContact.getLastName().equals("Testerton"));
	}
	@Test
	void testContactClassSetLastNameTooLong() {
		Contact newContact = new Contact("845", "Matt", "Tester", "1232343450", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName("Testeringtonmcgee");
		});
	}
	@Test
	void testContactClassSetLastNameNull() {
		Contact newContact = new Contact("845", "Matt", "Tester", "1232343450", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName(null);
		});
	}
	// Test phone number setter method
	@Test
	void testContactClassSetPhone() {
		Contact newContact = new Contact("845", "Matt", "Tester", "1232343450", "new address");
		newContact.setPhone("1232343450");
		assertTrue(newContact.getPhone().equals("1232343450"));
	}
	@Test
	void testContactClassSetPhoneTooLong() {
		Contact newContact = new Contact("845", "Matt", "Tester", "1232343450", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone("1232343450000000");
		});
	}
	@Test
	void testContactClassSetPhoneNull() {
		Contact newContact = new Contact("845", "Matt", "Tester", "1232343450", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone(null);
		});
	}
	@Test
	void testContactClassSetPhoneTooShort() {
		Contact newContact = new Contact("845", "Matt", "Tester", "1232343450", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone("123234");
		});
	}
	// Test address setter method
	@Test
	void testContactClassSetAddress() {
		Contact newContact = new Contact("845", "Matt", "Tester", "1232343450", "new address");
		newContact.setAddress("new address 2");
		assertTrue(newContact.getAddress().equals("new address 2"));
	}
	@Test
	void testContactClassSetAddressTooLong() {
		Contact newContact = new Contact("845", "Matt", "Tester", "1232343450", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress("This address is also new because it is a new address");
		});
	}
	@Test
	void testContactClassSetAddressNull() {
		Contact newContact = new Contact("845", "Matt", "Tester", "1232343450", "new address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress(null);
		});
	}
	

}