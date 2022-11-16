package com.bridgelabz;

public class AddressBook {

    public static void main(String[] args) {
        /**
         * create a main method ,all program execute in main method
         * 1st print welcome msg.
         */
            System.out.println("Welcome to Address Book System\n");
            /**
             * We are just calling an object using class name.
             * Simply passing the argument value according to the parameter defined in the constructor.
             */
            Contact details = new Contact("Poonam", "Desai", "Shirol", "Shirol",
                    "Maharashtra", "loharpoonam98@gmail.com", 416103, 7058835985l);
            System.out.println("The following contact details is mentioned below : \n");
            System.out.println("First Name : " + details.getFirstName());
            System.out.println("Last Name  : " + details.getLastName());
            System.out.println("Address    : " + details.getAddress());
            System.out.println("City       : " + details.getCity());
            System.out.println("State      : " + details.getState());
            System.out.println("E-mail     : " + details.getEmail());
            System.out.println("Zip Code   : " + details.getZip());
            System.out.println("Phone No   : " + details.getPhoneNumber());
        }
    }
