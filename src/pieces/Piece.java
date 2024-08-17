package pieces;

import java.awt.Image;
import program.*;
public class Piece{
	public int x,y;
    String color;
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
