package racingcar.model;

import java.util.Random;

public class RandomNumber {
    private final int RANDOM_RANGE = 2;
    private final Random random;

    public RandomNumber() {
        this.random = new Random();
    }

    public int createRandom() {
        return random.nextInt(RANDOM_RANGE);
    }

}