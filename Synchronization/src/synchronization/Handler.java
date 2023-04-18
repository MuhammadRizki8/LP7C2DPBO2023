/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronization;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Satria Ramadhani
 */
public class Handler implements GameInterface
{
    /**
     * Attribute declaration.
     */
    
    private ArrayList<GameObject> object; // Array / List of GameObject.
    private Random rand;                  // Randomizer.
    
    /**
     * Constructor.
     */
    
    // Default constructor.
    public Handler()
    {
        this.object = new ArrayList<>();
        this.rand = new Random();
    }
    
    /**
     * Object access and manipulations.
     */
    
    // Add object to list.
    public void add(GameObject object)
    {
        this.object.add(object);
    }
    
    // Access object from list.
    public GameObject get(int i)
    {
        return this.object.get(i);
    }
    
    // Count total object on list.
    public int count()
    {
        return this.object.size();
    }
    
    // Remove object from list based on its index.
    public void remove(int i)
    {
        this.object.remove(i);
    }
    
    // Remove object from list.
    public void remove(GameObject object)
    {
        this.object.remove(object);
    }
    public void makan(GameObject object1, GameObject object2){
        if (object2 == null) {
            return;
        }
        // Hitbox of object 1
        int object1Left = object1.getX();
        int object1Right = object1.getX() + object1.getWidth();
        int object1Top = object1.getY();
        int object1Bottom = object1.getY() + object1.getHeight();

        // Hitbox of object 2
        int object2Left = object2.getX();
        int object2Right = object2.getX() + object2.getWidth();
        int object2Top = object2.getY();
        int object2Bottom = object2.getY() + object2.getHeight();
        
        // Check for collision
        if (object1Right >= object2Left && object1Left <= object2Right && object1Bottom >= object2Top && object1Top <= object2Bottom) {
            object2.setX(this.rand.nextInt(640));
            object2.setY(this.rand.nextInt(480));
//            object2.setHeight(object2.getHeight()+object2.getHeight());

        } 
    }

    /**
     * 
     * Override interface.
     */
    
    @Override
    public void render(Graphics g)
    {
        for(int i = 0; i < object.size(); i++)
        {
            GameObject temp;
            temp = object.get(i);
            
            temp.render(g);
        }
    }
    
    @Override
    public void loop()
    {
        for(int i = 0; i < object.size(); i++)
        {
            GameObject temp;
            temp = object.get(i);
            temp.loop();
        }
//        this.makan(object.get(0),object.get(1));
    }
}
