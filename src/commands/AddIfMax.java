package commands;

import app.App;
import app.CollectionManager;
import collectionObject.Movie;

/**
 * ����� ������� AddIfMax, ��������������� ��� ���������� ������ �������� � ���������,
 * ���� ��� �������� ��������� �������� ����������� �������� ���������.
 */
public class AddIfMax implements Command {

    /**
     * ��������� ������� ���������� ��������, ���� ��� �������� ��������� ������������ � ���������.
     */
    @Override
    public void execute(String argument) {
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        Movie movie = collectionManager.createMovie();
        if (movie.getOscarsCount() > collectionManager.getMaxOscarsCount()) {
            collectionManager.addMovie(movie);
        } else {
            System.out.println("������� �� ��� �������� � ���������");
        }
    }

    /**
     * ���������� �������� �������.
     *
     * @return ������ � ��������� �������
     */
    @Override
    public String getDescription() {
        return "�������� ����� ������� � ���������, ���� ��� �������� ��������� �������� ����������� �������� ���� ���������";
    }
}
