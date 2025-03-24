package collectionObject;

/**
 *  ласс, представл€ющий координаты (X, Y) дл€ фильма.
 */
public class Coordinates {

    private Double x; // ћаксимальное значение пол€: 160
    private Long y; // ћаксимальное значение пол€: 170, ѕоле не может быть null

    /**
     * ”станавливает значение координаты X.
     * «начение X должно быть не больше 160.
     *
     * @param x координата X
     */
    public void setX(Double x) {
        this.x = x;
    }

    /**
     * ”станавливает значение координаты Y.
     * «начение Y должно быть не больше 170.
     *
     * @param y координата Y
     */
    public void setY(Long y) {
        this.y = y;
    }

    /**
     * ѕолучает значение координаты X.
     *
     * @return координата X
     */
    public Double getX() {
        return x;
    }

    /**
     * ѕолучает значение координаты Y.
     *
     * @return координата Y
     */
    public Long getY() {
        return y;
    }
}
