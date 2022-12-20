package FuelCharging.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DistanceTest {

    @Test
    void 거리_0미만_넣을시_에러() {
        assertThatThrownBy(() -> {
            Distance distance = new Distance(-1);
        }).hasMessage("이동거리는 0이상을 입력해주세요");
    }
}
