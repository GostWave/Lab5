package app;

import commands.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * ����� ��� ���������� ��������� � ����������.
 * ��������� ��������������, �������� � ������� �������.
 */
public class CommandManager {

    /**
     * ������ ������ ��������� ������, ��� ���� � �������� �������, � �������� � ��������������� ������ �������.
     */
    private Map<String, Command> commands = new HashMap<>();

    /**
     * ������������ ����� ������� � ���������.
     *
     * @param key     �������� ������� (������� �� ����� ��������)
     * @param command ������ �������, ����������� ��������� {@link Command}
     */
    public void registerCommand(String key, Command command) {
        commands.put(key.toLowerCase(), command);
    }

    /**
     * �������� ������� �� � ��������.
     *
     * @param key �������� �������
     * @return ������ ������� �� �����
     */
    public Command getCommandByKey(String key) {
        return commands.get(key.toLowerCase());
    }

    /**
     * ���������� ��� ������������������ �������.
     *
     * @return ������������������ �������
     */
    public Map<String, Command> getCommands() {
        return commands;
    }
}
