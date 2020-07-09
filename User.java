import java.util.Scanner;  // Import the Scanner class
import java.util.Random;

class User {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("random");
    System.out.println("Enter username");

    String userName = myObj.nextLine();  // Read user input
    System.out.println("Username is: " + userName);  // Output user input
System.out.println("random");
Random random = new Random();
  
  int a = random.nextInt(6);
  System.out.println("random");

  }
}