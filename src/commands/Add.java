package commands;

import app.App;
import app.CollectionManager;
import collectionObject.Movie;

/**
 * ����� ������� Add, ��������������� ��� ���������� ������ �������� � ���������.
 */
public class Add implements Command {

    /**
     * ��������� ������� ���������� ������ �������� � ���������.
     */
    @Override
    public void execute(String argument) {
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        Movie movie = collectionManager.createMovie();
        collectionManager.addMovie(movie);
    }

    /**
     * ���������� �������� �������.
     *
     * @return ������ � ��������� �������
     */
    @Override
    public String getDescription() {
        return "�������� ����� ������� � ���������";
    }
}
