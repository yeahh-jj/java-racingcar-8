package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto;

public class OutputView {

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void outputRoundResult(List<CarDto> carDtos) {
        for (CarDto carDto : carDtos) {
            System.out.println(carDto.getName() + " : " + carDto.getMovementSymbol());
        }
        System.out.println();
    }

    public static void outputFinalWinner(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}
