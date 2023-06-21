package components.backendComponents;

public class MianBoard extends Board {
    Board[][]mainBoard;

    public MianBoard() {
    }

    public MianBoard(int[][] board, Tile[][] tileBoard, Board[][] mainBoard) {
        super(board, tileBoard);
        this.mainBoard = mainBoard;
    }

    public Board[][] getMainBoard() {
        return mainBoard;
    }

    public void setMainBoard(Board[][] mainBoard) {
        this.mainBoard = mainBoard;
    }
}
