import java.io.BufferedReader;
import java.io.FileReader;

public class ModelCivics extends Model {
   
   public ModelCivics () {
      super(new QuestionCivics [100]);
      readFile("civics.txt");
   }//constructor

   protected void readFile(String path) {
      FileReader theFile;
      BufferedReader inFile;
      
      try {
         theFile = new FileReader(path);
         inFile = new BufferedReader(theFile);
         String oneLine = inFile.readLine();
         int count = 1;
         
         while (oneLine != null) {
            array[count-1] = new QuestionCivics(count, oneLine);
            oneLine = inFile.readLine();
            
            while (oneLine.length() != 0) {
               ((QuestionCivics) (array[count-1])).addAns(oneLine);
               oneLine= inFile.readLine();
               if (oneLine == null) break;
            }//while
            
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
