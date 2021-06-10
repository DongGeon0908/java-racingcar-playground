package stringaddcalculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SeparatorTest {

    @DisplayName("구분자가_Defalt_또는_Custom")
    @Test
    void findDefaultOrCustomSeparator() {
        boolean actual = "//asdjkaskd".substring(0, 2).equals("//");
        assertThat(actual).isTrue();
    }

    @DisplayName("custom_test")
    @Test
    void custom_test() {
        //String text = "//;\\n1;2;3";
        Matcher m = Pattern.compile("\\/\\/(.)\\\\n(.*)").matcher("//;\\n1;2;3");

        if (m.find()) {
            String customDelimiter = m.group(1);
            List<String> tokens = Arrays.asList(m.group(2).split(customDelimiter));

            for (String str : tokens) {
                System.out.print(str);
            }

            System.out.println(">>" + Arrays.asList(m.group(2).split(m.group(1))).size());
        }

        //throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    // 다시
    @DisplayName("커스텀_구분자_성공")
    @Test
    void customSeparateSuccess() {
        String[] expect = {"1", "5", "6"};

        Matcher m = Pattern.compile("\\/\\/(.)\\\\n(.*)").matcher("//;\n1;5;6");

        assertThat(expect).isEqualTo(m.group(2).split(m.group(1)));
    }

    // 다시
    @DisplayName("커스텀_구분자_실패")
    @ParameterizedTest
    @CsvSource({
            "//;n1;2;3,123",
            "//;\1;4;3,143",
            "/;\n1;3;6,136"
    })
    void customSeparateFail(String input, String result) {
        List<String> expect = Arrays.asList(result.split(""));

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            assertThat(expect).isEqualTo(Arrays.asList(m.group(2).split(m.group(1))));
        }
        //throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    @DisplayName("기본_구분자_성공")
    @Test
    void defaultSeparateSuccess() {
        List<String> actual = Arrays.asList("1,2:3".split(",|:"));
        List<String> expect = Arrays.asList("123".split(""));

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("기본_구분자_실패")
    @Test
    void defaultSeparateFail() {
        List<String> actual = new ArrayList<>();
        if ("1*3".matches(".*,*.*:*")) {
            actual = Arrays.asList("1:3,4".split(",|:"));
        }
        if (actual.size() == 0) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        System.out.println(actual);
    }


}
