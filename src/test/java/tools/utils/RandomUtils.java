package tools.utils;

import java.util.List;
import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();

    public static <T> T getRandomItemFromList(List<T> list) {
        return list.get(RANDOM.nextInt(list.size()));
    }

}
