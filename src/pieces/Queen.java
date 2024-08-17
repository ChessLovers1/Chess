package pieces;

import javax.swing.ImageIcon;

public class Queen extends Piece{
    

    public Queen(String color){
    	super(color);
	    if(color != null) {
    		if(color.equals("white")){
	    		
	    		this.Img = new ImageIcon("./src/img/z-White-queen-chess.png").getImage();
	    	}
	    	else {
	    		Img = new ImageIcon("./src/img/z-Black-queen-chess.png").getImage();
	    	}
    		
	    	
	    }
    }
    
    public String toString(){
        return "Queen";
    }   
}

