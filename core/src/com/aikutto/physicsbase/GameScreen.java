package com.aikutto.physicsbase;

import com.aikutto.physicsbase.helpers.BodyEditorLoader;
import com.aikutto.physicsbase.helpers.Box2DSpriteBody;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class GameScreen implements Screen {

    private World world;
    private OrthographicCamera camera;

    private SpriteBatch spriteBatch;
    private Box2DDebugRenderer box2DDebugRenderer;

    private Box2DSpriteBody firstPlayer, background;

    @Override
    public void show() {
        world = new World(new Vector2(0, -9.81f), false);
        BodyEditorLoader bodyEditorLoader = new BodyEditorLoader(Gdx.files.internal("bodies.json"));
        camera = new OrthographicCamera(16f, 9f);

        firstPlayer = new Box2DSpriteBody(bodyEditorLoader, world, "first", 1, BodyDef.BodyType.DynamicBody, 1, 0.4f, 0.6f);
        background = new Box2DSpriteBody(bodyEditorLoader, world, "bg", 16.1f, BodyDef.BodyType.StaticBody, 1, 0.4f, 0.6f);

        box2DDebugRenderer = new Box2DDebugRenderer();
        spriteBatch = new SpriteBatch();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.step(delta, 6, 2);

        spriteBatch.begin();
        background.draw(spriteBatch);
        firstPlayer.draw(spriteBatch);
        spriteBatch.end();
        camera.update();

        if (Gdx.input.isTouched()) {
            firstPlayer.getBody().setLinearVelocity(0, 10);
        }

//        box2DDebugRenderer.render(world, camera.combined);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
