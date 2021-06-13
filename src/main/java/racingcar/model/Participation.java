package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

// 일급 객체라면 계속 일급 객체로
public class Participation {

    private final List<Car> cars;

    public Participation(List<String> carName) {
        this.cars = participate(carName);
    }

    public List<Car> getParticipation() {
        return cars;
    }

    // 리플렉션으로 도전하기,,,!!! 도전도전! (리플렉션을 통해 TEST 코드짜기)
    // 자바 힙, 클래스 로더, 메소드 에리어.. 공부 (메소드 에리어에서 정부 다 빼올 수 있음. )... (스프링 + 리플렉션)
    private List<Car> participate(List<String> carName) {
        return carName.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

}
