package racingcar.view;

public class OutputView {

    public void outputInitMessage() {
        System.out.println("실행 결과");
    }

    public void outputEnter() {
        System.out.println();
    }

    public void outputRacing(String name, int location) {
        System.out.print(name + " : ");
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void outputWinner(String winner) {
        System.out.println(winner + "가 최종 우승했습니다.");
    }

}
