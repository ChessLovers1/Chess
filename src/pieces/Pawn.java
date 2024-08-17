package pieces;

import javax.swing.ImageIcon;

public class Pawn extends Piece{
    

    public Pawn(String color){
    	super(color);
    	if(color != null) {
    		if(color.equals("white")){
	    		
	    		this.Img = new ImageIcon("./src/img/z-White-pawn-chess.png").getImage();
	    	}
	    	else {
	    		Img = new ImageIcon("./src/img/z-Black-pawn-chess.png").getImage();
	    	}
    		
	    	
    	}

    }
    
    public String toString(){
        return "Pawn";
    }   
}
