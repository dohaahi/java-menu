package menu.domain;

import java.util.Arrays;
import menu.RandomNumberGenerator;

public enum MenuCategory {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final int typeNumber;
    private final String name;

    MenuCategory(int typeNumber, String name) {
        this.typeNumber = typeNumber;
        this.name = name;
    }

    public static MenuCategory pickCategory() {
        int number = RandomNumberGenerator.generate();

        return Arrays.stream(MenuCategory.values())
                .filter(category -> category.typeNumber == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("pickCategory에서 예외 발생"));
    }

    public String getName() {
        return name;
    }
}