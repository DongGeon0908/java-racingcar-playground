package racingcar.model;

import racingcar.exception.NumberSizeOver;

public class Name {
    private final String carName;

    public Name(String carName) {
        this.carName = carName;
        validateLength();
    }

    public String getName() {
        return carName;
    }

    private void validateLength() {
        if (carName.length() > 5) {
            throw new NumberSizeOver();
        }
    }
}
