package pieces;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Bishop extends Piece{
    
	BufferedImage img;
    public Bishop(String color){
    	super(color);
    	if(color != null) {
	    	if(color.equals("white")){
	    		this.Img = new ImageIcon(this.getClass().getResource("/img/z-White-bishop-chess.png")).getImage();
	    		
	    	}
	    	else {
	    		
	    		this.Img = new ImageIcon(this.getClass().getResource("/img/z-Black-bishop-chess.png")).getImage();
	    	}
	    	
	    	
    	}
    	
    	
}
    public String toString(){
        return "Bishop";
    }  
}
