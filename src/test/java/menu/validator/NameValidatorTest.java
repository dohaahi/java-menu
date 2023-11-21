package menu.validator;

import static menu.validator.NameValidator.inputNameValidate;
import static menu.view.InputView.NAME_DELIMITER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import menu.exception.IllegalNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameValidatorTest {
    @DisplayName("값이 정상 입력되면 검증 통과")
    @Test
    void test1() {
        // given
        final String input = "마이클";

        // when
        // then
        inputNameValidate(input);
    }

    @DisplayName("빈 값이 입력되면 예외 발생")
    @Test
    void test2() {
        // given
        final String input = "";

        // when
        // then
        assertThatThrownBy(() -> inputNameValidate(input)).isInstanceOf(IllegalNameException.class);
    }

    @DisplayName("한글이 아닌 다른 문자가 입력되면 예외 발생")
    @Test
    void test3() {
        // given
        final String input = "Jay";

        // when
        // then
        assertThatThrownBy(() -> inputNameValidate(input)).isInstanceOf(IllegalNameException.class);
    }

    @DisplayName("구분자가 " + NAME_DELIMITER + "이면 검증 통과")
    @Test
    void test4() {
        // given
        final String input = "토미,제임스,포코";

        // when
        // then
        inputNameValidate(input);
    }

    @DisplayName("구분자가 " + NAME_DELIMITER + "가 아니면 예외 발생")
    @Test
    void test5() {
        // given
        final String input = "토미;제임스;포코";

        // when
        // then
        assertThatThrownBy(() -> inputNameValidate(input)).isInstanceOf(IllegalNameException.class);
    }
}