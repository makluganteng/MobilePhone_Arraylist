package academy.learnprogramming;

import java.util.ArrayList;

public class Mobile_Phone {
    private ArrayList<Contacts> myContact ;
    private int number;

    public Mobile_Phone(int number) {
        this.myContact = new ArrayList<Contacts>();
        this.number = number;
    }

    public void printContact(){
        System.out.println("You have " + myContact.size() + " contact in your phone");
        for(int i=0;i<myContact.size();i++){
            System.out.println((i+1) + ". " + myContact.get(i).getName() + " --> " + myContact.get(i).getPhoneNumber());
        }
    }

    public boolean addNewContact(Contacts contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact is found");
            return false;
        }
        myContact.add(contact);
        return true;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition<0){
            System.out.println(oldContact.getName() + " not found");
            return false;
        }
        myContact.set(foundPosition,newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contacts contact){
        int foundPosition = findContact(contact);
        if(foundPosition<0){
            System.out.println(contact.getName() + " not found");
            return false;
        }
        myContact.remove(contact);
        System.out.println(contact.getName() + ", was deleted");
        return true;
    }


    private int findContact(String contactName){
        for(int i =0; i<myContact.size();i++){
            Contacts contact = myContact.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contacts contact){
        if(findContact(contact) > 0){
            return contact.getName();
        }
        return null;
    }

    public Contacts queryContact(String name){
        int position = findContact(name);
        if(position >= 0){
            return myContact.get(position);
        }
        return null;
    }

    private int findContact(Contacts contact){
        return myContact.indexOf(contact);
    }
}
