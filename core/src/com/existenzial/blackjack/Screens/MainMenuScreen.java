package com.existenzial.blackjack.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.existenzial.blackjack.Blackjack;
import com.existenzial.blackjack.Utils.GameInfo;
import com.existenzial.blackjack.Utils.MainMenuItems;
import com.sun.org.apache.xpath.internal.operations.String;

public class MainMenuScreen implements Screen{

    private Blackjack game;

    private OrthographicCamera camera;
    private Viewport gameView;

    private Texture background;

    private Music thememusic;

    private MainMenuItems menuItems;

    public MainMenuScreen(Blackjack game){
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameInfo.V_WIDTH / GameInfo.PPM, GameInfo.V_HEIGHT / GameInfo.PPM);
        camera.position.set(GameInfo.V_WIDTH /2f, GameInfo.V_HEIGHT / 2f, 0);

        gameView = new FitViewport(GameInfo.V_WIDTH, GameInfo.V_HEIGHT, camera);

        thememusic = game.getTheme();
        thememusic.setVolume(.36f);
        thememusic.setLooping(true);

    }

    private void loadBackground(java.lang.String bg){
        background = new Texture(bg);
    }

    private void clearWhite(){
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void show(){

        //Music Setup
        thememusic.play();

        //Background Setup
        loadBackground("gamelogo.png");

        //Main Menu Setup
        menuItems = new MainMenuItems(game);

    }

    @Override
    public void render(float delta) {

        clearWhite();

        game.getBatch().begin();

        game.getBatch().draw(background, (GameInfo.V_WIDTH / 2) - background.getWidth() / 2, (GameInfo.V_HEIGHT / 2) - background.getHeight() / 2);

        game.getBatch().end();

        // Menu Buttons
        game.getBatch().setProjectionMatrix(menuItems.getStage().getCamera().combined);
        menuItems.getStage().draw();
        menuItems.getStage().act();

    }

    @Override
    public void resize(int width, int height) {
        gameView.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        thememusic.setPan(.36f, 0);
    }

    @Override
    public void dispose() {
        game.getBatch().dispose();
        background.dispose();
        menuItems.getStage().dispose();
        thememusic.dispose();
    }

}
