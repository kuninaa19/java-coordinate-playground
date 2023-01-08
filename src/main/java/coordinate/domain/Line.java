package coordinate.domain;

import java.util.List;

public class Line extends Shape {
    public Line(List<Point> points) {
        super(points);
    }

    @Override
    public double getArea() {
        Point a = getPoint(0);
        Point b = getPoint(1);

        return Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2));
    }

    @Override
    public String getAreaString() {
        return "두 점 사이 거리는 " + getArea();
    }
}
