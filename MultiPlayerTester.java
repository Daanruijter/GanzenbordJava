import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;



class MultiPlayerTester {     

   
            int position;
     int numDiceEyes;
     

public MultiPlayerTester(int position, int numDiceEyes){
this.position = position;
this.numDiceEyes = numDiceEyes;
}

  public static void main(String[] args){


   
        int position = 0;
     int numDiceEyes= 0;
    
    ArrayList <String> playersArray = new ArrayList<String>();
    ArrayList <Integer> positionArray = new ArrayList<Integer>();
   ArrayList <Integer> skipOneTurnArray = new ArrayList<Integer>();
      ArrayList <Integer> skipPlayerArray = new ArrayList<Integer>();

    
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

//initialize skipOneTurnArray
for (int k = 0; k < playersArray.size(); k++) {
  skipOneTurnArray.add(-5);
  skipPlayerArray.add(-5);
  
  }
   System.out.println(skipOneTurnArray);
   System.out.println(skipPlayerArray);

//trying to implement the multiplayer thing//

   for(int i=0;i<playersArray.size(); i++){   
       


// while(position < 63){
    System.out.println(ConsoleColors.RESET + playersArray.get(i) + ", throw your dice by pressing enter\n");
     String throwDice = myObj.nextLine();  // Read user input
  Random random = new Random();
     numDiceEyes = random.nextInt(6) +1;
// myObj.next();
     System.out.println(ConsoleColors.BLUE + "You threw " + numDiceEyes + ", " + playersArray.get(i));

       positionArray.add(numDiceEyes);

          //bridge: go to position 12//
      if (positionArray.get(i)==6){
          System.out.println(ConsoleColors.GREEN + "Lucky you, " + playersArray.get(i) + "! " + "You are on the bridge and can move on to position 12!\n");
         positionArray.set(i, 12);
      }
        }
outer:
 for(int j=0;2<63; j++){  



    System.out.println(ConsoleColors.RED + j + "the value of j");
   
   for(int i=0;i<playersArray.size(); i++){   
       System.out.println(ConsoleColors.RESET + positionArray);
       System.out.println(positionArray.get(i));
     
       
  System.out.println(ConsoleColors.RESET + playersArray.get(i) + ", throw your dice by pressing enter\n"); 




     String throwDice = myObj.nextLine();  // Read user input
  Random random = new Random();
     numDiceEyes = random.nextInt(6) +1;

     System.out.println(ConsoleColors.BLUE + playersArray.get(i) + ", you threw " + numDiceEyes + " and you are on field " + (positionArray.get(i) + numDiceEyes) + ". No worries!\n");


 
          //goose that hit position 19 need to skip one turn
        if (positionArray.get(i)==19) {

           
           //print "skip one turn" if after a player hits 19
           if (positionArray.get(i)==19 && skipOneTurnArray.get(i)==-5){
  System.out.println(ConsoleColors.RED + "Skip one turn, " +  playersArray.get(i));      
           }
           
 
   //if skipOneTurnArray, which holds the turns in which a certain player hit 19, is not yet set for a player, set it to the "turn number" (j)
  if(skipOneTurnArray.get(i)==-5){
         skipPlayerArray.set(i,i);
             skipOneTurnArray.set(i,j);
  }


    System.out.println(skipOneTurnArray);
    System.out.println(skipPlayerArray);

System.out.println((j-skipOneTurnArray.get(i)));






   
         
           
             
            
              }
  System.out.println((j-skipOneTurnArray.get(i))==0);
  System.out.println((j-skipOneTurnArray.get(i))==1);
   

  
     if((j-skipOneTurnArray.get(i))==0 || (j-skipOneTurnArray.get(i))==1 ){
         System.out.println("turn skipper");
       
        continue;
        
     }

   //Reset skipOneTurnArray if a player has skipped his turn
 if (positionArray.get(i)!=19 && skipOneTurnArray.get(i)!=-5){
System.out.println("RESET skipOneTurnArray");
      skipOneTurnArray.set(i, -5);

  }

   
  positionArray.set(i, (positionArray.get(i) + numDiceEyes));



             if(positionArray.get(i)==63){
          System.out.println(ConsoleColors.PURPLE + playersArray.get(i) + ", YOU WON!!!!! Your position is: " + positionArray.get(i) );
        
         break outer;
       }

       
      //goose have throw the right number to get on position 63 and to win
      if(positionArray.get(i)>63){
          System.out.println(ConsoleColors.RED + playersArray.get(i) + ", You threw " + numDiceEyes + " which is " + (positionArray.get(i) - 63) + " too much! Your position is: " + (63 -(positionArray.get(i) - 63)));
          positionArray.set(i,(63 -(positionArray.get(i) - 63)));
       }

           //goose that hit the tens get extra steps, equal to what they threw
     if(positionArray.get(i) == 10 || positionArray.get(i) == 20 || positionArray.get(i) == 30 || positionArray.get(i) == 40 || positionArray.get(i) == 50 || positionArray.get(i) == 60){
            positionArray.set(i, (positionArray.get(i)+numDiceEyes));
            
          System.out.println(ConsoleColors.GREEN + " You threw " + numDiceEyes + ", " + playersArray.get(i) + ", and you are on field " + (positionArray.get(i)-numDiceEyes) + ": Bonus steps! Move on to field " + positionArray.get(i) + "!" );
          
           
       }


      //for goose that needs to breed at position 23, the game is over
      //   if (positionArray.get(i)==23){
             
      //       System.out.println(ConsoleColors.GREEN + "You have to brood eggs, so you can't play anymore!, " +  playersArray.get(i) + " GAME OVER!");          
      //       playersArray.remove(i);
      //       positionArray.remove(i);
      //     }

    //goose that get trapped in a maze at position 42 need to step back 3 positions
        if (positionArray.get(i)==42){
             
            System.out.println(ConsoleColors.RED + "You gut stuck in a maze on position 42! Go back to field 39, " +  playersArray.get(i) + "!");          
            positionArray.set(i, 39);
                      }
    
        //goose that are dead at position 58 need to start over
        if (positionArray.get(i)==58){
             
            System.out.println(ConsoleColors.RED + "You didn't survive a sad deadly accident on position 58, go back to start, " +  playersArray.get(i) + "!");          
            positionArray.set(i, 0);
                      }
   


        }

         
   
   }

  
    }
}