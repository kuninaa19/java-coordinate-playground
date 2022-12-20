package FuelCharging;

import FuelCharging.domain.RentCompany;
import FuelCharging.views.Input;
import FuelCharging.views.ResultView;

public class FuelChargingApplication {
    public static void main(String[] args) {
        int distance = Integer.parseInt(Input.read());

        RentCompany rentCompany = new RentCompany(distance);
        String report = rentCompany.generateReport();

        ResultView.printResult(report);
    }
}
