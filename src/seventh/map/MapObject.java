/*
 * see license.txt 
 */
package seventh.map;

import leola.vm.types.LeoObject;
import seventh.client.gfx.Camera;
import seventh.client.gfx.Canvas;
import seventh.client.gfx.Renderable;
import seventh.game.Game;
import seventh.game.entities.Entity;
import seventh.map.Tile.SurfaceType;
import seventh.math.Rectangle;
import seventh.math.Vector2f;
import seventh.shared.TimeStep;

/**
 * @author Tony
 *
 */
public class MapObject implements Renderable {

    private String type;
    protected Vector2f pos;
    protected Vector2f centerPos;
    protected Rectangle bounds;
    
    private LeoObject scriptObj;
    
    public MapObject(String type) {
        this.type = type;
        this.pos = new Vector2f();
        this.centerPos = new Vector2f();
        this.bounds = new Rectangle();
        this.scriptObj = LeoObject.valueOf(this);
    }
    
    /**
     * @return this script object
     */
    public LeoObject asScriptObject() {
        return this.scriptObj;
    }
    
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
    
    /**
     * @return the pos
     */
    public Vector2f getPos() {
        return pos;
    }
    
    /**
     * @return the centerPos
     */
    public Vector2f getCenterPos() {
        this.centerPos.set(pos);
        this.centerPos.x += bounds.width / 2;
        this.centerPos.y += bounds.height / 2;
        return centerPos;
    }
    
    public Rectangle getBounds() {
        return bounds;
    }
    
    public boolean isCollidable() {
        return true;
    }
    
    public SurfaceType geSurfaceType() {
        return SurfaceType.UNKNOWN;
    }
    
    public boolean isTouching(Rectangle bounds) {
        return false;
    }
    
    /**
     * If this {@link MapObject} touches the supplied {@link Entity}
     * 
     * @param ent
     * @return true if touching
     */
    public boolean isTouching(Entity ent) {
        return false;
    }
    
    /**
     * This {@link MapObject} is touched by an {@link Entity}
     * 
     * @param game
     * @param ent
     * @return true if this should block the entity
     */
    public boolean onTouch(Game game, Entity ent) {
        return true;
    }
    
    public void destroy() {        
    }
    

    @Override
    public void update(TimeStep timeStep) {
    }
    
    @Override
    public void render(Canvas canvas, Camera camera, float alpha) {       
    }
}
