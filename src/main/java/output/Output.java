package output;

import probability.AnalogTime;
import probability.MarkChain;
import probability.Vector;

import java.util.*;

public class Output {
    public static void main(String... args){
        System.out.println("------------- Модель с дискретным временем -------------");
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

        System.out.println("--------------- Модель с аналоговым временем ----------------");


        System.out.println("Введите число состояний:");
        int nAnalog = in.nextInt();
        Vector firstStateVectorAnalog = Vector.generate(nAnalog);

        System.out.println("Вектор плотностей начальных состояний: " + firstStateVectorAnalog);

        List<Vector> matrixAnalog = new ArrayList<>();

        for (int i = 0; i<nAnalog; i++){
            List<Double> list = new ArrayList<>();
            for (int j = 0; j<nAnalog; j++)
                list.add(new Random().nextInt(999) / 1000.0);
            matrixAnalog.add(new Vector(list));
        }

        System.out.println("Матрица плотностей вероятностей переходов: " + matrixAnalog);

        System.out.println("Введите время работы: ");

        Double t = in.nextDouble();

        System.out.println("Проведем эксперименты");

        System.out.println("Вектор конечных вероятностей, полученный экспериментально: " + AnalogTime.calculateFinalVector(matrixAnalog, firstStateVectorAnalog, t));


    }
}
