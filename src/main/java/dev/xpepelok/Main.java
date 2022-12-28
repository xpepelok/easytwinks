package dev.xpepelok;

import dev.xpepelok.utils.CreatingFiles;
import dev.xpepelok.utils.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CreatingFiles.checkingAndCreatingRequiredFiles();
        Menu.startMenu();
    }
}