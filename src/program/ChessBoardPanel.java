package program;

import pieces.*;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
    
public class ChessBoardPanel extends JPanel {
        
    private Image pic;
    private Image pieceImage;
       
    //Board
    Board daBoard = new Board();    
    Piece List[][] = daBoard.getBoard();
    
    //Pieces
    Piece daPiece = new Piece();
    
    public ChessBoardPanel() {
        ImageIcon obj = new ImageIcon("./src/img/z-chessBoardV1.png");
        pic = obj.getImage();
        
        
        // Load your piece image
        pieceImage = new ImageIcon("./src/img/z-Black-bishop-chess.png").getImage();
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //getWidth = screen width 
        //pic.getWidth = image width
        int x = (getWidth() - pic.getWidth(this)) / 2;
        int y = (getHeight() - pic.getHeight(this)) / 2;
        
        
        //Board
        g.drawImage(pic, x, y, null);
        
        //---------------------------------------------------------
        //---------------------------------------------------------
        //---------------------------------------------------------

        
        //Variable to help control where the Piece images go once centered for x value
        int varx = 87;  // 87 is a1
		   			    // 167 is b1
		                // Difference in y is 80
        
        			    // MIN: 87
        				// MAX: 647
        
       
        //---------------------------------------------------------
        //---------------------------------------------------------
        //---------------------------------------------------------

      //Variable to help control where the Piece images go once centered for y value
        int vary = 647; // 647 is a1 
        			    // 567 is a2
        			    // Difference in y is 80
        
	    				// MIN: 647 
						// MAX: 87
        
        
        //---------------------------------------------------------
        //---------------------------------------------------------
        //---------------------------------------------------------
        
        //Loop that check list of array to display on screen
        /*
        //Checks the x value
        for (int xvalue = 0; xvalue<8; xvalue++) {
        	//Checks the y value
            for (int yvalue = 0; yvalue<8; yvalue++) {
            	
            //	if (daBoard[xvalue][yvalue] != null) {
            		//Get piece
            		
            		
            		
            		//Draw Piece and gonna need to find a way to get it to go exactly where needed
            	}
            }
            
        }
        */	        
        
       //Draws img
        g.drawImage(pieceImage, x+varx,  y+vary,65,65,null);

    }
}

