package coordinate.domain;

import coordinate.messages.ErrorMessages;

import java.util.*;


public class Rectangle implements Figure {
    public static final int POINT_COUNT = 4;
    public static final int EQUAL_POINT_CONDITION = 2;
    public static final int RECTANGLE_CONDITION = 4;
    private final Points points;

    public Rectangle(Points points) {
        checkPointCount(points);
        checkRectangle(points);

        this.points = points;
    }

    private void checkPointCount(Points points) {
        if (points.count() < POINT_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.RECTANGLE_POINT_LACK_EXCEPTION);
        }
    }

    private void checkRectangle(Points points) {
        if (!isRectangle(getCoordinateXPoints(points), getCoordinateYPoints(points))) {
            throw new IllegalArgumentException(ErrorMessages.RECTANGLE_EXCEPTION);
        }
    }

    private boolean isRectangle(int[] coordinateXPoints, int[] coordinateYPoints) {
        return getPointSum(coordinateXPoints) == RECTANGLE_CONDITION && getPointSum(coordinateYPoints) == RECTANGLE_CONDITION;
    }

    private int getPointSum(int[] points) {
        return Arrays.stream(points).filter(p -> p == EQUAL_POINT_CONDITION).sum();
    }

    private int[] getCoordinateXPoints(Points points) {
        int[] coordinateX = new int[Point.MAX + 1];

        for (int i = 0; i < points.count(); i++) {
            /* bad case : get을 한다음 데이터 처리하지마라. */
            Point point = points.getPoint(i);
            coordinateX[point.getX()] += 1;
        }

        return coordinateX;
    }

    private int[] getCoordinateYPoints(Points points) {
        int[] coordinateY = new int[Point.MAX + 1];

        for (int i = 0; i < points.count(); i++) {
            /* bad case : get을 한다음 데이터 처리하지마라. */
            Point point = points.getPoint(i);
            coordinateY[point.getY()] += 1;
        }

        return coordinateY;
    }

    @Override
    public int getArea() {
        int width = points.getMaxPointX() - points.getMinPointX();
        int height = points.getMaxPointY() - points.getMinPointY();

        return width * height;
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

    @Override
    public String getAreaString() {
        return "사각형의 넓이는 " + getArea();
    }
}
