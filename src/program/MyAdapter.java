package program;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyAdapter extends JPanel {

  public MyAdapter() {

      addMouseListener(new MouseAdapter() { 
          public void mousePressed(MouseEvent me) { 
            System.out.println(me); 
          } 
        }); 

  }

  /**
 * @param args
 */
public static void main(String[] args) {
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(new MyAdapter());

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    frame.setSize(200, 200);
	    frame.setVisible(true);
	  }
}
