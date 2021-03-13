package co.com.sofka.domain.game.events;

import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.game.values.RoundId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Set;

public class NewRoundCreated extends DomainEvent {
    private final Set<PlayerId> playersIds;
    private final RoundId roundId;

    public NewRoundCreated(RoundId roundId, Set<PlayerId> playersIds) {
        super("nomemientan.game.roundCreated");
        this.playersIds = playersIds;
        this.roundId = roundId;
    }

    public Set<PlayerId> getPlayerIdsIds() {
        return playersIds;
    }

    public RoundId getRoundId() {
        return roundId;
    }
}
