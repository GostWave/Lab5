package commands;

import app.App;
import app.CollectionManager;
import collectionObject.Movie;

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
            Movie movie = collectionManager.createMovie();
            collectionManager.insertElement(movie, Integer.parseInt(argument));
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
