package pieces;

import javax.swing.ImageIcon;

public class Queen extends Piece{
    

    public Queen(String color){
    	super(color);
	    if(color != null) {

    		if(color.equals("white")){
	    		this.Img = new ImageIcon(this.getClass().getResource("/img/z-White-queen-chess.png")).getImage();
	    		
	    	}
	    	else {
	    		
	    		this.Img = new ImageIcon(this.getClass().getResource("/img/z-Black-queen-chess.png")).getImage();
	    	}
    		
	    	
	    }
    }
    
    public String toString(){
        return "Queen";
    }   
}

