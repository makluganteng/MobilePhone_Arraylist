package academy.learnprogramming;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Mobile_Phone mobilePhone = new Mobile_Phone(11-22-33-44-55);
    public static void main(String[] args) {
	// write your code here
        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("Choose between 0 to 6:\n");
            int choose = scanner.nextInt();
            scanner.nextLine();

            switch(choose){
                case 0:
                    quit = true;
                case 1:
                    mobilePhone.printContact();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    query();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    public static void startPhone(){
        System.out.println("Starting phone...");

    }

    private static void printActions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shutdown\n" + "1 - to print contacts\n" + "2 - to add a new contact\n" + "3 - to update existing an existing contact\n" + "4 - to remove an existing contact\n" + "5 - query if an existing contact exists\n" + "6 - to print a list of available actions.");

    }

    public static void addContact(){
        System.out.println("Enter Contact Name and number: ");
        String name = scanner.nextLine();
        System.out.println("Enter Contact Number: ");
        String phoneNumber = scanner.nextLine();
        Contacts contact = Contacts.createContact(name, phoneNumber);
        mobilePhone.addNewContact(contact);
    }

    public static void updateContact(){
        System.out.println("Enter old contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new Phone number: ");
        String newNumber = scanner.nextLine();
        Contacts contact = Contacts.createContact(newName,newNumber);
        if(mobilePhone.updateContact(existingContactRecord, contact)){
            System.out.println("Successfully updated record.");
        }
        else{
            System.out.println("error updating record.");
        }
    }

    public static void deleteContact(){
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        Contacts findContact = mobilePhone.queryContact(name);
        if(findContact == null){
            System.out.println("Contact not found");
            return;
        }
        mobilePhone.removeContact(findContact);
    }

    public static void query(){
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        Contacts contacts = mobilePhone.queryContact(name);
        if(contacts == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.println(name + "is found");
    }


}
