package app;

import IO.FileManager;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * �������� ����� ����������, ����������� ��� ������������ � ����������� �������.
 * ��������� ������� Singleton ��� ����������� ������������� ����������.
 */
public class App {
    private CollectionManager collectionManager;
    private ConsoleCaller consoleCaller;
    private FileManager fileManager;
    private CommandManager commandManager;
    private static App app;
    Scanner scanner = new Scanner(System.in);

    /**
     * ��������� ����������� ��� �������������� �������� ����������� ������ �����.
     */
    private App() {
    }

    /**
     * ���������� ������������ ��������� ������ App.
     * ���� �� ��� �� ������, ������ �����.
     *
     * @return ��������� ������ App
     */
    public static App getApp() {
        if (app == null) {
            app = new App();
        }
        return app;
    }

    /**
     * ������������� �������� ���������.
     *
     * @param collectionManager ������ CollectionManager
     */
    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * ���������� �������� ���������.
     *
     * @return ������ CollectionManager
     */
    public CollectionManager getCollectionManager() {
        return collectionManager;
    }

    /**
     * ���������� �������� ������.
     *
     * @return ������ CommandManager
     */
    public CommandManager getCommandManager() {
        return commandManager;
    }

    /**
     * ������������� �������� ������.
     *
     * @param commandManager ������ CommandManager
     */
    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    /**
     * ������������� �������� ������.
     *
     * @param fileManager ������ FileManager
     */
    public void setFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    /**
     * ���������� �������� ������.
     *
     * @return ������ FileManager
     */
    public FileManager getFileManager() {
        return fileManager;
    }

    /**
     * ������������� ���������� ���������� ������.
     *
     * @param consoleCaller ������ ConsoleCaller
     */
    public void setConsoleCaller(ConsoleCaller consoleCaller) {
        this.consoleCaller = consoleCaller;
    }

    /**
     * ���������� ���������� ���������� ������.
     *
     * @return ������ ConsoleCaller
     */
    public ConsoleCaller getConsoleCaller() {
        return consoleCaller;
    }

    /**
     * ��������� ����������, ������ ����� ������ �� ������������.
     * � ������ ����� "exit" ���������� ��������� ������.
     */
    public void start() {
        while (true) {
            try {
                String text = scanner.nextLine().toLowerCase().trim();
                if (text.equals("exit")) {
                    break;
                }
                consoleCaller.call(text);
            } catch (NoSuchElementException e){
                System.out.println("Ctrl + D. ��������� ����� ���������.");
                break;
            }

        }
    }
}
