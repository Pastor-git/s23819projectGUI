package components.eventComponents;

import components.Const;

public class State {

    public static int player_turn;
    public static int bigX;
    public static int bigY;
    public static boolean isGameFinished = false;
    String result;
    boolean endGame = false;
    int gameResult = 0;
    String gameLabel;
    SaveGame saveGame;
    public State(String label){
        this.gameLabel = label;
        System.out.println("State zainicjaizowany" + " label: " + label);
        this.gameLunch();
    };
    public void gameLunch() {
        switch(this.gameLabel) {
            case "START":
                break;
            case "LOAD":
                break;
            case "TEST":
                break;
            default:
                break;
        }
        System.out.println("game lunch");
    }
    public void gameUpLoad(int[][] tab) {

    }
//    STATYCZNE WARTOŚCI DLA ROZGRYKI WCZYTUJĄCE USTAWIENIA Z SAVE GAME LUB INICJOWANE DOMYŚLNYMI
//    Warunki zwycięstwa tutaj sprawdzajmy możę?

//    WIN/LOSE CONDIDITIONS METODS
    public int resultIntTab(int[][] tab) {
      int result = 0;
      if (didPlayerWinColumns(tab)!=0) {
          result = didPlayerWinColumns(tab);
      } else if (didPlayerWinDiagonal(tab)!=0) {
          result = didPlayerWinDiagonal(tab);
      } else if (didPlayerWinRows(tab)!=0) {
          result = didPlayerWinRows(tab);
      } else if (isDrawGame(tab)!=0) {
          result = 3;
      } else {
          result = 0;
      }
        System.out.println("state speaks result: " + result);
        return result;
    }

    public int didPlayerWinDiagonal(int[][] tab) {
        int win_number = 0;

        if ((tab[0][0] != 0) && (tab[0][0] == tab[1][1]) && (tab[0][0] == tab[2][2])) {
            win_number = tab[0][0];
        } else if ((tab[2][0] != 0) && (tab[2][0] == tab[1][1]) && (tab[2][0] == tab[0][2])) {
            win_number = tab[2][0];
        } else {
            System.out.println("diagonal: brak wygranej");
        }

        return win_number;
    }

    public int didPlayerWinRows(int[][] tab) {
        int win_number = 0;
        for (int i = 0; i < 3; i++) {
            if ((tab[i][0] != 0) && (tab[i][0] == tab[i][1]) && (tab[i][0] == tab[i][2])) {
                win_number = tab[i][0];
                break;
            } else {
                System.out.println("wiersz " + i + ": brak wygranej");
            }
        }
        return win_number;
    }

    public int didPlayerWinColumns(int[][] tab) {
        int win_number = 0;
        for (int i = 0; i < 3; i++) {
            if ((tab[0][i] != 0) && (tab[0][i] == tab[1][i]) && (tab[0][i] == tab[2][i])) {
                win_number = tab[0][i];
                break;
            } else {
                System.out.println("kolumna " + i + ": brak wygranej");
            }
        }
        return win_number;
    }


    public int isDrawGame(int[][] tab) {
        int draw = 0;
        boolean fullTab = true;
        for (int i = 0; i < tab.length; i++) {
        for (int j = 0; j < tab[i].length; j++) {
             if (tab[i][j] == 0) {
             fullTab = false;
             break;
        }}}
        if (fullTab) {
            draw = 3;
        }
        return draw;
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
