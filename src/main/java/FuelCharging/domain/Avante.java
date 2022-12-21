package FuelCharging.domain;

public class Avante extends Car {
    private static final String NAME = "Avante";
    private static final double FUEL_EFFICIENCY = 15.0;

    public Avante(int distance) {
        super(distance);
    }

    @Override
    double getDistancePerLiter() {
        return FUEL_EFFICIENCY;
    }

    @Override
    double getTripDistance() {
        return this.distance.getDistance();
    }

    @Override
    String getName() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME + " : " + (int) getChargeQuantity() + "리터" + "\n";
    }
}
