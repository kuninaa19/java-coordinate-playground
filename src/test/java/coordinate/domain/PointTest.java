package coordinate.domain;

import coordinate.messages.ErrorMessages;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {
    @Test
    void 유저_입력_좌표_생성() {
        Point point = new Point(0, 24);
        assertThat(point).isEqualTo(new Point(0, 24));
    }

    @Test
    void 최소값_미만_입력_에러() {
        assertThatThrownBy(() -> {
            new Point(-1, 24);
            new Point(24, -1);
        }).hasMessage(ErrorMessages.POINT_MIN_EXCEPTION);
    }

    @Test
    void 최대값_초과_입력_에러() {
        assertThatThrownBy(() -> {
            new Point(25, 0);
            new Point(0, 25);
        }).hasMessage(ErrorMessages.POINT_MAX_EXCEPTION);
    }
}
