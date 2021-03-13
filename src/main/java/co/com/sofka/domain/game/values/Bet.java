package co.com.sofka.domain.game.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Bet implements ValueObject<Integer> {
    private final Integer value;

    public Bet(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return value;
    }
}
