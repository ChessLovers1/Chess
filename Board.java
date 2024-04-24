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
            Board[6][i] = new pawn("black");
        }


        for(int i = 0; i < 2; i++){
            Board[0][i*7] = new rook("white");
        }
        for(int i = 0; i < 2; i++){
            Board[7][i*7] = new rook("black");
        }

        for(int i = 0; i < 2; i++){
            Board[0][2 +i*3] = new bishop("white");
        }
        for(int i = 0; i < 2; i++){
            Board[7][2 +i*3] = new bishop("black");
        }

        for(int i = 0; i < 2; i++){
            Board[0][1 +i*5] = new knight("white");
        }
        for(int i = 0; i < 2; i++){
            Board[7][1 +i*5] = new knight("black");
        }

       
        Board[0][3] = new queen("white");
        Board[7][3] = new queen("black");

        Board[0][4] = new king("white");
        Board[7][4] = new king("black");
        
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

                System.out.print(this.getPiece(j, i)+" ");
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
