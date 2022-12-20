package FuelCharging.domain;

public class K5 extends Car {
    private static final String NAME = "K5";
    private static final double FUEL_EFFICIENCY = 13.0;

    public K5(int distance) {
        super(NAME, distance);
    }

    @Override
    double getDistancePerLiter() {
        return FUEL_EFFICIENCY;
    }

    @Override
    double getTripDistance() {
        return this.distance.getDistance();
    }
}
