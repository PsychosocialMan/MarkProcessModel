package probability;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnalogTime {
    public static List<Double> calculateFinalVector(List<Vector> matrix, Vector vector, Double time){
        List<Double> result = new ArrayList<>();

        int stateNumber = 0, newState = 0, sumPereh = 0, n = vector.getSize();
        double randValue, sum = 0.0, minPereh;
        int[] sost = new int[1000];
        double[] rez = new double[100], sumRez = new double[100], pereh = new double[100];


        for (int x = 0; x < 100; x++){
            int z = 0;
            double t1 = time;
            while (t1 > 0){
                if (stateNumber == 0){
                    for (int i = 0; i < n; i++){
                        pereh[i] = -1 / vector.getVector().get(i) * Math.log(1.0 - (new Random().nextInt(100) / 100.0));
                    }
                    minPereh = pereh[0];
                    stateNumber = 1;
                    for (int i = 0; i < n; i++){
                        if (minPereh > pereh[i]){
                            minPereh = pereh[i];
                            stateNumber = i + 1;
                        }
                    }
                }
                else {
                    for (int i = 0; i<n;i++){
                        pereh[i] = -1 / matrix.get(stateNumber - 1).getVector().get(i) * Math.log(1.0 - (new Random().nextInt(100) / 100.0));
                    }
                    minPereh = pereh[0];
                    stateNumber = 1;
                    for (int i = 0; i< n; i++){
                        if(minPereh > pereh[i]){
                            minPereh = pereh[i];
                            stateNumber = i + 1;
                        }
                    }
                }
                sost[z] = stateNumber;
                rez[stateNumber - 1] = rez[stateNumber - 1] + 1;
                z++;
                t1 = t1 - minPereh;
                sumPereh++;
            }
            for (int i = 0; i<n;i++){
                sumRez[i] = sumRez[i] + rez[i];
            }
            for (int i = 0; i<n;i++){
                rez[i] = 0;
            }
        }
        for (int i = 0; i<n;i++){
            result.add(sumRez[i] / sumPereh);
        }

        return  result;
    }
}
