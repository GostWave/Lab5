package commands;

import app.App;
import app.CollectionManager;

/**
 * ����� ������� Clear, ��������������� ��� ������� ���������.
 */
public class Clear implements Command {

    /**
     * ��������� ������� ������� ���������.
     */
    @Override
    public void execute(String argument) {
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        if (collectionManager.getCollection().isEmpty()) {
            System.out.println("��������� �� �������� ���������, ������� ����� ���� �� ��������");
        } else {
            collectionManager.clearCollection();
            System.out.println("��������� ������� �������");
        }
    }

    /**
     * ���������� �������� �������.
     *
     * @return ������ � ��������� �������
     */
    @Override
    public String getDescription() {
        return "�������� ���������";
    }
}
