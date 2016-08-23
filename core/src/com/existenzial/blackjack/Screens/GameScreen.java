package com.existenzial.blackjack.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.existenzial.blackjack.Blackjack;
import com.existenzial.blackjack.Sprites.GameBoard;
import com.existenzial.blackjack.Utils.GameInfo;
import com.existenzial.blackjack.Utils.GameItems;

public class GameScreen implements Screen, ContactListener {

    private Blackjack game;
    private World world;

    private OrthographicCamera camera;
    private Viewport gameView;

    private GameBoard gameBoard;
    private GameItems gameItems;

    public GameScreen(Blackjack game){
        this.game = game;

        camera = new OrthographicCamera(GameInfo.V_WIDTH, GameInfo.V_HEIGHT);
        camera.position.set(GameInfo.V_WIDTH / 2f, GameInfo.V_HEIGHT / 2f, 0);

        gameView = new FitViewport(GameInfo.V_WIDTH, GameInfo.V_HEIGHT, camera);

        world = new World(new Vector2(0, -9.8f), true);
        world.setContactListener(this);

        gameBoard = new GameBoard(game);

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


    private void setScreenBlue(){
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void render(float delta) {

        setScreenBlue();

        game.getBatch().begin();



        game.getBatch().end();

        // Game Items
        game.getBatch().setProjectionMatrix(gameItems.getStage().getCamera().combined);

        gameItems.getStage().draw();
        gameItems.getStage().act();

        world.step(Gdx.graphics.getDeltaTime(), 5, 2);
    }

    @Override
    public void show() {

        //Game Setup
        gameItems = new GameItems(game);
    }


    @Override
    public void resize(int width, int height) {
        gameView.update(width, height);
    }

    @Override
    public void beginContact(Contact contact) {

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

    @Override
    public void dispose() {

        world.dispose();
        game.getBatch().dispose();

    }

}
