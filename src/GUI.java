import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class GUI extends JPanel{
   Model model;
   Controller control;
   JTextField correct_tf, incorrect_tf;
   JButton correct, incorrect;
   
   public GUI (Model model, Controller control) {
      this.model = model;
      this.control = control;
      setSize(1000, 725);
      setLayout(null);
      setBackground(Color.white);
      addKeyListener(control);
   }//constructor
   
   protected abstract void createTopHalf();
   
   protected void createButtons() {
      
      //TextFields
      Font font = new Font("TimesRoman", Font.BOLD, 20);
      correct_tf = new JTextField();
      correct_tf.setHighlighter(null);
      correct_tf.setEditable(false);
      correct_tf.setHorizontalAlignment(JTextField.CENTER);
      correct_tf.setFont(font);
      correct_tf.setBackground(Color.white);
      add(correct_tf);
      correct_tf.setBounds(325, 555, 50, 30);
      correct_tf.setText(Integer.toString(model.num_correct));
      
      incorrect_tf = new JTextField();
      incorrect_tf.setHighlighter(null);
      incorrect_tf.setEditable(false);
      incorrect_tf.setHorizontalAlignment(JTextField.CENTER);
      incorrect_tf.setFont(font);
      incorrect_tf.setBackground(Color.white);
      add(incorrect_tf);
      incorrect_tf.setBounds(625, 555, 50, 30);
      incorrect_tf.setText(Integer.toString(model.num_incorrect));
      
      //Buttons
      correct = new JButton("Correct");
      correct.addActionListener(control);
      correct.setFocusPainted(false);
      add(correct);
      correct.setBounds(300,605,100,30);
      
      incorrect = new JButton("Incorrect");
      incorrect.addActionListener(control);
      incorrect.setFocusPainted(false);
      add(incorrect);
      incorrect.setBounds(600,605,100,30);
   }//createButtons
   
   public abstract void update();
   
}//class