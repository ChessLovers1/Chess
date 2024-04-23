public class Board {
    /*

    Project Board at all time
    
    Update Board/Pieces as game goes on


    */
    Piece[][] Board = new Piece[8][8]; //a1 - h8
    

   
    private int[] convertToIndex(String coord){
        //returns usable index for Board
        int[] index = new int[2];

        int toASCII = (int) (coord.toLowerCase().charAt(0));

        toASCII = toASCII-97;
        index[1] = toASCII;
        
        index[0] = Integer.valueOf(coord.substring(1))- 1 ;
        
        return index;

    }

    private String convertToCoord(int[] index){
        //returns chess coord
        String coord = "";

        return coord;
    }

    public static void main(String arg[]){


        Board board = new Board();

        System.out.println(board.convertToIndex("f5")[0]+ "a"+board.convertToIndex("f6")[1] );

    }
}
