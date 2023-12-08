package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public enum Menu {
    JAPANESE(
            List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"),
            MenuCategory.JAPANESE),
    KOREAN(
            List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),
            MenuCategory.KOREAN),
    CHINESE(
            List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),
            MenuCategory.CHINESE),
    ASIAN(
            List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"),
            MenuCategory.ASIAN),
    WESTERN(
            List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"),
            MenuCategory.WESTERN);

    private final List<String> menus;
    private final MenuCategory menuCategory;

    Menu(List<String> menus, MenuCategory menuCategory) {
        this.menus = menus;
        this.menuCategory = menuCategory;
    }

    public static String pickMenu(final MenuCategory pickCategory) {
        List<String> matchMenus = Arrays.stream(Menu.values())
                .filter(menu -> menu.menuCategory.equals(pickCategory))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("pickMenu에서 오류가 발생했습니다."))
                .menus;

        return Randoms.shuffle(matchMenus).get(0);
    }

    public static boolean hasMenu(final String name) {
        return Arrays.stream(Menu.values())
                .anyMatch(menu -> menu.menus.contains(name));
    }
}