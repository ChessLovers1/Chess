package program;

import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JFrame;

import java.util.Timer;
import java.util.Date;
public class GUI extends JFrame {

    public GUI() {
    	super("Chess"); 
    	
    	//ChessBoard background
    	
    	
    	
        
        
        setSize(830, 850); // Set your desired size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true); // Make the window visible
    }

    public static void main(String[] args) {
        JFrame a = new GUI();
        
        
        //a.getContentPane().add(new MyAdapter());//Prints 
        ChessBoardPanel b = new ChessBoardPanel("Rookblack", 10);
        a.add(b);
        
        
        
        

        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;

        while (elapsedTime < 4*1000) {
            
            elapsedTime = (new Date()).getTime() - startTime;
        }

        b.num += 100;


        b.repaint();
    }
}

