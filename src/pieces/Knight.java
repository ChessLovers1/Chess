package pieces;

import javax.swing.ImageIcon;

public class Knight extends Piece{

    public Knight(String color){
    	super(color);
    	if(color != null) {
    		
    		if(color.equals("white")){
	    		this.Img = new ImageIcon(this.getClass().getResource("/img/z-White-knight-chess.png")).getImage();
	    		
	    	}
	    	else {
	    		
	    		this.Img = new ImageIcon(this.getClass().getResource("/img/z-Black-knight-chess.png")).getImage();
	    	}
    		
    		
    		
	    	
    	}
    }
    
    public String toString(){
        return "Knight";
    }   
    
}
