package co.com.sofka.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.game.Game;
import co.com.sofka.domain.game.command.StartGame;

public class StartGameUseCase extends UseCase<RequestCommand<StartGame>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<StartGame> input) {
        var command = input.getCommand();
        var game = Game.from(command.getGameId(), retrieveEvents());
        try {
            game.startGame();
            emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
        } catch (RuntimeException e){
            emit().onError(new BusinessException(game.identity().value(), e.getMessage()));
        }
    }
}
