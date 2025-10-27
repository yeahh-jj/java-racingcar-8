package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarRepository {
    private final List<Car> cars = new ArrayList<>();

    public void saveCarList(List<Car> carList) {
        cars.clear();
        cars.addAll(carList);
    }

    public List<Car> findAll() {
        return new ArrayList<>(cars);
    }

    public void clear() {
        cars.clear();
    }
}
