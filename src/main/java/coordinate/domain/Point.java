package coordinate.domain;

import coordinate.messages.ErrorMessages;

import java.util.Objects;

public class Point {
    public static final int MIN = 0;
    public static final int MAX = 24;
    private final int x;
    private final int y;

    public Point(int x, int y) {
        checkValidPoint(x, y);

        this.x = x;
        this.y = y;
    }

    private void checkValidPoint(int x, int y) {
        if (x < MIN || y < MIN) {
            throw new IllegalArgumentException(ErrorMessages.POINT_MIN_EXCEPTION);
        }

        if (x > MAX || y > MAX) {
            throw new IllegalArgumentException(ErrorMessages.POINT_MAX_EXCEPTION);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
