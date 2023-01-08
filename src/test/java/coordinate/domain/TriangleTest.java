package coordinate.domain;

import coordinate.messages.ErrorMessages;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TriangleTest {
    @Test
    void 삼각형_생성() {
        String inputs = "(10,10)-(14,15)-(20,8)";
        Points points = new Points(inputs);
        Triangle triangle = new Triangle(points);

        assertThat(triangle).isEqualTo(new Triangle(points));
    }

    @Test
    void 예외처리_점이_3개가_아닐때() {
        String inputs = "(10,10)-(14,15)-(20,8)-(1,5)";
        Points points = new Points(inputs);

        assertThatThrownBy(() -> {
            Triangle triangle = new Triangle(points);
        }).hasMessage(ErrorMessages.TRIANGLE_POINT_LACK_EXCEPTION);
    }

    @Test
    void 삼각형_넓이_구하기() {
        String inputs = "(10,10)-(14,15)-(20,8)";
        Points points = new Points(inputs);

        Triangle triangle = new Triangle(points);

        assertThat(triangle.area()).isEqualTo(29.0, offset(0.001));
    }

    @Test
    void 삼각형_넓이_메시지() {
        String inputs = "(10,10)-(14,15)-(20,8)";
        Points points = new Points(inputs);

        Triangle triangle = new Triangle(points);

        assertThat(triangle.getAreaString()).isEqualTo("삼각형 넓이는 " + triangle.area());

    }
}
