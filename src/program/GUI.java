package program;

import javax.swing.*; 

public class GUI extends JFrame {

   
   
    public GUI() {
    	super("Chess"); 
    	
    	
    	//imageObject a =  new imageObject(new ImageIcon("./src/img/z-White-queen-chess.png").getImage(), 0,0) ;
    	//add(a);
    	ChessBoardPanel test = new ChessBoardPanel();
        
    	add(test);
    	//imageObject a =  new imageObject(new ImageIcon("./src/img/z-White-queen-chess.png").getImage(), 0,0) ;
    	//add(a);
    	//setExtendedState(JFrame.MAXIMIZED_BOTH);//Fullscreen
    	//Toolkit.getDefaultToolkit().getScreenSize
        setSize(850,850 ); // Set your desired size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setLocationRelativeTo(null); // Center the window on the screen
        
    	

        setVisible(true); // Make the window visible
    }
    
    
    
    public static void main(String[] args) {
        JFrame frame = new GUI();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        frame.setLayout(new FlowLayout());
        
        ChessBoardPanel horse = new ChessBoardPanel();
        imageObject horse2 = new imageObject("./src/img/z-Black-bishop-chess.png",10,10);
        //frame.getContentPane().add(horse);
        frame.add(horse);
        frame.add(horse2);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        frame.setLayout(new FlowLayout());
        
        ChessBoardPanel horse = new ChessBoardPanel();
        imageObject horse2 = new imageObject("./src/img/z-Black-bishop-chess.png",10,10);
        //frame.getContentPane().add(horse);
        frame.add(horse);
        frame.add(horse2);
         
        
        //getContentPane()
        
        
        
        
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;

        while (elapsedTime < 4*1000) {
            
            elapsedTime = (new Date()).getTime() - startTime;
        }
		
		
        while(true) {
        	
        	horse.moveImg(((GUI)frame).Adapter.x, ((GUI)frame).Adapter.y);
        
        	
        }
        */
        
    }
}

