package menu.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import menu.exception.IllegalMenuException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CoachNameValidatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    void 빈_값이_입력되면_예외_발생(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> XXXValidator.validateInputXXX(input))
                .isInstanceOf(IllegalMenuException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가.나.다", "가,나,,", "가,나,", ",가,나"})
    void 콤마가_아닌_문자로_구분된_문자열이거나_콤마_사이가_비어있으면_검증_실패(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> RegexValidator.validateCommaSeparatedRegex(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가가. 나나. 다다", "가가, 나나,,", "가가, 나나,", ", 가가, 나나"})
    void 콤마와_공백이_아닌_문자로_구분된_문자열이거나_콤마_사이가_비어있으면_검증_실패(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> RegexValidator.validateCommaSpaceSeparatedRegex(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1"})
    void 코치이름_패턴과_일치하지_않으면_예외_발생(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> CoachNameValidator.validateCoach(input))
                .isInstanceOf(IllegalMenuException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가", "가나다라마"})
    void 이름이_최소값_미만이거나_최대값_초과하면_예외_발생(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> CoachNameValidator.validateCoach(input))
                .isInstanceOf(IllegalMenuException.class);
    }
}