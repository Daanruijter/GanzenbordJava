import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;



class LoopTester {     

   
     public static void main(String[] args){
     
   
   for(int j=0;j<10;j++){
             System.out.println("Feyenoord" + j);
        for(int i=0;i< 3;i++){
           
             if(i==2 && j==1 || i==2 && j==2){
              
                continue;
             }
                System.out.println("Ajax");     
                       
   
        }
      
   }

     }
}