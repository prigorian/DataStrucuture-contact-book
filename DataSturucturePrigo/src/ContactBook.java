import java.util.LinkedList;
import java.util.Scanner;

public class ContactBook {

    private static LinkedList<Contact> contacts = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println("*********************************************");
        System.out.println("(A)dd\n(D)elete\n(E)mail Search\n(P)rint List\n(S)earch\n(Q)uit");
        System.out.println("*********************************************");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Please enter a command: ");
            String command = scanner.next();

            switch (command.toUpperCase()) {
                case "A":
                    addContact(scanner);
                    break;
                case "D":
                    deleteContact(scanner);
                    break;
                case "E":
                    emailSearch(scanner);
                    break;
                case "P":
                    printContacts();
                    break;
                case "S":
                    searchContacts(scanner);
                    break;
                case "Q":
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }

    private static void addContact(Scanner scanner) {
        System.out.print("Please enter the name: ");
        String name = scanner.next();
        System.out.println("Please enter the phone number: ");
        String phone = scanner.next();
        System.out.println("Please enter the email: ");
        String email = scanner.next();

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        System.out.println("Contact added.");
    }

    private static void deleteContact(Scanner scanner) {
        System.out.print("Please enter the name of the contact to delete: ");
        String name = scanner.next();

        boolean removed = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                removed = true;
                System.out.println("Contact removed.");
                break;
            }
        }

        if (!removed) {
            System.out.println("Contact not found.");
        }
    }

    private static void emailSearch(Scanner scanner) {
        System.out.print("Please enter the email to search: ");
        String email = scanner.next();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getEmail().equalsIgnoreCase(email)) {
                System.out.println(contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    private static void printContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private static void searchContacts(Scanner scanner) {
        System.out.print("Please enter the name to search: ");
        String name = scanner.next();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println(contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    private static class Contact {
        private String name;
        private String phone;
        private String email;

        public Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public String toString() {
            return "Contact{name='" + name + "', phone='" + phone + "', email='" + email + "'}";
        }
    }
}