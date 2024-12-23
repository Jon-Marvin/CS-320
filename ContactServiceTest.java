

package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Service.Contact;
import Service.ContactService;

class ContactServiceTest {


	@Test
	void testContactServiceClass() {
		ContactService.addContact("James", "Smith", "6618886118", 
				"123 Fake St. Encino, CA 91158");
		assertTrue(ContactService.contactList.get(0).getId().equals("1000000002"));
		assertTrue(ContactService.contactList.get(0).getFirstName().equals("James"));
		assertTrue(ContactService.contactList.get(0).getLastName().equals("Smith"));
		assertTrue(ContactService.contactList.get(0).getPhone().equals("6618886118"));
		assertTrue(ContactService.contactList.get(0).getAddress().equals("123 Fake St. Encino, CA 91158"));
	}
	// Confirm deletion of a contact
	@Test
	void testContactServiceDelete() {
		ContactService.addContact("James", "Smith", "6618886118", 
				"123 Fake St. Encino, CA 91158");
		ContactService.deleteContact("1000000003");
		assertTrue(ContactService.searchContact("1000000003") == 2);
	}
	// Update first name
	@Test
	void testContactServiceUpdateFirstName() {
		ContactService.addContact("Jack", "Skellingto", "6618886118", "Halloween Ave.");
		int size = ContactService.contactList.size();
		System.out.println(ContactService.contactList.get(size - 1).getId());
		System.out.println(ContactService.contactList.get(size - 1).getFirstName());
		ContactService.updateFirstName("1000000003", "Mary");
		System.out.println(ContactService.contactList.get(size - 1).getFirstName());
		assertTrue(ContactService.contactList.get(size - 1).getFirstName().equals("Mary"));
	}
	// Update last name
	@Test
	void testContactServiceUpdateLastName() {
		int size = ContactService.contactList.size();
		ContactService.updateLastName("1000000003", "Poppins");
		assertTrue(ContactService.contactList.get(size - 1).getLastName().equals("Poppins"));
	}
	// Update phone number
	@Test
	void testContactServiceUpdatePhone() {
		int target = 0;
		target = ContactService.findIndex("1000000003");
		ContactService.updatePhoneNum("1000000003", "8884446161");
		assertTrue(ContactService.contactList.get(target).getPhone().equals("8884446161"));
	}
	// Update address
	@Test
	void testContactServiceUpdateAddress() {
		int target = 0;
		target = ContactService.findIndex("1000000003");
		ContactService.updateAddress("1000000003", "456 Fake St. Acton, CA 91542");
		assertTrue(ContactService.contactList.get(target).getAddress().equals("456 Fake St. Acton, CA 91542"));
	}
	
	// test to confirm unique ID
	@Test
	void testContactServiceUniqueId() {
		Contact newContact = new Contact("49594", "Smith", "Smithson", "6618886118", "Original Contact Address");
		ContactService.addContact(newContact);
		Contact duplicateId = new Contact("49594", "Smith", "Smithson", "6618886118", "Duplicate Contact Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact(duplicateId);
		});
	}

}