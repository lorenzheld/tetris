package ch.bbw.lorenzheld;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.awt.*;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private Stage stage;
    private Skin skin;
    private ShapeRenderer shape;
    private float x = 100, y = 100, speed = 200;

    @Override
    public void create() {

        shape = new ShapeRenderer();

        // Stage erstellen mit einer Viewport-Größe (z. B. 800 × 600)
        stage = new Stage(new FitViewport(800, 600));

        // Input-Verarbeitung auf die Stage legen (falls du Buttons hast)
        Gdx.input.setInputProcessor(stage);


        GameMatrix GameMatrix = new GameMatrix();

        GameMatrix.getMatrix();




    }

    @Override
    public void render() {
        ScreenUtils.clear(0.4f, 0.2f, 0.9f, 1);

        float delta = Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(0.2f, 0.6f, 1f, 1);

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))  x -= speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x += speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.UP))    y += speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))  y -= speed * delta;

        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.RED);
        shape.rect(x, y, 50, 50);
        shape.end();
    }

    @Override
    public void resize(int width, int height) {
        // If the window is minimized on a desktop (LWJGL3) platform, width and height are 0, which causes problems.
        // In that case, we don't resize anything, and wait for the window to be a normal size before updating.
        if(width <= 0 || height <= 0) return;

        stage.getViewport().update(width, height);
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
