package co.com.sofka.domain.game.events;

import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Set;

public class PlayersEliminated extends DomainEvent {

    private final Set<PlayerId> playersIds;

    public PlayersEliminated(Set<PlayerId> playersIds) {
        super("nomemientan.juego.jugadoreseliminados");
        this.playersIds = playersIds;
    }

    public Set<PlayerId> getPlayersIds() {
        return playersIds;
    }
}
