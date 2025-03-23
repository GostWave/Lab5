package commands;

import app.App;
import app.CollectionManager;

/**
 * ����� ������� Update, ��������������� ��� ���������� �������� �������� ��������� �� ��� ID.
 */
public class Update implements Command {

    /**
     * ��������� ������� ���������� �������� ��������� �� ���������� ID.
     *
     * @param argument ������, ���������� ID �������� ��� ����������
     */
    @Override
    public void execute(String argument) {
        try {
            CollectionManager collectionManager = App.getApp().getCollectionManager();
            if (collectionManager.findMovieById(Long.parseLong(argument)) == null) {
                System.out.println("� ��������� �� ���������� �������� � ����� ��������");
            } else {
                collectionManager.updateElement(Long.parseLong(argument), collectionManager.findMovieById(Long.parseLong(argument)));
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
        return "�������� �������� �������� ���������, id �������� ����� ���������";
    }
}
