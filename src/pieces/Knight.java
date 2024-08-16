package pieces;

public class Knight extends Piece{

    public Knight(String color){
    	super(color);
    	if(color != null) {
	    	if(color.equals("white")){
	    		this.Img = "./src/img/z-White-knight-chess.png";
	    	}
	    	else {
	    		Img = "./src/img/z-Black-knight-chess.png";
	    	}
    	}
    }
    public String toString(){
        return "Knight";
    }   
    
}
