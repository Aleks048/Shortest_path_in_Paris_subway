package assignment4;

import java.util.Vector;
import java.util.Comparator;

public class Vertex implements Comparator<Vertex>{
    private String id;
    private String name;
    private int timeToGetHere;
    boolean visited;
    Vector<Vertex> pathToHere;

    private Vector<Edge> comingIn = new Vector<Edge>();
    private Vector<Edge> goingOut = new Vector<Edge>();

    public Vertex(String id, String name){
        this.name = name;
        this.id = id;
        timeToGetHere = -1;
        this.visited = false;
        pathToHere=null;
    }

    //Comparator methods

    public int compare(Vertex o1,Vertex o2){
        return o1.getTimeToGetHere()>o2.getTimeToGetHere()?1:(o1.getTimeToGetHere()<o2.getTimeToGetHere()?-1:0);
    }
    


    //setters
    public void setIsVisited(boolean in){this.visited=in;}
    public void setPathToHere(Vector<Vertex> in){pathToHere=in;}
    public void addEdgeIn(Edge in){comingIn.add(in);}
    public void addEdgeOut(Edge out){goingOut.add(out);}
    public void setTimeToGethere(int time){this.timeToGetHere=time;}

    //getters
    public Vector<Vertex> getPathToHere(){return pathToHere;};
    public boolean getIsVisited(){return visited;};
    public String getId(){return id;}
    public String getName(){return name;}
    public int getTimeToGetHere(){return timeToGetHere;};

    public Vector<Edge> getEdgesOut(){return goingOut;}
    public Vector<Edge> getEdgesIn(){return comingIn;}
}