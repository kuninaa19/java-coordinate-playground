package coordinate.domain;

import java.util.*;

public class Triangle extends Shape {
    public static final String TRIANGLE_EXCEPTION = "삼각형이 아닙니다.";
    private final List<Point> points;

    public Triangle(List<Point> points) {
        isTriangle(points);

        this.points = points;
    }

    private void isTriangle(List<Point> points) {
        Point maxX = points.stream().max(Comparator.comparing(Point::getX)).orElseThrow(NoSuchElementException::new);
        Point minX = points.stream().min(Comparator.comparing(Point::getX)).orElseThrow(NoSuchElementException::new);

        Point maxY = points.stream().max(Comparator.comparing(Point::getY)).orElseThrow(NoSuchElementException::new);
        Point minY = points.stream().min(Comparator.comparing(Point::getY)).orElseThrow(NoSuchElementException::new);

        if (maxX.getX() == minX.getX() || maxY.getY() == minY.getY()) {
            throw new IllegalArgumentException(TRIANGLE_EXCEPTION);
        }
    }

    /* 삼각형 넓이 구하기: https://ko.wikipedia.org/wiki/헤론의_공식 */
    @Override
    public double getArea() {
        Line lineA = new Line(Arrays.asList(points.get(0), points.get(1)));
        Line lineB = new Line(Arrays.asList(points.get(1), points.get(2)));
        Line lineC = new Line(Arrays.asList(points.get(2), points.get(0)));

        double s = (lineA.getArea() + lineB.getArea() + lineC.getArea()) / 2;

        return Math.sqrt(s * (s - lineA.getArea()) * (s - lineB.getArea()) * (s - lineC.getArea()));
    }

    @Override
    public String getAreaString() {
        return "삼각형 넓이는 " + getArea();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(points, triangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
