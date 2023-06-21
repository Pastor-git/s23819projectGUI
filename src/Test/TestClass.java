package Test;

import components.backendComponents.Board;

public class TestClass {

    public static void main(String[] args) {

        Board board = new Board();
        int[][] tab = new int[3][3];
        board.setIntBoard(tab);
        for (int i =0; i<tab.length;i++) {
            for (int j =0; j<tab.length;j++) {
                System.out.print(board.getIntBoard()[i][j]);
            }
            System.out.println();
        }





    }
}
