package menu.view;

import menu.domain.RecommendResultDto;

public class OutputView {
    private static final String RESULT_START_MESSAGE = System.lineSeparator() + """
            메뉴 추천 결과입니다.
            [ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]
            [ 카테고리 | %s ]
            """;
    private static final String LINE_PATTERN = "[ %s ]" + System.lineSeparator();
    private static final String RESULT_END_MESSAGE = System.lineSeparator() + "추천을 완료했습니다.";

    public void printRecommendResult(final RecommendResultDto recommendResultDto) {
        System.out.printf(RESULT_START_MESSAGE, recommendResultDto.categories());
        recommendResultDto.recommendResults()
                .forEach(result -> System.out.printf(LINE_PATTERN, result));
        System.out.println(RESULT_END_MESSAGE);
    }
}
