package FuelCharging2.domain;

public class K5 implements Car {
    private static final String NAME = "K5";
    private static final double FUEL_EFFICIENCY = 13.0;

    private final Distance distance;

    public K5(int distance) {
        this.distance = new Distance(distance);
    }

    @Override
    public double getDistancePerLiter() {
        return FUEL_EFFICIENCY;
    }

    @Override
    public double getTripDistance() {
        return this.distance.getDistance();
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public double getChargeQuantity() {
        return this.getTripDistance() / this.getDistancePerLiter();
    }

    @Override
    public String toString() {
        return NAME + " : " + (int) getChargeQuantity() + "리터" + "\n";
    }
}
