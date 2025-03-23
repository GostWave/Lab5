package commands;

import app.App;
import app.CollectionManager;

/**
 * ����� ������� Insert, ��������������� ��� ���������� ������ �������� � ���������
 * �� �������� �������.
 */
public class Insert implements Command {

    /**
     * ��������� ������� ������� ������ �������� � ��������� �� ��������� �������.
     *
     * @param argument ������, ���������� ������� ��� ������� ��������
     */
    @Override
    public void execute(String argument) {
        try {
            CollectionManager collectionManager = App.getApp().getCollectionManager();
            collectionManager.insertElement(Integer.parseInt(argument));
        } catch (NumberFormatException e) {
            System.out.println("����� �������� �������� �������");
        }
    }

    /**
     * ���������� �������� �������.
     *
     * @return ������ � ��������� �������
     */
    @Override
    public String getDescription() {
        return "�������� ����� ������� � �������� �������";
    }
}
