package FuelCharging.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    void 이름_입력() {
        Name name = new Name("Sonata");
        assertThat(name).isEqualTo(new Name("Sonata"));
    }

    @Test
    void 이름_빈값_에러() {
        assertThatThrownBy(() -> {
            Name name = new Name("");
        }).hasMessage("차량이름을 입력해주세요");
    }

    @Test
    void 이름_출력() {
        Name name = new Name("Sonata");
        assertThat(name).hasToString("Sonata");
    }
}
