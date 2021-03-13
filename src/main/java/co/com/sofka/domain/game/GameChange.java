package co.com.sofka.domain.game;

import co.com.sofka.domain.game.events.*;
import co.com.sofka.domain.generic.EventChange;

public class GameChange extends EventChange {
    public GameChange(Game game) {

        apply((GameCreated event) -> {
            game.players = event.getPlayers();
            game.gameStarted = Boolean.FALSE;
            game.hasWinner = Boolean.FALSE;
        });

        apply((AccumulatedCapitalAssigned event) -> {
            game.players.get(event.getPlayerId())
                    .aumentarCapital(event.getValue());
        });

        apply((GameStarted event) -> {
            if(Boolean.TRUE.equals(game.gameStarted)){
                throw new IllegalArgumentException("El juego ya esta inicializado");
            }
            game.gameStarted = Boolean.TRUE;
        });

        apply((PlayersEliminated event) -> {
            event.getPlayersIds()
                    .forEach(playerId -> game.players.remove(playerId));
        });

        apply((NewRoundCreated event) -> {
            if(Boolean.FALSE.equals(game.gameStarted)){
                throw new IllegalArgumentException("El juego debe estar inicializado");
            }
            if(Boolean.TRUE.equals(game.hasWinner)){
                throw new IllegalArgumentException("El juego ya tiene un ganador");
            }
            game.roundId = event.getRoundId();
        });

        apply((GameFinishedWithWinner event) -> {
            game.hasWinner = true;
        });
    }
}
