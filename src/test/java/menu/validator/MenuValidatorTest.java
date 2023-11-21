package menu.validator;

import static menu.validator.MenuValidator.inputMenuValidate;
import static menu.validator.NameValidator.inputNameValidate;
import static menu.view.InputView.NAME_DELIMITER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import menu.exception.IllegalMenuException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuValidatorTest {
    @DisplayName("빈 값 입력하면 검증 통과")
    @Test
    void test() {
        // given
        final String input = "";

        // when
        // then
        inputMenuValidate(input);
    }

    @DisplayName("한글이 아닌 다른 문자가 입력되면 예외 발생")
    @Test
    void test4() {
        // given
        final String input = "Sushi";

        // when
        // then
        assertThatThrownBy(() -> inputMenuValidate(input)).isInstanceOf(IllegalMenuException.class);
    }

    @DisplayName("하나의 메뉴를 입력하면 검증 통과")
    @Test
    void test2() {
        // given
        final String input = "우동";

        // when
        // then
        inputMenuValidate(input);
    }

    @DisplayName("여러개의 메뉴를 입력하면 검증 통과")
    @Test
    void test3() {
        // given
        final String input = "우동,스시";

        // when
        // then
        inputMenuValidate(input);
    }

    @DisplayName("구분자가 " + NAME_DELIMITER + "이면 검증 통과")
    @Test
    void test5() {
        // given
        final String input = "스시,초밥";

        // when
        // then
        inputNameValidate(input);
    }

    @DisplayName("구분자가 " + NAME_DELIMITER + "가 아니면 예외 발생")
    @Test
    void test6() {
        // given
        final String input = "스시;초밥";

        // when
        // then
        assertThatThrownBy(() -> inputMenuValidate(input)).isInstanceOf(IllegalMenuException.class);
    }
}