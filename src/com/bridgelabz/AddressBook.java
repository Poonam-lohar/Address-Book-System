package com.bridgelabz;

public class AddressBook {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book System\n");

        /**
         * We are just calling an object using class name.
         * Simply passing the argument value according to the parameter defined in the constructor.
         */

        Contacts info = new Contacts("Poonam", "Desai", "Shirol", "Shirol", "Maharashtra", "loharpoonam98@gmail.com", 416103, 7058835985l);
        System.out.println("Firstname: " + info.getFirstName());
        System.out.println("Lastname: " + info.getLastName());
        System.out.println("Address: " + info.getAddress());
        System.out.println("City: " + info.getCity());
        System.out.println("State: " + info.getState());
        System.out.println("Email: " + info.getEmail());
        System.out.println("Zip: " + info.getZip());
        System.out.println("PhoneNumber: " + info.getPhoneNumber());
    }
}
