package commands;

import app.App;
import app.CollectionManager;
import collectionObject.Movie;

/**
 * ����� ������� Info, ��������������� ��� ������ ���������� � ���������.
 */
public class Info implements Command {

    /**
     * ��������� ������� ������ ���������� � ���������, ������� � ���, ��� ���������, ���� ������������� � ���������� ���������.
     */
    @Override
    public void execute(String argument) {
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        if (!collectionManager.getCollection().isEmpty()) {
            System.out.println("Type of collection: " + collectionManager.getCollection().getClass().getSimpleName() +
                    "\nType of elements: " + Movie.class.getSimpleName() +
                    "\nInitialization date: " + collectionManager.findMovieById(1L).getCreationDate() +
                    "\nNumber of collection items: " + collectionManager.getCollection().size());
        } else {
            System.out.println("��������� �� �������� ���������");
        }
    }

    /**
     * ���������� �������� �������.
     *
     * @return ������ � ��������� �������
     */
    @Override
    public String getDescription() {
        return "������� � ����������� ����� ������ ���������� � ��������� (���, ���� �������������, ���������� ��������� � �.�.)";
    }
}
