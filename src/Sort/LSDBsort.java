package Sort;

public class LSDBsort {

    private final static int BITS_PER_BYTE = 8;
    private final static int BITS_INT = 32;
    private final static int COUNT_NUMBER = 256;

    // method for sort array of natural numbers
    public static int[] radixByteSortNatural(int[] a) {
        int[] c = new int[COUNT_NUMBER];
        for (int i = 0; i < BITS_INT; i+=BITS_PER_BYTE) {

            for (int j = 0; j < c.length; j++) {
                c[j] = 0;
            }

            for (int j = 0; j < a.length; j++) {
                int d = (a[j] >> i) & 0xFF;
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
                int d = (a[j] >> i) & 0xFF;
                b[c[d]] = a[j];
                c[d]++;
            }
            a = b;
        }
        return a;
    }

    // method for sort array of any int numbers
    public static int[] radixByteSortAll(int[] a) {
        int[] c = new int[COUNT_NUMBER];
        for (int i = 0; i < BITS_INT; i+=BITS_PER_BYTE) {

            for (int j = 0; j < c.length; j++) {
                c[j] = 0;
            }

            for (int j = 0; j < a.length; j++) {
                int d = digitByte(a[j], i);
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
                int d = digitByte(a[j], i);
                b[c[d]] = a[j];
                c[d]++;
            }
            a = b;
        }
        return a;
    }

    private static int digitByte(int target, int index) {
        byte b = (byte)(target >>> index);
        if (index == 24)
            return b + 128;
        if (b < 0) {
            return b + 256;
        }
        return b;
    }

}
