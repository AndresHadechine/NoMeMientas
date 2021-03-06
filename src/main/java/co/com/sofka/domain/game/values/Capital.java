package co.com.sofka.domain.game.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Capital implements ValueObject<Integer> {
    private final Integer value;

    public Capital(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(value < 0){
            throw new IllegalArgumentException("El valor del capital no puede ser negativo");
        }
    }

    public Capital raise(Integer value){
        return new Capital(this.value + value);
    }
    @Override
    public Integer value() {
        return value;
    }
}
