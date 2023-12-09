package menu.domain;

import static menu.domain.MenuCategory.ASIAN;
import static menu.domain.MenuCategory.CHINESE;
import static menu.domain.MenuCategory.JAPANESE;
import static menu.domain.MenuCategory.KOREAN;
import static menu.domain.MenuCategory.WESTERN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public enum Menu {
    // 일식
    GYUDON("규동", JAPANESE),
    UDON("우동", JAPANESE),
    MISOSHIRU("미소시루", JAPANESE),
    SUSHI("스시", JAPANESE),
    KATSUDON("가츠동", JAPANESE),
    ONIGIRI("오니기리", JAPANESE),
    HAYAISU("하이라이스", JAPANESE),
    RAMEN("라멘", JAPANESE),
    OKONOMIYAKI("오코노미야끼", JAPANESE),

    // 한식
    GIMBAP("김밥", KOREAN),
    KIMCHIJJIGAE("김치찌개", KOREAN),
    SSAMBAP("쌈밥", KOREAN),
    DOENJANGJJIGAE("된장찌개", KOREAN),
    BIBIMBAP("비빔밥", KOREAN),
    KALGUKSU("칼국수", KOREAN),
    BULGOGI("불고기", KOREAN),
    TTEOKBOKKI("떡볶이", KOREAN),
    JAEYUKBOKKEUM("제육볶음", KOREAN),

    // 중식
    KANPOONGGI("깐풍기", CHINESE),
    BOKKEUMMYEON("볶음면", CHINESE),
    DONGPAYUK("동파육", CHINESE),
    JJAJANGMYEON("짜장면", CHINESE),
    JJAMPPONG("짬뽕", CHINESE),
    MAPADUBU("마파두부", CHINESE),
    TANGSUYUK("탕수육", CHINESE),
    TOMATO_EGG_STIR_FRY("토마토 달걀볶음", CHINESE),
    GOCHUJAPCHAE("고추잡채", CHINESE),

    // 아시안
    PADTHAI("팟타이", ASIAN),
    KAOPAD("카오 팟", ASIAN),
    NASIGORENG("나시고렝", ASIAN),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥", ASIAN),
    RICE_NOODLE("쌀국수", ASIAN),
    TOMYUMKUNG("똠얌꿍", ASIAN),
    BANHMI("반미", ASIAN),
    SUMMERSPRINGROLLS("월남쌈", ASIAN),
    PHO("분짜", ASIAN),

    // 양식
    LASAGNA("라자냐", WESTERN),
    GRATIN("그라탱", WESTERN),
    GNOCCHI("뇨끼", WESTERN),
    QUICHE("끼슈", WESTERN),
    FRENCH_TOAST("프렌치 토스트", WESTERN),
    BAGUETTE("바게트", WESTERN),
    SPAGHETTI("스파게티", WESTERN),
    PIZZA("피자", WESTERN),
    PANINI("파니니", WESTERN);

    private final String name;
    private final MenuCategory category;

    Menu(String name, MenuCategory category) {
        this.name = name;
        this.category = category;
    }

    public static String pickMenu(final MenuCategory category) {
        List<String> menus = Arrays.stream(Menu.values())
                .filter(menu -> menu.category.equals(category))
                .map(menu -> menu.name)
                .toList();

        return Randoms.shuffle(menus).get(0);
    }

    public static boolean match(final String name) {
        return Arrays.stream(Menu.values())
                .anyMatch(menu -> menu.name.equals(name));
    }

    public String getName() {
        return name;
    }
}