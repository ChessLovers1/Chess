package program;

import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JFrame;

public class GUI extends JFrame {

    public GUI() {
    	super("Chess"); 
    	
    	//ChessBoard background
        ChessBoardPanel chessBoardPanel = new ChessBoardPanel();
        add(chessBoardPanel);

 
        setSize(830, 850); // Set your desired size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true); // Make the window visible
    }

    public static void main(String[] args) {
        new GUI();
        System.out.println("Hello World");
    }
}
