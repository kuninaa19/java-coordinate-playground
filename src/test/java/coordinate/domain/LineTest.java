package coordinate.domain;

import coordinate.messages.ErrorMessages;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineTest {
    @Test
    void 두_점_사이_거리_계산() {
        String inputs = "(10,10)-(14,15)";
        Points points = new Points(inputs);

        Line line = new Line(points);

        assertThat(line.length()).isEqualTo(6.403, offset(0.001));
    }

    @Test
    void 두_점_사이_거리_계산_에러_한개_이하의_점() {
        String inputs = "(10,10)";
        Points points = new Points(inputs);

        assertThatThrownBy(() -> {
            Line line = new Line(points);
            double distance = line.length();
        }).hasMessage(ErrorMessages.LINE_LENGTH_EXCEPTION);
    }
}
