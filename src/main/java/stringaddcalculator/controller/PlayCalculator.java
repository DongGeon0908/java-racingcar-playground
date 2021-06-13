package stringaddcalculator.controller;

import stringaddcalculator.model.Number;
import stringaddcalculator.model.Separator;
import stringaddcalculator.model.Validation;
import stringaddcalculator.service.Calculate;
import stringaddcalculator.view.InputView;
import stringaddcalculator.view.OutputView;

import java.lang.reflect.Member;
import java.util.stream.Stream;

public class PlayCalculator {

    private final InputView inputView;
    private final Calculate calculate;

    public PlayCalculator() {
        this.inputView = new InputView();
        this.calculate = new Calculate();
    }

    public void play() {
        String input = inputView.input();
        Validation validation = new Validation(input);


        if (!validation.validate().equals("PASS")) {
            OutputView.outputString(validation.validate());
        }

        // 함수형을 공부하자... 실행단계를 파이프로 넘겨서?
        // 파이프로 던지는 연습 --> 자바 trigger
        // calculate.add(new Number(new Separator(input)))처럼 단계적으로 변수를 집어 넣을 .,..

        Separator separator = new Separator(input);

        Number number = new Number(separator);


        int result = calculate.add(number);

        OutputView.outputInt(result);
    }
}
