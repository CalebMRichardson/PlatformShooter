package gameObjects.characters;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import gameObjects.GameObject;
import gameObjects.characters.collision.CharacterCollision;

public class Character extends GameObject {

    public boolean isFacingRight = true;

    public boolean canJump = false;

    protected enum collisionState
    {
        Falling;
    }

    private Motor motor;

    public Character(Vector2 pos, String tag, String name, int width, int height, World world)
    {
        super(pos, tag, name, width, height, world);

        this.motor = motor;

        body = buildBox(true, true);

        CharacterCollision characterCollision = new CharacterCollision(world, name);
    }
}
