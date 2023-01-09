package coordinate.inputs;

import coordinate.domain.ShapeFactory;
import coordinate.domain.Point;
import coordinate.domain.Shape;
import coordinate.views.ErrorView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    public static final String POINT_REGEX = "[\\(\\)]";
    public static final String MULTI_POINT_REGEX = "\\)-\\(";
    public static final String POINT_REGEX_REPLACE = "";
    public static final String POINT_SEPARATOR = ",";

    private static String read() {
        return new Scanner(System.in).nextLine();
    }

    public static Shape inputShape() {
        try {
            List<Point> points = createPoints(Input.read());

            return ShapeFactory.createShape(points);
        } catch (IllegalArgumentException e) {
            ErrorView.printError(e.getMessage());
            return inputShape();
        }
    }

    private static List<Point> createPoints(String inputs) {
        List<Point> points = new ArrayList<>();

        String[] pointsString = splitMultiPointsString(inputs);

        for (String pointString : pointsString) {
            Point point = createPoint(pointString);

            points.add(point);
        }

        return points;
    }

    private static String[] splitMultiPointsString(String inputs) {
        return inputs.split(MULTI_POINT_REGEX);
    }

    private static Point createPoint(String pointString) {
        String[] extractedPoint = extractPoint(pointString);

        int x = Integer.parseInt(extractedPoint[0]);
        int y = Integer.parseInt(extractedPoint[1]);

        return new Point(x, y);
    }

    private static String[] extractPoint(String pointString) {
        return pointString.replaceAll(POINT_REGEX, POINT_REGEX_REPLACE).split(POINT_SEPARATOR);
    }
}
