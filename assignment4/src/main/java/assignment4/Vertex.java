package assignment4;

import java.util.Vector;

public class Vertex{
    private String id;
    private String name;
    private Vector<Edge> comingIn = new Vector<Edge>();
    private Vector<Edge> goingOut = new Vector<Edge>();
    private boolean vertexStatus = false;

    public Vertex(String id, String name){
        this.name = name;
        this.id = id;
    }

    //setters
    public void addEdgeIn(Edge in){comingIn.add(in);}
    public void addEdgeOut(Edge out){goingOut.add(out);}
    public void disableVertex() {this.vertexStatus = true; }
    public void enableVertex() {this.vertexStatus = false; }

    //getters
    public String getId(){return id;}
    public String getName(){return name;}

    public Vector<Edge> getEdgesOut(){return goingOut;}
    public Vector<Edge> getEdgesIn(){return comingIn;}

    public boolean isDisabled() { return vertexStatus; }
}