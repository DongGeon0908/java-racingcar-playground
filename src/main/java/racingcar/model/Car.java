package racingcar.model;

public class Car {
    private final Name name;
    private int location;

    public Car(Name name) {
        this.name = name;
        location = 0;
    }

    public int getLocation() {
        return location;
    }

    public Name getName() {
        return name;
    }

    public void moveCar() {
        location += new RandomNumber().createRandom();
    }

}
