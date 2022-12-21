package FuelCharging2;

import FuelCharging2.domain.RentCompany;
import FuelCharging2.views.Input;
import FuelCharging2.views.ResultView;

public class FuelChargingApplication {
    public static void main(String[] args) {
        int distance = Integer.parseInt(Input.read());

        RentCompany rentCompany = new RentCompany(distance);
        String report = rentCompany.generateReport();

        ResultView.printResult(report);
    }
}
