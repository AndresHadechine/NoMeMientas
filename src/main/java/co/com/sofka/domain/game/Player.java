package co.com.sofka.domain.game;

import co.com.sofka.domain.game.values.Capital;
import co.com.sofka.domain.game.values.Name;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.generic.Entity;

import java.util.*;

public class Player extends Entity<PlayerId> {
    private final Name name;
    private Capital capital;

    public Player(PlayerId entityId, Name name, Capital capital) {
        super(entityId);
        this.name = name;
        this.capital = capital;
    }

    public Player(PlayerId entityId, Name name) {
        super(entityId);
        this.name = name;
        this.capital = new Capital(0);
    }

    public void aumentarCapital(Integer valor) {
        this.capital = this.capital.raise(valor);
    }

    public Capital capital() {
        return capital;
    }

    public Name name() {
        return name;
    }
}
