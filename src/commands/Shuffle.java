package commands;

import app.App;
import app.CollectionManager;

/**
 * ����� ������� Shuffle, ��������������� ��� ������������� ��������� ��������� � ��������� �������.
 */
public class Shuffle implements Command {

    /**
     * ��������� ������� ������������� ��������� ���������.
     */
    @Override
    public void execute(String argument) {
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        if (!collectionManager.getCollection().isEmpty()) {
            collectionManager.shuffleCollection();
            System.out.println("��������� ������� ����������");
        } else {
            System.out.println("��������� �����, � ������ ����������");
        }
    }

    /**
     * ���������� �������� �������.
     *
     * @return ������ � ��������� �������
     */
    @Override
    public String getDescription() {
        return "���������� �������� ��������� � ��������� �������";
    }
}