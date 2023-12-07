package menu.validator;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import menu.exception.IllegalMenuException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class MenuValidatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    void 빈_값이_입력되면_예외_발생(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> MenuValidator.validateInputMenu(input))
                .isInstanceOf(IllegalMenuException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가.나.다", "가,나,,", "가,나,", ",가,나"})
    void 콤마가_아닌_문자로_구분된_문자열이거나_콤마_사이가_비어있으면_검증_실패(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> MenuValidator.validateInputMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가가. 나나. 다다", "가가, 나나,,", "가가, 나나,", ", 가가, 나나"})
    void 콤마와_공백이_아닌_문자로_구분된_문자열이거나_콤마_사이가_비어있으면_검증_실패(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> MenuValidator.validateInputMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1"})
    void 메뉴_패턴과_일치하지_않으면_예외_발생(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> MenuValidator.validateInputMenu(input))
                .isInstanceOf(IllegalMenuException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"우동,우동"})
    void 메뉴에_중복된_값이_있으면_예외_발생(final List<String> input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> MenuValidator.validateMenu(input))
                .isInstanceOf(IllegalMenuException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"우동,스시시", "뇨끼끼,월남쌈"})
    void 메뉴에_없는_메뉴를_시키면_예외_발생(final List<String> input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> MenuValidator.validateMenu(input))
                .isInstanceOf(IllegalMenuException.class);
    }
}