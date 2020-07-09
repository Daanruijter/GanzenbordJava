import java.util.Scanner;
import java.util.Random;

class Ganzenbord {

  public static void main(String[] args){

    int position = 0;
     int numDiceEyes= 0;

  //ask user to throw the dice//
   Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	System.out.println("You are on start. Throw your dice (t) by hitting enter:");
   String throwDice = myObj.nextLine();  // Read user input

  //user does not hit t//
  if(!throwDice.equals("t")){
    	System.out.println("You are on start. Throw your dice (t):");
      throwDice = myObj.nextLine();  // Read user input
  }

  //user hits t//
  if(throwDice.equals("t")){
  Random random = new Random();
     numDiceEyes = random.nextInt(6);
  
  //update goose position//
  position = numDiceEyes;


 }

 //all over again
   System.out.println("You threw " + numDiceEyes + " and you are on field " + position + ". No worries. Throw your dice (t)");
	
    
    }
}