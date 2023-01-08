package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LineTest {
    @Test
    void 선_생성() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(14, 15));
        Line line = new Line(points);

        assertThat(line).isEqualTo(new Line(points));
    }

    @Test
    void 두_점_사이_거리_계산() {
        List<Point> points = Arrays.asList(new Point(10, 10), new Point(14, 15));
        Line line = new Line(points);

        assertThat(line.getArea()).isEqualTo(6.403, offset(0.001));
    }
}
