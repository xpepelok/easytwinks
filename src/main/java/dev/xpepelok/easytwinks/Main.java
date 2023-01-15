package dev.xpepelok.easytwinks;

import dev.xpepelok.easytwinks.utils.Menu;
import dev.xpepelok.easytwinks.utils.CreatingFiles;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CreatingFiles.checkingAndCreatingRequiredFiles();
        Menu.startMenu();
    }
}