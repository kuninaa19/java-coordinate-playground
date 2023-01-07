package coordinate.domain;

import coordinate.messages.ErrorMessages;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FigureFactoryTest {
    @Test
    void 도형생성불가() {
        String inputs = "(10,10)";
        Points points = new Points(inputs);

        assertThatThrownBy(() -> {
            Figure figure = FigureFactory.createFigure(points);

        }).hasMessage(ErrorMessages.FIGURE_EXCEPTION);
    }

    @Test
    void 선_생성() {
        String inputs = "(10,10)-(14,15)";
        Points points = new Points(inputs);

        Figure figure = FigureFactory.createFigure(points);

        assertThat(figure).isEqualTo(new Line(points));
    }

    @Test
    void 직사각형_생성() {
        String inputs = "(10,10)-(22,10)-(22,18)-(10,18)";
        Points points = new Points(inputs);

        Figure figure = FigureFactory.createFigure(points);

        assertThat(figure).isEqualTo(new Rectangle(points));
    }
}
