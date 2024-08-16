package pieces;

public class Rook extends Piece{

    public Rook(String color){
    	super(color);
    	if(color != null) {
	    	if(color.equals("white")){
	    		this.Img = "./src/img/z-White-rook-chess.png";
	    	}
	    	else {
	    		Img = "./src/img/z-Black-rook-chess.png";
	    	}
    	}

    }

    public String toString(){
        return "Rook";
    }   
}
