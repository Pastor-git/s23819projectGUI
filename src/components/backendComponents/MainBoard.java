package components.backendComponents;

public class MainBoard extends Board {
    Board[][]mainBoard;

    public MainBoard() {
        super();
    }

    public MainBoard(int[][] board, Tile[][] tileBoard, Board[][] mainBoard) {
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
