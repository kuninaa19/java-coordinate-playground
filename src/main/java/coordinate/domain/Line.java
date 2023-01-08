package coordinate.domain;

import java.util.List;
import java.util.Objects;

public class Line extends Shape {
    public static final String LENGTH_EXCEPTION = "점 2개가 필요합니다";
    public static final int POINT_COUNT = 2;
    private final List<Point> points;

    public Line(List<Point> points) {
        checkPointCount(points);

        this.points = points;
    }

    private void checkPointCount(List<Point> points) {
        if (points.size() != POINT_COUNT) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION);
        }
    }

    @Override
    public double getArea() {
        Point a = points.get(0);
        Point b = points.get(1);

        return Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2));
    }

    @Override
    public String getAreaString() {
        return "두 점 사이 거리는 " + getArea();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
