package coordinate.domain;

import java.util.*;
import java.util.stream.Collectors;


public class Rectangle extends Shape {
    public static final String RECTANGLE_EXCEPTION = "직사각형이 아닙니다.";
    public static final int EQUAL_POINT_CONDITION = 2;
    public static final int RECTANGLE_CONDITION = 4;

    public Rectangle(List<Point> points) {
        super(points);
        checkRectangle(points);
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

    private int getWidth(List<Point> points, Point standardPoint) {
        List<Point> coordinates = points.stream().filter((point) -> point.getY() == standardPoint.getY()).collect(Collectors.toList());

        return coordinates.get(0).getX() - coordinates.get(1).getX();
    }

    private int getHeight(List<Point> points, Point standardPoint) {
        List<Point> coordinates = points.stream().filter((point) -> point.getX() == standardPoint.getX()).collect(Collectors.toList());

        return coordinates.get(0).getY() - coordinates.get(1).getY();
    }

    @Override
    public double getArea() {
        List<Point> points = getPoints();
        Point point = getPoint(0);

        return getWidth(points, point) * getHeight(points, point);
    }

    @Override
    public String getAreaString() {
        return "사각형의 넓이는 " + (int) getArea();
    }
}
