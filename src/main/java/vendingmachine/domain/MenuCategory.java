package vendingmachine.domain;

import java.util.Arrays;
import vendingmachine.util.RandomNumberGenerator;

public enum MenuCategory {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private final String name;
    private final int number;

    MenuCategory(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public static MenuCategory pickCategory() {
        int number = RandomNumberGenerator.generate();

        return Arrays.stream(MenuCategory.values())
                .filter(menu -> menu.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("pickCategory에서 오류가 발생했습니다"));
    }

    public String getName() {
        return name;
    }
}