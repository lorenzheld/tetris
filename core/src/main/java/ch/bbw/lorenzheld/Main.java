package ch.bbw.lorenzheld;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {

    private ShapeRenderer shapeRenderer;
    private int[][] matrix;
    private int cellSize = 30; // Größe einer Zelle in Pixeln

    GameMatrix gameMatrix = new GameMatrix();


    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();

        // Matrix aus deiner GameMatrix-Klasse holen
        gameMatrix.newLBlock();
        gameMatrix.blockInMatrix(2, 2);
        matrix = gameMatrix.getMatrix();   // <--- wichtig: zuweisen

    }

    @Override
    public void render() {

        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            System.out.println("DOWN gedrückt!");

            gameMatrix.blockInMatrix(1, 0);
            matrix = gameMatrix.getMatrix();   // <--- wichtig: zuweisen

        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            System.out.println("Up gedrückt!");

            gameMatrix.turnBlock();
            matrix = gameMatrix.getMatrix();   // <--- wichtig: zuweisen

        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            System.out.println("Left gedrückt!");

            gameMatrix.moveBlock(-1);

            matrix = gameMatrix.getMatrix();   // <--- wichtig: zuweisen
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            System.out.println("Right gedrückt!");

            gameMatrix.moveBlock(1);

            matrix = gameMatrix.getMatrix();   // <--- wichtig: zuweisen
        }

        ScreenUtils.clear(0f, 0f, 0f, 1f);

        if (matrix == null) return;

        int rows = matrix.length;
        int cols = matrix[0].length;

        // 1) Zellen gefüllt zeichnen (mit Farben je nach Wert)
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                int flippedY = rows-y-1;
                int value = matrix[flippedY][x];


                if (value == 0) continue; // 0 = leer, nichts zeichnen

                switch (value) {
                    case 1:
                        shapeRenderer.setColor(Color.RED);
                        break;
                    case 2:
                        shapeRenderer.setColor(Color.BLUE);
                        break;
                    case 3:
                        shapeRenderer.setColor(Color.GREEN);
                        break;
                    default:
                        shapeRenderer.setColor(Color.GRAY);
                        break;
                }

                shapeRenderer.rect(
                    x * cellSize,
                    (y) * cellSize,
                    cellSize,
                    cellSize
                );
            }
        }

        shapeRenderer.end();

        // 2) Rasterlinien drüber zeichnen
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.WHITE);

        // Vertikale Linien
        for (int x = 0; x <= cols; x++) {
            float px = x * cellSize;
            shapeRenderer.line(px, 0, px, rows * cellSize);
        }

        // Horizontale Linien
        for (int y = 0; y <= rows; y++) {
            float py = y * cellSize;
            shapeRenderer.line(0, py, cols * cellSize, py);
        }

        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
