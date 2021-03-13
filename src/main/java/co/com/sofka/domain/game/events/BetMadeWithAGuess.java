package co.com.sofka.domain.game.events;

import co.com.sofka.domain.game.values.Bet;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.game.values.Riddle;
import co.com.sofka.domain.generic.DomainEvent;

public class BetMadeWithAGuess extends DomainEvent {
    private final PlayerId playerId;
    private final Bet bet;
    private final Riddle riddle;

    public BetMadeWithAGuess(PlayerId playerId, Bet bet, Riddle riddle) {
        super("nomemientas.juego.apuestahechaconadivinanza");
        this.playerId = playerId;
        this.bet = bet;
        this.riddle = riddle;
    }

    public Bet getBet() {
        return bet;
    }

    public Riddle getRiddle() {
        return riddle;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }
}
