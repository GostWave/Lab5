package app;

import collectionObject.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

/**
 * �����, ����������� ������ {@link Movie} �������, ��������� �������������.
 */
public class MovieFiller {
    private final Scanner scanner = new Scanner(System.in);
    private String text;

    /**
     * ��������� ������ {@link Movie} ������� � ���������� ���.
     *
     * @param movie ������ ������, ������� ����� ���������
     * @return ����������� ������ {@link Movie}
     */
    public Movie fill(Movie movie) {
        movie.setCreationDate(LocalDate.now());
        Coordinates coordinates = new Coordinates();
        fillName(movie);
        fillCoordinates(movie, coordinates);
        fillGenre(movie);
        fillOscarsCount(movie);
        fillMpaaRating(movie);
        fillPerson(movie);
        return movie;
    }

    /**
     * ����������� � ������������ �������� ������.
     *
     * @param movie ������ ������, � ������� ����� ����������� ��������
     */
    public void fillName(Movie movie) {
        System.out.println("������� �������� ������:");
        while (true) {
            text = scanner.nextLine();
            if (text != null && !text.trim().isEmpty()) {
                movie.setName(text);
                break;
            } else {
                System.out.println("�������� ������ �����, ���������� ��� ���:");
            }
        }
    }

    /**
     * ����������� � ������������ ���� ������ � ������������� ���.
     *
     * @param movie ������ ������, � ������� ����� ���������� ����
     */
    public void fillGenre(Movie movie) {
        System.out.println("�������� ���� ������ �� ��������� ���������:\n" +
                MovieGenre.ACTION + "\n" +
                MovieGenre.WESTERN + "\n" +
                MovieGenre.MUSICAL + "\n" +
                MovieGenre.ADVENTURE + "\n" +
                MovieGenre.SCIENCE_FICTION);
        while (true) {
            text = scanner.nextLine().toUpperCase();
            try {
                movie.setGenre(MovieGenre.valueOf(text));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("�������� ��������. ���������� ��� ���.");
            }
        }
    }

    /**
     * ����������� � ������������ ���������� � ������������� ��.
     *
     * @param movie       ������ ������, � ������� ����� ����������� ����������
     * @param coordinates ������ ���������
     */
    public void fillCoordinates(Movie movie, Coordinates coordinates) {
        System.out.println("������� �������� ���������� X:");
        double doubleValue;
        while (true) {
            doubleValue = fillDouble();
            if (doubleValue > 160) {
                System.out.println("�������� ������ ���� �� ������ 160. ���������� ��� ���.");
            } else {
                break;
            }
        }
        coordinates.setX(doubleValue);

        System.out.println("������� �������� ���������� Y:");
        Long longValue;
        while (true) {
            longValue = fillLong();
            if (longValue > 170) {
                System.out.println("�������� ������ ���� �� ������ 170. ���������� ��� ���.");
            } else {
                break;
            }
        }
        coordinates.setY(longValue);
        movie.setCoordinates(coordinates);
    }

    /**
     * ����������� � ������������ ���������� ������ ������ � ������������� ���.
     *
     * @param movie ������ ������, � ������� ����� ����������� ���������� �������
     */
    public void fillOscarsCount(Movie movie) {
        System.out.println("������� ���������� ������ ������:");
        int intValue = fillInt();
        movie.setOscarsCount(intValue);
    }

    /**
     * ����������� � ������������ ������� MPAA � ������������� ���.
     *
     * @param movie ������ ������, � ������� ����� ���������� MPAA �������
     */
    public void fillMpaaRating(Movie movie) {
        System.out.println("�������� �������� MPAA Rating �� ��������� ���������:\n" +
                MpaaRating.G + "\n" +
                MpaaRating.PG + "\n" +
                MpaaRating.PG_13 + "\n" +
                MpaaRating.R + "\n" +
                MpaaRating.NC_17);
        while (true) {
            text = scanner.nextLine();
            try {
                movie.setMpaaRating(MpaaRating.valueOf(text));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("�������� ��������. ���������� ��� ���.");
            }
        }
    }

    /**
     * ����������� � ������������ ������ � �������� ������ � ������������� ��.
     *
     * @param movie ������ ������, � ������� ����� ����������� ������ � ��������
     * @throws DateTimeException ���� ������� ������������ ����
     */
    public void fillPerson(Movie movie) throws DateTimeException {
        Person person = new Person();
        System.out.println("������� ��� ��������:");
        while (true) {
            text = scanner.nextLine();
            if (isOnlyLetters(text)) {
                person.setName(text.trim());
                break;
            } else {
                System.out.println("�������� ������ �����: ������ ������ ��������� ������ �����. ���������� ��� ���.");
            }
        }

        System.out.println("������� ���� �������� �������� � ������� dd.MM.yyyy:");
        while (true) {
            try {
                String text = scanner.nextLine();
                String[] content = text.split("\\.");
                if (content.length != 3) {
                    throw new IllegalArgumentException("������: ������ ������ ���� dd.MM.yyyy.");
                }
                ZonedDateTime date = ZonedDateTime.of(Integer.parseInt(content[2]), Integer.parseInt(content[1]), Integer.parseInt(content[0]), 0, 0, 0, 0, ZoneId.of("Europe/Moscow"));
                if (date.isAfter(ZonedDateTime.now())) {
                    throw new DateTimeException("������: ���� �� ����� ���� � �������.");
                }
                person.setBirthday(date);
                movie.setOperator(person);
                break;
            } catch (NumberFormatException e) {
                System.out.println("������: ���� ������ ��������� ������ �����. ���������� ��� ���.");
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                System.out.println("������: ������������ ������ ����. ����������� dd.MM.yyyy. ���������� ��� ���.");
            } catch (DateTimeException e) {
                System.out.println("������: ���� �������� �� ����� ���� ����� ������� ����. ���������� ��� ���.");
            }
        }
        System.out.println("������� ����� �������� ��������");
        while (true) {
            text = scanner.nextLine();
            if (text != null && text.length() >= 6 ) {
                person.setPassportID(text);
                break;
            } else {
                System.out.println("�������� ������ �����: ������ ������ ���� ������ �� ����� 6 ��������. ���������� ��� ���");
            }
        }
    }

    /**
     * @return �������� ������������� ����� ���� double
     */
    public double fillDouble() {
        while (true) {
            try {
                text = scanner.nextLine().replace(",", ".");
                return Double.parseDouble(text);
            } catch (NumberFormatException e) {
                System.out.println("����� ������� �����.");
            }
        }
    }

    /**
     * @return �������� ������������� ����� ���� Long
     */
    public Long fillLong() {
        while (true) {
            try {
                text = scanner.nextLine();
                return Long.parseLong(text);
            } catch (NumberFormatException e) {
                System.out.println("����� ������� ����� ���� Long.");
            }
        }
    }

    /** @return �������� ������������� ����� ���� int */
    public int fillInt() {
        while (true) {
            try {
                text = scanner.nextLine();
                int value = Integer.parseInt(text);
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("����� ������ ���� ������ 0. ���������� �����.");
                }
            } catch (NumberFormatException e) {
                System.out.println("����� ������� ����� ���� int � ������ 0.");
            }
        }
    }

    /** @return {@code true}, ���� ������ �������� ������ ����� */
    public static boolean isOnlyLetters(String text) {
        if (text.isEmpty()) return false;
        for (char ch : text.toCharArray()) {
            if (!Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }
}
