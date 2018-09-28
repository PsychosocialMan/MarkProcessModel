package probability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MarkChain {
    private static Integer ACCURACY = 10000;

    private static List<Integer> markChain;
    private static Integer numberOfStates;

    private MarkChain(List<Integer> markChain, Integer numberOfStates){
        this.markChain = markChain;
        this.numberOfStates = numberOfStates;
    }

    public static MarkChain generate(Vector firstStateVector, List<Vector> matrix) {
        List<Integer> result = new ArrayList<>();

        Double random = Probability.generate();
        Integer firstState = firstStateVector.switchToState(random);
        result.add(firstState);

        Integer previousState = firstState;
        for (int i = 0; i < ACCURACY; i++){
            random = Probability.generate();
            previousState = matrix.get(previousState).switchToState(random);
            result.add(previousState);
        }

        return new MarkChain(result, firstStateVector.getSize());
    }

    public List<Double> calculateFinalProbabilityVector(){
        List<Double> result = new ArrayList<>();

        for (int i = 0; i < numberOfStates; i++){
            result.add(Collections.frequency(this.markChain, i) / (double)ACCURACY);
        }

        return result;
    }

    @Override
    public String toString() {
        return markChain.toString();
    }
}
