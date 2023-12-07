package menu.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import menu.exception.IllegalMenuException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class XXXValidatorTest {
    // TODO: 검증 통과 케이스 Test도 작성하기
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
    @ValueSource(strings = {"a", "가", "."})
    void 정수가_아닌_값이_입력되면_예외_발생(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> XXXValidator.validateInputXXX(input))
                .isInstanceOf(IllegalMenuException.class);
    }

    // TODO: Regextest에서 복붙해오기
    @ParameterizedTest
    @ValueSource(strings = {""})
    void XXX_패턴과_일치하지_않으면_예외_발생(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> XXXValidator.validateInputXXX(input))
                .isInstanceOf(IllegalMenuException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void XXX이_최소값_미만이거나_최대값_초과하면_예외_발생(final List<Integer> input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> XXXValidator.validateXXX(input))
                .isInstanceOf(IllegalMenuException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void XXX의_길이가_ZZZ가_아니면_예외_발생(final List<Integer> input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> XXXValidator.validateXXX(input))
                .isInstanceOf(IllegalMenuException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void XXX에_중복된_값이_있으면_예외_발생(final List<Integer> input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> XXXValidator.validateXXX(input))
                .isInstanceOf(IllegalMenuException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void XXX이_ZZZ로_나누어_떨어지지_않으면_예외_발생(final List<Integer> input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> XXXValidator.validateXXX(input))
                .isInstanceOf(IllegalMenuException.class);
    }
}