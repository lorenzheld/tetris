package ch.bbw.lorenzheld;


public class GameMatrix {



    int[][] matrix = new int[20][10];
    int[][][] matrixWBlock = new int[2][20][10];
    int[][] currentBlock;
    int currentheight;
    int currentx;

    public void newLBlock(){
        currentBlock = BlockMatrix.getL();
        currentheight = 0;
    }

    public void moveBlock(int x){
        blockInMatrix(0, x);
    }

    public void turnBlock() {
        int[][] turningMatrix = currentBlock;
        int n = 4; // Oder matrix.length
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Die Kern-Formel:
                // Neue Spalte = Alte Zeile (j = i)
                // Neue Zeile = Spalte von rechts gezählt (i = j) -> [j][n-1-i]
                rotated[j][n - 1 - i] = turningMatrix[i][j];
            }
        }
        currentBlock = rotated;

        blockInMatrix(0, 0);
    }


    public void blockInMatrix(int height, int x){
        if(height == 2){
            currentheight = 0;
        } else if (height == 1) {
            currentheight +=1;
        }
        //wenn height = 2 wirds auf 0 gestzt
        //wenn height = 1 wirds +1 gemacht
        //wenn height = 0 bleibt die höhe gleich

        if(x == 2){
            currentx = 0;
        } else if (x == 1) {
            currentx +=1;
        } else if (x== -1) {
            currentx -=1;
        }

        //Clear matrix
        for (int i = 0; i < matrixWBlock[0].length; i++) {
            for (int j = 0; j < matrixWBlock[0][i].length; j++) {
                matrixWBlock[0][i][j] = 0;
            }
        }

        for (int i = 0; i < 4; i++) {         // Zeilen der 4x4
            for (int j = 0; j < 4; j++) {     // Spalten der 4x4
                matrixWBlock[0][currentheight + i][currentx+ 3 + j] = currentBlock[i][j];
            }
        }
    }






    public int[][] getMatrix(){
        // matrix zurücksetzen
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = 0;
            }
        }

        // neu aufbauen
        for (int layer = 0; layer < 2; layer++) {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 10; j++) {
                    matrix[i][j] += matrixWBlock[layer][i][j];
                }
            }
        }

        return matrix;
    }

    public int getMatrixByK(int x, int y){
        System.out.println("Matrix: "+ matrix);
        return matrix[x][y];
    }

    public void setMatrixByK(int x, int y, int value){
        matrix[x][y] = value;
        matrixWBlock[1] = matrix;
    }


}
