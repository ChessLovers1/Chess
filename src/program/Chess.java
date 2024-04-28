package program;

import pieces.*;

public class Chess {
    /* 




    GameState

        Problem 1: Turns
            (What if we used odd and even numbers?)
            (Odd number = Player Turn, even number = computer Turn) 
            (We just setup a counter that goes up by 1 per turn and we use the % to find out which players turn is up!)

    Rules that get checked every turn 

        Problem 1: Is King in check?
            (We just check the kings current posititon with all the opposing pieces attacking tiles)
            (We will need to make sure pieces can be moved to protect the king as well) ??
            (If king is in check and has no possible moves then he loses)
        
        Problem 2: Stalemate
            (If king has no pieces that can move and cant move himself without being in check)

    */

    public static boolean validMove(Board board,int yIni,int xIni,int y,int x ){
        boolean result = false;
    	Piece piece = board.getBoard()[yIni][xIni];
        //check if any specials execeptions would prevent from moving such as check
    	
    	//method called valid capture
        //1. Check if There is a piece on the final square
        //2.Check if the pieces are different colors***************


        //check if valid move for that specific piece
        if(piece.getClass() == new Queen(null).getClass()){
            result = false;
        }
        else if(piece.getClass() == new Rook(null).getClass()){
        	result = rookMove(board,yIni,xIni,y,x );
        }
        else if(piece.getClass() == new Pawn(null).getClass()){
        	result = false;
        }
        else if(piece.getClass() == new Bishop(null).getClass()){
        	result = false;
        }
        else if(piece.getClass() == new Knight(null).getClass()){
        	result = false;
        }
        else{
        	result = false;
        }
        return result;
    }

    private static boolean kingMove(Board board,int yIni,int xIni,int y,int x){
        return true;
    }

    private static boolean rookMove(Board board,int yIni,int xIni,int y,int x){
        boolean result = false;

        if(yIni <0 || yIni >7 || xIni <0 || xIni >7){
            throw new IndexOutOfBoundsException("The rook starting position is not on the board");
        }
        if(y <0 || y >7 || x <0 || x >7){
            throw new IndexOutOfBoundsException("The rook destination is not on the board");
        }
        
        if(yIni == y && xIni == x){//the piece has not moved
            return false;
        }
        if(yIni-y != 0 && xIni-x != 0){//checks if it's moving in two dimensions
            return false;
        }
       
        
        
        //Find direction
        if(yIni-y<0 || xIni - x == 0){//up
            //Direction = "up";
        	result = isObstructed(board,yIni,xIni,y,x,1,0);
        	System.out.print("up");
        }
        else if(yIni - y>0 || xIni - x == 0){//down
        	result = isObstructed(board,yIni,xIni,y,x,-1,0);
        	System.out.print("down");
        }
        else if(xIni-x<0 || yIni - y == 0){//right
        	result = isObstructed(board,yIni,xIni,y,x,0,1);
        	System.out.print("right");
        }
        else if(xIni - x>0 || yIni - y == 0){//left
        	result = isObstructed(board,yIni,xIni,y,x,0,-1);
        	System.out.print("left");
        }
        else{//Not a valid rook move
            result = false;
        }
   
        return result;
    }
    
    
    private static boolean isObstructed(Board board, int yIni, int xIni, int y, int x, int yStep,int xStep){
        
    	while(!(yIni == y-yStep && xIni == x-xStep) && (yIni < 8 && yIni >= 0 && xIni < 8 && xIni >= 0)) {
    		xIni += xStep;
    		yIni += yStep;
    		
    		if(board.getBoard()[yIni][xIni] != null) {
    			return false;
    		}
    		
    		
    		
    		
    	}
    	
    	if (yIni == y-yStep && xIni == x-xStep){
    		return true;
    	}
    	return false;
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
    	System.out.println("test");
        Board test = new Board("Rookwhite Knightwhite Bishopwhite Queenwhite Kingwhite Bishopwhite Knightwhite Rookwhite \r\n"
        		+ "Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack \r\n"
        		+ "Rookblack Knightblack Bishopblack Queenblack Kingblack Bishopblack Knightblack Rookblack ");

        System.out.println(validMove(test, 0, 0, 2, 0));
        

        System.out.println("test1");
        Board test1 = new Board("Rookwhite Knightwhite Bishopwhite Queenwhite Kingwhite Bishopwhite Knightwhite Rookwhite \r\n"
        		+ "null Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "Rookblack null null null null null null null \r\n"
        		+ "Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack \r\n"
        		+ "null Knightblack Bishopblack Queenblack Kingblack Bishopblack Knightblack Rookblack ");

        System.out.println(validMove(test1, 5, 5, 5, 0));

    }
}
