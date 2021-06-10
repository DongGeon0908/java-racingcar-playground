package stringaddcalculator.model;

import stringaddcalculator.exception.NumberFormat;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    private final String CUSTOM_SEPARATOR = "\\/\\/(.)\\\\n(.*)";
    private final String DEFAULT_SEPARATOR = ",|:";
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
            throw new NumberFormat();
        }
    }

    private List<String> separate(String input) {
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR).matcher(input);
        if (m.find()) {
            return Arrays.asList(m.group(2).split(m.group(1)));
        }
        return Arrays.asList(input.split(DEFAULT_SEPARATOR));
    }


}
