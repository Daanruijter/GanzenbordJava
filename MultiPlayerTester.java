import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;



class MultiPlayerTester {     

   
            int position;
     int numDiceEyes;
    // ArrayList <String> playersArray = new ArrayList<String>();

public MultiPlayerTester(int position, int numDiceEyes){
this.position = position;
this.numDiceEyes = numDiceEyes;
}

  public static void main(String[] args){


   
        int position = 0;
     int numDiceEyes= 0;
    ArrayList <String> playersArray = new ArrayList<String>();
    ArrayList <Integer> positionArray = new ArrayList<Integer>();


    
  //ask user to throw the dice//
   Scanner myObj = new Scanner(System.in);  // Create a Scanner object


   System.out.println(ConsoleColors.RED + "Welcome to the ancient Dutch game of Ganzenbord\n");
   

   System.out.println(ConsoleColors.RESET + "With how many players do you want to play? Enter a number\n" );
int numPlayers = myObj.nextInt();  // Read user input

    //loop numPlayer times and create player names and or player objects //
   for(int i=0;i<(numPlayers);i++){

      

        // MultiPlayerTester player
 

       
         // Read user input
  
      	System.out.println("Enter the name of player " + (i+1)+"\n");
         
           String playerName = myObj.next();

       
    playersArray.add(playerName);

      
   }




//trying to implement the multiplayer thing//

   for(int i=0;i<playersArray.size(); i++){   
       


// while(position < 63){
    System.out.println(ConsoleColors.RESET + playersArray.get(i) + ", throw your dice by pressing enter\n");
     String throwDice = myObj.nextLine();  // Read user input
  Random random = new Random();
     numDiceEyes = random.nextInt(6) +1;
// myObj.next();
     System.out.println(ConsoleColors.BLUE + "You threw " + numDiceEyes + playersArray.get(i));

       positionArray.add(numDiceEyes);

          //bridge: go to position 12//
      if (positionArray.get(i)==6){
          System.out.println(ConsoleColors.RESET + "Lucky you, " + playersArray.get(i) + "! " + "You are on the bridge and can move on to position 12!\n");
         positionArray.set(i, 12);
      }
        }
outer:
 for(int j=0;2<63; j++){  
   
   for(int i=0;i<playersArray.size(); i++){   
       System.out.println(ConsoleColors.RESET + positionArray);
       System.out.println(positionArray.get(i));
     
       
  System.out.println(ConsoleColors.RESET + playersArray.get(i) + ", throw your dice by pressing enter\n"); 




     String throwDice = myObj.nextLine();  // Read user input
  Random random = new Random();
     numDiceEyes = random.nextInt(6) +1;

     System.out.println(ConsoleColors.BLUE + playersArray.get(i) + ", you threw " + numDiceEyes + " and you are on field " + (positionArray.get(i) + numDiceEyes) + ". No worries!\n");

   

      //update position of player i
       positionArray.set(i, (positionArray.get(i) + numDiceEyes));


      



      //for goose that needs to breed, the game is over
        if (positionArray.get(i)==23){
             
            System.out.println("You have to brood eggs, so you can't play anymore!, " +  playersArray.get(i) + " GAME OVER!");          
            playersArray.remove(i);
            positionArray.remove(i);
          }


    
         if(positionArray.get(i)>63){
          System.out.println(playersArray.get(i) + ", you won!!!!! Your position is: " + positionArray.get(i) );
        
         break outer;
       }


        }

         
   
   }

  
    }
}