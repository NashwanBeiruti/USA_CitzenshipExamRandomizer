public class QuestionCivics extends Question {
   String answer;
   int count;
   
   public QuestionCivics (int number, String question) {
      super(number, question);
      answer = "";
   }//constructor
   
   public void addAns (String answer) {
      this.answer += ++count + ". " + answer + "\n";
   }//addAns
   
}//class