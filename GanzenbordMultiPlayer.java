import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class GanzenbordMultiPlayer {

   int position;
   int numDiceEyes;

   public GanzenbordMultiPlayer(int position, int numDiceEyes) {
      this.position = position;
      this.numDiceEyes = numDiceEyes;
   }

   public static void main(String[] args) {

      int numDiceEyes = 0;

      ArrayList<String> playersArray = new ArrayList<String>();
      ArrayList<Integer> positionArray = new ArrayList<Integer>();
      ArrayList<Integer> skipOneTurnArray = new ArrayList<Integer>();
      ArrayList<Integer> skipThreeTurnsArray = new ArrayList<Integer>();
      ArrayList<Integer> skipPlayerArray = new ArrayList<Integer>();
      ArrayList<Integer> wellArray = new ArrayList<Integer>();
      ArrayList<Boolean> wellBooleanArray = new ArrayList<Boolean>();

      // ask user to throw the dice//
      Scanner myObj = new Scanner(System.in); // Create a Scanner object

      System.out.println(ConsoleColors.RED + "Welcome to the ancient Dutch game of Ganzenbord\n");

      System.out.println(ConsoleColors.RESET + "With how many players do you want to play? Enter a number\n");
      int numPlayers = myObj.nextInt(); // Read user input

      // loop numPlayer times and create player names and or player objects //
      for (int i = 0; i < (numPlayers); i++) {

         // MultiPlayerTester player

         // Read user input

         System.out.println("Enter the name of player " + (i + 1) + "\n");

         String playerName = myObj.next();

         playersArray.add(playerName);

      }

      // initialize skipOneTurnArray and skipThreeTurnsArray
      for (int k = 0; k < playersArray.size(); k++) {
         skipOneTurnArray.add(-5);
         skipPlayerArray.add(-5);
         skipThreeTurnsArray.add(-5);
         wellBooleanArray.add(false);

      }

      // STARTING THE GAME WITH A LOOP THAT POPULATES PLAYERSARRAY

      for (int i = 0; i < playersArray.size(); i++) {

         System.out.println(ConsoleColors.RESET + playersArray.get(i) + ", throw your dice by pressing enter\n");
         myObj.nextLine(); // Read user input
         Random random = new Random();
         numDiceEyes = random.nextInt(6) + 1;

         System.out.println(ConsoleColors.BLUE + playersArray.get(i) + ", you threw " + numDiceEyes
               + " and you are on field " + numDiceEyes + "\n");

         positionArray.add(numDiceEyes);

         // bridge: go to position 12//
         if (positionArray.get(i) == 6) {
            System.out.println(ConsoleColors.GREEN + "Lucky you, " + playersArray.get(i) + "! "
                  + "You are on the bridge and can move on to position 12!\n");
            positionArray.set(i, 12);
         }
      }

      // STARTING THE REST OF THE GAME: THE SECOND TURN FOR EACH PLAYER
      // The outer loop has to run all the time, so the condition is always true
      // The inner loop switches between the "playersarray.size()" number of players
      // and if a player is on position 63 the loop breaks, because there is a winner

      outer: for (int j = 0; 2 < 63; j++) {

         for (int i = 0; i < playersArray.size(); i++) {

            // only print this when a player does not need to skip a turn//
            if (positionArray.get(i) != 19 && positionArray.get(i) != 31 && positionArray.get(i) != 52) {
               System.out.println(ConsoleColors.RESET + playersArray.get(i) + ", throw your dice by pressing enter\n");

            }

            // THROW THE DICE
            myObj.nextLine(); // Read user input
            Random random = new Random();
            numDiceEyes = random.nextInt(6) + 1;

            // only print this when a player does not need to skip a turn//
            if (positionArray.get(i) != 19 && positionArray.get(i) != 31 && positionArray.get(i) != 52) {
               System.out.println(ConsoleColors.BLUE + playersArray.get(i) + ", you threw " + numDiceEyes
                     + " and you are on field " + (positionArray.get(i) + numDiceEyes) + ". No worries!\n");
            }

            // SKIP ONE TURN
            // goose that hit position 19 need to skip one turn
            if (positionArray.get(i) == 19) {

               // print "skip one turn" if after a player hits 19
               if (positionArray.get(i) == 19 && skipOneTurnArray.get(i) == -5) {
                  System.out.println(ConsoleColors.RED + "Skip one turn, " + playersArray.get(i) + "\n");
               }

               // if skipOneTurnArray, which holds the turn in which a certain player hits 19,
               // is not yet set for a player, set it to the "turn number" (j)
               if (skipOneTurnArray.get(i) == -5) {
                  skipPlayerArray.set(i, i);
                  skipOneTurnArray.set(i, j);
               }

            }

            // if a player hits 19, skip his next turn by calling continue;,
            // which skips the iteration for player i if the difference between the turn j
            // when he hit 19 and the actual turn j is 0

            if ((j - skipOneTurnArray.get(i)) == 0) {

               continue;

            }

            // Reset skipOneTurnArray if a player has skipped his turn
            if (positionArray.get(i) != 19 && skipOneTurnArray.get(i) != -5) {

               skipOneTurnArray.set(i, -5);

            }

            // JAIL: SKIP THREE TURNS
            // A goose that hits the jail on position 52 needs to skip three turns

            if (positionArray.get(i) == 52) {

               // print "skip three turns" after a player hits 52
               if (positionArray.get(i) == 52 && skipThreeTurnsArray.get(i) == -5) {
                  System.out.println(ConsoleColors.RED + "You are in jail, skip three turns, " + playersArray.get(i));
               }

               // if skipThreeTurnsArray, which holds the turn in which a certain player hits
               // 52,
               // is not yet set for a player, set it to the "turn number" (j)
               if (skipThreeTurnsArray.get(i) == -5) {
                  skipThreeTurnsArray.set(i, j);

               }

               // if a player hits 52, skip his next turn by calling continue;,
               // which skips the iteration for player i if the difference between the turn j
               // when he hit 19 and the actual turn j is 0, 1 or 2,

               if ((j - skipThreeTurnsArray.get(i)) == 0 || (j - skipThreeTurnsArray.get(i)) == 1
                     || (j - skipThreeTurnsArray.get(i)) == 2) {

                  continue;

               }
               // Reset skipOneTurnArray if a player has skipped his turn
               if (positionArray.get(i) != 52 && skipThreeTurnsArray.get(i) != -5
                     && (j - skipThreeTurnsArray.get(i)) > 2) {

                  skipThreeTurnsArray.set(i, -5);

               }
            }

            if (wellBooleanArray.get(i) == false) {
               positionArray.set(i, (positionArray.get(i) + numDiceEyes));
            }

            // PLAYER WINS
            if (positionArray.get(i) == 63) {
               System.out.println(ConsoleColors.PURPLE + playersArray.get(i) + ", YOU WON!!!!! Your position is: "
                     + positionArray.get(i) + "\n");

               break outer;
            }

            // PUSH A PLAYER BACK IF HIS/HER POSITION IS GREATER THEN 63
            // goose have throw the right number to get on position 63 and to win
            if (positionArray.get(i) > 63) {
               System.out.println(ConsoleColors.RED + playersArray.get(i) + ", You threw " + numDiceEyes + ", which is "
                     + (positionArray.get(i) - 63) + " too much! Your position is: "
                     + (63 - (positionArray.get(i) - 63)) + "\n");
               positionArray.set(i, (63 - (positionArray.get(i) - 63)));
            }

            // BONUS STEPS
            // goose that hit the tens get extra steps, equal to what they threw
            if (positionArray.get(i) == 10 || positionArray.get(i) == 20 || positionArray.get(i) == 30
                  || positionArray.get(i) == 40 || positionArray.get(i) == 50 || positionArray.get(i) == 60) {
               positionArray.set(i, (positionArray.get(i) + numDiceEyes));

               if ((positionArray.get(i)) < 64) {
                  System.out.println(ConsoleColors.GREEN + " You threw " + numDiceEyes + ", " + playersArray.get(i)
                        + ", and you are on field " + (positionArray.get(i) - numDiceEyes)
                        + ": Bonus steps! Move on to field " + positionArray.get(i) + "!\n");

                  // PLAYER WINS
                  if (positionArray.get(i) == 63) {
                     System.out.println(ConsoleColors.PURPLE + playersArray.get(i) + ", YOU WON!!!!! Your position is: "
                           + positionArray.get(i) + "\n");

                     break outer;
                  }
               } else {
                  System.out.println(ConsoleColors.GREEN + " You threw " + numDiceEyes + ", " + playersArray.get(i)
                        + ", and you are on field " + (positionArray.get(i) - numDiceEyes)
                        + ": Bonus steps! Move on to field " + positionArray.get(i)
                        + ", which does not exist! Therefore move " + (positionArray.get(i) - 63)
                        + " back from position 63, bringing you on position " + (63 - (positionArray.get(i) - 63))
                        + "!\n");
                  positionArray.set(i, (63 - (positionArray.get(i) - 63)));

               }

            }

            // WELL
            // goose that get trapped in a well have to wait till another goose redeems him
            if (positionArray.get(i) == 31) {
               System.out.println(ConsoleColors.RED + playersArray.get(i)
                     + ", you are stuck in a well. Wait until another player redeems you!\n");
               wellBooleanArray.set(i, true);
               wellArray.add(i);

               int trueCount = 0;
               for (int l = 0; l < wellBooleanArray.size(); l++) {
                  if (wellBooleanArray.get(l)) {
                     trueCount++;
                  }
               }

               if (trueCount == 2) {
                  wellBooleanArray.set(wellArray.get(0), false);
                  wellArray.clear();
                  wellArray.add(i);

               }
            }

            // MAZE
            // goose that get trapped in a maze at position 42 need to step back 3 positions
            if (positionArray.get(i) == 42) {

               System.out.println(ConsoleColors.RED + "You gut stuck in a maze on position 42! Go back to field 39, "
                     + playersArray.get(i) + "!\n");
               positionArray.set(i, 39);
            }

            // BREEDING
            // for goose that needs to breed at position 23, the game is over

            if (positionArray.get(i) == 58) {

               System.out.println(ConsoleColors.RED + "You have to brood eggs, which takes time, so go back to start!, "
                     + playersArray.get(i) + "!\n");
               positionArray.set(i, 0);
            }

            // DEAD
            // goose that are dead at position 58 need to start over

            if (positionArray.get(i) == 23) {
               System.out.println(ConsoleColors.RED + "You didn't survive a sad deadly accident on position 58, "
                     + playersArray.get(i) + ", GAME OVER!\n");

               playersArray.remove(i);
               positionArray.remove(i);
               skipOneTurnArray.remove(i);
               skipThreeTurnsArray.remove(i);
               wellBooleanArray.remove(i);
            }
         }
         if (playersArray.size() == 0) {
            System.out.println("Unfortunately there is no winner! Start the game over to decide a winner!");

            break;
         }

      }
      myObj.close();
   }
}
