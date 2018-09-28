package probability;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vector {

    private List<Double> vector;

    public Vector(List<Double> vector) {
        this.vector = vector;
    }

    private static Integer ACCURACY = 1000;

    public Integer getSize(){
        return this.vector.size();
    }

    public List<Double> getVector(){
        return this.vector;
    }

    public static Vector generate(Integer size) {
        List<Double> listOfProbabilities = new ArrayList<Double>();

        if (size == 0)
            return null;

        int bound = new Random().nextInt(ACCURACY);
        Double down = (double) ACCURACY;
        Integer sumOfUp = 0;

        for (int i = 0; i < size - 1; i++) {
            Integer up = new Random().nextInt(bound);
            sumOfUp += up;
            Double probability = up / down;
            bound -= up;
            listOfProbabilities.add(probability);
        }

        listOfProbabilities.add((ACCURACY - sumOfUp) / down);

        return new Vector(listOfProbabilities);
    }

    public Integer switchToState(Double probability) {
        Double sum = this.vector.get(0);
        for (int i = 0; i < this.vector.size() - 1; i++){
            if (probability <= sum)
                return i;
            sum += this.vector.get(i + 1);
        }
        return this.vector.size() - 1;
    }

    @Override
    public String toString() {
        return vector.toString();
    }
}
