package Sort;

public class LSDBsort {

    public static int[] radixByteSort(int[] a) {
        int[] c = new int[256];
        for (int i = 0; i < 32; i+=8) {
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
        if (b < 0) {
            return b + 256;
        }
        return b;
    }
}