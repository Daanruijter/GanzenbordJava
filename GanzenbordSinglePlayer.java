import java.util.Scanner;
import java.util.Random;

class GanzenbordSinglePlayer {     
   


  public static void main(String[] args){

   
        int position = 0;
     int numDiceEyes= 0;





  //ask user to throw the dice//
   Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	System.out.println("You are on start. Throw your dice (t) by hitting enter:");
   String throwDice = myObj.nextLine();  // Read user input

  Random random = new Random();
     numDiceEyes = random.nextInt(6) +1;
  
  //update goose position//
  position = numDiceEyes;

 



  //Show user his result, position and ask user to throw the dice again//

  while(position >=0 && position <=68){

    if (position > 63 ){
          System.out.println("You threw " + (position-63) + " too much!");
       position = (63 - (position - 63)); 

   System.out.println("You are on field " + position + " Just throw " + (63-position) + " to win!!"); 
 }


  System.out.println("You threw " + numDiceEyes + " and you are on field " + position + ". No worries. Throw your dice (t) by hitting enter");
     throwDice = myObj.nextLine();  // Read user input
  

       numDiceEyes = random.nextInt(6) +1;
       position = position + numDiceEyes;
        

          if (position ==23){
             position = -1;
            System.out.println("You are in jail. GAME OVER!");          
          }

           if(position == 10 || position == 20 || position == 30 || position == 40 || position == 50 || position == 60){
          System.out.println("You threw " + numDiceEyes + " and you are on field " + position + "Bonus steps! You are on field" + (position + numDiceEyes) + "." );
          position = position + numDiceEyes;
           
       }

         if (position ==25 || position ==45){
            position = 0;
         }
          
   if (position == 63 ){
    System.out.println("You won by throwing " + numDiceEyes);
    break;
 }

   
     
  }

  
    }
}