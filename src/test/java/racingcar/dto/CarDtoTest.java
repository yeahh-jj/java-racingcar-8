package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarDtoTest {

    @Test
    void 자동차_이름_이동거리_저장_확인() {
        String name = "pobi";
        int moveCount = 3;

        CarDto carDto = new CarDto(name, moveCount);

        assertThat(carDto.getName()).isEqualTo("pobi");
        assertThat(carDto.getMovementSymbol()).isEqualTo("---");
    }
}


