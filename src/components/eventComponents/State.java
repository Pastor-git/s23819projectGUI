package components.eventComponents;

public class State {

    public static int player_turn;
    public static int bigX;
    public static int bigY;
    public static boolean isGameFinished = false;
    String result;

    public State(){
        System.out.println("State zainicjaizowany");
        player_turn = 1;
    };
//    STATYCZNE WARTOŚCI DLA ROZGRYKI WCZYTUJĄCE USTAWIENIA Z SAVE GAME LUB INICJOWANE DOMYŚLNYMI
//    Warunki zwycięstwa tutaj sprawdzajmy możę?

}
