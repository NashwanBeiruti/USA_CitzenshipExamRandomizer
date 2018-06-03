import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class Controller implements ActionListener, KeyListener {
   WindowFrame frame;
   Model civics_m, reading_m, writing_m;
   GUI current_gui;
   
   public Controller (WindowFrame frame) {
      this.frame = frame;
      civics_m = new ModelCivics();
      reading_m = new ModelReadWrite(37, "reading.txt");
      writing_m = new ModelReadWrite(35, "writing.txt");
   }//constructor
   
   public void actionPerformed(ActionEvent arg0) {
      String command = arg0.getActionCommand();
      switch (command) {
         
         case "Correct":
            correct();
            break;
            
         case "Incorrect":
            incorrect();
            break;
            
         case "Quit":
            System.exit(0);
            break;
            
         case "Undo":
            undo();
            break;
         
         case "Reset Current":
            resetCurrent();
            break;
         
         case "Reset All":
            resetAll();
            break;
            
         case "Civics":
            current_gui = new GUICivics (civics_m, this);
            frame.setContentPane(current_gui);
            break;
         
         case "Reading":
            current_gui = new GUIReadWrite (reading_m, this, true);
            frame.setContentPane(current_gui);
            break;
            
         case "Writing":
            current_gui = new GUIReadWrite (writing_m, this, false);
            frame.setContentPane(current_gui);
            break;   
      }//switch
   }//actionPerformed

   public void keyPressed(KeyEvent e) {}

   public void keyReleased(KeyEvent e) {
      int code = e.getKeyCode();
      switch (code) {
         case KeyEvent.VK_LEFT:
            correct();
            break;
            
         case KeyEvent.VK_RIGHT:
            incorrect();
            break;
            
         case KeyEvent.VK_Q:
            System.exit(0);
            break;
         
         case KeyEvent.VK_U:
            undo();
            break;
            
         case KeyEvent.VK_R:
            resetCurrent();
            break;
         
         case KeyEvent.VK_A:
            resetAll();
            break;
            
         case KeyEvent.VK_1:
            current_gui = new GUICivics (civics_m, this);
            frame.setContentPane(current_gui);
            break;
            
         case KeyEvent.VK_2:
            current_gui = new GUIReadWrite (reading_m, this, true);
            frame.setContentPane(current_gui);
            break;
            
         case KeyEvent.VK_3:
            current_gui = new GUIReadWrite (writing_m, this, false);
            frame.setContentPane(current_gui);
            break;
      }//switch
   }//keyReleased

   public void keyTyped(KeyEvent e) {}
   
   private void correct () {
      if (current_gui == null) return;
      if (current_gui.model.index < current_gui.model.array.length) {
         current_gui.model.array[current_gui.model.index++].right = true;
         current_gui.model.num_correct++;
         current_gui.update();
      }//if
      else
         JOptionPane.showMessageDialog(null, "All questions have already been completed.");
   }//correct
   
   private void incorrect () {
      if (current_gui == null) return;
      if (current_gui.model.index < current_gui.model.array.length) {
         current_gui.model.array[current_gui.model.index++].right = false;
         current_gui.model.num_incorrect++;
         current_gui.update();
      }//if
      else
         JOptionPane.showMessageDialog(null, "All questions have already been completed.");
   }//incorrect
   
   private void undo () {
      if (current_gui == null || current_gui.model.index == 0) return;
      current_gui.model.index--;
      if (current_gui.model.array[current_gui.model.index].right == true) current_gui.model.num_correct--;
      else current_gui.model.num_incorrect--;
      current_gui.update();
   }//undo
   
   private void resetCurrent () {
      if (current_gui == null) return;
      current_gui.model.reset();
      current_gui.update();
   }//resetCurrent
   
   private void resetAll () {
      civics_m.reset();
      reading_m.reset();
      writing_m.reset();
      if (current_gui != null) current_gui.update();
   }//resetAll
   
   
}//class
