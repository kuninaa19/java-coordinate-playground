package FuelCharging2;

import FuelCharging2.domain.Avante;
import FuelCharging2.domain.Car;
import FuelCharging2.domain.K5;
import FuelCharging2.domain.Sonata;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 여행하려는_거리() {
        Car sonata = new Sonata(150);
        Car k5 = new K5(260);
        Car avante = new Avante(300);

        assertThat(sonata.getTripDistance()).isEqualTo(150);
        assertThat(k5.getTripDistance()).isEqualTo(260);
        assertThat(avante.getTripDistance()).isEqualTo(300);
    }
}
