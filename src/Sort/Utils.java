package Sort;

public class Utils {

    public static boolean isSorted(int[] target) {
        for (int i = 0; i < target.length - 1; i++) {
            if (target[i] > target[i+1])
                return false;
        }
        return true;
    }

    public static final byte[] intToByteArray(int value) {
        return new byte[] {
                (byte)(value >> 24),
                (byte)(value >> 16),
                (byte)(value >> 8),
                (byte)value};
    }
}
