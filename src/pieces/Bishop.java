package pieces;

import javax.swing.ImageIcon;

public class Bishop extends Piece{
    
	
    public Bishop(String color){
    	super(color);
    	if(color != null) {
	    	if(color.equals("white")){
	    		
	    		this.Img = new ImageIcon("./src/img/z-White-bishop-chess.png").getImage();
	    	}
	    	else {
	    		Img = new ImageIcon("./src/img/z-Black-bishop-chess.png").getImage();
	    	}
	    	
	    	
    	}
    	
    	
}
    public String toString(){
        return "Bishop";
    }  
}
