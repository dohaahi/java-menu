package vendingmachine.util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumberGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 5;


    public static int generate() {
        return pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}