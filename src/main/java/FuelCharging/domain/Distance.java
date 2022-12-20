package FuelCharging.domain;

public class Distance {
    private final static int MIN = 0;
    private final int distance;

    public Distance(int distance) {
        checkDistance(distance);

        this.distance = distance;
    }

    private void checkDistance(int distance) {
        if (distance < MIN) {
            throw new IllegalArgumentException("이동거리는 0이상을 입력해주세요");
        }
    }

    public double getDistance() {
        return distance;
    }
}
