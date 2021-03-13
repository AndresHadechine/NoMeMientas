package co.com.sofka.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class GameStarted extends DomainEvent {

    public GameStarted() {
        super("nomemientas.game.started");
    }
}
