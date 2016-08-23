package com.existenzial.blackjack.Screens;


import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.existenzial.blackjack.Blackjack;
import com.existenzial.blackjack.Utils.OptionsMenuItems;

public class OptionsScreen {

    private Blackjack game;

    private OrthographicCamera camera;
    private Viewport gameView;

    private Texture background;

    private Music thememusic;

    private OptionsMenuItems optionsMenuItems;

    public OptionsScreen(Blackjack game){
        this.game = game;

    }

}
