package com.existenzial.blackjack;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.existenzial.blackjack.Screens.MainMenuScreen;
import com.existenzial.blackjack.Utils.GameManager;

public class Blackjack extends Game {

    private SpriteBatch batch;
    private TextureAtlas assetAtlas;
    private BitmapFont font;

    private Music thememusic;

    @Override
    public void create() {

        batch = new SpriteBatch();
        assetAtlas = new TextureAtlas("packed/packt.atlas");
        font = new BitmapFont(new FileHandle("font.fnt"), new FileHandle("font.png"), false);

        thememusic = Gdx.audio.newMusic(Gdx.files.internal("thememusic.mp3"));

        GameManager.getGameInstance();

        setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    public final SpriteBatch getBatch() {
        return this.batch;
    }

    public final TextureAtlas getAtlas(){
        return this.assetAtlas;
    }

    public final BitmapFont getFont(){
        return this.font;
    }

    public final Music getTheme(){
        return this.thememusic;
    }

}
