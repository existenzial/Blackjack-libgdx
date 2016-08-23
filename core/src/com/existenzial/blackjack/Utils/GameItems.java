package com.existenzial.blackjack.Utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.existenzial.blackjack.Blackjack;
import com.existenzial.blackjack.Screens.MainMenuScreen;

public class GameItems {

    // Game, Stage, View, Camera
    private Blackjack game;
    private Stage stage;
    private Viewport gameView;

    private BitmapFont font;

    // Buttons
    private TextButton menuButton;
    private TextButton.TextButtonStyle menuButtonStyle;

    // Labels
    private Label player1Label;
    private Label player2Label;
    private VerticalGroup playerLabelGroup;

    // Layout
    private Table gameTable;

    public GameItems(Blackjack game){
        this.game = game;

        gameView = new FitViewport(GameInfo.V_WIDTH, GameInfo.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(gameView, game.getBatch());

        Gdx.input.setInputProcessor(stage);

        font = game.getFont();
        menuButtonStyle = new TextButton.TextButtonStyle();

        gameTable = new Table().padRight(10).right();
        gameTable.setFillParent(true);

        createAndGroupLabels();
        addLabelsToTable();

        createButtons();
        addButtonListeners();
        addButtons();

    }

    private void createAndGroupLabels(){

        player1Label = new Label("Player 1: " + "Guest # 1", new Label.LabelStyle(font, Color.YELLOW));
        player1Label.setFontScale(1f);
        player1Label.setPosition(GameInfo.V_WIDTH / 2 + 575, GameInfo.V_HEIGHT / 2 + 100);

        player2Label = new Label("Player 2: " + "Guest # 2", new Label.LabelStyle(font, Color.RED));
        player2Label.setFontScale(1f);
        player2Label.setPosition(GameInfo.V_WIDTH / 2 + 575, GameInfo.V_HEIGHT / 2 + 75);

        // Group Player Labels
        playerLabelGroup = new VerticalGroup();

        playerLabelGroup.addActor(player1Label);
        playerLabelGroup.addActor(player2Label);

        stage.addActor(gameTable);

    }

    private void addLabelsToTable(){
        gameTable.add(player1Label).pad(10);
        gameTable.row();
        gameTable.row();
        gameTable.add(player2Label).pad(10);
        gameTable.row();
    }

    private void createButtons(){

        menuButtonStyle.font = font;
        menuButtonStyle.fontColor = Color.GRAY;
        menuButtonStyle.overFontColor = Color.LIGHT_GRAY;
        menuButton = new TextButton("Back to Menu", menuButtonStyle);
        menuButton.setPosition(GameInfo.V_WIDTH / 2 + 325, GameInfo.V_HEIGHT / 2 - 350);

    }

    private void addButtons(){

        getStage().addActor(menuButton);

    }

    private void addButtonListeners(){

        // Menu Button Actions
        menuButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                GameManager.getGameInstance().gameStarted = false;

                game.setScreen(new MainMenuScreen(game));

                // On Click UI - Screen Fade Out to MainMenuScreen
                SequenceAction sequenceAction = new SequenceAction();
                sequenceAction.addAction(Actions.fadeOut(1.75f));
                stage.addAction(sequenceAction);
            }
        });

    }

    public Stage getStage(){
        return this.stage;
    }

}
