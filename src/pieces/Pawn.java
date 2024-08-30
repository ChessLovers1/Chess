package pieces;

import javax.swing.ImageIcon;

public class Pawn extends Piece{
    
	public int jump = -1;//the number will be at what turn did it jump 
    public Pawn(String color){
    	super(color);
    	if(color != null) {

    		if(color.equals("white")){
	    		this.Img = new ImageIcon(this.getClass().getResource("/img/z-White-pawn-chess.png")).getImage();
	    		
	    	}
	    	else {
	    		
	    		this.Img = new ImageIcon(this.getClass().getResource("/img/z-Black-pawn-chess.png")).getImage();
	    	}
    		
    		
	    	
    	}

    }
    
    public String toString(){
        return "Pawn";
    }   
}
