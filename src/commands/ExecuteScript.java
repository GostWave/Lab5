package commands;

import IO.CollectionChecker;
import app.App;
import app.CollectionManager;
import app.ConsoleCaller;
import collectionObject.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Scanner;

/**
 * ����� ������� ExecuteScript, ��������������� ��� ���������� ������ �� ���������� �����.
 */
public class ExecuteScript implements Command {
    final ConsoleCaller consoleCaller = App.getApp().getConsoleCaller();
    CollectionManager collectionManager = App.getApp().getCollectionManager();
    Movie movie ;
    /**
     * ��������� �������, �������� ������� �� ����� � �������� �� ���������������.
     *
     * @param argument ��� �����, ����������� ������� ��� ����������
     */
    @Override
    public void execute(String argument) {
        HashSet<String> callScripts= new HashSet<>();
        try {
            Scanner scanner = new Scanner(new File(argument));

            while (scanner.hasNext()) {
                String text = scanner.nextLine().trim();
//                System.out.println(text);
                if (text.length()>4 && text.substring(text.length() - 4).equals(".txt")){
                    callScripts.add(text.split(" ")[1]);
                }
                if (text.length()>4 && text.substring(text.length() - 4).equals(".txt") && callScripts.contains(text.split(" ")[1])){
                    System.out.println("�������� ��������");
                    break;
                } else if (text.equals("add")){
                    if (element(scanner)){
                        collectionManager.addMovie(movie);
                    }
                } else if (text.contains("update")) {
                    if (element(scanner)){
                        try {
                            collectionManager.updateElement(Long.parseLong(text.split(" ")[1]),movie);
                        } catch (NumberFormatException e) {
                            System.out.println("������ ��� ���������� �������");
                        }
                    }
                } else if (text.contains("insert")){
                    try {
                        collectionManager.insertElement(movie,Integer.parseInt(text.split(" ")[1]));
                    } catch (NumberFormatException e) {
                        System.out.println("������ ��� ���������� �������");
                    }
                } else if (text.contains("add_if_max")){
                    try {
                        if (movie.getOscarsCount() > collectionManager.getMaxOscarsCount()) {
                            collectionManager.addMovie(movie);
                        } else {
                            System.out.println("������� �� ��� �������� � ���������");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("������ ��� ���������� �������");
                    }
                } else {
                    consoleCaller.call(text);
                }


            }
        } catch (FileNotFoundException e) {
            System.out.println("������� �������� ��� ����� ��� ����������� ���� �����������");
        }
    }


    public boolean element(Scanner scanner){
        movie=new Movie();
        movie.setId(collectionManager.getCurrentid());
        String text;
        movie.setName(scanner.nextLine().trim());
        Coordinates coordinates = new Coordinates();
        text = scanner.nextLine().trim();
        try{
            coordinates.setX(Double.parseDouble(text));
        } catch (NumberFormatException e) {
            System.out.println("������ ��� ���������� �������");
            return false;
        }
        text = scanner.nextLine().trim();
        try{
            coordinates.setY(Long.parseLong(text));
        } catch (NumberFormatException e) {
            System.out.println("������ ��� ���������� �������");
            return false;
        }
        movie.setCoordinates(coordinates);
        text = scanner.nextLine().trim().toUpperCase();
        try {
            movie.setGenre(MovieGenre.valueOf(text));
        } catch (IllegalArgumentException e) {
            System.out.println("������ ��� ���������� �������");
            return false;
        }
        text = scanner.nextLine().trim();
        try {
            movie.setOscarsCount(Integer.parseInt(text));
        } catch (NumberFormatException e) {
            System.out.println("������ ��� ���������� �������");
            return false;
        }
        text = scanner.nextLine().trim();
        try {
            movie.setMpaaRating(MpaaRating.valueOf(text));
        } catch (IllegalArgumentException e) {
            System.out.println("������ ��� ���������� �������");
            return false;
        }
        Person person = new Person();
        text = scanner.nextLine().trim();
        try {
            person.setName(text);
        } catch (Exception e) {
            System.out.println("������ ��� ���������� �������");
            return false;
        }
        text = scanner.nextLine().trim();
        try {
            String[] content = text.split("\\.");
            if (content.length != 3) {
                System.out.println("������ ��� ���������� �������");
                return false;
            }
            ZonedDateTime date = ZonedDateTime.of(Integer.parseInt(content[2]), Integer.parseInt(content[1]), Integer.parseInt(content[0]), 0, 0, 0, 0, ZoneId.of("Europe/Moscow"));
            if (date.isAfter(ZonedDateTime.now())) {
                System.out.println("������ ��� ���������� �������");
                return false;
            }
            person.setBirthday(date);
        } catch (Exception e) {
            System.out.println("������ ��� ���������� �������");
            return false;
        }
        text = scanner.nextLine().trim();
        try {
            person.setPassportID(text);
        } catch (Exception e){
            System.out.println("������ ��� ���������� �������");
            return false;
        }
        movie.setOperator(person);
        movie.setCreationDate(LocalDate.now());
        System.out.println(movie.toString());
        CollectionChecker collectionChecker = new CollectionChecker(new Movies());
        if (collectionChecker.checkMovie(movie)) {
            return true;
        } else {
            return false;
        }


    }

    /**
     * ���������� �������� �������.
     *
     * @return ������ � ��������� �������
     */
    @Override
    public String getDescription() {
        return "������� � ��������� ������ �� ���������� �����. � ������� ���������� ������� � ����� �� ����, � ������� �� ������ ������������ � ������������� ������";
    }
}
