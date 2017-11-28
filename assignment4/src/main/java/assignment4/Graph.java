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

        String out ="";
        boolean isFirst = true;
        int numOfWalkIntersections = 0;

        Vertex root = verticesArr[VertexId];
        
        for(Edge e:root.getEdgesOut()){if(e.getTime()==-1){numOfWalkIntersections++;}}//count the number of walking crossections

        for (Edge e:root.getEdgesOut()){
            //System.out.println(e.getFinish().getName());
            if (e.getTime()!=-1){
                root.setIsVisited(true);
                tempVec.addAll( Graph.sameLine(e.getFinish(),root,isFirst));
               // String temp = Graph.sameLine(e.getFinish(),root,isFirst);
                
                //System.out.println(temp);
                line.addAll(tempVec);
               // out += temp;
                if (isFirst){
                    isFirst=false;
                    line.add(root);
                   // out+=" -> root "+root.getName()+" root <- ";
                }
            }
        }

        return line;
    }


    static private Vector<Vertex> sameLine(Vertex currentVertex,Vertex previousVertex,boolean isFirst){
        Vector <Vertex> line = new Vector<Vertex>();
        Vector <Vertex> temp = new Vector<Vertex>();

        //String out ="";
        int numOfWalkIntersections = 0;

        for (Edge e :currentVertex.getEdgesOut()){ 
            if (e.getTime()==-1){numOfWalkIntersections++;}
          
        }//find the number of walking crossections
        
        line.add(currentVertex);
       // out +=" "+currentVertex.getName();
        
            currentVertex.setIsVisited(true);
            for (Edge e:currentVertex.getEdgesOut()){
                if ((e.getFinish()!=previousVertex)&&(e.getTime()!=-1)&&(!e.getFinish().getIsVisited())){
                    
                    if (isFirst)
                    {
                        
                        line.addAll(0,sameLine(e.getFinish(),currentVertex,isFirst));//check me!!!
                       //
                        //out=sameLine(e.getFinish(),currentVertex,isFirst)+" -> "+out;
                    }
                    else{
                        line.addAll(sameLine(e.getFinish(),currentVertex,isFirst));
                        //out+=" <- "+sameLine(e.getFinish(),currentVertex,isFirst);
                    }
                }
            }
           // System.out.println(out+currentVertex.getName());
            return line;
       // }
       
    }
   
    public static String toString(Vector<Vertex> in){
         String out = "";
         for (Vertex v:in){
             if (v!=in.lastElement()){
             out+=v.getName()+" -> ";}
             else{out+=v.getName();}
         }
         return out;
    }

    public Vector<Vertex> shortestPath(int id1,int id2){
        PriorityQueue<Vertex> minQueue = new PriorityQueue<Vertex>();
        Stack <Vertex> stack = new Stack<Vertex>();
        Vector <Vertex> currentPath = new Vector<Vertex>();
        Vertex start = verticesArr[id1];
        Vertex finish = verticesArr[id2];
        Integer currentTime=start.getTimeToGetHere();

        Vertex current = verticesArr[id1];
        int numOfStationsVisited=0;
        
        start.setTimeToGethere(0);
        start.setIsVisited(true);
       // minQueue.add(start);   
        while (numOfStationsVisited<vertices.size()){
            currentPath.add(current);
            for (Edge e:start.getEdgesOut()){
                e.getFinish().setTimeToGethere(e.getTime()+currentTime);
                e.getFinish().setPathToHere(currentPath);
                minQueue.add(e.getFinish());
              //  stack.push(e.getFinish());
            }
            current = minQueue.remove();
            currentTime = current.getTimeToGetHere();
            currentPath = current.getPathToHere();
            numOfStationsVisited++;
            if (Integer.parseInt(current.getId())==id2){break;}
        }
        return verticesArr[id2].getPathToHere();
    }
}