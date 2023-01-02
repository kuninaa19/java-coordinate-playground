package coordinate;

import coordinate.domain.Points;
import coordinate.inputs.Input;
import coordinate.views.ErrorView;
import coordinate.views.InputView;

public class FlowController {
    public void run() {
        InputView.coordinateInputForm();
        Points points = createPoints();
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
