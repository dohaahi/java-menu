package menu.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RegexValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "a,b,c", "가,나,다", "가,나나,다다다"})
    void 콤마로_구분된_문자열이면_검증_성공(final String input) {
        // given
        // when
        // then
        RegexValidator.validateCommaSeparatedRegex(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a.b.c", "a,b,,", "a,b,", ",a,b"})
    void 콤마가_아닌_문자로_구분된_문자열이거나_콤마_사이가_비어있으면_검증_실패(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> RegexValidator.validateCommaSeparatedRegex(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "a, b, c", "가, 나, 다", "가, 나나, 다다다"})
    void 콤마와_공백으로_구분된_문자열이면_검증_성공(final String input) {
        // given
        // when
        // then
        RegexValidator.validateCommaSpaceSeparatedRegex(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a. b. c", "a, b,,", "a, b,", ", a, b"})
    void 콤마와_공백이_아닌_문자로_구분된_문자열이거나_콤마_사이가_비어있으면_검증_실패(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> RegexValidator.validateCommaSpaceSeparatedRegex(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,1,1,1,1", "0,0,0,0,0,0"})
    void 콤마로_구분된_6자리_숫자열이면_검증_성공(final String input) {
        // given
        // when
        // then
        RegexValidator.validateCommasSeparatedNumbersRegex(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,-1,-1,-1,-1,-1", "",})
    void 콤마가_아닌_문자로_구분된_6자리_음수이거나_콤마_사이가_비어있으면_검증_실패(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> RegexValidator.validateCommasSeparatedNumbersRegex(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20]", "[콜라,1500,20];[사이다,1000,10]", "[콜라,1500,20];[사이다,1000,10];[환타,1000,20]"})
    void 콤마와_세미콜론으로_구분된_문자열이면_검증_성공(final String input) {
        // given
        // when
        // then
        RegexValidator.validateCommasAndSemicolonSeparatedRegex(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"[콜라, 1500, 20]", "[콜라,1500,20]; [사이다,1000,20]"})
    void 콤마와_세미콜론이_아닌_문자로_구분된_문자열이거나_구분자_사이가_비어있으면_검증_실패(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> RegexValidator.validateCommasAndSemicolonSeparatedRegex(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"타파스-1", "타파스-1,제로콜라-10"})
    void 대쉬와_콤마로_구분된_문자열이면_검증_성공(final String input) {
        // given
        // when
        // then
        RegexValidator.validateDashSeparatedRegex(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가_1", "abc-1", "타파스 - 1", "타파스-1, 제로콜라-10", ",타파스-1,제로콜라-10", "타파스-1,제로콜라-10,"})
    void 대쉬와_콤마가_아닌_문자로_구분된_문자열이거나_구분자_사이가_비어있으면_검증_실패(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> RegexValidator.validateDashSeparatedRegex(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}