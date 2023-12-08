package vendingmachine.domain;

import static vendingmachine.validator.CoachNameValidator.validateName;

public class Coach {
    private final String name;

    private Coach(String name) {
        validateName(name);

        this.name = name;
    }

    public static Coach from(final String name) {
        return new Coach(name);
    }
}
