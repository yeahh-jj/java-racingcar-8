package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Car> cars;
    private int currentRound;
    private final int totalRounds;

    public Game(List<String> names, int totalRounds) {
        this.cars = names.stream()
                .map(Car::new)
                .toList();
        this.totalRounds = totalRounds;
    }

    public void playRound(List<Integer> randomNum) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(randomNum.get(i));
        }
        currentRound++;
    }

    public boolean isFinished() {
        return currentRound >= totalRounds;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public List<Car> getWinners() {
        int winnerDistance = 0;
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() > winnerDistance) {
                winnerDistance = car.getPosition();
            }
        }

        for (Car car : cars) {
            if (car.getPosition() == winnerDistance) {
                winners.add(car);
            }
        }

        return winners;
    }

    // 테스트용
    public Game(List<Car> cars, int totalRounds, boolean TestMode) {
        this.cars = cars;
        this.totalRounds = totalRounds;
    }

}
