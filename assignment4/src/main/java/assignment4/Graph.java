package assignment4;
//import assignment4.Graph.Vertex;
import java.util.Vector;

public class Graph{
    static Vector<Vertex> vertices = new Vector<Vertex>();
    static Vector<Edge> edges = new Vector<Edge>();
    static Vertex[] verticesArr;

    private Graph(){
    }

    static public String sameLine(int VertexId){
        String out ="";
        boolean isFirst = true;
        int numOfWalkIntersections = 0;

        Vertex root = verticesArr[VertexId];
        
        for(Edge e:root.getEdgesOut()){if(e.getTime()==-1){numOfWalkIntersections++;}}//count the number of walking crossections

        for (Edge e:root.getEdgesOut()){
            if (e.getTime()!=-1){
                String temp = Graph.sameLine(e.getFinish(),root,isFirst);
                out = temp + out;
                if (isFirst){
                    isFirst = false; 
                    if ((root.getEdgesOut().size()==1)||((root.getEdgesOut().size()!=1)&&(numOfWalkIntersections==root.getEdgesOut().size()-1))){
                        out="root"+root.getName()+"last"+out;//change me
                    }
                    else{
                        out=" <- root "+root.getName()+" root <- "+out;//change me
                    }
                }
            }
        }

        return out;
    }
    static private String sameLine(Vertex currentVertex,Vertex previousVertex,boolean isFirst){
        String out ="";
        int numOfWalkIntersections = 0;

        for (Edge e :currentVertex.getEdgesOut()){ if (e.getTime()==-1){numOfWalkIntersections++;}}//find the number of walking crossections
        
        if ((currentVertex.getEdgesOut().size()==1)||((currentVertex.getEdgesOut().size()!=1)&&(numOfWalkIntersections==currentVertex.getEdgesOut().size()-1))){
            return currentVertex.getName()+"last";}//bottom condition//change me
        else{
            for (Edge e:currentVertex.getEdgesOut()){
                if ((e.getFinish()!=previousVertex)&&(e.getTime()!=-1)){
                    if (isFirst){
                        out = currentVertex.getName()+" <- "+sameLine(e.getFinish(),currentVertex,isFirst);
                    }
                    else{
                        out = sameLine(e.getFinish(),currentVertex,isFirst) +" -> "+ currentVertex.getName();//chamge me
                    }
                }
            }
        }
        return out;
    }
}