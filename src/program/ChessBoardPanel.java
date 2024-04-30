package program;

import java.awt.Graphics;
import java.awt.Image;
    
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class ChessBoardPanel extends JPanel {
        
    private Image pic;
    public int num;
    public ChessBoardPanel(String Object,int num) {
        //
    	this.num = num;
        ImageIcon obj = null;
        if(Object.equals("Board")){
            obj = new ImageIcon("./src/img/z-chessBoardV1.png");
        }
        else if(Object.equals("Rookblack")){
            obj = new ImageIcon("./src/img/z-Black-knight-chess.png");
        }
        
        
        
        
        pic = obj.getImage();
        
      
        
    }

    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(pic, num, num, null);
    }
}
