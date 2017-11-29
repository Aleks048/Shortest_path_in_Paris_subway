package assignment4;
import java.util.Vector;
import java.util.PriorityQueue;
import java.util.Stack;

public class Graph{
    static Vector<Vertex> vertices = new Vector<Vertex>();
    static Vector<Edge> edges = new Vector<Edge>();
    static Vertex[] verticesArr;

    private Graph(){
    }

    static public Vector<Vertex> sameLine(int VertexId){
        Vector<Vertex> line = new Vector<Vertex>();//to accumulate stations
        Vector<Vertex> tempVec = new Vector<Vertex>();

        inputData.renewData();

        Boolean isFirst = true;

        Vertex root = verticesArr[VertexId];
    
        for (Edge e:root.getEdgesOut()){
            if (e.getTime()!=-1){
                root.setIsVisited(true);
                
                tempVec= Graph.sameLine(e.getFinish(),tempVec,isFirst);
                line.addAll(tempVec);
                if (isFirst){
                    isFirst=false;
                    line.add(root);
                }
                tempVec.clear();
            }
        }
        return line;
    }


    static private Vector<Vertex> sameLine(Vertex currentVertex,Vector<Vertex>line,Boolean isFirst){

        currentVertex.setIsVisited(true);
        if (!isFirst){
        line.add(currentVertex);}
        else{line.add(0,currentVertex);}
       
            for (Edge e:currentVertex.getEdgesOut()){
                if ((e.getTime()!=-1)&&(!e.getFinish().getIsVisited())){
                    
                    sameLine(e.getFinish(),line,isFirst);//check me!!!
                }
            }
            
            return line;
    }
   
    public static String toString(Vector<Vertex> in){
         String out = "";
         for (Vertex v:in){
             if (v!=in.lastElement()){
             out+=v.getName()+" - ";}
             else{out+=v.getName();}
         }
         return "# of stations"+in.size()+"\n"+out;
    }

    public static Vertex shortestPath(int id1,int id2){
        inputData.renewData();

        PriorityQueue<Vertex> minQueue = new PriorityQueue<Vertex>();
        Vector <Vertex> currentPath = new Vector<Vertex>();
        Vertex start = verticesArr[id1];
        int walkingTime=90;
        
      //  Vertex finish = verticesArr[id2];
        start.setTimeToGethere(0);
        Integer currentTime=start.getTimeToGetHere();
      
        System.out.print(currentTime);
        Vertex current = start;
        int numOfStationsVisited=0;
       
        minQueue.add(start);
       // start.setIsVisited(true);

        while (numOfStationsVisited<vertices.size()){
            current = minQueue.remove();

            current.setIsVisited(true);
            currentPath.add(current);
            currentTime = current.getTimeToGetHere();
            currentPath = current.getPathToHere();

            System.out.println(current.getName());

            for (Edge e:current.getEdgesOut()){
              //  System.out.println(e.getFinish().getName());
                if (e.getTime()==-1){if((walkingTime+currentTime)<e.getFinish().getTimeToGetHere()){e.getFinish().setTimeToGethere(walkingTime+currentTime);}}
                else{if((e.getTime()+currentTime)<e.getFinish().getTimeToGetHere()){ e.getFinish().setTimeToGethere(e.getTime()+currentTime);}}
                e.getFinish().setPathToHere(currentPath);
                if(!e.getFinish().getIsVisited()){minQueue.add(e.getFinish());}
            }
                    
            numOfStationsVisited++;
            if (Integer.parseInt(current.getId())==id2){break;}
        }
        return verticesArr[id2];
    }
}