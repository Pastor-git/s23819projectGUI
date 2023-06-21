package components.backendComponents;

public class Board {
//COMPONENT SKŁADOWY GAMECOTROLER'A
    int[][] intBoard;
    Tile[][]tileBoard;
    public Board() {
        super();
    }
    public Board(int[][] intBoard, Tile[][] tileBoard) {
        this.intBoard = intBoard;
        this.tileBoard = tileBoard;
    }

    public int[][] getIntBoard() {
        return intBoard;
    }

    public void setIntBoard(int[][] intBoard) {
        this.intBoard = intBoard;
    }

    public Tile[][] getTileBoard() {
        return tileBoard;
    }

    public void setTileBoard(Tile[][] tileBoard) {
        this.tileBoard = tileBoard;
    }
}
