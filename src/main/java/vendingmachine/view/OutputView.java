package vendingmachine.view;

import vendingmachine.domain.dto.RecommendResultDto;

public class OutputView {
    private static final String RECOMMEND_RESULT_START_MESSAGE = System.lineSeparator() + """
            메뉴 추천 결과입니다.
            [ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]
            [ 카테고리 | %s ]
            """;
    private static final String RECOMMEND_RESULT_END_MESSAGE = System.lineSeparator() + "추천을 완료했습니다.";

    private static final String LINE_FORMAT = "[ %s ]" + System.lineSeparator();

    public void printRecommendResult(final RecommendResultDto recommendResultDto) {
        System.out.printf(RECOMMEND_RESULT_START_MESSAGE, recommendResultDto.categories());
        recommendResultDto.results()
                .forEach(result -> System.out.printf(LINE_FORMAT, result));
        System.out.println(RECOMMEND_RESULT_END_MESSAGE);
    }
}