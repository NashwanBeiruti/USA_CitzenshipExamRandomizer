import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class GUIReadWrite extends GUI {
   JTextPane question;
   JScrollPane spq;
   int num_question;
   boolean reading;
   
   public GUIReadWrite (Model model, Controller control, boolean reading) {
      super(model,control);
      num_question = (reading) ? 37 : 35;
      createTopHalf();
      createButtons();
      setVisible(true);
      addKeyListener(control);
   }//constructor

   protected void createTopHalf() {
      question = new JTextPane();
      question.setHighlighter(null);
      question.setEditable(false);
      spq = new JScrollPane(question,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      add(spq);
      
      if (model.index < model.array.length)
         question.setText(model.array[model.index].number + ". " + model.array[model.index].question);
      
      spq.setBounds(150,300,700,60);
      
   }//createTopHalf

   public void update() {
      correct_tf.setText(Integer.toString(model.num_correct));
      incorrect_tf.setText(Integer.toString(model.num_incorrect));
      if (model.index < num_question)
         question.setText(model.array[model.index].number + ". " + model.array[model.index].question);
      else 
         question.setText("");
      
   }//update
   
}//class