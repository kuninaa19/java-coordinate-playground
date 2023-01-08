package coordinate;

import coordinate.domain.Shape;
import coordinate.inputs.Input;
import coordinate.views.InputView;
import coordinate.views.OutputView;

public class FlowController {
    public void run() {
        InputView.coordinateInputForm();
        Shape shape = Input.inputShape();

        OutputView.printCoordinatePlate(shape);
        OutputView.printArea(shape);
    }
}
