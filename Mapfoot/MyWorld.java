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
    
    public ArrayList<Edge> edges() {
        ArrayList<Edge> edges = new ArrayList<>();
        List<Location> locations = getObjects(Location.class);
        for (int i = 0; i < locations.size(); i++) {
            for (int j = 0; j < locations.size(); j++) {
                if (i != j) {
                    Edge e = new Edge(locations.get(i), locations.get(j));
                    edges.add(e);
                }
            }
        }
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

    // public void prims() {
    //     ArrayList<Edge> possibleEdges = possibleEdges();

    //     List<Location> allLocations = getObjects(Location.class);
    //     ArrayList<Edge> finalizedEdges = new ArrayList<>();

    //     for (Edge e : possibleEdges) {
    //         e.getLocOne().addEdge(e);
    //         e.getLocTwo().addEdge(e);
    //     }

    //     for (int i = 0; i < allLocations.size(); i++) {
    //         Location currentLocation = allLocations.get(i);
    //         if (! currentLocation.isPermanent()) {
    //             ArrayList<Edge> connectedEdges = currentLocation.getEdges();
    //             for (Edge e : connectedEdges) {
    //                 e.getOppositeSide(currentLocation).setDistance(e.getDistance());
    //             }
                
    //             ArrayList<Location> currentConnections = currentLocation.getConnections();
    //             Location closest = currentConnections.get(0);
    //             for (int j = 1; j < currentConnections.size(); j++) {
    //                 if (! closest.isPermanent()) {
    //                     if (currentConnections.get(j).getDistance() < closest.getDistance()) {
    //                         closest = currentConnections.get(j);
    //                     }
    //                 } else {
    //                     closest = currentLocation.getConnections().get(j);
    //                 }
    //             }
    //             if (! closest.isPermanent()) {
    //                 currentLocation.setPermanent();
    //                 closest.setPermanent();
    //                 finalizedEdges.add(new Edge(currentLocation, closest));
    //             }
    //             System.out.println("Got here");
    //             boolean hasTempsConnected = false;
    //             for (Location l : currentLocation.getConnections()) {
    //                 if (! l.isPermanent()) {
    //                     hasTempsConnected = true;
    //                 }
    //             }
    //             if (!hasTempsConnected) {
    //                 ArrayList<Location> newConnections = currentLocation.getConnections();
    //                 Location newClosest = currentConnections.get(0);

    //                 ArrayList<Location> alreadyConnected = new ArrayList<>();
    //                 alreadyConnected.add(currentLocation);
    //                 for (Edge e : finalizedEdges) {
    //                     if (e.getOppositeSide(currentLocation) != null) {
    //                         alreadyConnected.add(e.getOppositeSide(currentLocation));
    //                     }
    //                 }

    //                 for (int j = 1; j < newConnections.size(); j++) {
    //                     if (! alreadyConnected.contains(newConnections.get(j))
    //                         && newConnections.get(j).getDistance() < newClosest.getDistance()) {
    //                         newClosest = newConnections.get(j);
    //                     }
    //                 }
    //                 finalizedEdges.add(new Edge(currentLocation, newClosest));
    //             }
    //         }
    //     }
    //     drawEdges(finalizedEdges);
    // }

    public void prims() {
        List<Location> allLocations = getObjects(Location.class);
        Location pastLocation = allLocations.get(0);
        pastLocation.setDistance(0);
        ArrayList<Location> currentConnections = pastLocation.getConnections();
        ArrayList<Edge> currentEdges = pastLocation.getEdges();
        ArrayList<Edge> finalizedEdges = new ArrayList<>();
        ArrayList<Edge> possibleEdges = possibleEdges();

        for (Edge e : possibleEdges) {
            e.getLocOne().addEdge(e);
            e.getLocTwo().addEdge(e);
        }

        for (Edge e : currentEdges) {
            e.getOppositeSide(pastLocation).setDistance(e.getDistance());
        }

        Location closest = currentConnections.get(0);
        for (int i = 1; i < currentConnections.size(); i++) {
            if (currentConnections.get(i).getDistance() < closest.getDistance()) {
                closest = currentConnections.get(i);
            }
        }
        finalizedEdges.add(new Edge(pastLocation, closest));



        while (!allArePermanent(allLocations)) {
            
        }
        drawEdges(finalizedEdges);
    }

    public boolean allArePermanent(List<Location> locations) {
        for (Location l : locations) {
            if (! l.isPermanent()) {
                return false;
            }
        }
        return true;
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
    
    public void drawEdges(ArrayList<Edge> edges) {
        edges.forEach(edge -> edge.show(this));
    }
}
