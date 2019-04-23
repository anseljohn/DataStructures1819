import greenfoot.*;
import java.util.Objects;

public class Location extends Actor
{
    public int x;
    public int y;
    public void act() 
    {
        
    }   
    
    public boolean equals(Location l) {
        return l.x == this.x && l.y == this.y;
    }
    
    public int hashCode() {
        return toString().hashCode();
    }
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
