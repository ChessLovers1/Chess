package program;

import pieces.Knight;
import javax.swing.JFrame;
import java.awt.Image;
import javax.swing.ImageIcon;


import java.io.BufferedInputStream;////////////////////



import pieces.*;

public class Chess {
    
	
	 /**
	  * Main method to be used in ChessBoardPanel when the mouse button get released
	  * 
	 * @param board		the Board state
	 * @param turn		What turn it is
	 * @param yIni		starting coord
	 * @param xIni		starting coord
	 * @param y			Destination
	 * @param x			Destination
	 * @return			true if the move is valid
	 */
	public static void validMove(Board board ,int turn , int yIni,int xIni,int y,int x ){
		
		int player = turn %  2;
		
		int checkPattern = isInCheck(board);
		
		Piece tempStorage;
		
		boolean canCapture;
		//white turn
		if(player == 0) {
			if(board.getBoard()[yIni][xIni] != null) {
				
				if(board.getBoard()[yIni][xIni].color == "white") {
					
					canCapture = canCapture(board, turn, yIni, xIni, y, x);
					
					//if you are already in check
					if( (checkPattern == 0 || checkPattern == 2 ) && canCapture ) {
						
						tempStorage = board.getBoard()[y][x];
						
						board.getBoard()[y][x] = board.getBoard()[yIni][xIni];
						board.getBoard()[yIni][xIni] = null;
						
						checkPattern = isInCheck(board);
						
						//if still in check that its invalid
						if( checkPattern == 0 || checkPattern == 2) {
							board.getBoard()[yIni][yIni] = board.getBoard()[y][x];
							
							board.getBoard()[y][x] = tempStorage;
						}
						else {
							board.getBoard()[y][x].x = x*80+87;
							board.getBoard()[y][x].y = 560-y*80+87;
						}
						
					}
					else if(canCapture) {
						
						board.getBoard()[y][x] = board.getBoard()[yIni][xIni];
						board.getBoard()[yIni][xIni] = null;
						
						board.getBoard()[y][x].x = x*80+87;
						board.getBoard()[y][x].y = 560-y*80+87;
					}
				}
			}
		}
		
		//black turn
		else {
			if(board.getBoard()[yIni][xIni] != null) {
				
				if(board.getBoard()[yIni][xIni].color == "black") {
					
					canCapture = canCapture(board, turn, yIni, xIni, y, x);
					
					//if you are already in check
					if( (checkPattern == 1 || checkPattern == 2 ) && canCapture ) {
						
						tempStorage = board.getBoard()[y][x];
						
						board.getBoard()[y][x] = board.getBoard()[yIni][xIni];
						board.getBoard()[yIni][xIni] = null;
						
						checkPattern = isInCheck(board);
						
						//if still in check that its invalid
						if( checkPattern == 1 || checkPattern == 2) {
							board.getBoard()[yIni][yIni] = board.getBoard()[y][x];
							
							board.getBoard()[y][x] = tempStorage;
						}
						else {
							board.getBoard()[y][x].x = x*80+87;
							board.getBoard()[y][x].y = 560-y*80+87;
						}
						
					}
					else if(canCapture) {
						
						board.getBoard()[y][x] = board.getBoard()[yIni][xIni];
						board.getBoard()[yIni][xIni] = null;
						
						board.getBoard()[y][x].x = x*80+87;
						board.getBoard()[y][x].y = 560-y*80+87;
					}
				}
			}
		}
		
		
		
		
		
		//check if in check
		 
		 //canCapture(board, turn, yIni, xIni, y, x);
		 
		 //check if the person who is playing is in check after playing
		 //return to old state if it doesnt work
		 //return canCapture(board, turn, yIni, xIni, y, x);
	 
	 }
	 
	 
	 
	 
    public static boolean canCapture(Board board ,int turn , int yIni,int xIni,int y,int x ){
    	
        boolean result = false;
    	Piece piece = board.getPiece(yIni, xIni);
    	
        //check if any specials execeptions would prevent from moving such as check
    	
    	
    	//check if the piece can't move because of checks/pins
    	
    	
    	
        //1. Check if There is a piece on the final square
        //2.Check if the pieces are different colors
    	if(!validCapture(board,yIni,xIni,y,x )) {
    		
    		return false;
    	}

        //check if valid move for that specific piece
        if(piece.getClass() == new Queen(null).getClass()){
        	//System.out.println("Queen");
        	result = rookMove(board,yIni,xIni,y,x ) ||bishopMove(board,yIni,xIni,y,x );
        }
        else if(piece.getClass() == new Rook(null).getClass()){
        	//System.out.println("Rook");
        	result = rookMove(board,yIni,xIni,y,x );
        }
        else if(piece.getClass() == new Pawn(null).getClass()){
        	//System.out.println("Pawn");
        	result = pawnMove(board ,turn , yIni ,xIni,y,x );
        }
        else if(piece.getClass() == new Bishop(null).getClass()){
        	//System.out.println("bishop");
        	result = bishopMove(board,yIni,xIni,y,x );
        }
        else if(piece.getClass() == new Knight(null).getClass()){
        	//System.out.println("Knight");
        	result = knightMove(board,yIni,xIni,y,x );
        }
        else if(piece.getClass() == new King(null).getClass()){
        	//System.out.println("King");
        	result = kingMove(board,yIni,xIni,y,x );
        }
        
        else{
        	System.out.print("initial coords has an object Piece that is unidentified");
        	result = false;
        }
        
        
        
        //if true and its a pawn on the last rank do call promote
        
        return result;
    }
    
    
    /**
     * 
     * @param board
     * @return 			-1 if not in check 		0 is white is in check		 1 if black is in check		2 if both are in check
     */
    public static int isInCheck(Board board) {

    	int result = -1;
    	
    	for(int j = 0; j < 8 ; j++) {
    		
    		for(int i = 0; i < 8 ; i++) {
    			
    			//find the index of the king
    			if(board.getPiece(j, i) != null) {
	    			if(board.getPiece(j, i).getClass() == new King(null).getClass()) {
	    				String color = board.getPiece(j, i).getColor();
	    				
	    				if(checkDirection(board, j, i, 1, 0) == true || checkDirection(board, j, i, -1, 0) == true ||
	    				   checkDirection(board, j, i, 0, 1) == true || checkDirection(board, j, i, 0, -1) == true ||
	    				   checkDirection(board, j, i, 1, 1) == true || checkDirection(board, j, i, -1, -1) == true ||
	    				   checkDirection(board, j, i, 1, -1) == true || checkDirection(board, j, i, -1, 1) == true) {//add knight moves
	    					
	    					if(color == "white") {
	    						
	    						if(result == -1) {
	    							result = 0;
	    						}
	    						else if(result == 1) {
	    							result = 2;
	    						}
	    						
	    					}
	    					else {
	    						
	    						if(result == -1) {
	    							result = 1;
	    						}
	    						else if(result == 0) {
	    							result = 2;
	    						}
	    						
	    					}
	    				}
	    				result = findHorse(board, result, j, i, 2, -1);
	    				result = findHorse(board, result, j, i, -2, 1);
	    				result = findHorse(board, result, j, i, 2, 1);
	    				result = findHorse(board, result, j, i, -2, -1);
	    				result = findHorse(board, result, j, i, 1, -2);
	    				result = findHorse(board, result, j, i, -1, 2);
	    				result = findHorse(board, result, j, i, -1, -2);
	    				result = findHorse(board, result, j, i,1 , 2);
	    			}
    			}
    		}}
    	
    	
    	return result;
    	
    }
    
