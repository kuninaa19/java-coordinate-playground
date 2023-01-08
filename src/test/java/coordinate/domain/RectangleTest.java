package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RectangleTest {
    @Test
    void 직사각형_생성() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(22, 10), new Point(22, 18), new Point(10, 18));

        assertThat(new Rectangle(points)).isEqualTo(new Rectangle(points));
    }

    @Test
    void 점_4개의_넓이_계산() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(22, 10), new Point(22, 18), new Point(10, 18));
        Rectangle rectangle = new Rectangle(points);

        assertThat(rectangle.getArea()).isEqualTo(96);
    }

    @Test
    void 실행결과_출력() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(22, 10), new Point(22, 18), new Point(10, 18));
        Rectangle rectangle = new Rectangle(points);

        assertThat(rectangle.getAreaString()).isEqualTo("사각형의 넓이는 " + 96);
    }
}
