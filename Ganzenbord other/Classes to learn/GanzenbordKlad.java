import java.util.Scanner;
import java.util.Random;

class Ganzenbord {

   public static void main(String[] args) {

      int position = 0;
      int numDiceEyes = 0;

      // ask user to throw the dice//
      Scanner myObj = new Scanner(System.in); // Create a Scanner object
      System.out.println("You are on start. Throw your dice (t) by hitting enter:");
      String throwDice = myObj.nextLine(); // Read user input
      myObj.close();

      // user does not hit t//
      if (!throwDice.equals("t")) {
         System.out.println("You are on start. Throw your dice (t):");
         throwDice = myObj.nextLine(); // Read user input
      }

      // user hits t//
      if (throwDice.equals("t")) {
         Random random = new Random();
         numDiceEyes = random.nextInt(6);

         // update goose position//
         position = numDiceEyes;

      }

      // all over again
      System.out.println(
            "You threw " + numDiceEyes + " and you are on field " + position + ". No worries. Throw your dice (t)");

   }
}

// Not used

// static int changePosition(int positionParameter, int diceParameter) {
// System.out.println("I just got executed!" + positionParameter);
// if(positionParameter == 10 || positionParameter == 20 || positionParameter ==
// 30 || positionParameter == 40 || positionParameter == 50 || positionParameter
// == 60){
// System.out.println(positionParameter);
// System.out.println(positionParameter + diceParameter);
// }
// return positionParameter + diceParameter;
// }

// Show user his result, position and ask user to throw the dice again//

// System.out.println("You threw " + numDiceEyes + " and you are on field " +
// position + ". No worries. Throw your dice (t) by hitting enter");
// throwDice = myObj.nextLine(); // Read user input

// numDiceEyes = random.nextInt(6) +1;

// position = position + numDiceEyes;

// Show user his result, position and ask user to throw the dice again//

// System.out.println("You threw " + numDiceEyes + " and you are on field " +
// position + ". No worries. Throw your dice (t) by hitting enter");
// throwDice = myObj.nextLine(); // Read user input

// numDiceEyes = random.nextInt(6) +1;

// position = position + numDiceEyes;

// position = 10;
// Show user his result, position and ask user to throw the dice again//
// System.out.println("You threw " + numDiceEyes + " and you are on field " +
// position + ". No worries. Throw your dice (t) by hitting enter");
// if(position == 10 || position == 20 || position == 30 || position == 40 ||
// position == 50 || position == 60){
// System.out.println("You threw " + numDiceEyes + " and you are on field " +
// position + "Bonus steps! You are on field" + (position + numDiceEyes) + "."
// );
// position = position + numDiceEyes;

// }