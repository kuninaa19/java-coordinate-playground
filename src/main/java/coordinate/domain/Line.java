package coordinate.domain;

import coordinate.messages.ErrorMessages;

public class Line {

    public static final int POINT_COUNT = 2;
    private final Points points;

    public Line(Points points) {

        this.points = points;
    }

    public double length() {
        checkPointCount();

        Point a = points.getPoint(0);
        Point b = points.getPoint(1);

        return Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2));
    }

    private void checkPointCount() {
        if (points.count() < POINT_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.LINE_LENGTH_EXCEPTION);
        }
    }

    @Override
    public String toString() {
        return "두 점 사이 거리는 " + length();
    }
}
