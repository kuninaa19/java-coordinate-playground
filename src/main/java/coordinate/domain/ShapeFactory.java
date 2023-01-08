package coordinate.domain;

import java.util.List;

public class ShapeFactory {
    public static final String SHAPE_EXCEPTION = "도형이 아닙니다.";
    public static final int LINE_POINT_COUNT = 2;
    public static final int RECTANGLE_POINT_COUNT = 4;
    public static final int TRIANGLE_POINT_COUNT = 3;

    public static Shape createShape(List<Point> points) {
        if (points.size() == LINE_POINT_COUNT) {
            return new Line(points);
        }

        if (points.size() == RECTANGLE_POINT_COUNT) {
            return new Rectangle(points);
        }

        if (points.size() == TRIANGLE_POINT_COUNT) {
            return new Triangle(points);
        }

        throw new IllegalArgumentException(SHAPE_EXCEPTION);
    }
}
