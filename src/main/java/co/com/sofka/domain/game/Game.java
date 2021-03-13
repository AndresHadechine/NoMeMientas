package co.com.sofka.domain.game;

import co.com.sofka.domain.game.events.*;
import co.com.sofka.domain.game.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Game extends AggregateEvent<GameId> {

    protected Map<PlayerId, Player> players;
    protected RoundId roundId;
    protected Boolean gameStarted;
    protected Boolean hasWinner;

    public Game(GameId entityId) {
        super(entityId);
        subscribe(new GameChange(this));
    }
    public static Game from(GameId entityId, List<DomainEvent> events){
        var game = new Game(entityId);
        events.forEach(game::applyEvent);
        return game;
    }
    public void startGame(){
        appendChange(new GameStarted()).apply();
    }
    //crearNuevaRonda
    public void createNewRound(){
        var playersIds = players.keySet();
        var newRoundId = new RoundId();
        appendChange(new NewRoundCreated(newRoundId, playersIds)).apply();
    }
    //eliminarJugadoresDeRonda
    public void eliminarJugadoresDeRonda(Set<PlayerId> playersIds){
        appendChange(new PlayersEliminated(playersIds)).apply();
    }
    //asignarAcumuladoACapital
    public void assignAccumulatedCapital(Set<PlayerId> playersIds){
        appendChange(new PlayersEliminated(playersIds)).apply();
    }
    //asignarAcumuladoACapital
    public void assignAccumulatedCapital(PlayerId playerId, Integer value){
        Objects.requireNonNull(value);
        appendChange(new AccumulatedCapitalAssigned(playerId, value)).apply();
    }
    //hacerApuestaConAdivinanza
    public void makeBetWithRiddle(PlayerId playerId, Bet bet, Riddle riddle){
        //ApuestaHechaConAdivinaza
        appendChange(new BetMadeWithAGuess(playerId, bet, riddle)).apply();
    }

    public RoundId roundId() {
        return roundId;
    }

    public Boolean hasWinner(){
        return hasWinner;
    }

    public Map<PlayerId, Player> players() {
        return players;
    }
}
