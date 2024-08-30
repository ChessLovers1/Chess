package program;

import java.util.ArrayList;
import pieces.Knight;
import pieces.*;

public class Chess {
    
	//
	
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
	public static boolean validMove(Board board ,int turn , int yIni,int xIni,int y,int x ){
		
		int player = turn %  2;
		
		int checkPattern = isInCheck(board);
		
		
		Piece tempStorage;
		
		boolean canCapture = false;
		
		if(checkmate(board) == 0) {
			System.out.println("white checkmated");
		}
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
							board.getBoard()[yIni][xIni] = board.getBoard()[y][x];
							
							board.getBoard()[y][x] = tempStorage;
							return false;
						}
						else {
							board.getBoard()[y][x].x = x*80+87;
							board.getBoard()[y][x].y = 560-y*80+87;
							
						}
						
					}
					else if(canCapture) {
						
						tempStorage = board.getBoard()[y][x];
						
						board.getBoard()[y][x] = board.getBoard()[yIni][xIni];
						board.getBoard()[yIni][xIni] = null;
						
						board.getBoard()[y][x].x = x*80+87;
						board.getBoard()[y][x].y = 560-y*80+87;
						
						checkPattern = isInCheck(board);
						
						if( checkPattern == 0 || checkPattern == 2) {
							board.getBoard()[yIni][xIni] = board.getBoard()[y][x];
							
							board.getBoard()[y][x] = tempStorage;
							return false;
					}
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
							board.getBoard()[yIni][xIni] = board.getBoard()[y][x];
							
							board.getBoard()[y][x] = tempStorage;
							return false;
						}
						else {
							board.getBoard()[y][x].x = x*80+87;
							board.getBoard()[y][x].y = 560-y*80+87;
						}
						
					}
					else if(canCapture) {
						
						tempStorage = board.getBoard()[y][x];
						
						board.getBoard()[y][x] = board.getBoard()[yIni][xIni];
						board.getBoard()[yIni][xIni] = null;
						
						board.getBoard()[y][x].x = x*80+87;
						board.getBoard()[y][x].y = 560-y*80+87;
						
						checkPattern = isInCheck(board);
						
						if( checkPattern == 1 || checkPattern == 2) {
							board.getBoard()[yIni][xIni] = board.getBoard()[y][x];
							
							board.getBoard()[y][x] = tempStorage;
							return false;
						
						}
					}
				}
			}
		}
		
		
		
		
		
		//method promote that looks for promotions		 
		
		return canCapture;
		}
	 
	 
	 
	 public static int[] promote(Board board) {
		 int[] index = new int[] {-1,-1};
		 for(int i = 0; i < 8; i++) {
			 if( board.getBoard()[0][i] != null) {
				 if(board.getBoard()[0][i].getClass() == new Pawn("").getClass()) {
					 index[0] = 0;
					 index[1] = i;
					 return index;
					 
				 }
			 }
			 if( board.getBoard()[7][i] != null) {
				 if(board.getBoard()[7][i].getClass() == new Pawn("").getClass()) {
					 index[0] = 7;
					 index[1] = i;
					 return index;
				 }
			 }
			 
					 
			
	 
		 }
		 return index;
	 }
	 
    public static boolean canCapture(Board board ,int turn , int yIni,int xIni,int y,int x ){
    	
        boolean result = false;
    	Piece piece = board.getPiece(yIni, xIni);
    	if( yIni == y && xIni == x) {
    		return false;
    	}
    	
    	if(yIni < 0 || yIni > 7 || xIni < 0 || xIni > 7 || y < 0 || y > 7 || x < 0 || x > 7) {
    		return false;
    	}
    	
    	if(piece == null) {
    		return false;
    	}
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
     * 
     * @param board
     * @return		-1 if nothing		0 if white checkmated		1 if black checkmated	
     */
    public static int checkmate(Board board) {//add black
    	
    	Board copy = new Board(board.printBoard());
    	int currentCheck = isInCheck(board);
    	Piece temp;
    	int result = currentCheck;
    	
    	
    	//if white is in check
    	if(currentCheck == 0) {
    		
    		int[][] relevantSquares = relevantSquareCheck(board);
    		//look through 
    		for(int j = 0; j < 8 ; j++) {
        		
        		for(int i = 0; i < 8 ; i++) {
        			
        			//find every white piece
        			if(board.getPiece(j, i) != null) {
    	    			if(board.getPiece(j, i).color.equals("white") ) {
    	    				//for every board.getBoard()[j][i] check if it covers any relevantSquare
    	    				//if so try it and see if there is still a check
    	    				
    	    				//once a white piece is found, see if it can block the check
    	    				
    	    				
    	    				if(board.getPiece(j, i).getClass() == new King("").getClass()) {
    	    					
    	    					if( canKingMove(board, 0) ) {
    	    						currentCheck = -1;
    	    						
    	    					}
    	    					
    	    					
    	    				}
    	    				else {
	    	    				for(int y = 0; y < relevantSquares.length; y++) {
	    	    					
	    	    					//if it can cover one of the squares see if it would still be check
	    	    					if( canCapture(copy, -1, j, i, relevantSquares[y][0], relevantSquares[y][1]) ) {
	    	    						
	    	    						temp = copy.getBoard()[relevantSquares[y][0]][relevantSquares[y][1]];
	    	    						copy.getBoard()[relevantSquares[y][0]][relevantSquares[y][1]] = copy.getBoard()[j][i];
	    	    						copy.getBoard()[j][i] = null;
	    	    						result = isInCheck(copy);
	    	    						
	    	    						//if no longer in check than it is not checkmate
	    	    						if( result == -1 ) {
	    	    							currentCheck = -1;
	    	    						}
	    	    						
	    	    						
	    	    						//return to original state
	    	    						copy.getBoard()[j][i] = copy.getBoard()[relevantSquares[y][0]][relevantSquares[y][1]];
	    	    						copy.getBoard()[relevantSquares[y][0]][relevantSquares[y][1]] = temp;
	    	    						
	    	    						//this is for a special case where the method canCapture is en passant
	    	    						//this makes sure that the original board state remains
	    	    						if( !copy.printBoard().equals(board.printBoard()) ) {
	    	    							copy = new Board(board.printBoard());
	    	    						}
	    	    					}
	    	    				}
	    	    				
    	    				
    	    				}
    	    			}
        			}
        		}
    		}
    	}

    		//if black is in check
    	else if(currentCheck == 1) {
        		
        		int[][] relevantSquares = relevantSquareCheck(board);
        		//look through 
        		for(int j = 0; j < 8 ; j++) {
            		
            		for(int i = 0; i < 8 ; i++) {
            			
            			//find every black piece
            			if(board.getPiece(j, i) != null) {
        	    			if(board.getPiece(j, i).color.equals("black") ) {
        	    				//for every board.getBoard()[j][i] check if it covers any relevantSquare
        	    				//if so try it and see if there is still a check
        	    				
        	    				//once a white piece is found, see if it can block the check
        	    				
        	    				
        	    				if(board.getPiece(j, i).getClass() == new King("").getClass()) {
        	    					
        	    					if( canKingMove(board, 1) ) {
        	    						currentCheck = -1;
        	    						
        	    					}
        	    					
        	    					
        	    				}
        	    				else {
    	    	    				for(int y = 0; y < relevantSquares.length; y++) {
    	    	    					
    	    	    					//if it can cover one of the squares see if it would still be check
    	    	    					if( canCapture(copy, -1, j, i, relevantSquares[y][0], relevantSquares[y][1]) ) {
    	    	    						
    	    	    						temp = copy.getBoard()[relevantSquares[y][0]][relevantSquares[y][1]];
    	    	    						copy.getBoard()[relevantSquares[y][0]][relevantSquares[y][1]] = copy.getBoard()[j][i];
    	    	    						copy.getBoard()[j][i] = null;
    	    	    						result = isInCheck(copy);
    	    	    						
    	    	    						//if no longer in check than it is not checkmate
    	    	    						if( result == -1 ) {
    	    	    							currentCheck = -1;
    	    	    						}
    	    	    						
    	    	    						
    	    	    						//return to original state
    	    	    						copy.getBoard()[j][i] = copy.getBoard()[relevantSquares[y][0]][relevantSquares[y][1]];
    	    	    						copy.getBoard()[relevantSquares[y][0]][relevantSquares[y][1]] = temp;
    	    	    						
    	    	    						//this is for a special case where the method canCapture is en passant
    	    	    						//this makes sure that the original board state remains
    	    	    						if( !copy.printBoard().equals(board.printBoard()) ) {
    	    	    							copy = new Board(board.printBoard());
    	    	    						}
    	    	    					}
    	    	    				}
    	    	    				
        	    				
        	    				}
        	    			}
            			}
            		}
        		}

    	}
    	
    	
    	return currentCheck;
    }
    
    /**
     * @param board
     * @param color		0 is white		1 is black
     * @return
     */
    public static boolean canKingMove(Board board, int color ) {//add black
    	int tempnum;
    	boolean result = false;
    	Piece temp;
    	for(int j = 0; j < 8; j++) {
    		for(int i = 0; i < 8; i++) {
    			
    			if(color == 0) {
    				if(board.getPiece(j, i) != null && board.getPiece(j, i).getClass() == new King("").getClass() && board.getPiece(j, i).color.equals("white") ) {
    					
    					
    					int y = j-1;
    					int x = i;
    					//see if the king can capture
    					if( canCapture(board, -1, j, i, y, x ) ) {
    						
    						//make a copy of the piece that will be taken
    						temp = board.getBoard()[y][x];
    						
    						//move the pieces
    						board.getBoard()[y][x] = board.getBoard()[j][i];
    						board.getBoard()[j][i] = null;
    						
    						//test if there is check, if there isn't than the king can move
    						tempnum = isInCheck(board);
    						if(  tempnum != 0 && tempnum != 2 ) {
   							 result =  true;
   							 
    						}
    						
    						//move the pieces back to there original position
    						board.getBoard()[j][i] = board.getBoard()[y][x];
    						board.getBoard()[y][x] = temp;
    						
    					}
    					
    					
    					//repeat it for every direction
    					y = j+1;
    					x = i;
    					if( canCapture(board, -1, j, i, y, x ) ) {
    						
    						temp = board.getBoard()[y][x];
    						
    						board.getBoard()[y][x] = board.getBoard()[j][i];
    						board.getBoard()[j][i] = null;
    						
    						
    						
    						tempnum = isInCheck(board);
    						if(  tempnum != 0 && tempnum != 2 ) {
   							 result =  true;
   							 
    						}
    						
    						board.getBoard()[j][i] = board.getBoard()[y][x];
    						board.getBoard()[y][x] = temp;
    						
    					}
    					y = j;
    					x = i+1;
    					if( canCapture(board, -1, j, i, y, x ) ) {

    						temp = board.getBoard()[y][x];
    						
    						board.getBoard()[y][x] = board.getBoard()[j][i];
    						board.getBoard()[j][i] = null;
    						
    						tempnum = isInCheck(board);
    						if(  tempnum != 0 && tempnum != 2 ) {
   							 result =  true;
   							 
    						}
    						
    						board.getBoard()[j][i] = board.getBoard()[y][x];
    						board.getBoard()[y][x] = temp;
    						
    					}
    					y = j;
    					x = i-1;
    					if( canCapture(board, -1, j, i, y, x ) ) {

    						temp = board.getBoard()[y][x];
    						
    						board.getBoard()[y][x] = board.getBoard()[j][i];
    						board.getBoard()[j][i] = null;
    						
    						tempnum = isInCheck(board);
    						if(  tempnum != 0 && tempnum != 2 ) {
   							 result =  true;
   							 
    						}
    						
    						board.getBoard()[j][i] = board.getBoard()[y][x];
    						board.getBoard()[y][x] = temp;
    						
    					}
    					y = j+1;
    					x = i+1;
    					if( canCapture(board, -1, j, i, y, x ) ) {

    						temp = board.getBoard()[y][x];
    						
    						board.getBoard()[y][x] = board.getBoard()[j][i];
    						board.getBoard()[j][i] = null;
    						
    						tempnum = isInCheck(board);
    						if(  tempnum != 0 && tempnum != 2 ) {
   							 result =  true;
   							 
    						}
    						
    						board.getBoard()[j][i] = board.getBoard()[y][x];
    						board.getBoard()[y][x] = temp;
    						
    					}
    					y = j+1;
    					x = i-1;
    					if( canCapture(board, -1, j, i, y, x ) ) {

    						temp = board.getBoard()[y][x];
    						
    						board.getBoard()[y][x] = board.getBoard()[j][i];
    						board.getBoard()[j][i] = null;
    						
    						tempnum = isInCheck(board);
    						if(  tempnum != 0 && tempnum != 2 ) {
   							 result =  true;
   							 
    						}
    						
    						board.getBoard()[j][i] = board.getBoard()[y][x];
    						board.getBoard()[y][x] = temp;
    						
    					}
    					y = j-1;
    					x = i+1;
    					if( canCapture(board, -1, j, i, y, x ) ) {

    						temp = board.getBoard()[y][x];
    						
    						board.getBoard()[y][x] = board.getBoard()[j][i];
    						board.getBoard()[j][i] = null;
    						
    						tempnum = isInCheck(board);
    						if(  tempnum != 0 && tempnum != 2 ) {
   							 result =  true;
   							 
    						}
    						
    						board.getBoard()[j][i] = board.getBoard()[y][x];
    						board.getBoard()[y][x] = temp;
    						
    					}
    					y = j-1;
    					x = i-1;
    					if( canCapture(board, -1, j, i, y, x ) ) {

    						temp = board.getBoard()[y][x];
    						
    						board.getBoard()[y][x] = board.getBoard()[j][i];
    						board.getBoard()[j][i] = null;
    						
    						tempnum = isInCheck(board);
    						if(  tempnum != 0 && tempnum != 2 ) {
   							 result =  true;
   							 
    						}
    						
    						board.getBoard()[j][i] = board.getBoard()[y][x];
    						board.getBoard()[y][x] = temp;
    						
    					}
    					
    					
    					
    				}
    			}
    			
    			if(color == 1) {
					if(board.getPiece(j, i) != null && board.getPiece(j, i).getClass() == new King("").getClass() && board.getPiece(j, i).color.equals("black") ) {
						
						
						int y = j-1;
						int x = i;
						//see if the king can capture
						if( canCapture(board, -1, j, i, y, x ) ) {
							
							//make a copy of the piece that will be taken
							temp = board.getBoard()[y][x];
							
							//move the pieces
							board.getBoard()[y][x] = board.getBoard()[j][i];
							board.getBoard()[j][i] = null;
							
							//test if there is check, if there isn't than the king can move
							tempnum = isInCheck(board);
							if(  tempnum != 1 && tempnum != 2 ) {
								 result =  true;
								 
							}
							
							//move the pieces back to there original position
							board.getBoard()[j][i] = board.getBoard()[y][x];
							board.getBoard()[y][x] = temp;
							
						}
						
						
						//repeat it for every direction
						y = j+1;
						x = i;
						if( canCapture(board, -1, j, i, y, x ) ) {
							
							temp = board.getBoard()[y][x];
							
							board.getBoard()[y][x] = board.getBoard()[j][i];
							board.getBoard()[j][i] = null;
							
							
							
							tempnum = isInCheck(board);
							if(  tempnum != 1 && tempnum != 2 ) {
								 result =  true;
								 
							}
							
							board.getBoard()[j][i] = board.getBoard()[y][x];
							board.getBoard()[y][x] = temp;
							
						}
						y = j;
						x = i+1;
						if( canCapture(board, -1, j, i, y, x ) ) {
	
							temp = board.getBoard()[y][x];
							
							board.getBoard()[y][x] = board.getBoard()[j][i];
							board.getBoard()[j][i] = null;
							
							tempnum = isInCheck(board);
							if(  tempnum != 1 && tempnum != 2 ) {
								 result =  true;
								 
							}
							
							board.getBoard()[j][i] = board.getBoard()[y][x];
							board.getBoard()[y][x] = temp;
							
						}
						y = j;
						x = i-1;
						if( canCapture(board, -1, j, i, y, x ) ) {
	
							temp = board.getBoard()[y][x];
							
							board.getBoard()[y][x] = board.getBoard()[j][i];
							board.getBoard()[j][i] = null;
							
							tempnum = isInCheck(board);
							if(  tempnum != 1 && tempnum != 2 ) {
								 result =  true;
								 
							}
							
							board.getBoard()[j][i] = board.getBoard()[y][x];
							board.getBoard()[y][x] = temp;
							
						}
						y = j+1;
						x = i+1;
						if( canCapture(board, -1, j, i, y, x ) ) {
	
							temp = board.getBoard()[y][x];
							
							board.getBoard()[y][x] = board.getBoard()[j][i];
							board.getBoard()[j][i] = null;
							
							tempnum = isInCheck(board);
							if(  tempnum != 1 && tempnum != 2 ) {
								 result =  true;
								 
							}
							
							board.getBoard()[j][i] = board.getBoard()[y][x];
							board.getBoard()[y][x] = temp;
							
						}
						y = j+1;
						x = i-1;
						if( canCapture(board, -1, j, i, y, x ) ) {
	
							temp = board.getBoard()[y][x];
							
							board.getBoard()[y][x] = board.getBoard()[j][i];
							board.getBoard()[j][i] = null;
							
							tempnum = isInCheck(board);
							if(  tempnum != 1 && tempnum != 2 ) {
								 result =  true;
								 
							}
							
							board.getBoard()[j][i] = board.getBoard()[y][x];
							board.getBoard()[y][x] = temp;
							
						}
						y = j-1;
						x = i+1;
						if( canCapture(board, -1, j, i, y, x ) ) {
	
							temp = board.getBoard()[y][x];
							
							board.getBoard()[y][x] = board.getBoard()[j][i];
							board.getBoard()[j][i] = null;
							
							tempnum = isInCheck(board);
							if(  tempnum != 1 && tempnum != 2 ) {
								 result =  true;
								 
							}
							
							board.getBoard()[j][i] = board.getBoard()[y][x];
							board.getBoard()[y][x] = temp;
							
						}
						y = j-1;
						x = i-1;
						if( canCapture(board, -1, j, i, y, x ) ) {
	
							temp = board.getBoard()[y][x];
							
							board.getBoard()[y][x] = board.getBoard()[j][i];
							board.getBoard()[j][i] = null;
							
							tempnum = isInCheck(board);
							if(  tempnum != 1 && tempnum != 2 ) {
								 result =  true;
								 
							}
							
							board.getBoard()[j][i] = board.getBoard()[y][x];
							board.getBoard()[y][x] = temp;
							
						}
						
						
						
					}
				
	    		}
	    	}
    	}
    	return result;
    	
    }
    
    public static boolean stalemate(Board board, int turn) {//add black
    	
    	//make a copy so that no bugs happen
    	Board test = new Board(board.printBoard());
    	boolean result = false;
    	
    	if(isInCheck(board) != -1) {
    		return false;
    	}
    	//white turn
    	if(turn % 2 == 0) {
    		for(int j = 0; j < 8 ; j++) {
        		
        		for(int i = 0; i < 8 ; i++) {
        			
        			//find every white piece
        			if(test.getPiece(j, i) != null) {
    	    			if(test.getPiece(j, i).color.equals("white")) {
    	    				
    	    				//if the piece is the king 
    	    				if(test.getPiece(j, i).getClass() == new King("").getClass() ) {
    	    					//see if the king has anywhere it can move
    	    					if( canKingMove(test, 0) ) {
    	    						 //System.out.println("j"+j+" i"+i);
    	    						result = true;
    	    					}
    	    				}
    	    				
	    	    			else {
	    	    				
	    	    				//look at every index to see if the piece can move there
	    	    				for(int x = 0; x < 64; x++) {
	    	    					
	    	    					 if( canCapture(test, -1, j, i, x/8, x%8) ) {
	    	    						 
	    	    						 //check if when this piece moves  if the king would be in check
	    	    						 if(isInCheck(test) != 0 ) {
	    	    							 //System.out.println("j"+j+" i"+i+" x/8"+x/8+" x%8"+x%8);
	    	    						 		
	    	    						 	result = true;
	    	    						 }
	    	    					 }
	    	    					
	    	    				}
	    	    			}
    	    			}
        			}
        		}
    		}
    	}
    	//black turn
    	else {
    		for(int j = 0; j < 8 ; j++) {
        		
        		for(int i = 0; i < 8 ; i++) {
        			
        			//find every white piece
        			if(test.getPiece(j, i) != null) {
    	    			if(test.getPiece(j, i).color.equals("black")) {
    	    				
    	    				//if the piece is the king 
    	    				if(test.getPiece(j, i).getClass() == new King("").getClass() ) {
    	    					//see if the king has anywhere it can move
    	    					if( canKingMove(test, 1) ) {
    	    						 //System.out.println("j"+j+" i"+i);
    	    						result = true;
    	    					}
    	    				}
    	    				
	    	    			else {
	    	    				
	    	    				//look at every index to see if the piece can move there
	    	    				for(int x = 0; x < 64; x++) {
	    	    					
	    	    					 if( canCapture(test, -1, j, i, x/8, x%8) ) {
	    	    						 
	    	    						 //check if when this piece moves  if the king would be in check
	    	    						 if(isInCheck(test) != 1 ) {
	    	    							 //System.out.println("j"+j+" i"+i+" x/8"+x/8+" x%8"+x%8);
	    	    						 		
	    	    						 	result = true;
	    	    						 }
	    	    					 }
	    	    					
	    	    				}
	    	    			}
    	    			}
        			}
        		}
    		}
    	}
    	
    	
    	return !result;
    }
    
    /**
     * 
     * @param board
     * @return 			-1 if not in check 		0 is white is in check		 1 if black is in check		2 if both are in check (not legal)
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
	    				   checkDirection(board, j, i, 1, -1) == true || checkDirection(board, j, i, -1, 1) == true) {
	    					
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
    
    
    /**
     * This method is meant to be used to find all the possible squares
     * that could block checkmate. This includes the square where the piece
     * that is delivering check is.
     * @param board
     * @return a list of index's that would possibly block checkmate
     */
    public static int[][] relevantSquareCheck(Board board) {
    	ArrayList<int[]> result = new ArrayList<int[]>();
    	
    	int[] current;
    	int x = 0;
    	int y = 0;
    	
    	for(int j = 0; j < 8 ; j++) {
    		
    		for(int i = 0; i < 8 ; i++) {
    			
    			//find the index of the king
    			if(board.getPiece(j, i) != null) {
	    			if(board.getPiece(j, i).getClass() == new King(null).getClass()) {
	    				String color = board.getPiece(j, i).getColor();
	    				
	    				current = relevantSquare(board, j, i, 1, 0);
	    				
	    				if( current[0] != -1 ) {
	    					y = j;
	    					x = i;
	    					while(y < current[0] && x == current[1]) {
	    						y+=1;
	    						
	    						result.add(new int[] {y,x});
	    					}
	    					
	    					result.add(current);
	    					
	    				}
	    				
	    				current = relevantSquare(board, j, i, -1, 0);
	    				
	    				if( current[0] != -1 ) {
	    					y = j;
	    					x = i;
	    					while(y > current[0] && x == current[1]) {
	    						y+=-1;
	    						
	    						result.add(new int[] {y,x});
	    					}
	    					
	    					result.add(current);
	    					
	    				}
	    				
	    				current = relevantSquare(board, j, i, 0, 1);
	    				
	    				if( current[0] != -1 ) {
	    					y = j;
	    					x = i;
	    					while(y == current[0] && x < current[1]) {
	    						x+=1;
	    						
	    						result.add(new int[] {y,x});
	    					}
	    					
	    					result.add(current);
	    					
	    				}
	    				
	    				current = relevantSquare(board, j, i, 0, -1);
	    				
	    				if( current[0] != -1 ) {
	    					y = j;
	    					x = i;
	    					while(y  == current[0] && x > current[1]) {
	    						x+=-1;
	    						
	    						result.add(new int[] {y,x});
	    					}
	    					
	    					result.add(current);
	    					
	    				}
	    				
	    				current = relevantSquare(board, j, i, 1, 1);//this works only
	    				
	    				if( current[0] != -1 ) {
	    					y = j;
	    					x = i;
	    					while(y < current[0] && x< current[1]) {
	    						y+=1;
	    						x+=1;
	    						
	    						result.add(new int[] {y,x});
	    					}
	    					
	    					result.add(current);
	    					
	    				}
	    				
	    				current = relevantSquare(board, j, i, -1, -1);
	    				
	    				if( current[0] != -1 ) {
	    					y = j;
	    					x = i;
	    					while(y > current[0] && x > current[1]) {
	    						y+=-1;
	    						x+=-1;
	    						
	    						result.add(new int[] {y,x});
	    					}
	    					
	    					result.add(current);
	    					
	    				}
	    				
	    				current = relevantSquare(board, j, i, 1, -1);
	    				
	    				if( current[0] != -1 ) {
	    					y = j;
	    					x = i;
	    					while(y < current[0] && x > current[1]) {
	    						y+=1;
	    						x+=-1;
	    						
	    						result.add(new int[] {y,x});
	    					}
	    					
	    					result.add(current);
	    					
	    				}
	    				
	    				current = relevantSquare(board, j, i, -1, 1);
	    				
	    				if( current[0] != -1 ) {
	    					y = j;
	    					x = i;
	    					while(y > current[0] && x< current[1]) {
	    						y+=-1;
	    						x+=1;
	    						
	    						result.add(new int[] {y,x});
	    					}
	    					
	    					result.add(current);
	    					
	    				}
	    				
	    				
	    				if( findHorse(board, -1, j, i, 2, -1) != -1) {
	    					result.add(new int[] {j+2,i-1});
	    				}
	    				if( findHorse(board, -1, j, i, 2, -1) != -1) {
	    					result.add(new int[] {j-2,i+1});
	    				}
	    				if( findHorse(board, -1, j, i, 2, -1) != -1) {
	    					result.add(new int[] {j+2,i+1});
	    				}
	    				if( findHorse(board, -1, j, i, 2, -1) != -1) {
	    					result.add(new int[] {j-2,i-1});
	    				}
	    				if( findHorse(board, -1, j, i, 2, -1) != -1) {
	    					result.add(new int[] {j+1,i-2});
	    				}
	    				if( findHorse(board, -1, j, i, 2, -1) != -1) {
	    					result.add(new int[] {j-1,i+2});
	    				}
	    				if( findHorse(board, -1, j, i, 2, -1) != -1) {
	    					result.add(new int[] {j-1,i-2});
	    				}
	    				if( findHorse(board, -1, j, i, 2, -1) != -1) {
	    					result.add(new int[] {j+1,i+2});
	    				}
	    				
	    				/*
	    				result = findHorse(board, result, j, i, 2, -1);
	    				result = findHorse(board, result, j, i, -2, 1);
	    				result = findHorse(board, result, j, i, 2, 1);
	    				result = findHorse(board, result, j, i, -2, -1);
	    				result = findHorse(board, result, j, i, 1, -2);
	    				result = findHorse(board, result, j, i, -1, 2);
	    				result = findHorse(board, result, j, i, -1, -2);
	    				result = findHorse(board, result, j, i,1 , 2);
	    				*/
	    			}
    			}
    		}}
    	
    	int[][] results = new int[result.size()][];
    	for(int i = 0; i < result.size();i++) {
    		results[i] = result.get(i);
    	}
    	
    	return results;
    	
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
            throw new IndexOutOfBoundsException("starting position is not on the board");
        }
        if(y <0 || y >7 || x <0 || x >7){
            throw new IndexOutOfBoundsException("destination is not on the board");
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
        }
        else if(yIni - y>0 && xIni - x == 0){//down
        	result = isNotObstructed(board,yIni,xIni,y,x,-1,0);
        }
        else if(xIni-x<0 && yIni - y == 0){//right
        	result = isNotObstructed(board,yIni,xIni,y,x,0,1);
        }
        else if(xIni - x>0 && yIni - y == 0){//left 
        	result = isNotObstructed(board,yIni,xIni,y,x,0,-1);
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
        	if(yIni == 3 && xIni - x == -1 && board.getBoard()[y][x] == null &&  
        			board.getBoard()[yIni][1+xIni] !=  null && board.getBoard()[yIni][1+xIni].getClass() == new Pawn("").getClass() ) {//enPassant left
        		
        		if(turn - ( (Pawn)board.getBoard()[yIni][1+xIni]).jump < 2) {
        			result = true;
        			board.getBoard()[yIni][1+xIni] = null;
        		}
        	}
        	else if(yIni == 3 && xIni - x == 1 && board.getBoard()[y][x] == null && 
        			board.getBoard()[yIni][-1+xIni] != null && board.getBoard()[yIni][-1+xIni].getClass() == new Pawn("").getClass() ) {//enPassant right
        		
        		if(turn - ( (Pawn)board.getBoard()[yIni][-1+xIni]).jump < 2) {
        			result = true;
        			board.getBoard()[yIni][-1+xIni] = null;
        		}
        	}
        	//move 1
        	else if(yIni-y == 1 && xIni - x == 0) {//fixx
        		if(board.getBoard()[yIni-1][xIni] != null) {
        			result = false;
        		}
        		else {
        			result = true;
        		}
        		
        		
        	}
        	//move 2
        	else if(yIni - y == 2 && xIni - x == 0 && yIni == 6) {//fix
        		
        		if(board.getBoard()[yIni-1][xIni] != null || board.getBoard()[yIni-2][xIni] != null) {
        			result = false;
        		}
        		else {
        			result = true;
        		}
        		
        		
        		((Pawn)board.getBoard()[yIni][xIni]).jump  = turn;
        	}
        	//capture left
        	else if(yIni - y == 1 && xIni - x == -1) {
        		if(board.getBoard()[y][x] != null && board.getBoard()[y][x].getColor() == "white") {
        				result = true;
        		}
        		
        	}
        	//capture right
        	else if(yIni - y == 1 && xIni - x == 1) {
        		if(board.getBoard()[y][x] != null && board.getBoard()[y][x].getColor() == "white") {
    				result = true;
        		}
        	}
        }
        
        //white
        else if(board.getBoard()[yIni][xIni].getColor() == "white") {
        	if(yIni == 4 && xIni - x == -1 && board.getBoard()[y][x] == null &&
        			board.getBoard()[yIni][1+xIni] != null && board.getBoard()[yIni][1+xIni].getClass() == new Pawn("").getClass() ) {//enPassant left
        		if(turn - ( (Pawn)board.getBoard()[yIni][1+xIni]).jump < 2) {
        			result = true;
        			board.getBoard()[yIni][1+xIni] = null;
        		}
        	}
        	else if(yIni == 4 && xIni - x == 1 && board.getBoard()[y][x] == null &&
        			board.getBoard()[yIni][-1+xIni] != null && board.getBoard()[yIni][-1+xIni].getClass() == new Pawn("").getClass() ) {//enPassant left
        		if(turn - ( (Pawn)board.getBoard()[yIni][-1+xIni]).jump < 2) {
        			result = true;
        			board.getBoard()[yIni][-1+xIni] = null;
        		}
        	}
        	//move 1
        	else if(yIni-y == -1 && xIni - x == 0) {
        		
            		if(board.getBoard()[yIni+1][xIni] != null) {
            			result = false;
            		}
            		else {
            			result = true;
            		}
            		
        	}
        	//move 2
        	else if(yIni - y == -2 && xIni - x == 0 && yIni == 1) {
        		if(board.getBoard()[yIni+1][xIni] != null || board.getBoard()[yIni+2][xIni] != null) {
        			result = false;
        		}
        		else {
        			result = true;
        		}
        		
        		((Pawn)board.getBoard()[yIni][xIni]).jump  = turn;
        	}
        	//capture left
        	else if(yIni - y == -1 && xIni - x == 1) {
        		if(board.getBoard()[y][x] != null && board.getBoard()[y][x].getColor() == "black") {
        				result = true;
        		}
        	}
        	//capture right
        	else if(yIni - y == -1 && xIni - x == -1) {
        		if(board.getBoard()[y][x] != null && board.getBoard()[y][x].getColor() == "black") {
    				result = true;
        		}
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
        }
        else if(yIni - y <0 && xIni - x < 0){//up right
        	result = isNotObstructed(board,yIni,xIni,y,x,1,1);
        }
        else if( yIni - y > 0 && xIni-x > 0){//down left
        	result = isNotObstructed(board,yIni,xIni,y,x,-1,-1);
        }
        else if(yIni - y > 0 && xIni - x < 0){//down right
        	result = isNotObstructed(board,yIni,xIni,y,x,-1,1);
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
    	while((y <= 7 && y >= 0 && x <= 7 && x >= 0)) {
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
    
    private static int[] relevantSquare(Board board, int yIni, int xIni,  int yStep,int xStep){
        //      the next step is y x                   make sure it in range
    	int x = xIni;
    	int y = yIni;
    	while((y <= 7 && y >= 0 && x <= 7 && x >= 0)) {
    		x += xStep;
    		y += yStep;
    		
    		
    		if(y == 8 || y == -1 || x == 8 || x == -1) {
    			return new int [] {-1,-1};
    		}
            
    		//if there is a piece is the way this will return false
    		if(board.getPiece(yIni, xIni) != null) {
    			 if(canCapture(board, -1, y, x, yIni, xIni)) {
    				 //System.out.println(board.getPiece(y, x) + "  hi");
    				 return new int [] {y,x};
    			 }
    		}
    			
    	}
    	
    	
    	return new int [] {-1,-1};
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
    	
        Board board = new Board("null null null null null null null null \r\n"
        		+ "null null Kingwhite null null null null null \r\n"
        		+ "null null Kingblack null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n"
        		+ "null null null null null null null null \r\n");
        
        System.out.println(canKingMove(board, 0));
        
        System.out.println(board.printBoard());

    }
}
