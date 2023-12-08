package vendingmachine.domain;

import java.util.List;

public class CoachHasInedibleMenus {
    private final List<CoachInedibleMenu> coachInedibleMenus;

    private CoachHasInedibleMenus(List<CoachInedibleMenu> coachInedibleMenus) {
        this.coachInedibleMenus = coachInedibleMenus;
    }

    public static CoachHasInedibleMenus from(final List<CoachInedibleMenu> coachInedibleMenus) {
        return new CoachHasInedibleMenus(coachInedibleMenus);
    }

    public List<CoachInedibleMenu> getCoachInedibleMenus() {
        return coachInedibleMenus;
    }
}