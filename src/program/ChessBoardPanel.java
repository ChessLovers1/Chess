package program;

import pieces.*;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
    
public class ChessBoardPanel extends JPanel {
    public int x;

    public int y;
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
    

    //To get the board intop a var
    Board daBoard = new Board();    
    Piece List[][] = daBoard.getBoard();
    
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
        
    }
    
    
    public void moveImg(int x, int y){

        this.x = x;
        this.y = y;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //getWidth = screen width 
        //pic.getWidth = image width
        int x = (getWidth() - board.getWidth(this)) / 2;
        int y = (getHeight() - board.getHeight(this)) / 2;
        
        //Board
        g.drawImage(board, x, y, null);
        
        //---------------------------------------------------------
        //---------------------------------------------------------
        //---------------------------------------------------------

        
        //Variable to help control where the Piece images go once centered for x value
        int varx = 87;  // 87 is a1
		   		// 167 is b1
		        	// Difference in y is 80
        
        			// MIN: 87
        		        // MAX: 647
        
       
        //---------------------------------------------------------
        //---------------------------------------------------------
        //---------------------------------------------------------

      //Variable to help control where the Piece images go once centered for y value
        int vary = 647; // 647 is a1 
        			    // 567 is a2
        			    // Difference in y is 80
        
	    			    // MIN: 647 
				    // MAX: 87
        
        
        //---------------------------------------------------------
        //---------------------------------------------------------
        //---------------------------------------------------------
        
        
       
        /*
           Checks the x value -- Loop that check list of array to display on screen
           
           It will go throughout the list, if not null it will identify the piece 
           and color and draw it to its correct starting position
         */
        for (int xvalue = 0; xvalue<8; xvalue++) {
            vary = xvalue * 80 + 87 ;  

        	//Checks the y value
            for (int yvalue = 0; yvalue<8; yvalue++) {
             varx = yvalue * 80 + 87; 
	            			
             //Make sure its not null
	            	if (List[xvalue][yvalue] != null) {
	            			
	                	//if (List[x][y] instanceof Bishop) 
	                	if (List[xvalue][yvalue] instanceof Bishop) 
	                	{ 
	                		if (List[xvalue][yvalue].getColor() == "white") //White
	                		{g.drawImage(whiteBishop, (x+varx), (y+vary), 65, 65, null);}
	                		
	                		if (List[xvalue][yvalue].getColor() == "black") //black
	                		{g.drawImage(blackBishop, (x+varx), (y+vary), 65, 65, null);}
	                	} 
	                	
	                	//if (List[x][y] instanceof Rook) 
	                	if (List[xvalue][yvalue] instanceof Rook) 
	                	{ 
	                		if (List[xvalue][yvalue].getColor() == "white") //White
	                		{g.drawImage(whiteRook, (x+varx), (y+vary), 65, 65, null);}
	                		
	                		if (List[xvalue][yvalue].getColor() == "black") //black
	                		{g.drawImage(blackRook, (x+varx), (y+vary), 65, 65, null);}
	                	} 
	                	
	                	//if (List[x][y] instanceof Knight) 
	                	if (List[xvalue][yvalue] instanceof Knight) 
	                	{ 
	                		if (List[xvalue][yvalue].getColor() == "white") //White
	                		{g.drawImage(whiteKnight, (x+varx), (y+vary), 65, 65, null);}
	                		
	                		if (List[xvalue][yvalue].getColor() == "black") //black
	                		{g.drawImage(blackKnight, (x+varx), (y+vary), 65, 65, null);}
	                	} 
	                	
	                	//if (List[x][y] instanceof Queen) 
	                	if (List[xvalue][yvalue] instanceof Queen) 
	                	{ 
	                		if (List[xvalue][yvalue].getColor() == "white") //White
	                		{g.drawImage(whiteQueen, (x+varx), (y+vary), 65, 65, null);}
	                		
	                		if (List[xvalue][yvalue].getColor() == "black") //black
	                		{g.drawImage(blackQueen, (x+varx), (y+vary), 65, 65, null);}
	                	} 
	                	
	                	//if (List[x][y] instanceof King) 
	                	if (List[xvalue][yvalue] instanceof King) 
	                	{ 
	                		if (List[xvalue][yvalue].getColor() == "white") //White
	                		{g.drawImage(whiteKing, (x+varx), (y+vary), 65, 65, null);}
	                		
	                		if (List[xvalue][yvalue].getColor() == "black") //black
	                		{g.drawImage(blackKing, (x+varx), (y+vary), 65, 65, null);}
	                	} 
	                	
	                	//if (List[x][y] instanceof Pawn) 
	                	if (List[xvalue][yvalue] instanceof Pawn) 
	                	{ 
	                		if (List[xvalue][yvalue].getColor() == "white") //White
	                		{g.drawImage(whitePawn, (x+varx), (y+vary), 65, 65, null);}
	                		
	                		if (List[xvalue][yvalue].getColor() == "black") //black
	                		{g.drawImage(blackPawn, (x+varx), (y+vary), 65, 65, null);}
	                	}  
	                	
            	}//Null checker 
	            	
            }//yvalue
        
        }//xvalue -- Loop ends here
           
    }
    
}

        
        
       //Draws img
        //g.drawImage(pieceImage, x+varx,  y+vary,65,65,null);



