package coordinate.domain;

import coordinate.messages.ErrorMessages;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RectangleTest {

    @Test
    void 직사각형_생성() {
        String inputs = "(10,10)-(22,10)-(22,18)-(10,18)";
        Points points = new Points(inputs);

        assertThat(new Rectangle(points)).isEqualTo(new Rectangle(points));
    }

    @Test
    void 직사각형_생성_오류() {
        String inputs = "(10,10)-(22,10)-(22,18)-(10,8)";
        Points points = new Points(inputs);

        assertThatThrownBy(() -> {
            new Rectangle(points);
        }).hasMessage(ErrorMessages.RECTANGLE_EXCEPTION);
    }

    @Test
    void 점_4개의_넓이_계산() {
        String inputs = "(10,10)-(22,10)-(22,18)-(10,18)";
        Points points = new Points(inputs);

        Rectangle rectangle = new Rectangle(points);

        assertThat(rectangle.getArea()).isEqualTo(96);
    }

    @Test
    void 실행결과_출력() {
        String inputs = "(10,10)-(22,10)-(22,18)-(10,18)";
        Points points = new Points(inputs);

        Rectangle rectangle = new Rectangle(points);

        assertThat(rectangle.getAreaString()).isEqualTo("사각형의 넓이는 " + 96);
    }
}
