package pieces;

public class King extends Piece{
    
    public King(String color){
    	super(color);
    	if(color.equals("white")){
    		this.Img = "./src/img/z-White-king-chess.png";
    	}
    	else {
    		Img = "./src/img/z-Black-king-chess.png";
    	}

    }
    public String toString(){
        return "King";
    }   
}
