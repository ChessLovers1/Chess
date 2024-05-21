package program;

import java.awt.Canvas;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JFrame;

import java.util.Timer;
import java.util.Date;
public class GUI extends JFrame {

   public MyAdapter Adapter= null;
   
    public GUI() {
    	super("Chess"); 
    	
      	//ChessBoard background
        ChessBoardPanel chessBoardPanel = new ChessBoardPanel();
        add(chessBoardPanel);

 
    	
    	Adapter = new MyAdapter();
    	
    	
    	
    	
    	
    	getContentPane().add(Adapter);
    	
    	//setExtendedState(JFrame.MAXIMIZED_BOTH);//Fullscreen
    	//Toolkit.getDefaultToolkit().getScreenSize
        setSize(850,600 ); // Set your desired size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setLocationRelativeTo(null); // Center the window on the screen
        
    	

        setVisible(true); // Make the window visible
    }
    public MyAdapter getAdapter() {
    	return this.Adapter;
    }
    public static void main(String[] args) {
        JFrame frame = new GUI();
        
       
        
        ChessBoardPanel horse = new ChessBoardPanel("Rookblack", 0, 0);
        frame.getContentPane().add(horse);
         
        
        //getContentPane()
        
        
        /*
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;

        while (elapsedTime < 4*1000) {
            
            elapsedTime = (new Date()).getTime() - startTime;
        }
		*/
        while(true) {
        	
        	horse.moveImg(((GUI)frame).Adapter.x, ((GUI)frame).Adapter.y);
        
        	
        }
    }
}

