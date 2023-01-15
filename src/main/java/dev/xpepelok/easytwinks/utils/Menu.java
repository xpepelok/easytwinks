package dev.xpepelok.easytwinks.utils;

import java.io.File;
import java.util.ArrayList;

public class Menu {
    public static void startMenu() {

        ArrayList<String> commands = new ArrayList<>();
        commands.add("importToken <nickname> - Если желаете импортировать токен.");
        commands.add("exportToken <nickname> - Если желаете экспортировать токен.");
        commands.add("importOptions <nickname> - Если желаете импортировать конфиги ваших настроек.");
        commands.add("exportOptions <nickname> - Если желаете экспортировать конфиги ваших настроек.");
        commands.add("importTokenWithLaunch <nickname> - Если желаете импортировать токен с запуском лаунчера.");
        commands.add("importOptionsWithLaunch <nickname> - Если желаете импортировать конфиги ваших настроек с запуском лаунчера.");
        commands.add("customlaunch <tokenNickname> <optionsNickname> - Профильный запуск лаунчера.");
        commands.add("startLauncher - Запуск лаунчера");
        commands.add("deleteToken - Если желаете удалить токен с корневой папки лаунчера.");
        commands.add("deleteOptions - Если желаете удалить конфиги ваших настроек.\n");

        while (true) {
            System.out.println("\nНеобходимо выбрать тип операции, введите:");
            for (String cm : commands) {
                System.out.println(cm);
            }

            String input = System.console().readLine();
            String[] nickname = input.split(" ");

            try {
                switch (nickname[0].toLowerCase()) {
                    case "importtoken": {
                        Execution.importToken(nickname[1]);
                        break;
                    }
                    case "exporttoken": {
                        Execution.exportToken(nickname[1]);
                        break;
                    }
                    case "importoptions": {
                        Execution.importOptions(nickname[1]);
                        break;
                    }
                    case "exportoptions": {
                        Execution.exportOptions(nickname[1]);
                        break;
                    }
                    case "importtokenwithlaunch": {
                        Execution.importToken(nickname[1]);
                        if (new File("required/CristalixLauncher.exe").exists()) {
                            Execution.startLauncher("./required/", "CristalixLauncher.exe");
                        } else {
                            Execution.startLauncher("./required/", "CristalixLauncher.jar");
                        }
                        break;
                    }
                    case "importoptionswithlaunch": {
                        Execution.importOptions(nickname[1]);
                        if (new File("required/CristalixLauncher.exe").exists()) {
                            Execution.startLauncher("./required/", "CristalixLauncher.exe");
                        } else {
                            Execution.startLauncher("./required/", "CristalixLauncher.jar");
                        }
                        break;
                    }
                    case "customlaunch": {
                        Execution.importToken(nickname[1]);
                        Execution.importOptions(nickname[2]);
                        if (new File("required/CristalixLauncher.exe").exists()) {
                            Execution.startLauncher("./required/", "CristalixLauncher.exe");
                        } else {
                            Execution.startLauncher("./required/", "CristalixLauncher.jar");
                        }
                        break;
                    }
                    case "startlauncher": {
                        if (new File("required/CristalixLauncher.exe").exists()) {
                            Execution.startLauncher("./required/", "CristalixLauncher.exe");
                        } else {
                            Execution.startLauncher("./required/", "CristalixLauncher.jar");
                        }
                        break;
                    }
                    case "deletetoken": {
                        Execution.deleteToken();
                        break;
                    }
                    case "deleteoptions": {
                        Execution.deleteOptions();
                        break;
                    }
                    default: {
                        System.out.println("\nНедостаточно аргументов для выполнения операции");
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("\nНедостаточно аргументов для выполнения операции");
            }
        }
    }
}
