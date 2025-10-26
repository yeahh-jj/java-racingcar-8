package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class InputValidationTest {

    @Test
    void 자동차_이름_5자_초과() {
        String inputName = "pobipobi, pobi";
        assertThatThrownBy(() -> Validator.validateCarname(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하");
        ;
    }

    @Test
    void 이름_비어있는_경우() {
        String inputName = "";
        assertThatThrownBy(() -> Validator.validateCarname(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("아무것도 입력되지 않았습니다.");
        ;
    }

    @Test
    void 이름_문자_외_입력() {
        String inputName = "@pobi, 13po";
        assertThatThrownBy(() -> Validator.validateCarname(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자나 특수문자");
        ;
    }

    @Test
    void 이름_중복_입력() {
        String inputName = "pobi, pobi";
        assertThatThrownBy(() -> Validator.validateCarname(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름");
        ;
    }

    @Test
    void 이름_공백_포함() {
        String inputName = "po bi, woni";
        assertThatThrownBy(() -> Validator.validateCarname(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백");
        ;
    }

    @Test
    void 이름_지정되지_않은_자동차() {
        String inputName = "pobi, , woni";
        assertThatThrownBy(() -> Validator.validateCarname(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("지정되지 않은");
        ;
    }

    @Test
    void 이름_입력_2대_미만() {
        String inputName = "pobi";
        assertThatThrownBy(() -> Validator.validateCarname(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("두개 이상");
        ;
    }

    @Test
    void 시도_횟수_숫자_외_입력() {
        String inputAttemptCount = "abc";
        assertThatThrownBy(() -> Validator.validateAttemptCount(inputAttemptCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자여야");
    }

    @Test
    void 시도_횟수_0_이하_입력() {
        String inputAttemptCount = "-1";
        assertThatThrownBy(() -> Validator.validateAttemptCount(inputAttemptCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상");
    }

}
