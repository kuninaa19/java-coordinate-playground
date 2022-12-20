package FuelCharging.domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private final List<Car> cars;

    public RentCompany(List<Car> rentCars) {
        this.cars = rentCars;
    }

    public RentCompany(int distance) {
        List<Car> rentCars = new ArrayList<>();

        rentCars.add(new Sonata(distance));
        rentCars.add(new K5(distance));
        rentCars.add(new Sonata(distance));
        rentCars.add(new Avante(distance));
        rentCars.add(new K5(distance));

        this.cars = rentCars;
    }

    public static RentCompany create() {
        List<Car> rentCars = new ArrayList<>();

        return new RentCompany(rentCars);
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();

        for (Car car : cars) {
            report.append(car);
        }

        return report.toString();
    }
}