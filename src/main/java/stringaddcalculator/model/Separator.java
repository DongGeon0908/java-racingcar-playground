package stringaddcalculator.model;

import stringaddcalculator.exception.NumberInputException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    private final String CUSTOM_SEPARATOR = "\\/\\/(.)\\\\n(.*)";
    private final String DEFAULT_SEPARATOR = ",|:";
    private final int TARGET_NUMBER = 2;
    private final int SPLIT_NUMBER = 1;
    private final List<String> separatorNumber;

    public Separator(String input) {
        this.separatorNumber = separate(input);
        existNumber();
    }

    public List<String> values() {
        return this.separatorNumber;
    }

    private void existNumber() {
        if (this.separatorNumber.isEmpty()) {
            throw new NumberInputException();
        }
    }

    private List<String> separate(String input) {
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR).matcher(input);
        if (m.find()) {
            return Arrays.asList(m.group(TARGET_NUMBER).split(m.group(SPLIT_NUMBER)));
        }
        return Arrays.asList(input.split(DEFAULT_SEPARATOR));
    }
}
