package commands;

import app.App;
import app.CollectionManager;

/**
 * ����� ������� PrintOscarsCount, ��������������� ��� ������ �������� ���� oscarsCount
 * ���� ��������� ��������� � ������� �����������.
 */
public class PrintOscarsCount implements Command {

    /**
     * ��������� �������, ������ �������� ���� oscarsCount ���� ��������� � ���������.
     */
    @Override
    public void execute(String argument) {
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        if (collectionManager.getCollection().isEmpty()) {
            System.out.println("��������� �����, ���������� ������� oscarsCount");
        } else {
            collectionManager.printOscarsCount();
        }
    }

    /**
     * ���������� �������� �������.
     *
     * @return ������ � ��������� �������
     */
    @Override
    public String getDescription() {
        return "������� �������� ���� oscarsCount ���� ��������� � ������� �����������";
    }
}