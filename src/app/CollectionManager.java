package app;

import collectionObject.Movie;
import collectionObject.Movies;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

import static java.lang.String.valueOf;

/**
 * �������� ���������, ���������� �� ���������� � ��������� ��������� �������.
 * ��������� ���������, ���������, ������� � ����������� ������� ���������.
 */
public class CollectionManager {
    /**
     * ��������� �������, ���������� � ���� �������� ������.
     */
    private LinkedList<Movie> collection = new LinkedList<>();

    /**
     * ������� id ��� �������.
     */
    private Long currentid = 0L;

    /** ������ ��� ���������� ���������� � ������. */
    MovieFiller movieFiller = new MovieFiller();

    /**
     * �������� ��������� �������.
     *
     * @return ��������� �������
     */
    public LinkedList<Movie> getCollection() {
        return collection;
    }

    /**
     * ������������� ������������ id � ���������.
     */
    public void setCurrentid() {
        for (Movie movie : collection) {
            if (movie.getId() > currentid) {
                currentid = movie.getId();
            }
        }
    }

    /**
     * ������������� � ��������� ������� ���������.
     *
     * @param movies ������, ���������� ����� ��������� �������
     */
    public void setCollection(Movies movies) {
        this.collection = movies.getMovies();
        checkCollection(movies);
        setCurrentid();
        Collections.sort(collection);
    }

    /**
     * ������� ����� ����� � ���������� ��������������� � ��������� ��� �������.
     *
     * @return ��������� ������ ������
     */
    public Movie createMovie() {
        Movie movie = new Movie();
        movie.setId(++currentid);
        movie = movieFiller.fill(movie);
        return movie;
    }

    /**
     * ��������� ����� � ���������.
     *
     * @param movie ����� ��� ����������
     */
    public void addMovie(Movie movie) {
        collection.add(movie);
        System.out.println("������� ������� �������� � ���������");
    }

    /**
     * ������� ���������� ��������� � �������.
     */
    public void showCollection() {
        if (collection.isEmpty()) {
            System.out.println("��������� �����");
        } else {
            for (Movie movie : collection) {
                System.out.println(movie.toString());
            }
        }
    }

    /**
     * ������� ��������� �������.
     */
    public void clearCollection() {
        collection.clear();
        currentid = 0L;
    }

    /**
     * ������������ �������� ��������� � ��������� �������.
     */
    public void shuffleCollection() {
        Collections.shuffle(collection);
    }

    /**
     * ���� ����� � ��������� �� ��� id.
     *
     * @param id ������������� ������
     * @return ��������� ����� ��� null, ���� ����� �� ������
     */
    public Movie findMovieById(Long id) {
        for (Movie movie : collection) {
            if (movie.getId().equals(id)) {
                return movie;
            }
        }
        return null;
    }

    /**
     * ��������� ������������ ������� ��������� �� ��� id.
     *
     * @param id    id ������
     * @param movie ����� ������ ������
     */
    public void updateElement(Long id, Movie movie) {
        collection.remove(movie);
        Movie update = new Movie();
        update.setId(id);
        collection.add(movieFiller.fill(update));
    }

    /**
     * ������� ����� �� ���������.
     *
     * @param movie ����� ��� ��������
     */
    public void removeElement(Movie movie) {
        collection.remove(movie);
    }

    /**
     * ��������� ����� ������� � ��������� ������� ���������.
     *
     * @param index ������, ���� ����� �������� �����
     */
    public void insertElement(int index) {
        try {
            Movie movie = createMovie();
            collection.add(index, movie);
            System.out.println("������� ������� �������� � ���������");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("����� �������� ������");
        }
    }

    /**
     * �������� ���������� �������� MPAA ��������� �� ���������.
     *
     * @return ��������� ���������� �������� MPAA ��������
     */
    public HashSet<String> uniqueMpaa() {
        HashSet<String> set = new HashSet<>();
        for (Movie movie : collection) {
            set.add(valueOf(movie.getMpaaRating()));
        }
        return set;
    }

    /**
     * ������� ���������� oscarsCount ���� ������� � ������� �����������.
     */
    public void printOscarsCount() {
        int[] oscarsCount = new int[collection.size()];
        int i = 0;
        for (Movie movie : collection) {
            oscarsCount[i] = movie.getOscarsCount();
            i++;
        }
        Arrays.sort(oscarsCount);
        for (int item : oscarsCount) {
            System.out.println(item);
        }
    }

    /**
     * ���������� ������������ ���������� oscarsCount ����� ���� ������� � ���������.
     *
     * @return ������������ ���������� oscarsCount
     */
    public int getMaxOscarsCount() {
        int maxOscars = Integer.MIN_VALUE;
        for (Movie movie : collection) {
            if (movie.getOscarsCount() > maxOscars) {
                maxOscars = movie.getOscarsCount();
            }
        }
        return maxOscars;
    }
    public void checkCollection(Movies movies){
        for (Movie movie: movies.getMovies()){
            System.out.println(movie.toString());
        }
    }
}
