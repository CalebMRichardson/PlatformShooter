package gameObjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.bullet.collision.ContactListener;

public class GameObject {

    protected Vector2       pos;

    protected int           width;

    protected int           height;

    protected World         world;

    protected Body          body;

    protected final float   PPM = 32;

    public String           tag;

    public GameObject(Vector2 pos, String tag, int width, int height, World world)
    {
        this.pos = pos;

        this.tag = tag;

        this.width = width;

        this.height = height;

        this.world = world;
    }

    public Body getBody()
    {
        return body;
    }

    public Vector2 getPos()
    {
        return body.getPosition();
    }

    public Body buildBox(boolean isDynamic, boolean fixedRotation)
    {
        Body body;

        BodyDef bodyDef = new BodyDef();

        if (isDynamic)
            bodyDef.type = BodyDef.BodyType.DynamicBody;

        else
            bodyDef.type = BodyDef.BodyType.StaticBody;

        bodyDef.fixedRotation = fixedRotation;

        bodyDef.position.set(pos.x / PPM, pos.y / PPM);

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();

        shape.setAsBox(width / 2 / PPM, height / 2 / PPM);

        body.createFixture(shape, 1.f).setUserData(this);

        shape.dispose();

        return body;
    }
}
