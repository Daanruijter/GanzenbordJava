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

   System.out.println("Welcome to the ancient Dutch game of Ganzenbord\n");

   System.out.println("With how many players do you want to play? Enter a number" );
int numPlayers = myObj.nextInt();  // Read user input

    //loop numPlayer times and create player names and or player objects //
   for(int i=0;i<(numPlayers);i++){

        System.out.println(i);

        // MultiPlayerTester player
 

       
         // Read user input
  
      	System.out.println("Enter the name of player " + (i+1));
         
           String playerName = myObj.next();

       
    playersArray.add(playerName);


      System.out.println("We play with " + numPlayers + " players");
      
   }




//trying to implement the multiplayer thing//

   for(int i=0;i<playersArray.size(); i++){   
       


// while(position < 63){
    System.out.println(playersArray.get(i) + ", throw your dice by pressing enter");
     String throwDice = myObj.nextLine();  // Read user input
  Random random = new Random();
     numDiceEyes = random.nextInt(6) +1;
// myObj.next();
     System.out.println(numDiceEyes);

       positionArray.add(numDiceEyes);

          //bridge: go to position 12//
      if (positionArray.get(i)==6){
          System.out.println("Lucky you, " + playersArray.get(i) + "! " + "You are on the bridge and can move on to position 12!");
         positionArray.set(i, 12);
      }
        }
outer:
 for(int j=0;2<63; j++){  
   
   for(int i=0;i<playersArray.size(); i++){   
       System.out.println(positionArray);
       System.out.println(positionArray.get(i));
     
       
  System.out.println(playersArray.get(i) + ", throw your dice by pressing enter"); 




     String throwDice = myObj.nextLine();  // Read user input
  Random random = new Random();
     numDiceEyes = random.nextInt(6) +1;

     System.out.println(playersArray.get(i) + ", you threw " + numDiceEyes + " and you are on field " + (positionArray.get(i) + numDiceEyes) + ". No worries!");

   

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