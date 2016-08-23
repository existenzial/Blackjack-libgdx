package com.existenzial.blackjack.Utils;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class GameManager extends Game{

    private static GameManager gameInstance = new GameManager();
    public boolean gameStarted;

    public GameManager(){

        gameStarted = false;

    }

    public static GameManager getGameInstance(){
        return gameInstance;
    }


    @Override
    public void create() {

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void setScreen(Screen screen) {
        super.setScreen(screen);
    }

    @Override
    public Screen getScreen() {
        return super.getScreen();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

}
