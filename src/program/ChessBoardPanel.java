package program;

import pieces.*;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
    
public class ChessBoardPanel extends JPanel {
    public int x;

    public int y;
    
    int[] tempPosition = new int[2];
    int[] position = new int[] {-1,-1}; 
    int xDimension = 0;
    
    int yDimension = 0;
    //Board
    private Image board;
    
    //Pieces
    private Image blackBishop;
    private Image whiteBishop;

    private Image blackRook;
    private Image whiteRook;
    
    private Image blackKnight;
    private Image whiteKnight;
    
    private Image blackQueen;
    private Image whiteQueen;
    
    private Image blackKing;
    private Image whiteKing;
    
    private Image blackPawn;
    private Image whitePawn;
  
    private imageObject[][] Board = new imageObject[8][8];
  
    

    //To get the board intop a var
    Board daBoard = new Board("Rookwhite Knightwhite Bishopwhite Queenwhite Kingwhite Bishopwhite Knightwhite Rookwhite \r\n"
    		+ "pawnwhite null Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite \r\n"
    		+ "Pawnblack null null null null null null null \r\n"
    		+ "null null null null null null null null \r\n"
    		+ "null null null null null null null null \r\n"
    		+ "Rookblack null null null null null null null \r\n"
    		+ "Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack \r\n"
    		+ "null Knightblack Bishopblack Queenblack Kingblack Bishopblack Knightblack Rookblack ");    
    
    
    
    Piece[][] List = daBoard.getBoard();
    
    //Pieces
    Piece daPiece = new Piece();
    
