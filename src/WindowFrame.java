import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class WindowFrame extends JFrame {
   JMenuBar menubar;
   JMenu file, edit, topic;
   JMenuItem setting, statistics, quit, undo, resetcurrent, resetall, civics_i,
         reading_i, writing_i;
   Controller control;
   
   public WindowFrame() {
      control = new Controller (this);
      setTitle("Naturalization Question Randomizer");
      setSize(1000, 725);
      setLayout(null);
      getContentPane().setBackground(Color.white);
      setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      createMenuBar();
      setVisible(true);
      addKeyListener(control);
   }//constructor

   private void createMenuBar() {
      menubar = new JMenuBar();

      file = new JMenu("File");
      edit = new JMenu("Edit");
      topic = new JMenu("Topic");
      menubar.add(file);
      menubar.add(edit);
      menubar.add(topic);

      // File
      setting = new JMenuItem("Setting");
      //setting.addActionListener(control);
      file.add(setting);

      file.addSeparator();

      statistics = new JMenuItem("Statistics");
      //statistics.addActionListener(control);
      file.add(statistics);

      file.addSeparator();

      quit = new JMenuItem("Quit");
      quit.addActionListener(control);
      file.add(quit);

      // Edit
      undo = new JMenuItem("Undo");
      undo.addActionListener(control);
      edit.add(undo);

      edit.addSeparator();

      resetcurrent = new JMenuItem("Reset Current");
      resetcurrent.addActionListener(control);
      edit.add(resetcurrent);

      edit.addSeparator();

      resetall = new JMenuItem("Reset All");
      resetall.addActionListener(control);
      edit.add(resetall);

      // Switch
      civics_i = new JMenuItem("Civics");
      civics_i.addActionListener(control);
      topic.add(civics_i);
      
      topic.addSeparator();
      
      reading_i = new JMenuItem("Reading");
      reading_i.addActionListener(control);
      topic.add(reading_i);
      
      topic.addSeparator();
      
      writing_i = new JMenuItem("Writing");
      writing_i.addActionListener(control);
      topic.add(writing_i);

      setJMenuBar(menubar);
   }//createMenuBar
   
}//class