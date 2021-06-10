package racingcar.model;

public class Car {
    private final Name name;
    private int location = 0;

    public Car(String name) {
        this.name = new Name(name);
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name.getName();
    }

    public void moveCar() {
        this.location += new RandomNumber().createRandom();
    }

}
