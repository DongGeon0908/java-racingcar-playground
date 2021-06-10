package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Participation {

    private final List<Car> cars;

    public Participation(List<String> carName) {
        this.cars = participate(carName);
    }

    public List<Car> getParticipation() {
        return cars;
    }

    private List<Car> participate(List<String> carName) {
        return carName.stream().map(Car::new).collect(Collectors.toList());
    }

}
