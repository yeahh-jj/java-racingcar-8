package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void 입력_횟수만큼_경기() {
        Game game = new Game(List.of("pobi", "woni", "jun"), 3);
        for (int i = 0; i < 3; i++) {
            game.playRound(List.of(1, 2, 3));
        }
        assertThat(game.getCurrentRound()).isEqualTo(3);
    }

    @Test
    void 우승자_판별() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        for (int i = 0; i < 5; i++) {
            pobi.move(5);
        }
        for (int i = 0; i < 5; i++) {
            woni.move(3);
        }

        Game game = new Game(List.of(pobi, woni), 4, true);
        List<Car> winner = game.getWinners();
        assertThat(winner).extracting("name").containsExactly("pobi");
    }

    @Test
    void 공동_우승자_판별() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        for (int i = 0; i < 5; i++) {
            pobi.move(6);
        }
        for (int i = 0; i < 5; i++) {
            woni.move(6);
        }

        Game game = new Game(List.of(pobi, woni), 5, true);
        List<Car> winners = game.getWinners();
        assertThat(winners).extracting("name").containsExactly("pobi", "woni");
    }
}
