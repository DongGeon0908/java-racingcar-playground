package racingcar.controller;

import racingcar.model.RacingNumber;
import racingcar.service.Race;
import racingcar.service.Separator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class PlayRacingCar {

    private final InputView inputView;
    private final OutputView outputView;

    public PlayRacingCar() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play() {
        List<String> carName = new Separator(inputView.init()).getSeparatedName();

        int racingNumber = new RacingNumber(inputView.input()).getRacingNumber();

        Race proceedRace = new Race(carName);

        outputView.outputInitMessage();

        for (int i = 0; i < racingNumber; i++) {
            proceedRace.proceed();
            proceedRace.getCars().forEach(car -> outputView.outputRacing(car.getName(), car.getLocation()));
            outputView.outputEnter();
        }

        outputView.outputWinner(proceedRace.getWinner());

    }
}
