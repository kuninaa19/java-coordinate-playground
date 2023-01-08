package coordinate.domain;

import coordinate.messages.ErrorMessages;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointsTest {
    @Test
    void 유저_입력_좌표_생성() {
        String inputs = "(0,24)";
        Points points = new Points(inputs);

        assertThat(points).isEqualTo(new Points("(0,24)"));
    }

    @Test
    void 유저_입력_다중_좌표_생성() {
        String inputs = "(0,24)-(24,0)";
        Points points = new Points(inputs);

        assertThat(points).isEqualTo(new Points("(0,24)-(24,0)"));
    }

    @Test
    void 유저_입력_좌표_에러() {
        String inputs = "(-1,2)-(3,-4)-(-3,-3)";
        String input = "(1,-1)";

        assertThatThrownBy(() -> {
            Points points = new Points(inputs);
            Points point = new Points(inputs);
        }).hasMessage(Point.RANGE_MIN_EXCEPTION);
    }

    @Test
    void 특정_인덱스_출력() {
        String inputs = "(0,24)-(24,0)";
        Points points = new Points(inputs);

        List<Point> expected = Arrays.asList(points.getPoint(0), points.getPoint(1));
        assertThat(points.getIndicesPoints(0, 1)).isEqualTo(expected);
    }


    @Test
    void 특정_인덱스_출력_에러() {
        String inputs = "(0,24)-(24,0)";
        Points points = new Points(inputs);

        assertThatThrownBy(() -> {
            points.getIndicesPoints(0, 2);
        }).hasMessage(ErrorMessages.POINT_INDEX_EXCEPTION);
    }
}
