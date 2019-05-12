import greenfoot.*;
import java.util.*;

public class Location extends Actor
{
    private int x;
    private int y;
    private boolean permanent;
    private double distance;
    private Location closest;

    private ArrayList<Edge> connectedEdges;
    
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        permanent = false;
        distance = Integer.MAX_VALUE;
        connectedEdges = new ArrayList<>();
    }
    
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

    public void addEdge(Edge e) {
        connectedEdges.add(e);
    }

    public ArrayList<Edge> getEdges() {
        return connectedEdges;
    }

    public ArrayList<Location> getConnections() {
        ArrayList<Location> toReturn = new ArrayList<>();
        for (Edge e : getEdges()) {
            if (e.getLocOne().equals(this)) {
                toReturn.add(e.getLocTwo());
            } else {
                toReturn.add(e.getLocOne());
            }
        }
        return toReturn;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent() {
        permanent = true;
    }

    public Location getClosest() {
        return closest;
    }

    public void setClosest(Location l) {
        closest = l;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double newDistance) {
        distance = newDistance;
    }
}
