package racingcar.model;

import racingcar.exception.NumberSizeOverException;

public class Name {
    private final String name;
    private final int MAX_SIZE = 5;

    public Name(String carName) {
        name = carName;
        validateLength();
    }

    public String getNameValue() {
        return name;
    }

    private void validateLength() {
        if (name.length() > MAX_SIZE) {
            throw new NumberSizeOverException();
        }
    }
}
