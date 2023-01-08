package coordinate.domain;

import coordinate.messages.ErrorMessages;

import java.util.List;
import java.util.Objects;

public class Line implements Figure {

    public static final int POINT_COUNT = 2;
    private final List<Point> points;

    public Line(Points externalPoints) {
        checkPointCount(externalPoints.count());
        points = createLine(externalPoints);
    }

    public Line(List<Point> externalPoints) {
        checkPointCount(externalPoints.size());
        points = externalPoints;
    }

    private static List<Point> createLine(Points points) {
        return points.getIndicesPoints(0, 1);
    }

    public double length() {
        Point a = points.get(0);
        Point b = points.get(1);

        return Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2));
    }

    private void checkPointCount(int count) {
        if (count < POINT_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.LINE_LENGTH_EXCEPTION);
        }
    }

    @Override
    public int getArea() {
        return 0;
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

    @Override
    public String getAreaString() {
        return "두 점 사이 거리는 " + length();
    }
}
