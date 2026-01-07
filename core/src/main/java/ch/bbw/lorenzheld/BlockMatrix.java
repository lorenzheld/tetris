package ch.bbw.lorenzheld;

public class BlockMatrix {
    int[][] BlockMatrix = new int[20][10];

    static int[][] L = {
        {0, 1, 0, 0},
        {0, 1, 0, 0},
        {0, 1, 1, 0},
        {0, 0, 0, 0}
    };

    public static int[][] getL() {
        return L;
    }
}
