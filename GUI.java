import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JFrame;

public class GUI extends JFrame {

    public GUI() {
        super("Blank Page");

        Canvas canvas = new Canvas();

        // Set canvas background color to white
        canvas.setBackground(Color.WHITE);

        add(canvas);
        setSize(800, 600); // Set your desired size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true); // Make the window visible
    }

    public static void main(String[] args) {
        new GUI();
    }
}
