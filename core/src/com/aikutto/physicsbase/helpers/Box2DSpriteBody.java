package com.aikutto.physicsbase.helpers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import net.dermetfan.gdx.graphics.g2d.Box2DSprite;

public class Box2DSpriteBody {

    Box2DSprite sprite;
    Body body;
    FixtureDef fixtureDef;

    public Box2DSpriteBody(BodyEditorLoader bodyEditorLoader, World world, String name, float scale, BodyDef.BodyType bodyType, float density, float friction, float restitution) {
        BodyDef bdef = new BodyDef();
        bdef.position.set(0, 0);
        bdef.type = bodyType;
        this.body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        fdef.density = density;
        fdef.friction = friction;
        fdef.restitution = restitution;
        this.fixtureDef = fdef;

        this.sprite = new Box2DSprite(new Texture(bodyEditorLoader.getImagePath(name)));

        bodyEditorLoader.attachFixture(this.body, name, this.fixtureDef, scale);

        this.body.setUserData(this.sprite);
    }

    public Box2DSprite getSprite() {
        return sprite;
    }

    public Body getBody() {
        return body;
    }

    public FixtureDef getFixtureDef() {
        return fixtureDef;
    }

    public void draw(SpriteBatch spriteBatch) {
        this.sprite.draw(spriteBatch, this.body);
    }
}
