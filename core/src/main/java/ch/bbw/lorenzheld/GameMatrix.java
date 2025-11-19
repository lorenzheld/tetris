package ch.bbw.lorenzheld;


public class GameMatrix {



    int[][] matrix = new int[10][20];


    public int[][] getMatrix(){
        System.out.println("Matrix: "+ matrix);
        return matrix;
    }

    public int getMatrixByK(int x, int y){
        System.out.println("Matrix: "+ matrix);
        return matrix[x][y];
    }

    public void setMatrixByK(int x, int y, int value){
        matrix[x][y] = value;
    }


}
