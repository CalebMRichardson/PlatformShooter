package gameObjects.characters;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.bullet.collision.ContactListener;
import gameObjects.GameObject;

public class Character extends GameObject {

    protected boolean isFacingRight = true;
    protected ContactListener contactListener;

    protected enum collisionState
    {
        Falling;
    }

    private Motor motor;

    public Character(Vector2 pos, String tag, int width, int height, World world)
    {
        super(pos, tag, width, height, world);

        this.motor = motor;

        body = buildBox(true, true);
    }
}
