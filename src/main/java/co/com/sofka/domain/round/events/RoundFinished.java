package co.com.sofka.domain.round.events;

import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.generic.DomainEvent;

public class RoundFinished extends DomainEvent {

    private final GameId gameId;
    public RoundFinished(GameId gameId) {
        super("nomemientas.round.RoundFinished");
        this.gameId = gameId;
    }

    public GameId getGameId() {
        return gameId;
    }
}
