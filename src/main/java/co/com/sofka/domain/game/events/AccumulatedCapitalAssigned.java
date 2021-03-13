package co.com.sofka.domain.game.events;

import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.generic.DomainEvent;

public class AccumulatedCapitalAssigned extends DomainEvent {
    private final PlayerId playerId;
    private final Integer value;

    public AccumulatedCapitalAssigned(PlayerId playerId, Integer value) {
        super("nomemientas.juego.acumuladoacapitalasignado");
        this.playerId = playerId;
        this.value = value;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public Integer getValue() {
        return value;
    }
}
