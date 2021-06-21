package jediGalaxy;

public class Galaxy {
    private int[][] matrix;

    Galaxy(int x, int y){
        this.matrix = buildMatrixGalaxy(x, y);
    }
    private static int[][] buildMatrixGalaxy(int x, int y){
        int[][] matrix = new int[x][y];

        int value = 0;
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }
    public int[][] getMatrix() {
        return matrix;
    }
    public void evilStarsDestroy(int x, int y){
        this.matrix[x][y] = 0;
    }
    public int starValue(int x, int y){
        return this.matrix[x][y];
    }
}
