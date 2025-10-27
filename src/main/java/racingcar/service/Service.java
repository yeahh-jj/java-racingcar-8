package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.CarRepository;
import racingcar.repository.GameRepository;
import racingcar.util.Validator;

public class Service {
    private final CarRepository carRepository = new CarRepository();
    private final GameRepository gameRepository = new GameRepository();

    public void startGame(String inputNames, String inputAttemptNumber) {
        Validator.validateCarname(inputNames);
        int totalRounds = Validator.validateAttemptCount(inputAttemptNumber);

        List<String> nameList = List.of(inputNames.split(","));
        Game game = new Game(nameList, totalRounds);

        gameRepository.save(game);
    }

    public boolean playRound() {
        Game game = gameRepository.find();
        List<Integer> randomNumbers = game.getCars().stream()
                .map(car -> Randoms.pickNumberInRange(0, 9))
                .toList();

        game.playRound(randomNumbers);
        carRepository.saveCarList(game.getCars());

        return game.isFinished();
    }

    public List<Car> getWinners() {
        Game game = gameRepository.find();
        return game.getWinners();
    }

    public Game getGame() {
        return gameRepository.find();
    }
}
