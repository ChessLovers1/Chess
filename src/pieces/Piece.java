package pieces;

import program.*;
public class Piece{

    String color;
    String Img = null;
    imageObject dynamicImage;
    public Piece(){
     
     
    }

    public Piece(String color){
        
        this.color = color;
        
    }

    public String getColor(){
        return color;
    }

    public String getImg(){
        return Img;
    }

    
}
