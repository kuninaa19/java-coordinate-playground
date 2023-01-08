package coordinate.domain;

import coordinate.messages.ErrorMessages;

import java.util.Arrays;
import java.util.Objects;

public class Triangle implements Figure {
    public static final int POINT_COUNT = 3;
    private final Points points;

    public Triangle(Points points) {
        checkPointCount(points);
        isTriangle(points);

        this.points = points;
    }

    private void checkPointCount(Points points) {
        if (points.count() != POINT_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.TRIANGLE_POINT_LACK_EXCEPTION);
        }
    }

    private void isTriangle(Points points) {
        if (points.getMaxPointX() == points.getMinPointX() || points.getMaxPointY() == points.getMinPointY()) {
            throw new IllegalArgumentException(ErrorMessages.TRIANGLE_EXCEPTION);
        }
    }

    /* 삼각형 넓이 구하기: https://ko.wikipedia.org/wiki/헤론의_공식 */
    public double area() {
        Line lineA = new Line(points.getIndicesPoints(0, 1));
        Line lineB = new Line(points.getIndicesPoints(1, 2));
        Line lineC = new Line(points.getIndicesPoints(2, 0));

        double s = (lineA.length() + lineB.length() + lineC.length()) / 2;

        return Math.sqrt(s * (s - lineA.length()) * (s - lineB.length()) * (s - lineC.length()));
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

    @Override
    public int getArea() {
        /* 타입 변경 예정 */
        return 0;
    }

    @Override
    public String getAreaString() {
        return "삼각형 넓이는 " + area();
    }
}
