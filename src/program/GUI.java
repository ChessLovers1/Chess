package program;

import java.awt.Canvas;

import java.awt.Color;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import java.io.File;

public class GUI extends JFrame {
	
	public Canvas canvas;
		
    public GUI() {
        super("Blank Page");

        canvas = new Canvas();

        // Set canvas background color to white
        canvas.setBackground(Color.WHITE);

        add(canvas);
        setSize(800, 600); // Set your desired size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true); // Make the window visible
    }

    public static void main(String[] args) {
        
    }
}
