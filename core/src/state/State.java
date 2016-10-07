package state;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State {

    protected GameStateManager      gsm;

    protected OrthographicCamera    camera;

    protected State(GameStateManager gsm, OrthographicCamera camera)
    {
        this.gsm = gsm;

        this.camera = camera;
    }

    protected abstract void update(float dt);

    protected abstract void render(SpriteBatch sb);

    protected abstract void dispose();
}
