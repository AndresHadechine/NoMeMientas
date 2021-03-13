package co.com.sofka.domain.game.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Riddle implements ValueObject<Integer> {
    private final Integer value;

    public Riddle(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return value;
    }
}
