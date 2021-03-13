package co.com.sofka.domain.game;

import co.com.sofka.domain.game.values.Bet;
import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.game.values.RoundId;
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
        appendChange(new JuegoIniciado()).apply();
    }
    //crearNuevaRonda
    public void createNewRound(){
        var PlayersIds = players.keySet();
        var newRoundId = new RoundId();
        appendChange(new NuevaRondaCreada(newRoundId, PlayersIds)).apply();
    }
    //eliminarJugadoresDeRonda
    public void eliminarJugadoresDeRonda(Set<PlayerId> PlayersIds){
        appendChange(new JugadoresEliminados(PlayersIds)).apply();
    }
    //asignarAcumuladoACapital
    public void assignAccumulatedCapital(Set<PlayerId> PlayersIds){
        appendChange(new JugadoresEliminados(PlayersIds)).apply();
    }
    //asignarAcumuladoACapital
    public void assignAccumulatedCapital(PlayerId playerId, Integer value){
        Objects.requireNonNull(value);
        appendChange(new AcumuladoACapitalAsignado(playerId, value)).apply();
    }
    public void makeBetWithRiddle(PlayerId playerId, Bet bet, Adivinanza adivinanza){
        appendChange(new ApuestaHechaConAdivinanza(playerId, apusta, adivinanza)).apply();
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
