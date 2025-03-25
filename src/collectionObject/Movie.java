package collectionObject;

import IO.LocalDateAdapter;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * �����, �������������� �����.
 * ��������� ��� �������� ���������� � ������, ����� ��� ��������, ����������, ����, �������, ���������� ������� � �. �.
 */
@XmlRootElement()
@XmlType(propOrder = {"name", "coordinates", "genre", "mpaaRating", "oscarsCount", "operator", "creationDate"})
public class Movie implements Comparable<Movie> {

    private Long id; // ���� �� ����� ���� null, �������� ���� ������ ���� ������ 0, �������� ����� ���� ������ ���� ����������, �������� ����� ���� ������ �������������� �������������
    private String name; // ���� �� ����� ���� null, ������ �� ����� ���� ������
    private Coordinates coordinates; // ���� �� ����� ���� null
    private LocalDate creationDate; // ���� �� ����� ���� null, �������� ����� ���� ������ ���� �������������� �������������
    private int oscarsCount; // �������� ���� ������ ���� ������ 0
    private MovieGenre genre; // ���� ����� ���� null
    private MpaaRating mpaaRating; // ���� �� ����� ���� null
    private Person operator; // ���� �� ����� ���� null


    @Override
    public int compareTo(Movie movie) {
        return Long.compare(this.id, movie.getId());
    }

    /**
     * ������������� id ������.
     *
     * @param id ������������� ������
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * �������� id ������.
     *
     * @return id ������
     */
    @XmlAttribute
    public Long getId() {
        return id;
    }

    /**
     * ������������� �������� ������.
     *
     * @param name �������� ������
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * �������� �������� ������.
     *
     * @return �������� ������
     */
    @XmlElement
    public String getName() {
        return name;
    }

    /**
     * ������������� ���������� ������.
     *
     * @param coordinates ���������� ������
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * �������� ���������� ������.
     *
     * @return ���������� ������
     */
    @XmlElement
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * ������������� ���� �������� ������.
     *
     * @param localDate ���� �������� ������
     */
    public void setCreationDate(LocalDate localDate) {
        this.creationDate = localDate;
    }

    /**
     * �������� ���� �������� ������.
     *
     * @return ���� �������� ������
     */
    @XmlElement
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * ������������� ���������� ������ ������.
     *
     * @param oscarsCount ���������� ������ ������
     */
    public void setOscarsCount(int oscarsCount) {
        this.oscarsCount = oscarsCount;
    }

    /**
     * �������� ���������� ������ ������.
     *
     * @return ���������� ������ ������
     */
    @XmlElement
    public int getOscarsCount() {
        return oscarsCount;
    }

    /**
     * ������������� ���� ������.
     *
     * @param genre ���� ������
     */
    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    /**
     * �������� ���� ������.
     *
     * @return ���� ������
     */
    public MovieGenre getGenre() {
        return genre;
    }

    /**
     * ������������� ������� ������ �� ������� MPAA.
     *
     * @param mpaaRating ������� ������
     */
    public void setMpaaRating(MpaaRating mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    /**
     * �������� ������� ������ �� ������� MPAA.
     *
     * @return ������� ������
     */
    @XmlElement
    public MpaaRating getMpaaRating() {
        return mpaaRating;
    }

    /**
     * ������������� ��������� ������.
     *
     * @param operator �������� ������
     */
    public void setOperator(Person operator) {
        this.operator = operator;
    }

    /**
     * �������� ��������� ������.
     *
     * @return �������� ������
     */
    @XmlElement
    public Person getOperator() {
        return operator;
    }

    /**
     * ���������� ��������� ������������� ������.
     * ������ �������� ���������� � ��������, �����������, �����, ���������� �������,
     * �������� MPAA � ���������.
     *
     * @return ��������� ������������� ������
     */
    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "Movie{" +
                "creationDate: " + creationDate +
                ", id = " + id +
                ", name: " + name +
                ", Coordinate X: " + coordinates.getX() +
                ", Coordinate Y: " + coordinates.getY() +
                ", genre: " + genre +
                ", oscarsCount: " + oscarsCount +
                ", mpaaRating: " + mpaaRating +
                ", Operator{name: " + operator.getName() +
                ", birthday: " + operator.getBirthday().format(dateTimeFormatter) +
                ", passportID: " + operator.getPassportID() +
                "}}";
    }
}
