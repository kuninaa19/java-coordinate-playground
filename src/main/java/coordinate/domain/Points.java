package coordinate.domain;

import coordinate.constants.PointConstant;
import coordinate.messages.ErrorMessages;

import java.util.*;

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

    public boolean hasPoint(int x, int y) {
        return points.stream().anyMatch(point -> point.equals(new Point(x, y)));
    }

    public int getMaxPointX() {
        Point max = this.points.stream().max(Comparator.comparing(Point::getX)).orElseThrow(NoSuchElementException::new);
        return max.getX();
    }

    public int getMinPointX() {
        Point min = this.points.stream().min(Comparator.comparing(Point::getX)).orElseThrow(NoSuchElementException::new);
        return min.getX();
    }

    public int getMaxPointY() {
        Point max = this.points.stream().max(Comparator.comparing(Point::getY)).orElseThrow(NoSuchElementException::new);
        return max.getY();
    }

    public int getMinPointY() {
        Point min = this.points.stream().min(Comparator.comparing(Point::getY)).orElseThrow(NoSuchElementException::new);
        return min.getY();
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

    public List<Point> getIndicesPoints(int i, int j) {
        long count = points.size() - 1;

        if (count < i || count < j) {
            throw new IndexOutOfBoundsException(ErrorMessages.POINT_INDEX_EXCEPTION);
        }

        return Arrays.asList(points.get(i), points.get(j));
    }
}
