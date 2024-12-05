import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int C = 259;
        int[] W = { 81, 58, 42, 33, 61 };

        System.out.println("Max : " + findMax(C, W));
    }
//greedy algorithms
//    public static int findMax(int c, int[] W) {
//        Arrays.sort(W);
//        int max = 0;
//        for (int i=W.length - 1; i>=0; i--) {
//            if (max + W[i] < c) {
//                max += W[i];
//            }
//        }
//
//        return max;
//    }
// dynamic programming
    public static int findMax(int C, int[] W) {
        int[][] k = new int[W.length + 1][C +1];
        for(int i=0; i<=W.length; i++) {
            for(int j=0; j<=C; j++) {
                if (i == 0 || j == 0) {
                    k[i][j] = 0;
                } else if (W[i-1] <= j) {
                    k[i][j] = Math.max(k[i-1][j], W[i-1] + k[i-1][j - W[i-1]]);
                } else {
                    k[i][j] = k[i-1][j];
                }
            }
        }

        return k[W.length][C];
    }
}
