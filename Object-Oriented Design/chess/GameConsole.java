import java.util.List;

public class GameConsole {
    private Player[] players;
    private Board board;
    private Player currentPlayer;
    private List<Move> movesPlayed;
    private GameStatus gameStatus;

    private void initialize(Player p1, Player p2){
        players[0] = p1;
        players[1] = p2;

        board.resetBoard();

        if(p1.isWhiteSide()) {
            this.currentPlayer = p1;
        } else {
            this.currentPlayer = p2;
        }

        movesPlayed.clear();
    }

    private boolean makeMove(Move move){
        Piece sourcePiece = move.start.piece;
        Piece destPiece = move.end.piece;
        // valid player
        if(this.currentPlayer!=move.player){
            return false;
        }
        if(move.start.color!=move.player.color){
            return false;
        }
        // valid move?
        if(!move.start.piece.canMove(board,move.start,move.end)){
            return false;
        }
        // kill?
        if(move.end.piece!=null){
            move.end.piece.setKilled(true);
            move.setPieceKilled(move.end.piece);
        }
        // castling?
        if(move.start.piece instanceof King && ((King) move.start.piece).isCastingMove()){
            move.setCastlingMove(true);
        }

        // store the move
        movesPlayed.add(move);

        // move piece from the stat box to end box
        move.getEnd().setPiece(move.start.piece);
        move.getStart().setPiece(null);

        //isWon
        if(destPiece!=null&&destPiece instanceof King){
            if(move.player.isWhiteSide()){
                this.gameStatus = GameStatus.WHITE_WIN;
            } else {
                this.gameStatus = GameStatus.BLACK_WIN;
            }
        }

        // set the current turn to the other player
        if(this.currentPlayer==players[0]){
            this.currentPlayer = players[1];
        } else {
            this.currentPlayer = players[0];
        }
        return true;
    }
}
