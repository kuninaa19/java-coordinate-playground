package coordinate.domain;

import java.util.Objects;

public class Point {
    public static final String RANGE_MIN_EXCEPTION = "좌표 최소 값은 " + Point.MIN + "입니다";
    public static final String RANGE_MAX_EXCEPTION = "좌표 최대 값은 " + Point.MAX + "입니다";
    public static final int MIN = 0;
    public static final int MAX = 24;
    private final int x;
    private final int y;

    public Point(int x, int y) {
        checkValidRange(x, y);

        this.x = x;
        this.y = y;
    }

    private void checkValidRange(int x, int y) {
        if (x < MIN || y < MIN) {
            throw new IllegalArgumentException(RANGE_MIN_EXCEPTION);
        }

        if (x > MAX || y > MAX) {
            throw new IllegalArgumentException(RANGE_MAX_EXCEPTION);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
