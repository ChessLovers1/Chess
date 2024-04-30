package program;

import java.awt.Graphics;
import java.awt.Image;
    
import javax.swing.ImageIcon;
import javax.swing.JPanel;
    
public class ChessBoardPanel extends JPanel {
        
    private Image pic;
    
    public ChessBoardPanel() {
        ImageIcon obj = new ImageIcon("./src/img/z-chessBoardV1.png");
        pic = obj.getImage();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(pic, 10, 10, null);
    }
}
