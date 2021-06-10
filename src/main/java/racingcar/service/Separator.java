package racingcar.service;

import racingcar.exception.NumberSizeOver;

import java.util.Arrays;
import java.util.List;

public class Separator {
    public static final String REGEX = ",";
    private final String inputName;
    private final List<String> separatedName;

    public Separator(String name) {
        this.inputName = name;
        this.separatedName = separated();
    }

    public List<String> getSeparatedName() {
        return this.separatedName;
    }

    private List<String> separated() {
        if (inputName.length() == 0) {
            throw new NumberSizeOver();
        }

        return Arrays.asList(inputName.split(REGEX));
    }

}
