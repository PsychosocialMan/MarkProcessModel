package probability;

import org.apache.commons.math3.linear.*;

import java.util.ArrayList;
import java.util.List;

public class Equations {

    public static List<Double> calculateEquation(List<Vector> matrix, Vector vector){
        RealMatrix coefficients =
                new Array2DRowRealMatrix(transformListOfVectorToMatrix(matrix),
                        false);
        DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();

        RealVector constants = new ArrayRealVector(transformVectorToArray(vector),
                false);
        RealVector solution = solver.solve(constants);
        // solution.getEntry(0) - 0 элемент

        List<Double> result = new ArrayList<>();
        for (int i = 0; i < vector.getSize(); i++){
            result.add(solution.getEntry(i));
        }

        return result;
    }

    private static double[][] transformListOfVectorToMatrix(List<Vector> matrix){
        double[][] result = new double[matrix.size()][];
        for (int i = 0; i < result.length; i++) {
            double[] array = new double[matrix.get(i).getSize()];
            for (int j = 0; j < array.length; j++){
                array[j] = matrix.get(i).getVector().get(j);
            }
            result[i] = array;
        }
        return result;
    }

    private static double[] transformVectorToArray(Vector array){
        double[] result = new double[array.getSize()];
        for (int j = 0; j < result.length; j++){
            result[j] = array.getVector().get(j);
        }
        return result;
    }
}
