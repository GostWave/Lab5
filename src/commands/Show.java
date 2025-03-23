package commands;

import app.App;
import app.CollectionManager;

/**
 * ����� ������� Show, ��������������� ��� ������ ���� ��������� ��������� � ��������� �������������.
 */
public class Show implements Command {

    /**
     * ��������� ������� ����������� ���� ��������� ���������.
     */
    @Override
    public void execute(String argument) {
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        collectionManager.showCollection();
    }

    /**
     * ���������� �������� �������.
     *
     * @return ������ � ��������� �������
     */
    @Override
    public String getDescription() {
        return "������� � ����������� ����� ������ ��� �������� ��������� � ��������� �������������";
    }
}