    public static int findHorse(Board board, int result, int j, int i, int y, int x) {
    	
    	if(j +y >= 0 && j + y <=7 && i + x >= 0 && i + x <= 7) {
    		if( board.getPiece(j + y, i + x) != null) {
				if( board.getPiece(j + y, i+ x).getClass() ==  new Knight("").getClass() ) {
					
					if(board.getPiece(j , i).getColor() == "white" && board.getPiece(j + y, i+ x).getColor() == "black" ) {
						if(result == -1) {
							result = 0;
						}
						else if(result == 1) {
							result = 2;
						}
					}
					else if(board.getPiece(j, i).getColor() == "black" && board.getPiece(j + y, i+ x).getColor() == "white" ) {
						if(result == -1) {
							result = 1;
						}
						else if( result == 0){
							result = 2;
						}
					}
				}
    		}
		}
    	return result;
    }
    
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
        
        if(yIni - y <= 1 && yIni - y >= -1 && xIni - x <= 1 && xIni - x >= -1) {
        	return true;
        }
        return result;
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
        if(yIni-y<0 && xIni - x == 0){//up
            //Direction = "up";
        	result = isNotObstructed(board,yIni,xIni,y,x,1,0);
        	System.out.print("up");
        }
        else if(yIni - y>0 && xIni - x == 0){//down
        	result = isNotObstructed(board,yIni,xIni,y,x,-1,0);
        	System.out.print("down");
        }
        else if(xIni-x<0 && yIni - y == 0){//right
        	result = isNotObstructed(board,yIni,xIni,y,x,0,1);
        	System.out.print("right");
        }
        else if(xIni - x>0 && yIni - y == 0){//left 
        	result = isNotObstructed(board,yIni,xIni,y,x,0,-1);
        	System.out.print("left");
        }
        else{//Not a valid rook move
            result = false;
        }
   
