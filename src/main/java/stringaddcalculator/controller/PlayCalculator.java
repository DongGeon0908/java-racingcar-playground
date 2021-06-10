package stringaddcalculator.controller;

import stringaddcalculator.model.Number;
import stringaddcalculator.model.Separator;
import stringaddcalculator.model.Validation;
import stringaddcalculator.service.Calculate;
import stringaddcalculator.view.InputView;
import stringaddcalculator.view.OutputView;

import java.util.List;

public class PlayCalculator {

    private final InputView inputView;

    public PlayCalculator() {
        this.inputView = new InputView();
    }

    public void play() {
        String input = inputView.input();
        Validation validation = new Validation(input);


        if (!validation.validate().equals("PASS")) {
            OutputView.outputString(validation.validate());
        }
        List<String> separatedNumber = new Separator(input).values();

        Number numeral = new Number(separatedNumber);

        int result = new Calculate().add(numeral.getResultNumber());
        OutputView.outputInt(result);
    }

}
