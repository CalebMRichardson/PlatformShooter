package gameObjects.characters.collision;

import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.Contact;
import gameObjects.GameObject;


public class CharacterCollision {

    private World world;

    public CharacterCollision(World world, String name)
    {
        this.world = world;

        System.out.println("From Character Collision" + name);

        //Entry Point for Handling Character Collision
        createContactListener(name);
    }

    private void createContactListener(String name) {

        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {

                Fixture fixA = contact.getFixtureA();

                Fixture fixB = contact.getFixtureB();

                if (fixA == null || fixB == null) { System.out.println("Fixture is null."); return; }

                if (fixA.getUserData() == null || fixB.getUserData() == null){ System.out.println("Fixture is null."); return; }

                GameObject gameObjectA = (GameObject) fixA.getUserData();

                GameObject gameObjectB = (GameObject) fixB.getUserData();
            }

            @Override
            public void endContact(Contact contact) {

            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });
    }

}