package tools.utils.supportModels;

import org.openqa.selenium.Dimension;
import tools.constants.Splitters;

import java.util.Arrays;
import java.util.List;

public class Bound {
    private static int xUpPoint;
    private static int yUpPoint;
    private static int xDownPoint;
    private static int yDownPoint;

    public static Dimension getDimension(String bounds) {
        initialize(bounds);
        return new Dimension(xUpPoint - xDownPoint, yUpPoint - yDownPoint);
    }

    private static void initialize(String bounds) {
        List<String> points = Arrays.stream(bounds.split(Splitters.BOUNDS)).filter(el -> !el.isEmpty()).toList();
        xUpPoint = Integer.parseInt(points.get(0));
        yUpPoint = Integer.parseInt(points.get(1));
        xDownPoint = Integer.parseInt(points.get(2));
        yDownPoint = Integer.parseInt(points.get(3));
    }


}
