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
            Board[1][i] = new pawn("white");
        }
        for(int i = 0; i < 8; i++){
            Board[1][i] = new pawn("black");
        }
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
