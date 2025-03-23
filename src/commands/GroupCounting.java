package commands;

import app.CollectionManager;
import collectionObject.Movie;

import java.util.HashMap;
import java.util.Map;

/**
 * ����� ������� GroupCounting, ��������������� ��� ����������� ��������� ���������
 * �� �������� ���� oscarsCount � ������ ���������� ��������� � ������ ������.
 */
public class GroupCounting implements Command {

    /**
     * ��������� ������� ����������� ��������� ��������� �� ���������� ���������� "�������".
     * ������� ���������� ������� � ������ ������.
     */
    @Override
    public void execute(String argument) {
        CollectionManager collectionManager = app.App.getApp().getCollectionManager();
        Map<Integer, Integer> grouped = new HashMap<>();

        for (Movie movie : collectionManager.getCollection()) {
            if (movie != null) {
                grouped.put(movie.getOscarsCount(), grouped.getOrDefault(movie.getOscarsCount(), 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : grouped.entrySet()) {
            System.out.println("���������� �������: " + entry.getKey() + " �������: " + entry.getValue());
        }
    }

    /**
     * ���������� �������� �������.
     *
     * @return ������ � ��������� �������
     */
    @Override
    public String getDescription() {
        return "������������� �������� ��������� �� �������� ���� oscarsCount, ������� ���������� ��������� � ������ ������";
    }
}
