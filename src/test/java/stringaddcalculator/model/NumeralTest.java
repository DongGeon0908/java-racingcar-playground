package stringaddcalculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;

public class NumeralTest {

    @DisplayName("입력값_숫자_검사_실패")
    @ParameterizedTest
    @CsvSource({
            "3123^3",
            "1231)3123",
            "1254+75667"
    })
    void isNumberOneFail(String input) {
        boolean actual = input.chars().allMatch(Character::isDigit);
        assertThat(actual).isFalse();
    }

    @DisplayName("입력값_단일_항목_검사_성공")
    @ParameterizedTest
    @CsvSource({
            "31233",
            "-12313123",
            "1254075667"
    })
    void isNumberOneSuccess(String input) {
        boolean actual = input.chars().allMatch(Character::isDigit);
        assertThat(actual).isTrue();
    }

    @DisplayName("입력값_전체_항목_검사_성공")
    @Test
    void isNumberSuccess() {
        String input = "1231 1232 1232541";
        List<String> number = new ArrayList<>(Arrays.asList(input.split(" ")));

        for (String index : number) {
            if (!index.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }

    @DisplayName("입력값_전체_항목_검사_실패")
    @Test
    void isNumberFail() {
        String input = "123tt31 123tt2 1tt232541";
        List<String> number = new ArrayList<>(Arrays.asList(input.split(" ")));

        //number.stream().forEach(n -> n.chars().allMatch(Character::isDigit)).
    }

    @DisplayName("문자열_숫자_리스트_반환_성공")
    @Test
    void stringToNumberSuccess() {
        String input = "1231 122 1232541";
        List<String> number = new ArrayList<>(Arrays.asList(input.split(" ")));
        List<Integer> expect = Arrays.asList(1231, 122, 1232541);

        List<Integer> actual = number.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("문자열_숫자_리스트_반환_실패")
    @Test
    void stringToNumberFail() {
        String input = "122$31 1d22 1(232541";
        List<String> number = new ArrayList<>(Arrays.asList(input.split(" ")));
        List<Integer> expect = Arrays.asList(1231, 122, 1232541);

        List<Integer> actual = number.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        assertThat(actual).isEqualTo(expect);
    }

}
