package com.retrostruct.epsilon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import sun.font.GlyphLayout;


public class Game1 extends ApplicationAdapter {
	Stage stage;
	SpriteBatch batch;
	Texture img;
	Vector2 goTo;
	Vector2 currentPosition;
	float speed;
    BitmapFont font;

	dialogueHandler diaSwitch;

	String[] strings = new String[6];

	String[] answer1 = new String[3];
	String[] answer2 = new String[3];
	String[] answer3 = new String[2];

	String[] questions = new String[3];

	dialogue dia;
	dialogue[] answers = new dialogue[3];

	GlyphLayout layout;
	Choice choiceTest;

	
	@Override
	public void create () {

		strings[0] = "So you are new here?";
		strings[1] = "Don't worry";
		strings[2] = "We'll take good care of you";
		strings[3] = "You will fit in here in no time";
		strings[4] = "Head over to the reception";
		strings[5] = "I'm sure they'll help you there";

		questions[0] = "Where is the reception?";
		questions[1] = "Who are you?";
		questions[2] = "Where am I again?";

		answer1[0] = "Just through that door";
		answer1[1] = "Opening the door is simple";
		answer1[2] = "Just press it, and it should open";

		answer2[0] = "Me? I'm no one";
		answer2[1] = "You shouldn't ask such questions";
		answer2[2] = "Might get you in trouble";

		answer3[0] = "You are exactly where you need to be";
		answer3[1] = "I would get going if I were you";

		answers[0] = new dialogue(answer1);
		answers[1] = new dialogue(answer2);
		answers[2] = new dialogue(answer3);

		dia = new dialogue(strings);

		stage = new Stage(new ExtendViewport(800, 600));
		batch = new SpriteBatch();
		img = new Texture("logo.png");
		currentPosition = new Vector2(0,0);
		goTo = new Vector2(0,0);
		speed = 5;


		choiceTest = new Choice(questions);

        font = new BitmapFont(Gdx.files.internal("SFcartoon.fnt"));

		diaSwitch = new dialogueHandler(dia, answers, choiceTest, font);

	}


	@Override
	public void render () {




		if(Gdx.input.isTouched()){
			goTo.x = Gdx.input.getX();
			goTo.y = Gdx.input.getY();
		}




		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(stage.getCamera().combined);

		batch.begin();

		//batch.draw(img, 300, 0);
		diaSwitch.Render(batch, font, stage);

		batch.end();
	}
}
