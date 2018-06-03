import java.util.Random;

public class Shuffle {
   
   public static void shuffle (Question [] arr) {
      Random rnd = new Random();
      for (int i= arr.length-1; i>0; i--) {
         int index = rnd.nextInt(i+1);
         
         //swap
         Question a = arr[index];
         arr[index] = arr[i];
         arr[i] = a;
      }//for
   }//shuffle
   
}//class