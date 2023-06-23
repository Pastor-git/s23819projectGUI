package components.eventComponents;

import components.backendComponents.Board;
import components.backendComponents.MainBoard;

public class GameControler {
//    GABINET CIENI ROZGRYFKI - BACKEND ODPOWADAJACY ZA SPRAWDZANIE WSZSYKICH CZYNNIKÓW GRY NA PODSTAWIE STATE I INNYCH KOMPONENTÓ
    State state;
    MainBoard mainBoard;


    public GameControler(State state, MainBoard mainBoard) {
        this.state = state;
        this.mainBoard = mainBoard;
    }



    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public MainBoard getMainBoard() {
        return mainBoard;
    }

    public void setMainBoard(MainBoard mainBoard) {
        this.mainBoard = mainBoard;
    }
    //    METHODS GAMEPLAY
    public void testPrint(int x, int y, int bigX, int bigY) {
        System.out.println("GameControlerSpeaks:");
        System.out.println("x:"+x + "y:" + y);
        System.out.println("bigX:"+bigX + "bigY:" + bigY);
    }

    public void move(int x, int y, int bigX, int bigY){

        System.out.println("moved");
    }

}
