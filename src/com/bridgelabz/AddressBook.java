package com.bridgelabz;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddressBook {
    /*
     *create arraylist object
     * It implements list interface
     */

    static ArrayList<Contacts> arrayDetails = new ArrayList<Contacts>();
    /*
    create scanner class object
     */
    static Scanner sc = new Scanner(System.in);

    static HashMap<String, ArrayList> hashmap = new HashMap<>();
    static AddressBook details = new AddressBook();
    ArrayList<Contacts> new_address_book = new ArrayList<>();
    private Contacts newPerson;

    /*
    Method to add details in contacts
     */

    public void addDetails() {

        Contacts info = new Contacts();//create object of contact class as info

        System.out.print("Enter the first name: ");
        info.setFirstName(sc.next());
        System.out.print("Enter the last name: ");
        info.setLastName(sc.next());
        System.out.print("Enter the address: ");
        info.setAddress(sc.next());
        System.out.print("Enter the city: ");
        info.setCity(sc.next());
        System.out.print("Enter the state: ");
        info.setState(sc.next());
        System.out.print("Enter the email: ");
        info.setEmail(sc.next());
        System.out.print("Enter the zip code: ");
        info.setZip(sc.nextInt());
        System.out.print("Enter the phone number: ");
        info.setPhoneNumber(sc.nextLong());
        arrayDetails.add(info);
        //System.out.println(arrayDetails);
    }

    public void display() {
        System.out.println(arrayDetails);

    }
    /*
    method to edit contact list.
     */

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
     /*
     Method to delete contact from address book.
     */

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

    /**
     * Method to check for duplicate entry before adding the person.
     */

    public void duplicateCheck( String firstName) {
        /**
         * for loop is used check the condition if condition is true
         * then element at the specified position in this list in arrayDetails all store in contactName
     */

        for (int k = 0; k < arrayDetails.size(); k++) {
            String contactName = arrayDetails.get(k).getFirstName();

            if (firstName.equals(contactName)) {
                System.out.println("This Person is Already Present");
            } else {
                System.out.println("You can Add this Person");
                break;
            }
        }
    }

    /*
    Method to search person by city name.
     */
    public List<Contacts> searchByCity(String cityName) {
         return arrayDetails.stream().filter(person -> person.getCity().equalsIgnoreCase(cityName)).collect(Collectors.toList());
    }

    /*
    Method to search person by state name.
     */
    public List<Contacts> searchByState(String stateName) {
        return arrayDetails.stream().filter(person -> person.getState().equalsIgnoreCase(stateName)).collect(Collectors.toList());
    }

    public static List<Contacts> sortBy(Function<? super Contacts, ? extends String> key) {
        return arrayDetails.stream().sorted(Comparator.comparing(key)).collect(Collectors.toList());
    }

    public  List<Contacts> sortByZip(Function<? super Contacts, ? extends Long> key) {
        return arrayDetails.stream().sorted(Comparator.comparing(key)).collect(Collectors.toList());
    }


    public void searchPerson() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select options: 1.By City 2.By State");
        int select = scanner.nextInt();
        //sc.nextLine();
        switch (select) {
            case 1:
                System.out.println("Enter City Name: ");
                String cityName = scanner.next();
                arrayDetails.forEach(book -> searchByCity(cityName).forEach(System.out::println));
                break;
            case 2:
                System.out.println("Enter State Name: ");
                String stateName = scanner.next();
                arrayDetails.forEach(book -> searchByState(stateName).forEach(System.out::println));
        }
    }

    public void countByOption() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Count city\n2.Count by State\n3.Back");
        System.out.println("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter city name: ");
                String cityName = sc.next();
                Map<String,Long> countCity = arrayDetails.stream().collect(Collectors.groupingBy(e -> e.getCity(),Collectors.counting()));
                System.out.println(countCity + "\n");
                break;
            case 2:
                System.out.println("Enter state name: " );
                String stateName = sc.next();
                Map<String,Long> countState = arrayDetails.stream().collect(Collectors.groupingBy(e -> e.getState(),Collectors.counting()));
                System.out.println(countState + "\n");
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid Option");

        }
    }

    public static void sortByFirstName() {
        /**
         * display this options
         */
        System.out.println("1. By first name");
        System.out.println("2. By last name");
        System.out.println("3. By city");
        System.out.println("4. By state");
        System.out.println("5. By zip");
        System.out.println("6. Back");

        /**
         * choose the option what u want
         */
        System.out.print("Your choice: ");

        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                AddressBook.sortBy(Contacts::getFirstName).forEach(System.out::println);
                break;
            case 2:
                AddressBook.sortBy(Contacts::getLastName).forEach(System.out::println);
                break;
            case 3:
                AddressBook.sortBy(Contacts::getCity).forEach(System.out::println);
                break;
            case 4:
                AddressBook.sortBy(Contacts::getState).forEach(System.out::println);
                break;
            case 5:
                return;
            default:
                System.out.println("INVALID CHOICE!");
        }
    }

    public void createAddressBook() {
        System.out.println("Enter name of address book:");
        String Address_Book_name = sc.next();
        arrayDetails = new_address_book;
        while (true) {
            System.out.println("What do you want to do: ");

            System.out.println("1.Add Details.\n2.Edit Details.\n3.Delete contact\n4.Check Duplicate entry\n5.Search person \n6.Count by option.\n7.Sort by\n8.Display\n9.Create address book\n10.Exit");

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
                    System.out.println("Enter first name to check duplicate: ");
                    String name = sc.next();
                   details.duplicateCheck(name);
                   break;
                case 5:
                    details.searchPerson();
                    break;
                case 6:
                    details.countByOption();
                    break;
                case 7:
                    details.sortByFirstName();
                    break;
                case 8:
                    details.display();
                    break;
                case 9:
                    details.createAddressBook();
                    break;
                case 10:
                    System.out.println("Thank You We are Exiting");
                    return;
                default:
                    System.out.println("Invalid");
                    break;
            }
            hashmap.put(Address_Book_name, arrayDetails);
            System.out.println(hashmap);
        }
    }


    public static void main(String[] args) {

        System.out.println("Welcome To Address Book Program....");
        details.createAddressBook();
    }
}
