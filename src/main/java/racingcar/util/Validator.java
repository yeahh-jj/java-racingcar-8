package racingcar.util;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static int validateAttemptCount(String inputAttemptCount) {
        long countNum;

        try {
            countNum = Long.parseLong(inputAttemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }

        if (countNum < Integer.MIN_VALUE || countNum > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("시도 횟수가 너무 많습니다.");
        }

        int count = (int) countNum;

        if (count < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }

        return count;
    }

    public static void validateCarname(String inputValue) {
        if (inputValue == null || inputValue.isBlank()) {
            throw new IllegalArgumentException(("아무것도 입력되지 않았습니다. 자동차 이름을 입력해야 합니다."));
        }

        String[] names = inputValue.split(",");
        Set<String> sameNames = new HashSet<>();

        if (names.length < 2) {
            throw new IllegalArgumentException("자동차의 이름을 두개 이상 입력해야 합니다.");
        }

        for (String rawName : names) {
            String name = rawName.trim();
            validateSingleCarName(name);
            checkDuplicateName(sameNames, name);
        }
    }

    private static void validateSingleCarName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름이 지정되지 않은 자동차가 있습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }

        if (name.contains(" ")) {
            throw new IllegalArgumentException("이름에 공백이 포함될 수 없습니다.");
        }

        if (!name.matches("^[A-Za-z가-힣]+$")) {
            throw new IllegalArgumentException("자동차 이름에는 숫자나 특수문자를 포함할 수 없습니다.(" + name + ")");
        }
    }

    private static void checkDuplicateName(Set<String> samseNames, String name) {
        if (!samseNames.add(name)) {
            throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다.(" + name + ")");
        }
    }

}
