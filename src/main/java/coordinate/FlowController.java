package coordinate;

import coordinate.domain.Line;
import coordinate.domain.Points;
import coordinate.inputs.Input;
import coordinate.views.ErrorView;
import coordinate.views.InputView;
import coordinate.views.OutputView;

public class FlowController {
    public void run() {
        InputView.coordinateInputForm();
        Points points = createPoints();
        OutputView.printCoordinatePlate(points);
        Line line = new Line(points);
        OutputView.printLine(line);
    }

    private Points createPoints() {
        try {
            return new Points(Input.read());
        } catch (IllegalArgumentException e) {
            ErrorView.printError(e.getMessage());
            return createPoints();
        }
    }
}
