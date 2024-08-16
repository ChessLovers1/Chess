package program;

import javax.swing.JFrame;
import java.awt.Image;
import javax.swing.ImageIcon;


import java.io.BufferedInputStream;////////////////////



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

	//public static boolean canMove() {
		//Method that 
	//}
	
    public static boolean validMove(Board board,int yIni,int xIni,int y,int x ){
    	
        boolean result = false;
    	Piece piece = board.getPiece(yIni, xIni);
    	
        //check if any specials execeptions would prevent from moving such as check
    	
    	
    	//check if the piece can't move because of checks/pins
    	
    	
    	
        //1. Check if There is a piece on the final square
        //2.Check if the pieces are different colors
    	if(!validCapture(board,yIni,xIni,y,x )) {
    		System.out.println("not valid colors");
    		return false;
    	}

        //check if valid move for that specific piece
        if(piece.getClass() == new Queen(null).getClass()){
        	System.out.println("Queen");
        	result = false;
        }
        else if(piece.getClass() == new Rook(null).getClass()){
        	System.out.println("Rook");
        	result = rookMove(board,yIni,xIni,y,x );
        }
        else if(piece.getClass() == new Pawn(null).getClass()){
        	System.out.println("Pawn");
        	result = false;
        }
        else if(piece.getClass() == new Bishop(null).getClass()){
        	System.out.println("bishop");
        	result = bishopMove(board,yIni,xIni,y,x );
        }
        else if(piece.getClass() == new Knight(null).getClass()){
        	System.out.println("Knight");
        	result = false;
        }
        else{
        	System.out.print("initial coords has an object Piece that is unidentified");
        	result = false;
        }
        return result;
    }
    /*
    public static int isInCheck(Board board) {
    	// if white is in check return 1; if no checks return 0; if black check return -1;
    	for(int j = 0; j < 8 ; j++) {
    		
    		for(int i = 0; i < 8 ; i++) {
    			
    			if(board.getPiece(j, i).getClass() == new King(null).getClass()) {
    				String color = board.getPiece(j, i).getColor();
    				//not finished
    				
    				isObstructed(board, j , i , 8 , i, 1, 0 );
    				
    			}
    		}
    	}
    	
    }
    */
    /*
    private static int[] findClosestPiece(Board board,int yIni,int xIni,int yStep,int xStep) {
    	int[] result = new int[2];
    	int y = 0;
    	int x = 0;
    	//finish
    	while(!isObstructed(board,yIni,xIni,y,x,yStep,xStep)) {
    		
    		
    		
    	}
    	
    }
    */
    
    
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
        	result = isNotObstructed(board,yIni,xIni,y,x,1,0);
        	System.out.print("up");
        }
        else if(yIni - y>0 || xIni - x == 0){//down
        	result = isNotObstructed(board,yIni,xIni,y,x,-1,0);
        	System.out.print("down");
        }
        else if(xIni-x<0 || yIni - y == 0){//right
        	result = isNotObstructed(board,yIni,xIni,y,x,0,1);
        	System.out.print("right");
        }
        else if(xIni - x>0 || yIni - y == 0){//left
        	result = isNotObstructed(board,yIni,xIni,y,x,0,-1);
        	System.out.print("left");
        }
        else{//Not a valid rook move
            result = false;
        }
   
        return result;
    }
    
    private static boolean bishopMove(Board board,int yIni,int xIni,int y,int x){
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
        
       
        
        
        //Find direction
        if(yIni-y <0 || xIni - x > 0){//up left
            //Direction = "up";
        	result = isNotObstructed(board,yIni,xIni,y,x,1,-1);
        	System.out.print("upL");
        }
        else if(yIni - y <0 || xIni - x < 0){//up right
        	result = isNotObstructed(board,yIni,xIni,y,x,1,1);
        	System.out.print("upR");
        }
        else if( yIni - y > 0 || xIni-x > 0){//down left
        	result = isNotObstructed(board,yIni,xIni,y,x,-1,-1);
        	System.out.print("downL");
        }
        else if(yIni - y > 0 || xIni - x < 0){//down right
        	result = isNotObstructed(board,yIni,xIni,y,x,-1,1);
        	System.out.print("downR");
        }
        else{//Not a valid rook move
            result = false;
        }
   
        return result;
    }
    private static boolean validCapture(Board board,int yIni,int xIni,int y,int x ) {
    	//if there is no pieces at the destination than return true
    	//The piece at the destination need to be different than the piece traveling there
    	if(board.getPiece(y, x) == null) {
    		return true;
    	}
    	
    	if(board.getPiece(y, x).getColor() != board.getPiece(yIni, xIni).getColor()) {
    		return true;
    	}
    	
    	return false;
    	
    }
    
    private static boolean isNotObstructed(Board board, int yIni, int xIni, int y, int x, int yStep,int xStep){
        //      the next step is y x                   make sure it in range
    	while(!(yIni == y-yStep && xIni == x-xStep) && (yIni < 8 && yIni >= 0 && xIni < 8 && xIni >= 0)) {
    		xIni += xStep;
    		yIni += yStep;
    		
    		//if there is a piece is the way this will return false
    		if(board.getPiece(yIni, xIni) != null) {
    			return false;
    		}
    			
    	}
    	
    	//
    	if (yIni == y-yStep && xIni == x-xStep){
    		return true;
    	}
    	return false;
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
    	
        Board test = new Board("Rookwhite Knightwhite Bishopwhite Queenwhite Kingwhite Bishopwhite Knightwhite Rookwhite \r\n"
        		+ "Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "null null null Pawnwhite null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack \r\n"
        		+ "Rookblack Knightblack Bishopblack Queenblack Kingblack Bishopblack Knightblack Rookblack ");

        System.out.print("test");//False
        System.out.println(validMove(test, 0, 0, 2, 0));
        

        
        Board test1 = new Board("Rookwhite Knightwhite Bishopwhite Queenwhite Kingwhite Bishopwhite Knightwhite Rookwhite \r\n"
        		+ "null Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "Rookblack null null null null null null null \r\n"
        		+ "Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack \r\n"
        		+ "null Knightblack Bishopblack Queenblack Kingblack Bishopblack Knightblack Rookblack ");

        System.out.println("test1");//true
        System.out.println(validMove(test1, 0, 0, 4, 0)+"\r\n");
        
        
        Board test2 = new Board("Rookwhite Knightwhite Bishopwhite Queenwhite Kingwhite Bishopwhite Knightwhite Rookwhite \r\n"
        		+ "pawnwhite null Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "Rookblack null null null null null null null \r\n"
        		+ "Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack \r\n"
        		+ "null Knightblack Bishopblack Queenblack Kingblack Bishopblack Knightblack Rookblack ");

        System.out.println("test2");//true
        System.out.println(validMove(test2, 0, 2, 2, 0)+"\r\n");
        
        
        
        Board test3 = new Board("Rookwhite Knightwhite Bishopwhite Queenwhite Kingwhite Bishopwhite Knightwhite Rookwhite \r\n"
        		+ "pawnwhite null Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite \r\n"
        		+ "pawnblack null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "Rookblack null null null null null null null \r\n"
        		+ "Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack \r\n"
        		+ "null Knightblack Bishopblack Queenblack Kingblack Bishopblack Knightblack Rookblack ");

        System.out.println("test3");//True
        System.out.println(validMove(test3, 0, 2, 2, 0)+"\r\n");
        //System.out.println(validCapture(test3,0,3,2,0 ));
        
        
        Board test4 = new Board("Rookwhite Knightwhite Bishopwhite Queenwhite Kingwhite Bishopwhite Knightwhite Rookwhite \r\n"
        		+ "Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite \r\n"
        		+ "pawnblack null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "Rookblack null null null null null null null \r\n"
        		+ "Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack \r\n"
        		+ "null Knightblack Bishopblack Queenblack Kingblack Bishopblack Knightblack Rookblack ");

        System.out.println("test4");//False
        System.out.println(validMove(test4, 0, 2, 2, 0)+"\r\n");
        
        
        
        

    }
}