        return result;
    }
    
    private static boolean pawnMove(Board board,int turn, int yIni,int xIni,int y,int x){
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
        
        
        //black
        if(board.getBoard()[yIni][xIni].getColor() == "black") {
        	
        	//move 1
        	if(yIni-y == 1 && xIni - x == 0) {
        		result = isNotObstructed(board,yIni,xIni,y,x,-1,0);
        		System.out.print("move1");
        	}
        	//move 2
        	else if(yIni - y == 2 && xIni - x == 0 && yIni == 6) {
        		result = isNotObstructed(board,yIni,xIni,y,x,-1,0);
        		System.out.print("move2");
        		((Pawn)board.getBoard()[yIni][xIni]).jump  = turn;
        	}
        	//capture left
        	else if(yIni - y == 1 && xIni - x == -1) {
        		if(board.getBoard()[y][x] != null && board.getBoard()[y][x].getColor() == "white") {
        				result = true;
        		}
        		System.out.print("capture left");
        	}
        	//capture right
        	else if(yIni - y == 1 && xIni - x == 1) {
        		if(board.getBoard()[y][x] != null && board.getBoard()[y][x].getColor() == "white") {
    				result = true;
        		}
        		System.out.print("capture right");
        	}
        }
        
        //white
        else if(board.getBoard()[yIni][xIni].getColor() == "white") {
        	
        	//move 1
        	if(yIni-y == -1 && xIni - x == 0) {
        		result = isNotObstructed(board,yIni,xIni,y,x,1,0);
        		System.out.print("move1");
        	}
        	//move 2
        	else if(yIni - y == -2 && xIni - x == 0 && yIni == 1) {
        		result = isNotObstructed(board,yIni,xIni,y,x,1,0);
        		System.out.print("move2");
        		((Pawn)board.getBoard()[yIni][xIni]).jump  = turn;
        	}
        	//capture left
        	else if(yIni - y == -1 && xIni - x == 1) {
        		if(board.getBoard()[y][x] != null && board.getBoard()[y][x].getColor() == "black") {
        				result = true;
        		}
        		System.out.print("capture left");
        	}
        	//capture right
        	else if(yIni - y == -1 && xIni - x == -1) {
        		if(board.getBoard()[y][x] != null && board.getBoard()[y][x].getColor() == "black") {
    				result = true;
        		}
        		System.out.print("capture right");
        	}
        }
        else {
        
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
        if(yIni-y <0 && xIni - x > 0){//up left
            //Direction = "up";
        	result = isNotObstructed(board,yIni,xIni,y,x,1,-1);
        	System.out.print("upL");
        }
        else if(yIni - y <0 && xIni - x < 0){//up right
        	result = isNotObstructed(board,yIni,xIni,y,x,1,1);
        	System.out.print("upR");
        }
        else if( yIni - y > 0 && xIni-x > 0){//down left
        	result = isNotObstructed(board,yIni,xIni,y,x,-1,-1);
        	System.out.print("downL");
        }
        else if(yIni - y > 0 && xIni - x < 0){//down right
        	result = isNotObstructed(board,yIni,xIni,y,x,-1,1);
        	System.out.print("downR");
        }
        else{//Not a valid rook move
            result = false;
        }
   
        return result;
    }
    
    private static boolean knightMove(Board board,int yIni,int xIni,int y,int x){
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
        
        if( yIni - y == 2 && xIni - x == -1 || yIni - y == 1 && xIni - x == -2 ||
        	yIni - y == 2 && xIni - x == 1 || yIni - y == 1 && xIni - x == 2 ||
        	yIni - y == -2 && xIni - x == -1 || yIni - y == -1 && xIni - x == -2 ||
        	yIni - y == -2 && xIni - x == 1 || yIni - y == -1 && xIni - x == 2) {
        	result = true;
        }
        else {
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
    	if(board.getPiece(yIni, xIni) == null) {
    		return false;
    	}
    	if(board.getPiece(y, x).getColor() != board.getPiece(yIni, xIni).getColor()) {
    		return true;
    	}
    	
    	return false;
    	
    }
    
    private static boolean isNotObstructed(Board board, int yIni, int xIni, int y, int x, int yStep,int xStep){
        //      the next step is y x                   make sure it in range
    	while(!(yIni == y-yStep && xIni == x-xStep) && (yIni <= 7 && yIni >= 0 && xIni <= 7 && xIni >= 0)) {
    		xIni += xStep;
    		yIni += yStep;
    		
    		
    		if(yIni == 8 || yIni == -1 || xIni == 8 || xIni == -1) {
    			return false;
    		}
            
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
     * method used by isInCheck to see if anything is checking the king in a certain direction
     * @param board
     * @param yIni
     * @param xIni
     * @param yStep
     * @param xStep
     * @return true if the king is getting checked
     */
    private static boolean checkDirection(Board board, int yIni, int xIni,  int yStep,int xStep){
        //      the next step is y x                   make sure it in range
    	int x = xIni;
    	int y = yIni;
    	while((x <= 7 && y >= 0 && x <= 7 && x >= 0)) {
    		x += xStep;
    		y += yStep;
    		
    		
    		if(y == 8 || y == -1 || x == 8 || x == -1) {
    			return false;
    		}
            
    		//if there is a piece is the way this will return false
    		if(board.getPiece(yIni, xIni) != null) {
    			 if(canCapture(board, -1, y, x, yIni, xIni)) {
    				 //System.out.println(board.getPiece(y, x) + "  hi");
    				 return true;
    			 }
    		}
    			
    	}
    	
    	
    	return false;
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
    	
        
        
        
        
        

    }
}
