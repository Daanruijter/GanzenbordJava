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
       
       
  System.out.println(playersArray.get(i) + " playername"); 

// while(position < 63){
    System.out.println("throw your dice");
     String throwDice = myObj.next();  // Read user input
  Random random = new Random();
     numDiceEyes = random.nextInt(6) +1;
// myObj.next();
     System.out.println(numDiceEyes);

       positionArray.add(numDiceEyes);
        }
outer:
 for(int j=0;2<63; j++){  
   
   for(int i=0;i<playersArray.size(); i++){   
       System.out.println(positionArray);
       System.out.println(positionArray.get(i));
     
       
  System.out.println(playersArray.get(i) + " throw your dice"); 

      
     String throwDice = myObj.nextLine();  // Read user input
  Random random = new Random();
     numDiceEyes = random.nextInt(6) +1;

     System.out.println(numDiceEyes);

       positionArray.set(i, (positionArray.get(i) + numDiceEyes));

       System.out.println(positionArray.get(i) + "poisiiotnarray");
         if(positionArray.get(i)>63){
          System.out.println(playersArray.get(i) + " , you won!!!!! Your position is: " + positionArray.get(i) );
        
         break outer;
       }


        }

         
   
   }
// }

//     System.out.println("You are on start. Throw your dice (t) by hitting enter:");
//    String throwDice = myObj.nextLine();  // Read user input
   
//         while(position >=0 && position <=68){
  
	

//   Random random = new Random();
//      numDiceEyes = random.nextInt(6) +1;
  
  //update goose position//
    // position = numDiceEyes;
    //    System.out.println("You threw " + numDiceEyes + " and you are on field " + position + ". No worries. Throw your dice (t) by hitting enter");
    //  throwDice = myObj.nextLine();  // Read user input
  

    //    numDiceEyes = random.nextInt(6) +1;
    //    position = position + numDiceEyes;
//    }
  



// System.out.println("playerArray " + playersArray + playersArray.get(1));



 



  //Show user his result, position and ask user to throw the dice again//

//   while(position >=0 && position <=68){

//     if (position > 63 ){
//           System.out.println("You threw " + (position-63) + " too much!");
//        position = (63 - (position - 63)); 

//    System.out.println("You are on field " + position + " Just throw " + (63-position) + " to win!!"); 
//  }


//   System.out.println("You threw " + numDiceEyes + " and you are on field " + position + ". No worries. Throw your dice (t) by hitting enter");
//      throwDice = myObj.nextLine();  // Read user input
  

//        numDiceEyes = random.nextInt(6) +1;
//        position = position + numDiceEyes;
        

//           if (position ==23){
//              position = -1;
//             System.out.println("You are in jail. GAME OVER!");          
//           }

//            if(position == 10 || position == 20 || position == 30 || position == 40 || position == 50 || position == 60){
//           System.out.println("You threw " + numDiceEyes + " and you are on field " + position + "Bonus steps! You are on field" + (position + numDiceEyes) + "." );
//           position = position + numDiceEyes;
           
//        }

//          if (position ==25 || position ==45){
//             position = 0;
//          }
          
//    if (position == 63 ){
//     System.out.println("You won by throwing " + numDiceEyes);
//     break;
//  }

   
     
//   }

  
    }
}