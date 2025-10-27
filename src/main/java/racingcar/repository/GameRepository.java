package racingcar.repository;

import racingcar.domain.Game;

public class GameRepository {
    private Game game;

    public void save(Game game) {
        this.game = game;
    }

    public Game find() {
        return game;
    }

    public void clear() {
        game = null;
    }
}
