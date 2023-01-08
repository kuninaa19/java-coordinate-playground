package coordinate.domain;


import java.util.List;

public interface Figure {
    boolean hasPoint(int x, int y);

    List<Point> getPoints();

    Point getPoint(int idx);

    double getArea();

    String getAreaString();
}
