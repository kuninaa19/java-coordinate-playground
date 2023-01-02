package coordinate.domain;

import coordinate.constants.PointConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Points {
    private final List<Point> points;

    public Points(String inputs) {
        points = createPoints(inputs);
    }

    private static List<Point> createPoints(String inputs) {
        List<Point> tempPoints = new ArrayList<>();

        String[] pointsString = splitMultiPointsString(inputs);

        for (String pointString : pointsString) {
            Point point = createPoint(pointString);

            tempPoints.add(point);
        }

        return tempPoints;
    }

    private static Point createPoint(String pointString) {
        String[] extractedPoint = getExtractedPoint(pointString);

        int x = Integer.parseInt(extractedPoint[0]);
        int y = Integer.parseInt(extractedPoint[1]);

        return new Point(x, y);
    }

    private static String[] splitMultiPointsString(String inputs) {
        return inputs.split(PointConstant.MULTI_POINT_REGEX);
    }

    private static String[] getExtractedPoint(String pointString) {
        return pointString.replaceAll(PointConstant.POINT_REGEX, PointConstant.POINT_REGEX_REPLACE).split(PointConstant.POINT_SEPARATOR);
    }

    public Point getPoint(int idx) {
        return this.points.get(idx);
    }

    public int count() {
        return points.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points1 = (Points) o;
        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
