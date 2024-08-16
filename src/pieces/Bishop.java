package pieces;

import program.imageObject;

public class Bishop extends Piece{
    

    public Bishop(String color){
    	super(color);
    	if(color != null) {
	    	if(color.equals("white")){
	    		this.Img = "./src/img/z-White-bishop-chess.png";
	    	}
	    	else {
	    		Img = "./src/img/z-Black-bishop-chess.png";
	    	}
    	}
    	
    	
}
    public String toString(){
        return "Bishop";
    }  
}
