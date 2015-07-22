package Sort;

public class LSDsort {

    @Deprecated
    public static int[] radixSort(int[] a) {
        int[] c = new int[10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < c.length; j++) {
                c[j] = 0;
            }
            for (int j = 0; j < a.length; j++) {
                int d = digit(a[j], i);
                c[d]++;
            }
            int count = 0;
            for (int j = 0; j < c.length; j++) {
                int tmp = c[j];
                c[j] = count;
                count += tmp;
            }
            int[] b = new int[a.length];
            for (int j = 0; j < a.length; j++) {
                int d = digit(a[j], i);
                b[c[d]] = a[j];
                c[d]++;
            }
            a = b;
        }
        return a;
    }

    private static int digit(int target, int index) {
        String targetAsString = String.valueOf(target);
        if (index >= targetAsString.length())
            return 0;
        return Character.getNumericValue(targetAsString.charAt(targetAsString.length() - 1 - index));
    }
}
