package FuelCharging.domain;

public class Avante extends Car {
    private static final String NAME = "Avante";
    private static final double FUEL_EFFICIENCY = 15.0;

    public Avante(int distance) {
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
