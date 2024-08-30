package pieces;

import javax.swing.ImageIcon;

public class Rook extends Piece{

    public Rook(String color){
    	super(color);
    	if(color != null) {

    		if(color.equals("white")){
	    		this.Img = new ImageIcon(this.getClass().getResource("/img/z-White-rook-chess.png")).getImage();
	    		
	    	}
	    	else {
	    		
	    		this.Img = new ImageIcon(this.getClass().getResource("/img/z-Black-rook-chess.png")).getImage();
	    	}
    		
	    
    	}

    }

    public String toString(){
        return "Rook";
    }   
}
