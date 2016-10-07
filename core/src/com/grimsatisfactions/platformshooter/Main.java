package com.grimsatisfactions.platformshooter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import state.GameStateManager;
import state.PlayState;

public class Main extends ApplicationAdapter {

	private SpriteBatch 		batch;

	private GameStateManager 	gsm;

	private OrthographicCamera	camera;

	private final int			V_WIDTH = 720;

	private final int 			V_HEIGHT = 480;

	private final int 			SCALE = 2;

	@Override
	public void create ()
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);

		camera = new OrthographicCamera();

		camera.setToOrtho(false, V_WIDTH / SCALE, V_HEIGHT / SCALE);

		batch = new SpriteBatch();

		batch.setProjectionMatrix(camera.combined);

		gsm = new GameStateManager();

		gsm.push(new PlayState(gsm, camera));
	}

	@Override
	public void resize(int width, int height)
	{
		camera.setToOrtho(false, width / SCALE, height / SCALE);
	}

	@Override
	public void render ()
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gsm.update(Gdx.graphics.getDeltaTime());

		gsm.render(batch);
	}
	
	@Override
	public void dispose ()
	{
		batch.dispose();
		gsm.dispose();
	}
}