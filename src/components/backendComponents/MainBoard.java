package components.backendComponents;

public class MainBoard {
    Board[][] mainBoardTab;
    int[][]mainIntBoard;
    public MainBoard() {
        super();
    }

    public MainBoard(Board[][] mainBoard) {
        this.mainBoardTab = mainBoard;
    }

    public Board[][] getMainBoardTab() {
        return mainBoardTab;
    }

    public void setMainBoardTab(Board[][] mainBoardTab) {
        this.mainBoardTab = mainBoardTab;
    }

    public int[][] getMainIntBoard() {
        return mainIntBoard;
    }

    public void setMainIntBoard(int[][] mainIntBoard) {
        this.mainIntBoard = mainIntBoard;
    }
}
