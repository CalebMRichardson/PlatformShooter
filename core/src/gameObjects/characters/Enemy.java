package gameObjects.characters;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class Enemy extends Character {

    public Enemy(Vector2 pos, String tag, int width, int height, World world)
    {
        super(pos,tag,width,height,world);
        //body = buildBox(true, true);
    }
}
