package IO;

import app.App;
import app.CollectionManager;
import app.CommandManager;
import app.ConsoleCaller;
import collectionObject.Movies;
import jakarta.xml.bind.JAXBException;

import java.io.*;
import java.nio.file.AccessDeniedException;
import java.util.Scanner;


/**
 * ����� FileManager ������������ ��� ���������� ��������� � ����������� ��������� � ����.
 */
public class FileManager {

    /**
     * �������� �����, ���������� �� ���������� ��������� COLLECTION_FILE.
     */
    private final String fileName = System.getenv("COLLECTION_FILE");

    /**
     * ��������� ��������� � ������ .
     */
    private final CollectionManager collectionManager = App.getApp().getCollectionManager();
    private final CommandManager commandManager = App.getApp().getCommandManager();
    private final ConsoleCaller consoleCaller = App.getApp().getConsoleCaller();
    /**
     * ��������� ������������� ������ �����.
     */
    private String text;

    /**
     * ��������� ��������� �� �����.
     */
    public void importCollection() {
        File file = null;
        try {
            file = new File(fileName);
        } catch (NullPointerException e) {
            System.out.println("�� �������� ��� �����. ��������� ����� ���������");
            System.exit(0);
        }

        if (file != null) {
            if (file.exists()) {
                if (!file.canRead()){
                    System.out.println("������: ��� ���� ������� � �����. ��������� ����� ���������");
                    System.exit(0);
                } else {
                    fileReader(file);
                    textToObject();
                }
            } else {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println("�������� ��� �����. ��������� ����� ���������");
                    System.exit(0);
                }
            }
        }
    }



    /**
     * ������ ������ �� ����� � ��������� �� � ���������� text.
     *
     * @param file ����, �� �������� ����������� ������
     */
    public void fileReader(File file) {
        try {
            Scanner scanner = new Scanner(file, "UTF-8");
            scanner.useDelimiter("\\z");
            if (scanner.hasNext()) {
                text = scanner.next();
            }
        } catch (FileNotFoundException e){
                System.out.println("������: ����������� ����");
            }
        }


    /**
     * ����������� ��������� ������ � ������ ��������� � ��������� �� � �������� ���������.
     */
    public void textToObject() {
        if (text != null) {

            JAXBWorker jaxbWorker = new JAXBWorker();
            Movies movies = jaxbWorker.convertXmlToObject(text);
            if ((movies != null) && (movies.getMovies() != null)) {
                CollectionChecker collectionChecker = new CollectionChecker(movies);
                if (collectionChecker.checkCollection()) {
                    collectionManager.setCollection(movies);
                    System.out.println("��������� ������� ������������� �� �����");
                }

            }
        }
    }

    /**
     * ���������� ������� ��������� � ����.
     */
    public void fileWriter() {
        JAXBWorker jaxbWorker = new JAXBWorker();
        File file = new File("./" + fileName);
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        Movies movies = new Movies();
        movies.setMovies(collectionManager.getCollection());

        if (movies.getMovies().isEmpty()) {
            if (file.exists()) {
                try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8")) {
                    writer.write("");
                    System.out.println("��������� �����, ���� ������");
                } catch (IOException e) {
                    System.out.println("�� ������� �������� ����");
                }
            } else {
                System.out.println("��������� �����");
            }
        } else {
            try {
                jaxbWorker.convertObjectToXml(movies);
            } catch (JAXBException e) {
                System.out.println("�� ������� �������� ��������� � ����");
            }
        }
    }
}