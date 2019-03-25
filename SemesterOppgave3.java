import java.util.UUID;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class SemesterOppgave3 {
 public static void main(String[] args) {

   ArrayList < Parcel > registeredParcels = new ArrayList < Parcel > ();
   Scanner sc = new Scanner(System.in);
   boolean done = false;
   while (!done) {
    System.out.printf("Enter command (%d parcel(s) registered)" + "%nr: register parcel" +
     "%np: print parcels to display" +
     "%nw: write parcels to file" +
     "%nc: clear parcel queue" +
     "%nq: quit%n> ", registeredParcels.size());

    String command = sc.next();
    if (command.equals("r")) {
     Parcel p = registerParcel();
     registeredParcels.add(p);
 
    } else if (command.equals("p")) {
     for (Parcel p: registeredParcels) {
      System.out.println(p);
     }

    } else if (command.equals("w")) {
     System.out.println("Provide file path for writing: ");
     sc.nextLine(); // flush
     String path = sc.nextLine();
     boolean append = false;

     try {
      FileWriter file = new FileWriter(path, append);
      PrintWriter write = new PrintWriter(file);

      for (Parcel p: registeredParcels) {
       write.println(p);
       write.close();
      }
      
      System.out.println("File saved. ");
      
     } catch (IOException e) {
      System.out.println("This should never actually happen.");
     }

    } else if (command.equals("c")) {
     System.out.println("You are about to delete all " + registeredParcels.size() + " parcels. Press Enter to continue or x to cancel.");
     sc.nextLine(); // flush
     String input = sc.nextLine();
     if (input.equals("x")) {
      continue;
     }
     registeredParcels = new ArrayList < Parcel > ();
     System.out.println("Local storage cleared.");


    } else if (command.equals("q")) {
     System.out.println("[Quitting]");
     done = true;
    } else {
     System.out.println("[Unknown command]");
    }
   }
  } // end main


 public static class Address {
  private String street;
  private int streetNumber;
  private int postCode;
  private String town;
  private String country;

  public Address(String street, int streetNumber, int postCode, String town, String country) {
   this.street = street;
   this.streetNumber = streetNumber;
   this.postCode = postCode;
   this.town = town;
   this.country = country;
  }

  public String toString() {
   String toString = street + " " + streetNumber + "\n" + postCode + ", " + town + "\n" + country;
   return toString;
  }
 } // end Address

 public static class Person {
  private String name;
  private Address address;

  public Person(String name, Address address) {
   this.name = name;
   this.address = address;
  }

  public String toString() {
   String toString = name + "\n" + address;
   return toString;
  }
 } // end Person

 public static class Parcel {
  private Person sender;
  private Person recipient;
  private UUID barcode;

  public Parcel(Person sender, Person recipient) {
   this.sender = sender;
   this.recipient = recipient;
   barcode = UUID.randomUUID();
  }

  public String toString() {
   String toString = "Barcode: " + barcode + "\n" + "Sender: " + sender + "\n" + "Recipient: " + recipient;
   return toString;
  }
 } // end Parcel

 public static Parcel registerParcel() {

  Scanner sc = new Scanner(System.in);
  System.out.println("Enter the details of the sender. \nName: ");
  String name = sc.nextLine();
  System.out.println("Street: ");
  String street = sc.nextLine();

  System.out.println("Street number: ");
  int streetNumber = 0;
  Scanner sc2 = new Scanner(System.in);

  boolean valid = false;
  while (!valid) {
   try {
    streetNumber = sc2.nextInt();
    valid = true;
   } catch (Exception e) {
    sc2.nextLine(); // flush
    System.out.print("Give me integers!");
   }
  }

  System.out.println("Postal code: ");
  int postCode = 0;

  valid = false;
  while (!valid) {
   try {
    postCode = sc2.nextInt();
    valid = true;
   } catch (Exception e) {
    sc2.nextLine(); // flush
    System.out.print("Why did you do this? You knew this would happen. ");
   }
  }

  System.out.println("Town: ");
  String town = sc.nextLine();
  System.out.println("Country: ");
  String country = sc.nextLine();

  Address addressSender = new Address(street, streetNumber, postCode, town, country);
  Person sender = new Person(name, addressSender);

  System.out.println("Enter the details of the receiver. \nName: ");
  name = sc.nextLine();
  System.out.println("Street: ");
  street = sc.nextLine();

  System.out.println("Street number: ");

  valid = false;
  while (!valid) {
   try {
    streetNumber = sc2.nextInt();
    valid = true;
   } catch (Exception e) {
    sc2.nextLine(); // flush
    System.out.print("Give me integers!");
   }
  }

  System.out.println("Postal code: ");

  valid = false;
  while (!valid) {
   try {
    postCode = sc2.nextInt();
    valid = true;
   } catch (Exception e) {
    sc2.nextLine(); // flush
    System.out.print("Why did you do this? You knew this would happen. ");
   }
  }

  System.out.println("Town: ");
  town = sc.nextLine();
  System.out.println("Country: ");
  country = sc.nextLine();

  Address addressReceiver = new Address(street, streetNumber, postCode, town, country);
  Person receiver = new Person(name, addressReceiver);
  Parcel parcel = new Parcel(sender, receiver);
  return parcel;
 }
}