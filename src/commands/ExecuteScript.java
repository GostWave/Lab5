package commands;

import app.App;
import app.ConsoleCaller;

import java.io.File;
import java.io.FileNotFoundException;
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
        try {
            Scanner scanner = new Scanner(new File(argument));
            while (scanner.hasNext()) {
                String text = scanner.nextLine();
                System.out.println(text);
                consoleCaller.call(text);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Введено неверное имя файла или необходимый файл отсутствует");
        } catch (StackOverflowError e) {
            System.out.println("Ошибка: не должно возникать рекурсии");
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
