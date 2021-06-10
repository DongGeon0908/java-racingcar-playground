package stringaddcalculator.controller;

import stringaddcalculator.model.Numeral;
import stringaddcalculator.model.Separator;
import stringaddcalculator.model.Validation;
import stringaddcalculator.service.Calculate;
import stringaddcalculator.view.InputView;
import stringaddcalculator.view.OutputView;

import java.util.List;

public class Calculator {

    public void playCalculator() {
        String input = new InputView().input();
        Validation validation = new Validation(input);

        if (!validation.validate().equals("PASS")) {
            OutputView.outputString(validation.validate());
        }
        List<String> separatedNumber = new Separator(input).values();

        Numeral numeral = new Numeral(separatedNumber);

        int result = Calculate.add(numeral.getResultNumber());
        OutputView.outputInt(result);
    }

}
