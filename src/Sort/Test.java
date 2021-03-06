package Sort;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Random;

public class Test {

    final static int ARRAY_SIZE = 1000000;
    final static int NUMBER_OF_TESTS = 100;

    public static void main(String[] args) {
        long sumQS = 0;
        long sumRBS = 0;
        for (int j = 0; j < NUMBER_OF_TESTS; j++) {
            Random random = new Random();
            int[] array = new int[ARRAY_SIZE];
            for (int i = 0; i < ARRAY_SIZE; i++) {
                array[i] = random.nextInt(Integer.MAX_VALUE);            // Only natural numbers
//                array[i] = random.nextInt();                           // All numbers
            }

            int[] sortArray1 = Arrays.copyOf(array, array.length);
            int[] sortArray2 = Arrays.copyOf(array, array.length);

            long startQS = System.nanoTime();
            Arrays.sort(sortArray1);
            long finishQS = System.nanoTime();
            long resultQS = finishQS - startQS;
            sumQS += (finishQS - startQS);
            System.out.println("elapsed time for quick sort = " + resultQS);

            long startRBS = System.nanoTime();
            sortArray2 = LSDBsort.radixByteSortNatural(sortArray2);     // Sort for natural numbers
//            sortArray2 = LSDBsort.radixByteSortAll(sortArray2);       // Sort for all numbers
            long finishRBS = System.nanoTime();
            long resultRBS = finishRBS - startRBS;
            sumRBS += resultRBS;
            System.out.println("elapsed time for radix byte sort = " + resultRBS);
            System.out.println(Arrays.equals(sortArray1, sortArray2));
        }
        double resultQSda = (double)sumQS / NUMBER_OF_TESTS;
        double resultRBSda = (double)sumRBS / NUMBER_OF_TESTS;
        System.out.println(resultQSda + " average result for quick sort");
        System.out.println(resultRBSda + " average result for lsd sort");

        double result = new BigDecimal(resultQSda / resultRBSda).setScale(3, RoundingMode.UP).doubleValue();
        System.out.println(result + " times better than Arrays.sort");
    }
}
