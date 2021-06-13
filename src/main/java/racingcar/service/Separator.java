package racingcar.service;

import racingcar.exception.NumberSizeOverException;
import racingcar.model.Regex;

import java.util.Arrays;
import java.util.List;

public class Separator {
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
        isEmpty();
        return Arrays.asList(inputName.split(new Regex().getRegex()));
    }

    private void isEmpty() {
        if (inputName.isEmpty()) {
            throw new NumberSizeOverException();
        }
    }

}
