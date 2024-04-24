public class chess {
    /* 




    GameState

        Problem 1: Turns
            (What if we used odd and even numbers?)
            (Odd number = Player Turn, even number = computer Turn) 
            (We just setup a counter that goes up by 1 per turn and we use the % to find out which players turn is up!)

    Rules that get checked every turn 

        Problem 1: Is King in check?
            (We just check the kings current postiton with all the opposing pieces attacking tiles)
            (We will need to make sure pieces can be moved to protect the king as well) ??
            (If king is in check and has no possible moves then he loses)
        
        Problem 2: Stalemate
            (If king has no pieces that can move and cant move himself without being in check)

    */

    public static boolean validMove(Board board,int yIni,int xIni,int y,int x ){
        Piece piece = board.getBoard()[yIni][xIni];
        //check if any specials execptions would prevent from moving such as check



        //check if valid move for that specific piece
        if(piece.getClass() == new queen(null).getClass()){
            
        }
        else if(piece.getClass() == new rook(null).getClass()){

        }
        else if(piece.getClass() == new pawn(null).getClass()){

        }
        else if(piece.getClass() == new bishop(null).getClass()){

        }
        else if(piece.getClass() == new knight(null).getClass()){

        }
        else{

        }
        return true;
    }

    private static boolean kingMove(Board board,int yIni,int xIni,int y,int x){
        return true;
    }

    private static boolean rookMove(Board board,int yIni,int xIni,int y,int x){
        String Direction = "";

        if(yIni <0 || yIni >7 || xIni <0 || xIni >7){
            throw new IndexOutOfBoundsException("The rook starting position is not on the board");
        }
        if(y <0 || y >7 || x <0 || x >7){
            throw new IndexOutOfBoundsException("The rook destination is not on the board");
        }

        if(yIni == y && xIni == x){//the piece has not moved
            return false;
        }
        if(yIni-y != 0 && xIni-x == 0){//checks if it's moving in two dimensions
            return false;
        }

        
        //Find direction
        if(yIni-y<0 || xIni - x == 0){//up
            Direction = "up";
        }
        else if(yIni - y>0 || xIni - x == 0){//down
            Direction = "down";

        }
        else if(xIni-x<0 || yIni - y == 0){//up
            Direction = "right";
        }
        else if(xIni - x>0 || yIni - y == 0){//down
            Direction = "left";

        }
        else{//Not a valid rook move
            return false;
        }

        //check if there is a a Piece in between it and its destination

    }
    //private static String direction(int yIni, int xIni, int y, int x){
        // up left down right tr(top-right) tl(top-left) bl(bottom-left) br(bottom-right)    Knight: ktl 
        
    //}
    
    public static void main(String[] args) {
        Board test = new Board();


        test.printBoard();

        validMove(test, 0, 3, 0, 0);

    }
}
