package racingcar.view;

import racingcar.model.Car;

public class OutputView {

    public void outputInitMessage() {
        System.out.println("실행 결과");
    }

    public void outputEnter() {
        System.out.println();
    }

    public void outputRacing(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void outputWinner(String winner) {
        System.out.println(winner + "가 최종 우승했습니다.");
    }

}
