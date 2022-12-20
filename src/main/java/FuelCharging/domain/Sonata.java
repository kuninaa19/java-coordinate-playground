package FuelCharging.domain;

public class Sonata extends Car {
    private static final String NAME = "Sonata";
    private static final double FUEL_EFFICIENCY = 10.0;

    public Sonata(int distance) {
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
