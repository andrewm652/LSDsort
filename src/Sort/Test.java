package Sort;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Random;

public class Test {

    final static int ARRAY_SIZE = 1_000_000;
    final static int NUMBER_OF_TESTS = 100;

    public static void main(String[] args) {
        long sumQS = 0;
        long sumRBS = 0;
        for (int j = 0; j < NUMBER_OF_TESTS; j++) {
            Random random = new Random();
            int[] array = new int[ARRAY_SIZE];
            for (int i = 0; i < ARRAY_SIZE; i++) {
                array[i] = random.nextInt();
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
            sortArray2 = LSDBsort.radixByteSort(sortArray2);
            long finishRBS = System.nanoTime();
            long resultRBS = finishRBS - startRBS;
            sumRBS += resultRBS;
            System.out.println("elapsed time for radix byte sort = " + resultRBS);
            System.out.println(Utils.isSorted(sortArray2));
        }
        double resultQSda = (double)sumQS / NUMBER_OF_TESTS;
        double resultRBSda = (double)sumRBS / NUMBER_OF_TESTS;
        System.out.println(resultQSda + " average result for quick sort");
        System.out.println(resultRBSda + " average result for lsd sort");

        double result = new BigDecimal(resultQSda / resultRBSda).setScale(3, RoundingMode.UP).doubleValue();
        System.out.println(result + " times better than Arrays.sort");



        /*Random random = new Random();

        int[] array = new int[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt();
        }

        int[] sortArray1 = Arrays.copyOf(array, array.length);
        int[] sortArray2 = Arrays.copyOf(array, array.length);

        long stargQS = System.currentTimeMillis();
        Arrays.sort(sortArray1);
        long finishQS = System.currentTimeMillis();
        long resultQS = finishQS - stargQS;
        System.out.println("elapsed time for quick sort = " + resultQS);

        long stargRBS = System.currentTimeMillis();
        sortArray2 = LSDBsort.radixByteSort(sortArray2);
        long finishRBS = System.currentTimeMillis();
        long resultRBS = finishRBS - stargRBS;
        System.out.println("elapsed time for radix byte sort = " + resultRBS);

        double resultQSd = resultQS;
        double resultRBSd = resultRBS;
        double result = new BigDecimal(resultQSd / resultRBSd).setScale(3, RoundingMode.UP).doubleValue();
        System.out.println(result + " times better than Arrays.sort");

        System.out.println(Utils.isSorted(sortArray1));
        System.out.println(Utils.isSorted(sortArray2));*/

        /*int a = 127;
        int b = 128;
        for (int i = 0; i < 32; i+=8) {
            System.out.print(digitByte(a, i) + " ");
        }
        System.out.println();
        for (int i = 0; i < 32; i+=8) {
            System.out.print(digitByte(b, i) + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(intToByteArray(a)) + " = " + a);
        System.out.println(Arrays.toString(intToByteArray(b)) + " = " + b);*/

        /*for (int i = -20_000_100; i < -20_000_100 + 100; i++) {
            System.out.println(Arrays.toString(intToByteArray(i)) + " = " + i);
        }*/


    }
}
