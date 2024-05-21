package program;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.lang.Thread;
public class MyAdapter extends JPanel{
	public int x;
	public int y;
	
  public MyAdapter() {

	  addMouseMotionListener(new MouseAdapter() { 
          public void mouseDragged(MouseEvent me) {
       
            x = me.getX();
            y = me.getY();
            
          } 
        });  
      
      

  }

}
