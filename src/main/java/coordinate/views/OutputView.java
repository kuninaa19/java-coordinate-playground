package coordinate.views;

import coordinate.domain.Line;
import coordinate.domain.Point;
import coordinate.domain.Points;

public class OutputView {
    public static String BLANK = "    ";
    public static String POINT = "*";
    public static String COORDINATE_CENTER = "+";
    public static String HORIZON_LINE = "----";
    public static String VERTICAL_LINE = "|";

    public static void printCoordinatePlate(Points points) {
        printVerticalNumbers(points);
        printHorizonLine();
        printHorizonNumbers();
    }

    private static void printVerticalNumbers(Points points) {
        for (int y = Point.MAX; y > Point.MIN; y--) {
            printNumbers(y);
            System.out.print(VERTICAL_LINE);
            printPoints(points, y);
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


    private static void printPoints(Points points, int y) {
        for (int x = Point.MIN + 1; x <= Point.MAX; x++) {
            if (points.hasPoint(x, y)) {
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

    public static void printLine(Line line){
        System.out.println(line);
    }
}
