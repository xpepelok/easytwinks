package dev.xpepelok.easytwinks.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreatingFiles {

    public static void checkingAndCreatingRequiredFiles() throws IOException {
            Files.createDirectories(Paths.get("required"));
            Files.createDirectories(Paths.get("tokens"));
            Files.createDirectories(Paths.get("options"));

        if (!new File("required/CristalixLauncher.exe").exists()) {
            if (!new File ("required/CristalixLauncher.jar").exists()) {
            DownloadFile.downloadUsingNIO("https://webdata.c7x.dev/sworroo/CristalixLauncher.exe", "./required/CristalixLauncher.exe", "CristalixLauncher");
            }
        }
    }
}
