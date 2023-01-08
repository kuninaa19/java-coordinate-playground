package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TriangleTest {
    @Test
    void 삼각형_생성() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(14, 15), new Point(20, 8));
        Triangle triangle = new Triangle(points);

        assertThat(triangle).isEqualTo(new Triangle(points));
    }

    @Test
    void 삼각형_넓이_구하기() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(14, 15), new Point(20, 8));
        Triangle triangle = new Triangle(points);

        assertThat(triangle.getArea()).isEqualTo(29.0, offset(0.001));
    }

    @Test
    void 삼각형_넓이_메시지() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(14, 15), new Point(20, 8));
        Triangle triangle = new Triangle(points);

        assertThat(triangle.getAreaString()).isEqualTo("삼각형 넓이는 " + triangle.getArea());
    }
}
