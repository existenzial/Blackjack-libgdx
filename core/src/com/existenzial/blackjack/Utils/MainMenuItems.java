package com.existenzial.blackjack.Utils;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.existenzial.blackjack.Blackjack;
import com.existenzial.blackjack.Screens.GameScreen;
import com.existenzial.blackjack.Screens.OptionsScreen;

public class MainMenuItems {

    // Game, Stage, View, Camera
    private Blackjack game;
    private Stage stage;
    private Viewport gameView;

    // Buttons
    private ImageButton playButton;
    private ImageButton optionsButton;
    private ImageButton highScoresButton;

    // SoundFX
    private Sound click;

    // Fonts
    private BitmapFont font;

    // Main Labels
    private Label gameTitle;

    //Menu Layout
    private Table mainMenuTable;

    public MainMenuItems(Blackjack game){

        this.game = game;

        gameView = new FitViewport(GameInfo.V_WIDTH, GameInfo.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(gameView, game.getBatch());

        Gdx.input.setInputProcessor(stage);

        font = game.getFont();

        mainMenuTable = new Table().padLeft(10).bottom();
        mainMenuTable.setFillParent(true);

        click = Gdx.audio.newSound(Gdx.files.internal("button_click.wav"));

        createAndGroupLabels();

        createButtons();
        addButtonListeners();
        addButtons();

    }

    private void createAndGroupLabels(){

        gameTitle = new Label("Blackjack", new Label.LabelStyle(font, Color.BLACK));
        gameTitle.setFontScale(3);
        gameTitle.setPosition(GameInfo.V_WIDTH / 2 - 575, GameInfo.V_HEIGHT / 2 + 275);
        stage.addActor(gameTitle);

        stage.addActor(mainMenuTable);

    }

    private void createButtons(){

        playButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture("playButton.png"))));
        playButton.setPosition(GameInfo.V_WIDTH / 2 - 575, GameInfo.V_HEIGHT / 2 - 315);

        optionsButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture("optionsButton.png"))));
        optionsButton.setPosition(GameInfo.V_WIDTH / 2 - 375, GameInfo.V_HEIGHT / 2 - 315);

        highScoresButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture("highScoresButton.png"))));
        highScoresButton.setPosition(GameInfo.V_WIDTH / 2 - 175, GameInfo.V_HEIGHT / 2 - 315);

    }

    private void addButtons(){

        stage.addActor(playButton);
        stage.addActor(optionsButton);
        stage.addActor(highScoresButton);

    }

    private void addButtonListeners(){

        // Play Button Actions
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                GameManager.getGameInstance().gameStarted = true;

                RunnableAction runnableAction = new RunnableAction();
                runnableAction.setRunnable(new Runnable() {

                    @Override
                    public void run() {
                        game.setScreen(new GameScreen(game));
                    }

                });
                // On Click UI - Screen Fade Out to GameScreen
                SequenceAction sequenceAction = new SequenceAction();
                sequenceAction.addAction(Actions.fadeOut(1.75f));
                sequenceAction.addAction(runnableAction);
                stage.addAction(sequenceAction);
            }
        });

        optionsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                @Override
                public void run(){
                    game.setScreen(new OptionsScreen(game));
                }
            }
        });
    }

    public Stage getStage(){
        return this.stage;
    }

}
