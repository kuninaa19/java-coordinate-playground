package coordinate.domain;

import java.util.*;

public class Triangle extends Shape {
    public static final String TRIANGLE_EXCEPTION = "삼각형이 아닙니다.";

    public Triangle(List<Point> points) {
        super(points);
        isTriangle(points);
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
        Line lineA = new Line(Arrays.asList(getPoint(0), getPoint(1)));
        Line lineB = new Line(Arrays.asList(getPoint(1), getPoint(2)));
        Line lineC = new Line(Arrays.asList(getPoint(2), getPoint(0)));

        double s = (lineA.getArea() + lineB.getArea() + lineC.getArea()) / 2;

        return Math.sqrt(s * (s - lineA.getArea()) * (s - lineB.getArea()) * (s - lineC.getArea()));
    }

    @Override
    public String getAreaString() {
        return "삼각형 넓이는 " + getArea();
    }
}
