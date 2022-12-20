package FuelCharging.domain;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        checkBlank(name);
        this.name = name;
    }

    private void checkBlank(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("차량이름을 입력해주세요");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
