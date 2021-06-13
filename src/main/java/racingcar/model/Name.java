package racingcar.model;

import racingcar.exception.NumberSizeOver;

public class Name {
    private final String carName;
    private final int MAX_SIZE = 5;

    public Name(String carName) {
        this.carName = carName;
        validateLength();
    }

    public String getName() {
        return carName;
    }

    private void validateLength() {
        if (carName.length() > MAX_SIZE) {
            throw new NumberSizeOver();
        }
    }
}