    public ChessBoardPanel() {
        ImageIcon obj = new ImageIcon("./src/img/z-chessBoardV1.png");
        board = obj.getImage();
        
        
        // Bishop
        blackBishop = new ImageIcon("./src/img/z-Black-bishop-chess.png").getImage();
        whiteBishop = new ImageIcon("./src/img/z-White-bishop-chess.png").getImage();
        
        // Rook
        blackRook = new ImageIcon("./src/img/z-Black-rook-chess.png").getImage();
        whiteRook = new ImageIcon("./src/img/z-White-rook-chess.png").getImage();
        
        // Knight
        blackKnight = new ImageIcon("./src/img/z-Black-knight-chess.png").getImage();
        whiteKnight = new ImageIcon("./src/img/z-White-knight-chess.png").getImage();
        
        // Queen
        blackQueen = new ImageIcon("./src/img/z-Black-queen-chess.png").getImage();
        whiteQueen = new ImageIcon("./src/img/z-White-queen-chess.png").getImage();
        
        // King
        blackKing = new ImageIcon("./src/img/z-Black-king-chess.png").getImage();
        whiteKing = new ImageIcon("./src/img/z-White-king-chess.png").getImage();
        
        // Pawn
        blackPawn = new ImageIcon("./src/img/z-Black-pawn-chess.png").getImage();
        whitePawn = new ImageIcon("./src/img/z-White-pawn-chess.png").getImage();
        
      
        //set up the board
        xDimension = (getWidth() - board.getWidth(this)) / 2;
        yDimension = (getHeight() - board.getHeight(this)) / 2;
        
        
        int varx;
        int vary;
for (int xvalue = 0; xvalue<8; xvalue++) {
        	
            vary = 560 - xvalue * 80 + 87 ;  
            
        	//Checks the y value
            for (int yvalue = 0; yvalue<8; yvalue++) {
             varx =  yvalue * 80 + 87; 
             
             
         	if (List[xvalue][yvalue] != null) {
    			
            	//if (List[x][y] instanceof Bishop) 
            	if (List[xvalue][yvalue] instanceof Bishop) { 
            		if (List[xvalue][yvalue].getColor() == "white") //White
            		{ Board[xvalue][yvalue] = new imageObject(whiteBishop, varx, vary);}
            		
            		if (List[xvalue][yvalue].getColor() == "black") //black
            		{Board[xvalue][yvalue] = new imageObject(blackBishop, varx, vary);}} 
            	if (List[xvalue][yvalue] instanceof Rook) { 
            		if (List[xvalue][yvalue].getColor() == "white") //White
            		{ Board[xvalue][yvalue] = new imageObject(whiteRook, varx, vary);}//Board[y][x] = new imageObject(whiteBishop, x+varx, y+vary);
            		
            		if (List[xvalue][yvalue].getColor() == "black") //black
            		{Board[xvalue][yvalue] = new imageObject(blackRook, varx, vary);}} 
            	
            	if (List[xvalue][yvalue] instanceof Queen) { 
            		if (List[xvalue][yvalue].getColor() == "white") //White
            		{ Board[xvalue][yvalue] = new imageObject(whiteQueen, varx, vary);}
            		
            		if (List[xvalue][yvalue].getColor() == "black") //black
            		{Board[xvalue][yvalue] = new imageObject(blackQueen, varx, vary);}}
            	
            	if (List[xvalue][yvalue] instanceof King) { 
            		if (List[xvalue][yvalue].getColor() == "white") //White
            		{ Board[xvalue][yvalue] = new imageObject(whiteKing, varx, vary);}
            		
            		if (List[xvalue][yvalue].getColor() == "black") //black
            		{Board[xvalue][yvalue] = new imageObject(blackKing, varx, vary);}}
            	
            	if (List[xvalue][yvalue] instanceof Pawn) { 
            		if (List[xvalue][yvalue].getColor() == "white") //White
            		{ Board[xvalue][yvalue] = new imageObject(whitePawn, varx, vary);}
            		
            		if (List[xvalue][yvalue].getColor() == "black") //black
            		{Board[xvalue][yvalue] = new imageObject(blackPawn, varx, vary);}}
            	
            	if (List[xvalue][yvalue] instanceof Pawn) { 
            		if (List[xvalue][yvalue].getColor() == "white") //White
            		{ Board[xvalue][yvalue] = new imageObject(whitePawn, varx, vary);}
            		
            		if (List[xvalue][yvalue].getColor() == "black") //black
            		{Board[xvalue][yvalue] = new imageObject(blackPawn, varx, vary);}}
            
     
            	if (List[xvalue][yvalue] instanceof Knight) { 
            		if (List[xvalue][yvalue].getColor() == "white") //White
            		{ Board[xvalue][yvalue] = new imageObject(whiteKnight, varx, vary);}
            		
            		if (List[xvalue][yvalue].getColor() == "black") //black
            		{Board[xvalue][yvalue] = new imageObject(blackKnight, varx, vary);}}
         	}
             
            }
		}

        
        addMouseMotionListener(new MouseAdapter() { 
            public void mouseDragged(MouseEvent me) {
         
              x = me.getX();
              y = me.getY();
              System.out.println("x : "+x+" y : "+y);
              System.out.println("xDimension "+ xDimension+ " yDimension " + yDimension );
              
              
              if(position[0] == -1) {
	              //X position
	              if(x > xDimension+80*2 && x <xDimension+80*3) {
	            	  position[1] = 1;
	              }
	              else if(x > xDimension+80 && x <xDimension+80*2) {
	            	  position[1] = 0;
	              }
	              else if(x > xDimension+80*3 && x <xDimension+80*4) {
	            	  position[1] = 2;
	              }
	              else if(x > xDimension+80*4 && x <xDimension+80*5) {
	            	  position[1] = 3;
	              }
	              else if(x > xDimension+80*5 && x <xDimension+80*6) {
	            	  position[1] = 4;
	              }
	              else if(x > xDimension+80*6 && x <xDimension+80*7) {
	            	  position[1] = 5;
	              }
	              else if(x > xDimension+80*7 && x <xDimension+80*8) {
	            	  position[1] = 6;
	              }
	              else if(x > xDimension+80*8 && x <xDimension+80*9) {
	            	  position[1] = 7;
	              }
	              
	              //Y position
	              if( y > yDimension+80 && y < yDimension+80*2) {
	            		  position[0] = 7;
	              }
	              else if( y > yDimension+80*2 && y < yDimension+80*3) {
	        		  position[0] = 6;
	              }
	              else if( y > yDimension+80*3 && y < yDimension+80*4) {
	        		  position[0] = 5;
	              }
	              else if( y > yDimension+80*4 && y < yDimension+80*5) {
	        		  position[0] = 4;
	              }
	              else if( y > yDimension+80*5 && y < yDimension+80*6) {
	        		  position[0] = 3;
	              }
	              else if( y > yDimension+80*6 && y < yDimension+80*7) {
	        		  position[0] = 2;
	              }
	              else if( y > yDimension+80*7 && y < yDimension+80*8) {
	        		  position[0] = 1;
	              }
	              else if( y > yDimension+80*8 && y < yDimension+80*9) {
	        		  position[0] = 0;
	              }
             
              }
              
              
              
              if(position[0] != -1) {
            	  
            	  
	              if(Board[position[0]][position[1]] != null) {
	            	 moveImg(Board[position[0]][position[1]], x-30, y-30); 
	              }
              }
              }});  
        
        
        addMouseListener(new MouseAdapter() {
        	public void mouseReleased(MouseEvent me) {
        		
        		
        		//X position
	              if(x > xDimension+80*2 && x <xDimension+80*3) {
	            	  tempPosition[1] = 1;
	              }
	              else if(x > xDimension+80 && x <xDimension+80*2) {
	            	  tempPosition[1] = 0;
	              }
	              else if(x > xDimension+80*3 && x <xDimension+80*4) {
	            	  tempPosition[1] = 2;
	              }
	              else if(x > xDimension+80*4 && x <xDimension+80*5) {
	            	  tempPosition[1] = 3;
	              }
	              else if(x > xDimension+80*5 && x <xDimension+80*6) {
	            	  tempPosition[1] = 4;
	              }
	              else if(x > xDimension+80*6 && x <xDimension+80*7) {
	            	  tempPosition[1] = 5;
	              }
	              else if(x > xDimension+80*7 && x <xDimension+80*8) {
	            	  tempPosition[1] = 6;
	              }
	              else if(x > xDimension+80*8 && x <xDimension+80*9) {
	            	  tempPosition[1] = 7;
	              }
	              
	              //Y position
	              if( y > yDimension+80 && y < yDimension+80*2) {
	            	  tempPosition[0] = 7;
	              }
	              else if( y > yDimension+80*2 && y < yDimension+80*3) {
	            	  tempPosition[0] = 6;
	              }
	              else if( y > yDimension+80*3 && y < yDimension+80*4) {
	            	  tempPosition[0] = 5;
	              }
	              else if( y > yDimension+80*4 && y < yDimension+80*5) {
	            	  tempPosition[0] = 4;
	              }
	              else if( y > yDimension+80*5 && y < yDimension+80*6) {
	            	  tempPosition[0] = 3;
	              }
	              else if( y > yDimension+80*6 && y < yDimension+80*7) {
	            	  tempPosition[0] = 2;
	              }
	              else if( y > yDimension+80*7 && y < yDimension+80*8) {
	            	  tempPosition[0] = 1;
	              }
	              else if( y > yDimension+80*8 && y < yDimension+80*9) {
	            	  tempPosition[0] = 0;
	              }

        		
        		
        		
        		//do stuff to find out if it was a valid move
        		if(Chess.validMove(daBoard, position[0], position[1], tempPosition[0], tempPosition[1])) {
        			moveImg(Board[position[0]][position[1]], tempPosition[1]*80+87+xDimension, 560-tempPosition[0]*80+yDimension+87);
        			//Board[tempPosition[0]][tempPosition[1]] = Board[position[0]][position[1]];
        			//List[tempPosition[0]][tempPosition[1]] = List[position[0]][position[1]];
        		
        			//The current problem is that there is two arrays one Piece[][] and one imageObject[][]
        			//This is unnecessary because imageObject is no longer extends jFrame and only stores simple information
        			//the picture for ever piece should be a part of their classes
        			
        			
        			//after this is fixed it will be easier to swap the position of the pieces and then simply repaint(); after to update the position of the pieces
        		}
        		
        		
        		else if(Board[position[0]][position[1]] != null) {
	        		moveImg(Board[position[0]][position[1]], position[1]*80+87+xDimension, 560-position[0]*80+yDimension+87);
        		}
        		
        		position[0] = -1;
        		position[1] = -1;
        		
        		
        	}});
        
        
        
        
        
        
       
		
        
    }
    
    
    public void moveImg(imageObject piece, int x, int y){
    	
        piece.x = x-xDimension;
        piece.y = y-yDimension;
         
        
        
        repaint();
        
        
    }

    
    
    protected void paintComponent(Graphics g) {//find out what counts as a graphic
        super.paintComponent(g);
        xDimension = (getWidth() - board.getWidth(this)) / 2;
        yDimension = (getHeight() - board.getHeight(this)) / 2;
        
       //g.drawImage(Board[xvalue][yvalue].image, Board[xvalue][yvalue].x,  Board[xvalue][yvalue].y,65,65,null); 
       
        g.drawImage(board, xDimension, yDimension, null);
        int varx;
        int vary;
        for (int xvalue = 0; xvalue<8; xvalue++) {
        	
        	
            vary = xvalue * 80 + 87 ;  
            
            
        	//Checks the y value
            for (int yvalue = 0; yvalue<8; yvalue++) {
             varx = yvalue * 80 + 87; 
             g.drawLine(varx+xDimension, vary+yDimension, varx+xDimension, vary+yDimension);
            }}
        
        for(int i = 0; i < Board.length; i++) {
        	for(int z = 0; z < Board[1].length; z++) {
        		if(Board[z][i] != null) {
        			
        			g.drawImage(Board[z][i].image, Board[z][i].x+xDimension,  Board[z][i].y+yDimension,65,65,null); 
        			
        			
        		}
        	}
        }
           
    }
    
}