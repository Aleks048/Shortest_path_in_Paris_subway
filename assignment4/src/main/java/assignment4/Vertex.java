package assignment4;

import java.util.Vector;

public class Vertex{
    private String id;
    private String name;
    private Vector<Edge> comingIn = new Vector<Edge>();
    private Vector<Edge> goingOut = new Vector<Edge>();

    public Vertex(String id, String name){
        this.name = name;
        this.id = id;
    }

    //setters
    public void addEdgeIn(Edge in){comingIn.add(in);}
    public void addEdgeOut(Edge out){goingOut.add(out);}

    //getters
    public String getId(){return id;}
    public String getName(){return name;}

    public Vector<Edge> getEdgesOut(){return goingOut;}
    public Vector<Edge> getEdgesIn(){return comingIn;}
}