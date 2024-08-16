package pieces;

public class Queen extends Piece{
    

    public Queen(String color){
    	super(color);
	    if(color != null) {
	    	if(color.equals("white")){
	    		this.Img = "./src/img/z-White-queen-chess.png";
	    	}
	    	else {
	    		Img = "./src/img/z-Black-queen-chess.png";
	    	}
	    }
    }
    public String toString(){
        return "Queen";
    }   
}

