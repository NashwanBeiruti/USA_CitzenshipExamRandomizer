public class ModelReadWrite extends Model{

   public ModelReadWrite (int size, String filename) {
      super(new Question[size]);
      readFile(filename);
   }//constructor
   
}//class