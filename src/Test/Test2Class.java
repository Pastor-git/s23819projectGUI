package Test;

import components.backendComponents.MainBoard;
import components.eventComponents.SaveGame;
import components.sideComponents.EndScreen;
import components.sideComponents.SupportMenu;

import javax.swing.*;
import java.io.IOException;

public class Test2Class {
    public static void main(String[] args) throws IOException {
        SaveGame save = new SaveGame();
        save.setShadowMainBoard(new MainBoard());
        save.loadTXTSaveGametoInt();
        save.loadGameFromInt();
    }
}

