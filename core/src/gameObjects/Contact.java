package gameObjects;

import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

public class Contact implements ContactListener {

    @Override
    public void beginContact(com.badlogic.gdx.physics.box2d.Contact contact) {

        Fixture fixA = contact.getFixtureA();

        Fixture fixB = contact.getFixtureB();

        if (fixA == null || fixB == null) return;

        if (fixA.getUserData() == null || fixB.getUserData() == null) return;

        GameObject gameObjectA = (GameObject) fixA.getUserData();
        GameObject gameObjectB = (GameObject) fixB.getUserData();

        if (gameObjectA.tag == "PLAYER" || gameObjectB.tag == "PLAYER")
        {

        }
    }

    @Override
    public void endContact(com.badlogic.gdx.physics.box2d.Contact contact) {

    }

    @Override
    public void preSolve(com.badlogic.gdx.physics.box2d.Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(com.badlogic.gdx.physics.box2d.Contact contact, ContactImpulse impulse) {

    }

    private boolean isGameObject(Fixture a, Fixture b)
    {
        return a.getUserData() instanceof GameObject && b.getUserData() instanceof  GameObject;
    }
}
