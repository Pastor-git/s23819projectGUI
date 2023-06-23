package Test;

import components.backendComponents.Board;
import components.eventComponents.SaveGame;
import components.gameComponents.BoardPanel;
import components.gameComponents.MainFrame;
import components.sideComponents.EndScreen;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class TestClass {

    public static void print(String s) {
        System.out.println(s);
    }
    public static void main(String[] args) throws IOException {

//        wczytnaie i zapis pliku

        String path1 ="src/Test/test1.txt";
        String path2 ="src/Test/test2.txt";
        FileReader read = new FileReader(path1);
        FileWriter write = new FileWriter(path2);
        String s = read.toString();
        print(s);
        String[][] tab1 = new String[3][3];
        for (int y = 2;y>=0;y--){
            for (int x = 0; x <3;x++) {
                tab1[y][x] = "0";
                System.out.print(tab1[y][x] + " x:" + x + " y:" + y );
            }
            System.out.println();
        }

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path1));
            String line = reader.readLine();
            while (line != null) {
                        System.out.println(line);
                        String wiersz = line;
                        print(wiersz + "wiersz");
                        write.write(line);
                        System.out.println(line + "write");
                        line = reader.readLine();
            }

            write.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
