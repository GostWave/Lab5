package commands;

import app.App;
import app.ConsoleCaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Класс команды ExecuteScript, предназначенный для выполнения команд из указанного файла.
 */
public class ExecuteScript implements Command {
    final ConsoleCaller consoleCaller = App.getApp().getConsoleCaller();

    /**
     * Выполняет команду, считывая команды из файла и выполняя их последовательно.
     *
     * @param argument имя файла, содержащего команды для выполнения
     */
    @Override
    public void execute(String argument) {
        HashSet<String> callScripts= new HashSet<>();
        try {
            Scanner scanner = new Scanner(new File(argument));

            while (scanner.hasNext()) {
                String text = scanner.nextLine().trim();
                System.out.println(text);
                if (text.length()>4 && text.substring(text.length() - 4).equals(".txt")){
                    callScripts.add(text.split(" ")[1]);
                }
                if (text.substring(text.length() - 4).equals(".txt") && callScripts.contains(text.split(" ")[1])){
                    System.out.println("Возникла рекурсия");
                    break;
                } else {
                    consoleCaller.call(text);
                }



            }
        } catch (FileNotFoundException e) {
            System.out.println("Введено неверное имя файла или необходимый файл отсутствует");
        }
    }

    /**
     * Возвращает описание команды.
     *
     * @return строка с описанием команды
     */
    @Override
    public String getDescription() {
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
    }
}
