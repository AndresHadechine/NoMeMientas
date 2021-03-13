package co.com.sofka.domain.game.events;

import co.com.sofka.domain.game.values.Name;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.generic.DomainEvent;

public class GameFinishedWithWinner extends DomainEvent {

    private final Name namePlayer;
    private final PlayerId playerId;

    public GameFinishedWithWinner(PlayerId playerId, Name namePlayer ) {
        super("nomemientan.game.finishedwithwinner");
        this.namePlayer = namePlayer;
        this.playerId = playerId;
    }

    public Name getNamePlayer() {
        return namePlayer;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

}
