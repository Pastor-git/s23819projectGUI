package components.eventComponents;

public class State {

    public static int player_turn;
    public static int bigX;
    public static int bigY;
    public static boolean isGameFinished = false;
    String result;
    boolean endGame = false;
    int gameResult = 0;

    public State(String label){
        System.out.println("State zainicjaizowany");
        player_turn = 1;
        System.out.println("State speaks: " + label);
    };
//    STATYCZNE WARTOŚCI DLA ROZGRYKI WCZYTUJĄCE USTAWIENIA Z SAVE GAME LUB INICJOWANE DOMYŚLNYMI
//    Warunki zwycięstwa tutaj sprawdzajmy możę?

//    WIN/LOSE CONDIDITIONS METODS
    public int resultIntTab(int[][] tab) {
//        1,2,3
        return 0;
    }

//    TEST METHODS



//    BOILER PLATE
    public static int getPlayer_turn() {
        return player_turn;
    }

    public static void setPlayer_turn(int player_turn) {
        State.player_turn = player_turn;
    }

    public static int getBigX() {
        return bigX;
    }

    public static void setBigX(int bigX) {
        State.bigX = bigX;
    }

    public static int getBigY() {
        return bigY;
    }

    public static void setBigY(int bigY) {
        State.bigY = bigY;
    }

    public static boolean isIsGameFinished() {
        return isGameFinished;
    }

    public static void setIsGameFinished(boolean isGameFinished) {
        State.isGameFinished = isGameFinished;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
