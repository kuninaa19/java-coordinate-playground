package FuelCharging.domain;

public abstract class Car {
    protected final Name name;

    protected final Distance distance;

    public Car(String name, int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    /**기
     * 리터당 이동 거리. 즉, 연비
     */
    abstract double getDistancePerLiter();

    /**
     * 여행하려는 거리
     */
    abstract double getTripDistance();

    /**
     * 차종의 이름
     */
    String getName() {
        return this.name.toString();
    }

    /**
     * 주입해야할 연료량을 구한다.
     */
    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }

    public String toString() {
        return this.name + " : " + (int) getChargeQuantity() + "리터" + "\n";
    }
}
