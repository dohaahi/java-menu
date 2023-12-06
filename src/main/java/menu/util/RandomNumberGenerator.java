package menu.util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumberGenerator {
    public static final int START_INCLUSIVE = 1;

    public static int generate(final int endInclusive) {
        return pickNumberInRange(START_INCLUSIVE, endInclusive);
    }
}