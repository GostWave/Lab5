package commands;

import IO.FileManager;
import app.App;

/**
 * ����� ������� Save, ��������������� ��� ���������� ��������� � ����.
 */
public class Save implements Command {

    /**
     * ��������� ������� ���������� ��������� � ����.
     */
    @Override
    public void execute(String argument) {
        FileManager fileManager = App.getApp().getFileManager();
        fileManager.fileWriter();
    }

    /**
     * ���������� �������� �������.
     *
     * @return ������ � ��������� �������
     */
    @Override
    public String getDescription() {
        return "��������� ��������� � ����";
    }
}
