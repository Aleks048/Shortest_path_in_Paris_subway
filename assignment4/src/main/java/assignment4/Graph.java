package assignment4;
import java.util.Vector;
import java.util.PriorityQueue;

public class Graph{
    static Vector<Vertex> vertices = new Vector<Vertex>();
    static Vector<Edge> edges = new Vector<Edge>();
    static Vertex[] verticesArr;

    private Graph(){
    }

    static public String sameLine(int VertexId){
        inputData.renewData();

        String out ="";
        boolean isFirst = true;
        int numOfWalkIntersections = 0;

        Vertex root = verticesArr[VertexId];
        
        for(Edge e:root.getEdgesOut()){if(e.getTime()==-1){numOfWalkIntersections++;}}//count the number of walking crossections

        for (Edge e:root.getEdgesOut()){
            //System.out.println(e.getFinish().getName());
            if (e.getTime()!=-1){
                root.setIsVisited(true);
                String temp = Graph.sameLine(e.getFinish(),root,isFirst);
                
                //System.out.println(temp);
                out += temp;
                if (isFirst){isFirst=false;out+=" -> root "+root.getName()+" root <- ";}
            }
        }

        return out;
    }


    static private String sameLine(Vertex currentVertex,Vertex previousVertex,boolean isFirst){
        String out ="";
        int numOfWalkIntersections = 0;

        for (Edge e :currentVertex.getEdgesOut()){ 
            if (e.getTime()==-1){numOfWalkIntersections++;}
          
        }//find the number of walking crossections
        
        
        out +=" "+currentVertex.getName();
        
            currentVertex.setIsVisited(true);
            for (Edge e:currentVertex.getEdgesOut()){
                if ((e.getFinish()!=previousVertex)&&(e.getTime()!=-1)&&(!e.getFinish().getIsVisited())){
                    
                    if (isFirst){out=sameLine(e.getFinish(),currentVertex,isFirst)+" -> "+out;}
                    else{out+=" <- "+sameLine(e.getFinish(),currentVertex,isFirst);}
                }
            }
           // System.out.println(out+currentVertex.getName());
            return out;
       // }
       
    }
   

    public void shortestPath(int id1,int id2){
        PriorityQueue<Vertex> minQueue = new PriorityQueue<Vertex>();
        Vertex start = verticesArr[id1];
        Vertex finish = verticesArr[id2];
        
        start.setTimeToGethere(0);
        minQueue.add(start);
        

        
    }
}