package coordinate.domain;

import java.util.List;
import java.util.Objects;

public abstract class Shape implements Figure {
    private final List<Point> points;

    protected Shape(List<Point> points) {
        this.points = points;
    }

    @Override
    public List<Point> getPoints() {
        return this.points;
    }

    @Override
    public Point getPoint(int idx) {
        return this.points.get(idx);
    }

    @Override
    public boolean hasPoint(int x, int y) {
        return points.stream().anyMatch(point -> point.equals(new Point(x, y)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(points, shape.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
