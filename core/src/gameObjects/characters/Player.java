package gameObjects.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class Player extends Character {

    private float       moveSpeed = 5f;

    public Player(Vector2 pos, String tag, String name, int width, int height, World world) {
        super(pos, tag, name, width, height, world);
    }

    private void handleInput()
    {
        int horizontalMovement = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.D))
        {
            horizontalMovement += 1;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A))
        {
            horizontalMovement -= 1;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
        {
            body.applyForceToCenter(0, 300, false);
        }

        body.setLinearVelocity(horizontalMovement * moveSpeed, body.getLinearVelocity().y);
    }

    public void update(float dt)
    {
        handleInput();
    }

    public void render(SpriteBatch sb)
    {

    }

    public void dispose()
    {

    }
}
