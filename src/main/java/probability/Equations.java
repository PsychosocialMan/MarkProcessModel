package probability;

import org.apache.commons.math3.linear.*;

import java.util.List;

public class Equations {

    public static String calculateEquation(List<Vector> matrix, Vector vector){
        RealMatrix coefficients =
                new Array2DRowRealMatrix(new double[][] { { 2, 3, -2 }, { -1, 7, 6 }, { 4, -3, -5 } },
                        false);
        DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();

        RealVector constants = new ArrayRealVector(new double[] { 1, -2, 1 }, false);
        RealVector solution = solver.solve(constants);
        // solution.getEntry(0) - 0 элемент
        return solution.toString();
    }

}
