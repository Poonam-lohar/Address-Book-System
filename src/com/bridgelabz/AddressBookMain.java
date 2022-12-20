package com.bridgelabz;

import java.io.*;

public class AddressBookMain {

        private static final String FILE_PATH = "C:\\Users\\Suraj\\IdeaProjects\\add\\Practice\\src\\address-book-system-day10\\src\\AddressBookMain.txt";

         public void writeData() {
             try {
                 FileWriter fileWriter = new FileWriter(FILE_PATH);
                 fileWriter.write(String.valueOf(AddressBook.arrayDetails));
                 fileWriter.close();;
             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
         }

         public void readData() {
             try {
                 BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
                 String store;
                 while ((store = reader.readLine()) != null) {
                     System.out.println(store);
                 }
             } catch (IOException exception) {
                 throw new RuntimeException(exception);
             }
         }
}