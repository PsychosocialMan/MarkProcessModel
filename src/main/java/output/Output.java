package output;

import probability.Equations;
import probability.MarkChain;
import probability.Vector;

import java.util.*;

public class Output {
    public static void main(String... args){
        System.out.println("Введите число вершин графа состояний:");
        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        Vector firstStateVector = Vector.generate(n);
        System.out.println("Вектор начальных состояний: " + firstStateVector);

        List<Vector> matrix = new ArrayList<>();
        for (int i = 0; i<n; i++){
            matrix.add(Vector.generate(n));
        }
        System.out.println("Матрица переходов: " + matrix);

        MarkChain markChain = MarkChain.generate(firstStateVector, matrix);
        System.out.println("Сгенерированная марковская цепочка: " + markChain);

        System.out.println("Вектор финальных вероятностей, полученный экспериментально: " + markChain.calculateFinalProbabilityVector());

        System.out.println("Вектор финальных вероятностей, полученный теоретически: " + Equations.calculateEquation(matrix, firstStateVector));
    }
}
