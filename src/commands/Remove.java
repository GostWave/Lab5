package commands;

import app.App;
import app.CollectionManager;

/**
 * ����� ������� Remove, ��������������� ��� �������� �������� �� ��������� �� ��� ID.
 */
public class Remove implements Command {

    /**
     * ��������� ������� �������� �������� �� ��������� �� ���������� ID.
     *
     * @param argument ������, ���������� ID �������� ��� ��������
     */
    @Override
    public void execute(String argument) {
        try {
            CollectionManager collectionManager = App.getApp().getCollectionManager();
            if (collectionManager.findMovieById(Long.parseLong(argument)) == null) {
                System.out.println("� ��������� �� ���������� �������� � ����� ��������");
            } else {
                collectionManager.removeElement(collectionManager.findMovieById(Long.parseLong(argument)));
                System.out.println("������� ������� ����� �� ���������");
            }
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
        return "������� ������� �� ��������� �� ��� id";
    }
}
