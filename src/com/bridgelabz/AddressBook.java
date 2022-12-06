package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    /*
    *create arraylist object
    * It implements list interface
     */

    ArrayList<Contacts> arrayDetails = new ArrayList<Contacts>();
    /*
    create scanner class object
     */
    static Scanner sc = new Scanner(System.in);

    public void addDetails() {

        Contacts info = new Contacts();//create object of contact class as info

        System.out.print("Enter the first name: ");
        info.setFirstName(sc.nextLine());
        System.out.print("Enter the last name: ");
        info.setLastName(sc.nextLine());
        System.out.print("Enter the address: ");
        info.setAddress(sc.nextLine());
        System.out.print("Enter the city: ");
        info.setCity(sc.nextLine());
        System.out.print("Enter the state: ");
        info.setState(sc.nextLine());
        System.out.print("Enter the email: ");
        info.setEmail(sc.nextLine());
        System.out.print("Enter the zip code: ");
        info.setZip(sc.nextInt());
        System.out.print("Enter the phone number: ");
        info.setPhoneNumber(sc.nextLong());
        arrayDetails.add(info);
    }

    public void display() {
        System.out.println(arrayDetails);
    }

    public void editDetails() {
        System.out.println("Confirm first name to edit details: ");
        String confirmName = sc.next();
        for (int i = 0; i < arrayDetails.size(); i++) {
            if (arrayDetails.get(i).getFirstName().equals(confirmName)) {

                System.out.println("\n1.First Name\n2.last Name\n3.Address\n4.city\n5state\n6.Email\n7.Zip code\n8.Phone number");

                int edit = sc.nextInt();
                switch (edit) {
                    case 1:
                        System.out.println("Enter First name: ");
                        arrayDetails.get(i).setFirstName(sc.next());
                        break;
                    case 2:
                        System.out.println("Enter last name: ");
                        arrayDetails.get(i).setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter Address: ");
                        arrayDetails.get(i).setAddress(sc.next());
                        break;
                    case 4:
                        System.out.println("Enter City : ");
                        arrayDetails.get(i).setCity(sc.next());
                        break;

                    case 5:
                        System.out.println("Enter State: ");
                        arrayDetails.get(i).setState(sc.next());
                        break;

                    case 6:
                        System.out.println("Enter Email: ");
                        arrayDetails.get(i).setEmail(sc.next());
                        break;

                    case 7:
                        System.out.println("Enter Zip: ");
                        arrayDetails.get(i).setZip(sc.nextInt());
                        break;
                    case 8:
                        System.out.println("Enter Phone Number: ");
                        arrayDetails.get(i).setPhoneNumber(sc.nextInt());
                        break;
                }
                System.out.println("Edited list is: ");
                System.out.println(arrayDetails);
            } else
                System.out.println("Enter valid first name: ");
        }
    }

    public void deleteDetails() {

        System.out.println("Confirm the first name to delete contacts: ");

        String ConfirmName = sc.next();
        for (int i = 0; i < arrayDetails.size(); i++) {
            if (arrayDetails.get(i).getFirstName().equals(ConfirmName)) {
                arrayDetails.remove(i);
                System.out.println("Contact Deleted Successfully.....");
                System.out.println("List after removing details: " + arrayDetails);
            } else {
                System.out.println("Enter valid first name: ");
            }
        }
    }

    public static void main(String[] args) {


        AddressBook details = new AddressBook();//object create
        /*
        declare variable
         */
        int input, ans;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Welcome to Address Book Program");
            System.out.println("What do you want to do: ");

            System.out.println("1.Add Details.\n2.Edit Details.\n3.Delete contact\n4.Display\n5.Exit");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    details.addDetails();
                    break;
                case 2:
                    details.editDetails();
                    break;
                case 3:
                    details.deleteDetails();
                    break;
                case 4:
                    details.display();
                case 5:
                    System.out.println("Thank You We are Exiting");
                    return;
                default:
                    System.out.println("Invalid");
                    break;
            }
            System.out.println("Do you want to continue?(0/1)");
            ans = sc.nextInt();
        } while (ans == 1);
    }
}

