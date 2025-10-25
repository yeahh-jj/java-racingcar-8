package racingcar.dto;

public class CarDto {
    private final String name;
    private final String movementSymbol;

    public CarDto(String name, int isMoving) {
        this.name = name;
        this.movementSymbol = "-".repeat(isMoving);
    }

    public String getName() {
        return name;
    }

    public String getMovementSymbol() {
        return movementSymbol;
    }
}
