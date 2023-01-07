package coordinate.domain;

import coordinate.messages.ErrorMessages;

public class FigureFactory {

    public static Figure createFigure(Points points) {
        if (points.count() == Line.POINT_COUNT) {
            return new Line(points);
        }

        if(points.count() == Rectangle.POINT_COUNT){
            return new Rectangle(points);
        }

        throw new IllegalArgumentException(ErrorMessages.FIGURE_EXCEPTION);
    }
}
