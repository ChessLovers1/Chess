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
    /**
     *x position of the mouse that only updates when the mouse is being dragged 
     */
    public int x;

    /**
     * y position of the mouse that only updates when the mouse is being dragged 
     */
    public int y;
    
    /**
     * tempPosition records the index where the cursor button was released
     */
    int[] tempPosition = new int[2];
    
    /**
     * Position records the index where the Piece being dragged was initially
     */
    int[] position = new int[] {-1,-1}; 
    
    /**
     * Dimension of the board
     */
    int xDimension = 0;
    
    /**
     * Dimension of the board
     */
    int yDimension = 0;
    
    int step = 0;
    private Image board;
    
   
    /**
     * this variable is so that the image that is moving shows up on top of every other image
     */
    int[] prioIndex = new int[] {-1};

    
    

    
    /**
     * @see Board.java
     */
    Board Board =  new Board();
    /*new Board("Rookwhite Knightwhite Bishopwhite Queenwhite Kingwhite Bishopwhite Knightwhite Rookwhite \r\n"
    		+ "Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite Pawnwhite \r\n"
    		+ "null null null null null null null null \r\n"
    		+ "null null null null null null null null \r\n"
    		+ "null null null Pawnwhite null null null null \r\n"
    		+ "null null null null null null null null \r\n"
    		+ "Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack Pawnblack \r\n"
    		+ "Rookblack Knightblack Bishopblack Queenblack Kingblack Bishopblack Knightblack Rookblack ");
    */
    
    public ChessBoardPanel() {
        ImageIcon obj = new ImageIcon("./src/img/z-chessBoardV1.png");
        board = obj.getImage();
        
        
        
        
      
        //set up the board
        xDimension = (getWidth() - board.getWidth(this)) / 2;
        yDimension = (getHeight() - board.getHeight(this)) / 2;
        
        int vary,varx;
		for (int yvalue = 0; yvalue<8; yvalue++) {
		        	
		            vary = 560 - yvalue * 80 + 87 ;  
		            
		        	//Checks the y value
		            for (int xvalue = 0; xvalue<8; xvalue++) {
		             varx =  xvalue * 80 + 87; 
		             if(Board.getBoard()[yvalue][xvalue] != null) {
			             Board.getBoard()[yvalue][xvalue].x = varx;
			             Board.getBoard()[yvalue][xvalue].y = vary;
		             }
		            }
		            
			}
        

        
        addMouseMotionListener(new MouseAdapter() { 
            public void mouseDragged(MouseEvent me) {
         
              x = me.getX();
              y = me.getY();
              //System.out.println("x : "+x+" y : "+y);
              //System.out.println("xDimension "+ xDimension+ " yDimension " + yDimension );
              
              
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
	              else {
	            	  position[1]=-1;
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
	              else {
	            	  position[0]=-1;
	              }
             
              }
              
              
              
              if(!(position[0] == -1 || position[1] == -1)) {
            	  
            	  
	              if(Board.getBoard()[position[0]][position[1]] != null) {
	            	  if(Board.getBoard()[position[0]][position[1]].color == "white" && step %2 == 0) {
	 	            	 	moveImg(new int [] {position[0], position[1]}, x-30, y-30); 
	        			}
	        			else if(Board.getBoard()[position[0]][position[1]].color == "black" && step % 2 == 1) {
	   	            	 	moveImg(new int [] {position[0], position[1]}, x-30, y-30); 
	        			}
	              }
              }
              
              }});  
        
        
        addMouseListener(new MouseAdapter() {
        	public void mouseReleased(MouseEvent me) {
        		if( Board.getBoard()[position[0]][position[1]] != null &&
        			(Board.getBoard()[position[0]][position[1]].color == "white" && step % 2 == 0 || 
        			Board.getBoard()[position[0]][position[1]].color == "black" && step % 2== 1 ) ) {
	        		
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
		              else {
		            	  tempPosition[1] = -1;
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
		              else {
		            	  tempPosition[0] = -1;
		              }
	
	        		
	        		
	        		
	        		//do stuff to find out if it was a valid move
		            if( !(position[0] == -1 || position[1] == -1 || tempPosition[0] == -1 || tempPosition[1] == -1) ) {
		            	if(Board.getBoard()[position[0]][position[1]] != null) {
		            		
		            		if(Chess.validMove(Board, step, position[0], position[1], tempPosition[0], tempPosition[1])) {
		            				
		            		}
		            		else {
		            			moveImg( new int [] {position[0], position[1]}, position[1]*80+87+xDimension, 560-position[0]*80+yDimension+87);
		            			
		            		}
		            		step++;
		            		
			        		repaint();
		            		}
			        		
		            }
		            
		            //resets the piece to its original position
		            if(!(position[0] == -1 || position[1] == -1)) {
			            if(Board.getBoard()[position[0]][position[1]] != null) {
				            if(Board.getBoard()[position[0]][position[1]] != null) {
				        		moveImg( new int [] {position[0], position[1]}, position[1]*80+87+xDimension, 560-position[0]*80+yDimension+87);
				        		step--;
				            }
			            }
		            }
	        		
        		
        		}
        		position[0] = -1;
        		position[1] = -1;
        	}});
        
        
        
        
        
        
       
		
        
    }
    
    
    /**
     * this method changes the x and y coordinates in the desired Piece 
     * so that when we repaint it moves dynamically
     * 
     * @param prioIndex		index of the moving Piece
     * @param x			 	coordinate
     * @param y				coordinate
     * 
     * 
     */
    public void moveImg(int[] prioIndex, int x, int y){
    	this.prioIndex = prioIndex;
    	Piece piece = Board.getBoard()[prioIndex[0]][prioIndex[1]];
        piece.x = x-xDimension;
        piece.y = y-yDimension;
         
        
        
        repaint();
        
        
    }
    

    
    protected void paintComponent(Graphics g) {//find out what counts as a graphic
        super.paintComponent(g);
        
        //xDimension and yDimension are here so it gets updated every time the window changes dimensions
        xDimension = (getWidth() - board.getWidth(this)) / 2;
        yDimension = (getHeight() - board.getHeight(this)) / 2;
        
        
        g.drawImage(board, xDimension, yDimension, null);
        
        
        for(int i = 0; i < Board.getBoard().length; i++) {
        	
        	for(int z = 0; z < Board.getBoard()[1].length; z++) {
        		if(Board.getBoard()[i][z] != null) {
        			
        			//doesn't draw image if its moving
        			if( !(prioIndex[0] != -1 && Board.getBoard()[prioIndex[0]][prioIndex[1]] != null  && prioIndex[0] == i && prioIndex[1] == z) ) {
                		
        				g.drawImage(Board.getBoard()[i][z].Img, Board.getBoard()[i][z].x+xDimension,  Board.getBoard()[i][z].y+yDimension  ,65,65,null);
        				
	        			
        			}
        			
        		}
        	}}
        
        
        //draws moving image so it overlaps every other image
        if(prioIndex[0] != -1 && Board.getBoard()[prioIndex[0]][prioIndex[1]] != null  ) {
        		
            	g.drawImage(Board.getBoard()[prioIndex[0]][prioIndex[1]].Img, Board.getBoard()[prioIndex[0]][prioIndex[1]].x+xDimension,  Board.getBoard()[prioIndex[0]][prioIndex[1]].y+yDimension  ,65,65,null);
            	prioIndex = new int[] {-1};
        	
        	
        }  
        
    }
    
}