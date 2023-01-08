package coordinate.views;

import coordinate.domain.Figure;
import coordinate.domain.Point;
import coordinate.domain.Shape;

public class OutputView {
    public static String BLANK = "    ";
    public static String POINT = "*";
    public static String COORDINATE_CENTER = "+";
    public static String HORIZON_LINE = "----";
    public static String VERTICAL_LINE = "|";

    public static void printCoordinatePlate(Shape shape) {
        printVerticalNumbers(shape);
        printHorizonLine();
        printHorizonNumbers();
    }

    private static void printVerticalNumbers(Shape shape) {
        for (int y = Point.MAX; y > Point.MIN; y--) {
            printNumbers(y);
            System.out.print(VERTICAL_LINE);
            printPoints(shape, y);
            emptyLine();
        }
    }

    private static void printNumbers(int number) {
        if (number % 2 == 0) {
            System.out.printf("%4d", number);
            return;
        }

        System.out.print(BLANK);
    }


    private static void printPoints(Shape shape, int y) {
        for (int x = Point.MIN + 1; x <= Point.MAX; x++) {
            if (shape.hasPoint(x, y)) {
                System.out.printf("%3s", POINT);
                continue;
            }

            System.out.print(BLANK);
        }
    }

    private static void printHorizonLine() {
        System.out.print(BLANK + COORDINATE_CENTER);

        for (int x = Point.MIN + 1; x <= Point.MAX; x++) {
            System.out.print(HORIZON_LINE);
        }

        emptyLine();
    }

    private static void printHorizonNumbers() {
        for (int x = Point.MIN; x <= Point.MAX; x++) {
            printNumbers(x);
        }

        emptyLine();
    }

    private static void emptyLine() {
        System.out.println();
    }

    public static void printArea(Figure figure){
        emptyLine();
        System.out.println(figure.getAreaString());
    }
}
