package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.service.Service;

public class RacingGameIntegrationTest {

    @Test
    void 전체_흐름_테스트() {
        Service service = new Service();

        service.startGame("pobi,woni", "3");
        Game game = service.getGame();

        assertThat(game).isNotNull();
        assertThat(game.getCars()).hasSize(2);

        while (!game.isFinished()) {
            service.playRound();
        }

        assertThat(game.isFinished()).isTrue();

        List<Car> winners = service.getWinners();

        // then: 우승자가 최소 1명 존재
        assertThat(winners).isNotEmpty();
        assertThat(winners.get(0).getName()).isIn("pobi", "woni");
    }

}
