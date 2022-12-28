package dev.xpepelok.utils;

import java.io.IOException;
import java.nio.file.*;

public class Execution {
    private static final Path cristalixFolder = Paths.get(System.getenv("USERPROFILE"), ".cristalix");
    private static final Path minigamesFolder = Paths.get(System.getenv("USERPROFILE"), ".cristalix", "updates", "Minigames");

    public static void importToken(String nickname) {
        Path profileFile = Paths.get("tokens", nickname, ".launcher");
        try {
            Files.copy(profileFile, cristalixFolder.resolve(".launcher"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Player token " + nickname + " imported to root folder");
        }
        catch (NoSuchFileException e) {
            System.out.println("The token is missing from the directory");
        }
        catch (IOException e) {
            System.out.println("Not enough rights");
        }
    }

    public static void exportToken(String nickname) {
        Path path = Paths.get("tokens", nickname);
        Path launcherFile = cristalixFolder.resolve(".launcher");
        try {
            Files.createDirectories(path);
            Files.copy(launcherFile, path.resolve(".launcher"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Player token " + nickname + " exported from root folder");
        }
        catch (IOException e) {
            System.out.println("The token is missing from the root folder.\nLaunch the launcher and log in to export.");
        }
    }

    public static void importOptions(String nickname) {
        Path optionsFile = Paths.get("options", nickname, "options.txt");
        Path optionsOfFile = Paths.get("options", nickname, "optionsof.txt");
        try {
            Files.copy(optionsFile, minigamesFolder.resolve("options.txt"), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(optionsOfFile, minigamesFolder.resolve("optionsof.txt"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println(nickname + " player settings configuration files imported into the root folder");
        }
        catch (NoSuchFileException e) {
            System.out.println("Configuration files are missing from directory");
        }
        catch (IOException e) {
            System.out.println("Not enough rights");
        }
    }

    public static void exportOptions(String nickname) {
        Path optionsPath = Paths.get("options", nickname);
        Path optionsFile = minigamesFolder.resolve("options.txt");
        Path optionsOfFile = minigamesFolder.resolve("optionsof.txt");
        try {
            Files.createDirectories(optionsPath);
            Files.copy(optionsFile, optionsPath.resolve("options.txt"), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(optionsOfFile, optionsPath.resolve("optionsof.txt"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println(nickname + " player settings configuration files exported from the root folder");
        }
        catch (IOException e) {
            System.out.println("The settings configuration files are missing from the root folder. \n" +
                    "Run the client to create them.");
        }
    }

    public static void deleteToken() {
        try {
            Files.deleteIfExists(Paths.get(System.getenv("USERPROFILE"), ".cristalix", ".launcher"));
        }
        catch (NoSuchFileException e) {
            System.out.println("The token is missing from the directory");
        }
        catch (IOException e) {
            System.out.println("Not enough rights");
        }
        System.out.println("Token deletion completed successfully");
    }

    public static void deleteOptions() {
        try {
            Files.deleteIfExists(Paths.get(System.getenv("USERPROFILE"), ".cristalix", "updates", "Minigames", "options.txt"));
            Files.deleteIfExists(Paths.get(System.getenv("USERPROFILE"), ".cristalix", "updates", "Minigames", "optionsof.txt"));
        }
        catch (NoSuchFileException e) {
            System.out.println("Settings configurations are missing from the directory");
        }
        catch (IOException e) {
            System.out.println("Not enough rights");
        }
        System.out.println("Deletion of settings configuration files completed successfully");
    }



    public static void startLauncher(String directory, String application) {
        try {
            new ProcessBuilder("java", "-jar", directory + application).start();
            System.out.println("The following application is launched: " + application);
        }
        catch (IOException e) {
            System.out.println("An error occurred while starting: " + application);
        }
    }
}
