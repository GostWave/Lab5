package commands;

import app.App;
import app.CommandManager;

import java.util.Map;

/**
 * ����� ������� Help, ��������������� ��� ������ ������� �� ��������� ��������.
 */
public class Help implements Command {

    /**
     * ��������� ������� ������ ������ ��������� ������ � �� ��������.
     */
    @Override
    public void execute(String argument) {
        CommandManager commandManager = App.getApp().getCommandManager();
        Map<String, Command> commands = commandManager.getCommands();
        System.out.println("������ ��������� ������:");
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getDescription());
        }
    }

    /**
     * ���������� �������� �������.
     *
     * @return ������ � ��������� �������
     */
    @Override
    public String getDescription() {
        return "������� ������� �� ��������� ��������";
    }
}
