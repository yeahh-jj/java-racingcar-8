package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.dto.CarDto;
import racingcar.service.Service;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private Service service = new Service();

    public void run() {
        try {
            startGame();
            playGame();
            printWinners();
        } catch (IllegalArgumentException e) {
            printError(e);
            throw e;
        }
    }

    private void startGame() {
        String inputCarNames = InputView.inputCarName();
        String inputAttempts = InputView.inputAttemptCount();
        service.startGame(inputCarNames, inputAttempts);
        OutputView.printResult();
    }

    private void playGame() {
        do {
            service.playRound();
            printRoundResult();
        } while (!service.getGame().isFinished());
    }

    private void printRoundResult() {
        List<CarDto> carDtos = service.getGame().getCars().stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
        OutputView.outputRoundResult(carDtos);
    }

    private void printWinners() {
        List<String> winners = service.getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        OutputView.outputFinalWinner(winners);
    }

    private void printError(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }


}
