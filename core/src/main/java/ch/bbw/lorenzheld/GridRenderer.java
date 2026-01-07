package ch.bbw.lorenzheld;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GridRenderer {

    private ShapeRenderer shapeRenderer;
    private int cellSize = 30;

    public GridRenderer() {
        shapeRenderer = new ShapeRenderer();
    }

    public void drawGrid(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.WHITE);

        for (int x = 0; x <= cols; x++) {
            shapeRenderer.line(x * cellSize, 0, x * cellSize, rows * cellSize);
        }

        for (int y = 0; y <= rows; y++) {
            shapeRenderer.line(0, y * cellSize, cols * cellSize, y * cellSize);
        }

        shapeRenderer.end();
    }

    public void drawMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (int y = 20; y < rows; y--) {
            for (int x = 0; x < cols; x++) {
                System.out.println(y);

                int value = matrix[y][x];

                if (value != 0) {
                    // Farbe je nach Wert
                    switch (value) {
                        case 1: shapeRenderer.setColor(Color.RED); break;
                        case 2: shapeRenderer.setColor(Color.BLUE); break;
                        case 3: shapeRenderer.setColor(Color.GREEN); break;
                        default: shapeRenderer.setColor(Color.GRAY); break;
                    }

                    shapeRenderer.rect(
                        x * cellSize,
                        y * cellSize,
                        cellSize,
                        cellSize
                    );
                }
            }
        }

        shapeRenderer.end();
    }

}
