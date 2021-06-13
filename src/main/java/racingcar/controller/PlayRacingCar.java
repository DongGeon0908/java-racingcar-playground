package racingcar.controller;

import racingcar.model.Participation;
import racingcar.model.RacingNumber;
import racingcar.service.Race;
import racingcar.service.Separator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class PlayRacingCar {

    private final InputView inputView;
    private final OutputView outputView;

    public PlayRacingCar() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        String userInputName = inputView.init();
        Separator separator = new Separator(userInputName);
        Participation participation = new Participation(separator.getSeparatedName());
        Race race = new Race(participation);

        String userInputRacingNumber = inputView.input();
        int racingNumber = new RacingNumber(userInputRacingNumber).getRacingNumber();

        outputView.outputInitMessage();

        for (int index = 0; index < racingNumber; index++) {
            race.proceed();
            race.getParticipation().getCars().forEach(outputView::outputRacing);
            outputView.outputEnter();
        }

        outputView.outputWinner(race.getWinner());

    }
}
