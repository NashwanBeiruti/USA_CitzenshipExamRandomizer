import java.io.BufferedReader;
import java.io.FileReader;

public abstract class Model {
   public Question[] array;
   public int index, num_correct, num_incorrect;
   
   public Model (Question[] a) {
      index = num_correct = num_incorrect = 0;
      array = a;
   }//constructor
   
   public void reset() {
      num_correct = num_incorrect = index = 0;
      Shuffle.shuffle(array);
   }//reset
   
   protected void readFile(String path) {
      FileReader theFile;
      BufferedReader inFile;
      
      try {
         theFile = new FileReader(path);
         inFile = new BufferedReader(theFile);
         String oneLine = inFile.readLine();
         int count = 1;
         
         while (oneLine != null) {
            array[count-1] = new Question(count, oneLine);
            oneLine = inFile.readLine();
            count++;
         }//while
         
      }//try
      
      catch (Exception e) {
         System.out.println(e);
      }//catch
      
      Shuffle.shuffle(array);
      
   }//readFile
   
}//class