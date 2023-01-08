package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ShapeFactoryTest {
    @Test
    void 도형생성불가() {
        Point point = new Point(10, 10);
        List<Point> points = Arrays.asList(point);

        assertThatThrownBy(() -> {
            Shape shape = ShapeFactory.createShape(points);

        }).hasMessage(ShapeFactory.SHAPE_EXCEPTION);
    }

    @Test
    void 선_생성() {
        Point pointA = new Point(10, 10);
        Point pointB = new Point(14, 15);
        List<Point> points = Arrays.asList(pointA, pointB);

        Shape shape = ShapeFactory.createShape(points);

        assertThat(shape).isEqualTo(new Line(points));
    }

    @Test
    void 직사각형_생성() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(22, 10), new Point(22, 18), new Point(10, 18));
        Shape shape = ShapeFactory.createShape(points);

        assertThat(shape).isEqualTo(new Rectangle(points));
    }

    @Test
    void 삼각형_생성() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(22, 10), new Point(22, 18));
        Shape shape = ShapeFactory.createShape(points);

        assertThat(shape).isEqualTo(new Triangle(points));
    }
}
