package pieces;

import javax.swing.ImageIcon;

public class King extends Piece{
    
    public King(String color){
    	super(color);
    	if(color != null) {
    		if(color.equals("white")){
	    		
	    		this.Img = new ImageIcon("./src/img/z-White-king-chess.png").getImage();
	    	}
	    	else {
	    		Img = new ImageIcon("./src/img/z-Black-king-chess.png").getImage();
	    	}
	    	
    	}

    }
    
    public String toString(){
        return "King";
    }   
}
