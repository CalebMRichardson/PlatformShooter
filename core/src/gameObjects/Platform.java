package gameObjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class Platform extends GameObject {

    public Platform(Vector2 pos, String tag, int width, int height, World world) {
        super(pos, tag, width, height, world);

        body = buildBox(false, false);
    }
}
