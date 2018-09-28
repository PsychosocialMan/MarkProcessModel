package probability;

import java.util.Random;

public class Probability {

    private static Integer ACCURACY = 1000;

    static Double generate(){
        return new Random().nextInt(1000) / (double) ACCURACY;
    }
}
