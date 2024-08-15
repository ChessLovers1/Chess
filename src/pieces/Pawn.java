package pieces;

public class Pawn extends Piece{
    

    public Pawn(String color){
    	super(color);
    	if(color.equals("white")){
    		this.Img = "./src/img/z-White-pawn-chess.png";
    	}
    	else {
    		Img = "./src/img/z-Black-pawn-chess.png";
    	}

    }
    
    public String toString(){
        return "Pawn";
    }   
}
