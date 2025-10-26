package racingcar.domain;

public class Car {
    private final String name;
    private int isMoving = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            isMoving++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return isMoving;
    }
}
