package coordinate.domain;

import java.util.*;


public class Rectangle extends Shape {
    public static final String RECTANGLE_EXCEPTION = "직사각형이 아닙니다.";
    public static final int EQUAL_POINT_CONDITION = 2;
    public static final int RECTANGLE_CONDITION = 4;
    private final List<Point> points;

    public Rectangle(List<Point> points) {
        checkRectangle(points);

        this.points = points;
    }

    private void checkRectangle(List<Point> points) {
        if (!isRectangle(getCoordinateXPoints(points), getCoordinateYPoints(points))) {
            throw new IllegalArgumentException(RECTANGLE_EXCEPTION);
        }
    }

    private int[] getCoordinateXPoints(List<Point> points) {
        int[] coordinateX = new int[Point.MAX + 1];

        for (Point point : points) {
            coordinateX[point.getX()] += 1;
        }

        return coordinateX;
    }

    private int[] getCoordinateYPoints(List<Point> points) {
        int[] coordinateY = new int[Point.MAX + 1];

        for (Point point : points) {
            coordinateY[point.getY()] += 1;
        }

        return coordinateY;
    }

    private boolean isRectangle(int[] coordinateXPoints, int[] coordinateYPoints) {
        return getPointSum(coordinateXPoints) == RECTANGLE_CONDITION && getPointSum(coordinateYPoints) == RECTANGLE_CONDITION;
    }

    private int getPointSum(int[] points) {
        return Arrays.stream(points).filter(point -> point == EQUAL_POINT_CONDITION).sum();
    }

    private int getWidth() {
        Point max = this.points.stream().max(Comparator.comparing(Point::getX)).orElseThrow(NoSuchElementException::new);
        Point min = this.points.stream().min(Comparator.comparing(Point::getX)).orElseThrow(NoSuchElementException::new);

        return max.getX() - min.getX();
    }

    private int getHeight() {
        Point max = this.points.stream().max(Comparator.comparing(Point::getY)).orElseThrow(NoSuchElementException::new);
        Point min = this.points.stream().min(Comparator.comparing(Point::getY)).orElseThrow(NoSuchElementException::new);

        return max.getY() - min.getY();
    }

    @Override
    public double getArea() {
        return getWidth() * getHeight();
    }

    @Override
    public String getAreaString() {
        return "사각형의 넓이는 " + (int) getArea();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(points, rectangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
