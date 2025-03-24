package collectionObject;

/**
 * �����, �������������� ���������� (X, Y) ��� ������.
 */
public class Coordinates {

    private Double x; // ������������ �������� ����: 160
    private Long y; // ������������ �������� ����: 170, ���� �� ����� ���� null

    /**
     * ������������� �������� ���������� X.
     * �������� X ������ ���� �� ������ 160.
     *
     * @param x ���������� X
     */
    public void setX(Double x) {
        this.x = x;
    }

    /**
     * ������������� �������� ���������� Y.
     * �������� Y ������ ���� �� ������ 170.
     *
     * @param y ���������� Y
     */
    public void setY(Long y) {
        this.y = y;
    }

    /**
     * �������� �������� ���������� X.
     *
     * @return ���������� X
     */
    public Double getX() {
        return x;
    }

    /**
     * �������� �������� ���������� Y.
     *
     * @return ���������� Y
     */
    public Long getY() {
        return y;
    }
}
