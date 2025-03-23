package collectionObject;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.LinkedList;

/**
 * �����, �������������� ��������� �������.
 * �������� ������ �������� {@link Movie}, ������� �������� � ���������.
 */
@XmlRootElement()
public class Movies {

    private LinkedList<Movie> collection;

    /**
     * ������������� ��������� �������.
     *
     * @param collection ��������� �������, ������� ����� ����������
     */
    public void setMovies(LinkedList<Movie> collection) {
        this.collection = collection;
    }

    /**
     * �������� ��������� �������.
     *
     * @return ��������� ������� � ���� {@link LinkedList<Movie>}
     */
    @XmlElement(name = "movie")
    public LinkedList<Movie> getMovies() {
        return collection;
    }
}
