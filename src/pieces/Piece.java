package pieces;

import java.awt.Image;



public class Piece{
	public int x,y;
    public String color;
    public Image Img;
    public Piece(){
     
     
    }

    public Piece(String color){
        
        this.color = color;
        
    }

    public String getColor(){
        return color;
    }

    public Image getImg(){
        return Img;
    }
    
   

    
    
}
