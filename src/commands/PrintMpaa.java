package commands;

import app.App;
import app.CollectionManager;

import java.util.HashSet;

/**
 * ����� ������� PrintMpaa, ��������������� ��� ������ ���������� �������� ���� mpaaRating ���� ��������� � ���������.
 */
public class PrintMpaa implements Command {

    /**
     * ��������� �������, ������ ���������� �������� ���� mpaaRating �� ���������.
     */
    @Override
    public void execute(String argument) {
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        HashSet<String> set = collectionManager.uniqueMpaa();
        if (collectionManager.getCollection().isEmpty()) {
            System.out.println("��������� �����, ���������� ������� ���������� mpaaRating");
        } else {
            for (String mpaa : set) {
                System.out.println(mpaa);
            }
        }
    }

    /**
     * ���������� �������� �������.
     *
     * @return ������ � ��������� �������
     */
    @Override
    public String getDescription() {
        return "������� ���������� �������� ���� mpaaRating ���� ��������� � ���������";
    }
}