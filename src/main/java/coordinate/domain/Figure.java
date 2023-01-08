package coordinate.domain;


public interface Figure {
    boolean hasPoint(int x, int y);

    Point getPoint(int idx);

    double getArea();

    String getAreaString();
}
