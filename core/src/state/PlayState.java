package state;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.grimsatisfactions.platformshooter.StringData;
import gameObjects.Platform;
import gameObjects.characters.Enemy;
import gameObjects.characters.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayState extends State {

    private World                   world;

    private Box2DDebugRenderer      b2dr;

    private final float             PPM = 32;

    private Player                  player;

    private Enemy                   enemy;

    private List<Platform>          platforms;

    public PlayState(GameStateManager gsm, OrthographicCamera camera)
    {
        super(gsm, camera);

        world = new World(new Vector2(0, -9.8f), false);

        b2dr = new Box2DDebugRenderer();

        player = new Player(new Vector2(0, 64), StringData.CHARACTER, StringData.PLAYER, 32, 32, world);

        enemy = new Enemy(new Vector2(0, 0), StringData.CHARACTER, StringData.ENEMY, 32, 32, world);

        platforms = new ArrayList<Platform>();

        platforms.add(0, new Platform(new Vector2(0, -10), StringData.PLATFORM, StringData.PLATFORM, 64, 32, world));

        platforms.add(1, new Platform(new Vector2(-100, 50), StringData.PLATFORM, StringData.PLATFORM, 64, 32, world));

        platforms.add(2, new Platform(new Vector2(100, 50), StringData.PLATFORM, StringData.PLATFORM, 64, 32, world));
    }

    @Override
    public void update(float dt)
    {
        world.step(1 / 60f, 6, 2);

        player.update(dt);

        updateCameraPosition();
    }

    private void updateCameraPosition()
    {
        Vector3 pos = camera.position;

        pos.x = player.getPos().x * PPM;

        pos.y = player.getPos().y * PPM;

        camera.position.set(pos);

        camera.update();
    }

    @Override
    public void render(SpriteBatch sb)
    {
        b2dr.render(world, camera.combined.scl(PPM));

        player.render(sb);
    }

    @Override
    public void dispose()
    {
        b2dr.dispose();

        world.dispose();

        player.dispose();
    }
}
