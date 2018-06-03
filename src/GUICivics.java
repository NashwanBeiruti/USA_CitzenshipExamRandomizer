import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class GUICivics extends GUI{
   JTextPane question, answer;
   JScrollPane spq, spa;
   
   public GUICivics (Model model, Controller control) {
      super(model,control);
      createTopHalf();
      createButtons();
      setVisible(true);
      addKeyListener(control);
   }//constructor
   
   protected void createTopHalf() {
      //Questions and Answers TextPanes
      question = new JTextPane();
      question.setHighlighter(null);
      question.setEditable(false);
      spq = new JScrollPane(question,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      add(spq);
      
      answer = new JTextPane();
      answer.setHighlighter(null);
      answer.setEditable(false);
      spa = new JScrollPane(answer,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      add(spa);
      
      if (model.index < model.array.length) {
         question.setText(model.array[model.index].number + ". " + model.array[model.index].question);
         answer.setText( ((QuestionCivics) model.array[model.index]).answer);
      }//if
      spq.setBounds(150,40,700,40);
      spa.setBounds(150,100,700,425);
   }//createTopHalf
   
   
   public void update() {
      correct_tf.setText(Integer.toString(model.num_correct));
      incorrect_tf.setText(Integer.toString(model.num_incorrect));
      if (model.index < 100) {
         question.setText(model.array[model.index].number + ". " + model.array[model.index].question);
         answer.setText( ((QuestionCivics) model.array[model.index]).answer);
      }//if
      else {
         question.setText("");
         answer.setText("");
      }//else      
   }//update 
   
}//class