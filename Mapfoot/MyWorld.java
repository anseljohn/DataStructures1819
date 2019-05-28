import greenfoot.*;
import java.util.*;

public class MyWorld extends World
{
    public MyWorld()
    {
        super(961, 604, 1);
    }
    
    public void randomize(int amount) {
        for (int i = 0; i < amount; i++) {
            int randomX = (int)(Math.random() * 961);
            int randomY = (int)(Math.random() * 604);
            while (getColorAt(randomX, randomY).equals(Color.WHITE)){
                randomX = (int)(Math.random() * 961);
                randomY = (int)(Math.random() * 604);
            }
            addObject(new Location(randomX, randomY), randomX, randomY);
        }
    }

    public ArrayList<Edge> possibleEdges() {
        ArrayList<Edge> edges = new ArrayList<>();
        List<Location> locations = getObjects(Location.class);
        if (locations.size() > 1) {
            for (int i = 0; i < locations.size(); i++) {
                for (int j = 0; j < locations.size(); j++) {
                    if (i != j) {
                        Edge e = new Edge(locations.get(i), locations.get(j));
                        edges.add(e);
                    }
                }
            }
        }
        return edges;
    }

    public ArrayList<Edge> possibleEdges(Location forLoc) {
        ArrayList<Edge> possibleEdges = new ArrayList<>();
        List<Location> locs = getObjects(Location.class);
        locs.remove(forLoc);
        for (Location l : locs) {
            possibleEdges.add(new Edge(forLoc, l));
        }
        return possibleEdges;
    }
    
    public ArrayList<Edge> allEdges() {
        ArrayList<Edge> edges = possibleEdges();
        drawEdges(edges);
        return edges;
    }
    
    public ArrayList<Edge> buildRandomConnections(int n) {
        ArrayList<Edge> allEdges = possibleEdges();
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++ ) {
            edges.add(allEdges.get((int) (Math.random() * allEdges.size())));
        }
        drawEdges(edges);
        return edges;
    }
    
    public boolean formsCycle(Collection<Edge> edges, Edge completer) {
        if (edges.size() < 2) {
            return false;
        }
        HashMap<Location, Location> edgesMapped = new HashMap<>();
        edges.forEach(edge -> edgesMapped.put(edge.getLocOne(), edge.getLocTwo()));
        edgesMapped.put(completer.getLocOne(), completer.getLocTwo());
        
        Location starting = edgesMapped.get(completer.getLocOne());
        Location ending = null;
        for (int i = 0; i < edges.size() - 1; i++) {
            ending = edgesMapped.get(starting);
        }
        try {
            return ending != null || ending.equals(starting);
        } catch (Exception e) {
            return false;
        }
    }
    
    public void prims() {
        List<Location> connected = new ArrayList<>();
        List<Location> notConnected = getObjects(Location.class);
        connected.add(notConnected.remove(0));
        
        ArrayList<Edge> toBuild = new ArrayList<>();
        
        while (notConnected.size() != 0) {
            ArrayList<Edge> containing = new ArrayList<>();
            for (int j = 0; j < connected.size(); j++) {
                containing.addAll(possibleEdges(connected.get(j)));
            }
            Location[] smallestEdge = Location.getClosest(connected, notConnected);
            Location closest = smallestEdge[1];
            toBuild.add(new Edge(smallestEdge[0], smallestEdge[1]));
            notConnected.remove(closest);
            connected.add(closest);
            Greenfoot.delay(5);
            new Edge(smallestEdge[0], smallestEdge[1]).show(this);
        }
        //drawEdges(toBuild);
    }   
    
    public void drawEdges(ArrayList<Edge> edges) {
        edges.forEach(edge -> edge.show(this));
    }
}
