package assignment4;

public class Edge{
    private int time;
    private Vertex start;
    private Vertex finish;

    public Edge(Vertex start,Vertex finish,int time){
        this.start=start;
        this.finish=finish;
        this.time = time;
    }
    
    public int getTime(){return this.time;}
    public Vertex getStart(){return this.start;}
    public Vertex getFinish(){return this.finish;}
    

}