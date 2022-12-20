package FuelCharging.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car sonata;
    private Car k5;
    private Car avante;

    @BeforeEach
    void setUp() {
        sonata = new Sonata(150);
        k5 = new K5(260);
        avante = new Avante(300);
    }

    @Test
    void 자동차_만들기() {
        assertThat(sonata).isInstanceOf(Car.class);
        assertThat(k5).isInstanceOf(Car.class);
        assertThat(avante).isInstanceOf(Car.class);
    }

    @Test
    void 여행하려는_거리() {
        assertThat(sonata.getTripDistance()).isEqualTo(150);
        assertThat(k5.getTripDistance()).isEqualTo(260);
        assertThat(avante.getTripDistance()).isEqualTo(300);
    }

    @Test
    void 자동차_주입_연료량_계산() {
        assertThat(avante.getChargeQuantity()).isEqualTo(20);
        assertThat(k5.getChargeQuantity()).isEqualTo(20);
        assertThat(sonata.getChargeQuantity()).isEqualTo(15);
    }

    @Test
    void 자동차_이름_출력() {
        assertThat(avante.getName()).hasToString("Avante");
        assertThat(k5.getName()).hasToString("K5");
        assertThat(sonata.getName()).hasToString("Sonata");
    }
}
