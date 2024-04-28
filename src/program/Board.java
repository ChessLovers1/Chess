package program;

import pieces.*;

public class Board {
    /*

    Project Board at all time (Canvas)
    
    Update Board/Pieces as game goes on


    */
    Piece[][] Board;
    
    public Board(){
        this.Board =  new Piece[8][8];

        //populate the board

        for(int i = 0; i < 8; i++){
            Board[1][i] = new Pawn("white");
        }
        for(int i = 0; i < 8; i++){
            Board[6][i] = new Pawn("black");
        }


        for(int i = 0; i < 2; i++){
            Board[0][i*7] = new Rook("white");
        }
        for(int i = 0; i < 2; i++){
            Board[7][i*7] = new Rook("black");
        }

        for(int i = 0; i < 2; i++){
            Board[0][2 +i*3] = new Bishop("white");
        }
        for(int i = 0; i < 2; i++){
            Board[7][2 +i*3] = new Bishop("black");
        }

        for(int i = 0; i < 2; i++){
            Board[0][1 +i*5] = new Knight("white");
        }
        for(int i = 0; i < 2; i++){
            Board[7][1 +i*5] = new Knight("black");
        }

       
        Board[0][3] = new Queen("white");
        Board[7][3] = new Queen("black");

        Board[0][4] = new King("white");
        Board[7][4] = new King("black");
        
    }

   

    public Board(String[][] AlgebraicBoard ){
        //currentPosition is a list of moves that the board is meant to start with
    	
    }

    public Board(String currentPosition){
         //Custom boards
    	//Takes string inputs as follows:
    	/*
Rook Knight Bishop Queen King Bishop Knight Rook 
Pawn Pawn Pawn Pawn Pawn Pawn Pawn Pawn 
null null null null null null null null 
null null null null null null null null 
null null null null null null null null 
null null null null null null null null 
Pawn Pawn Pawn Pawn Pawn Pawn Pawn Pawn 
Rook Knight Bishop Queen King Bishop Knight Rook 
    	 */
    	this.Board =  new Piece[8][8];
    	
    	
    	currentPosition = currentPosition.replace("\r\n", "");
    	String[] OrderedPieceList = currentPosition.split(" ");
    	//for(int i = 0 ; i< OrderedPieceList.length;i++) {
    	//	System.out.println(OrderedPieceList[i]);
    	//}
    	for(int j = 0; j<8; j++) {
    		for(int i = 0; i<8; i++) {
    			
    			if(OrderedPieceList[i+j*8].equals("Rookwhite")) {
    				this.Board[j][i] = new Rook("white") ;	
    			}
    			else if(OrderedPieceList[i+j*8].equals("Rookblack")) {
    				this.Board[j][i] = new Rook("black") ;	
    			}
    			
    			
    			else if(OrderedPieceList[i+j*8].equals("Queenwhite")) {
    				this.Board[j][i] = new Queen("white") ;	
    			}
    			else if(OrderedPieceList[i+j*8].equals("Queenblack")) {
    				this.Board[j][i] = new Queen("black") ;	
    			}
    			
    			
    			else if(OrderedPieceList[i+j*8].equals("Pawnwhite")) {
    				this.Board[j][i] = new Pawn("white") ;	
    			}
    			else if(OrderedPieceList[i+j*8].equals("Pawnblack")) {
    				this.Board[j][i] = new Pawn("black") ;	
    			}
    			
    			
    			else if(OrderedPieceList[i+j*8].equals("Knightwhite")) {
    				this.Board[j][i] = new Knight("white") ;	
    			}
    			else if(OrderedPieceList[i+j*8].equals("Knightblack")) {
    				this.Board[j][i] = new Knight("black") ;	
    			}
    			
    			
    			else if(OrderedPieceList[i+j*8].equals("Bishopwhite")) {
    				this.Board[j][i] = new Bishop("white") ;	
    			}
    			else if(OrderedPieceList[i+j*8].equals("Bishopblack")) {
    				this.Board[j][i] = new Bishop("black") ;	
    			}
    			
    			
    			
    			else if(OrderedPieceList[i+j*8].equals("Kingwhite")) {
    				this.Board[j][i] = new King("white") ;	
    			}
    			else if(OrderedPieceList[i+j*8].equals("Kingblack")) {
    				this.Board[j][i] = new King("black") ;	
    			}
    			
    			else {
    				this.Board[j][i] = null;
    			}
    			
    			
    			
    			
        	}
    	}
    	
    	
    }


    public Piece getPiece(int j, int i){
        return Board[j][i];
    }

    public Piece[][] getBoard(){
        return Board;
    }

    public static int[] convertToIndex(String coord){
        //returns usable index for Board
        int[] index = new int[2];

        int toASCII = (int) (coord.toLowerCase().charAt(0));

        toASCII = toASCII-97;
        index[1] = toASCII;
        
        index[0] = Integer.valueOf(coord.substring(1))- 1 ;
        
        return index;

    }
    public void printBoard(){

        for(int j = 0; j<8;j++){
            System.out.println();
            for(int i = 0; i < 8;i++){
            	
            	if(this.getPiece(j, i) != null){ 
            		System.out.print(this.getPiece(j, i)+this.getPiece(j, i).getColor()+" ");
            	}
            	else {
            		System.out.print(this.getPiece(j, i)+" ");
            	 }
            	
            }
        }
    }

    public static String convertToCoord(int[] index){
        //returns chess coord
        String coord = "";

        coord = Character.toString ((char) 97+index[1]);
        
        coord = coord + String.valueOf(index[0]);


        return coord;
    }



    public static void main(String arg[]){

       
    }
}
