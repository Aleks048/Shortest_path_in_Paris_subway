package assignment4;
import java.util.Vector;
import java.util.PriorityQueue;
import java.util.Stack;

public class ParisMetro{
    static Vector<Vertex> vertices = new Vector<Vertex>();
    static Vector<Edge> edges = new Vector<Edge>();
    static Vertex[] verticesArr;

    private ParisMetro(){//to block creation of the objects of the class
    }

    /**
     * public method to find all the stations that belong to the same line of the VertexId
     */
    static public Vector<Vertex> sameLine(int VertexId){
        Vector<Vertex> line = new Vector<Vertex>();//to accumulate stations
        Vector<Vertex> tempVec = new Vector<Vertex>();

      //  inputData.renewData();

        Boolean isFirst = true;

        Vertex root = verticesArr[VertexId];
    
        for (Edge e:root.getEdgesOut()){
            if (e.getTime()!=-1){
                root.setIsVisited(true);
                
                tempVec= ParisMetro.sameLine(e.getFinish(),tempVec,isFirst);
                line.addAll(tempVec);
                if (isFirst){
                    isFirst=false;
                    line.add(root);
                }
                tempVec.clear();
            }
        }
        setAllToUnvisited();
        return line;
    }

    /**
     * traverses through the graph, markes stations that visited, ignore walking intersections
     */
    static private Vector<Vertex> sameLine(Vertex currentVertex,Vector<Vertex>line,Boolean isFirst){

        currentVertex.setIsVisited(true);
        if (!isFirst){
        line.add(currentVertex);}
        else{line.add(0,currentVertex);}
       
            for (Edge e:currentVertex.getEdgesOut()){
                if ((e.getTime()!=-1)&&(!e.getFinish().getIsVisited())){
                    
                    sameLine(e.getFinish(),line,isFirst);
                }
            }
            
            return line;
    }
   
    /**
     * printout the vector that would represent the line or shortest path 
     */
    public static String toString(Vector<Vertex> in){
         String out = "";
         for (Vertex v:in){
             if (v!=in.lastElement()){
             out+=v.getId()+" - ";}
             else{out+=v.getId();}
         }
         return "# of stations "+in.size()+"\n"+out;
    }

    /**
     * Dijkstra shortest path algorithm implementation
     */
    public static Vector <Vertex> shortestPath(int id1,int id2){
        setAllToUnvisited();
        readMetro.renewData(readMetro.pathToFile);

        PriorityQueue<Vertex> minQueue = new PriorityQueue<Vertex>();
        Vector <Vertex> currentPath = new Vector<Vertex>();
        Vertex start = verticesArr[id1];
        int walkingTime=90;

        start.setTimeToGethere(0);
        Integer currentTime=start.getTimeToGetHere();
      
        System.out.print(currentTime);
        Vertex current = start;
        int numOfStationsVisited=0;
       
        minQueue.add(start);

        while (numOfStationsVisited<vertices.size()){
            current = minQueue.remove();

            current.setIsVisited(true);
            currentPath = current.getPathToHere();

            currentPath.add(current);
            ParisMetro.toString(currentPath);
            currentTime = current.getTimeToGetHere();

            for (Edge e:current.getEdgesOut()){
                if (e.getTime()==-1){
                    if(((walkingTime+currentTime)<e.getFinish().getTimeToGetHere())&&(e.getFinish().getIsAvilable()))
                    {
                        e.getFinish().setTimeToGethere(walkingTime+currentTime);
                        e.getFinish().setPathToHere(currentPath);
                    }
                }
                else{
                    if(((e.getTime()+currentTime)<e.getFinish().getTimeToGetHere())&&(e.getFinish().getIsAvilable()))
                    {
                        e.getFinish().setTimeToGethere(e.getTime()+currentTime);
                        e.getFinish().setPathToHere(currentPath);
                    }
                }
                e.getFinish().setPathToHere(currentPath);
                if(!e.getFinish().getIsVisited()){minQueue.add(e.getFinish());}
            }                    
            numOfStationsVisited++;
            if (Integer.parseInt(current.getId())==id2){current.setPathToHere(currentPath);break;}
        }
        setAllToUnvisited();
        return verticesArr[id2].getPathToHere();
    }

    /**
     * mark all stations as unvisited
     */
    private static void setAllToUnvisited(){
        for (Vertex v:vertices){
            v.setIsVisited(false);
        }
    }
    /**
     * method to enable or disable the station
     */
    private static void disableEnableTheLine(Vector<Vertex> in,Boolean disableEnable){
        for (Vertex v:in){
            if (disableEnable){v.setToAvailable();}
            else{v.setToNotAvailable();}
        }
    }

    /**
     * method to find the shortest path when some line is closed
     */
    public static Vector<Vertex> shortestPathLineClosed(int id1,int id2, int id3){
        readMetro.renewData(readMetro.pathToFile);
        Vector<Vertex> lineToDisable = sameLine(id3);
        disableEnableTheLine(lineToDisable,false);
        setAllToUnvisited();
        Vector <Vertex> out = shortestPath(id1, id2);
        setAllToUnvisited();
        disableEnableTheLine(lineToDisable, true);
        return out;
    }

    public static void main(String[] args){
        readMetro.renewData("C:/Users/Aleks048/Downloads/studies_programming/git/all_programming/CSI2110_Algorithms/assignment4/assignment4/src/main/java/assignment4/parisSubway.txt");        
        
        if (args.length==1){System.out.println("Find the line: "+"\n"+ParisMetro.toString(sameLine(Integer.parseInt(args[0]))));}
        else if (args.length==2){
        Vector<Vertex> temp = shortestPath(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        System.out.println("Time of travel :"+temp.lastElement().getTimeToGetHere()+"\n"+"Shortest path: "+"\n"+ParisMetro.toString(temp));}
        else if (args.length==3){
            Vector<Vertex> temp =shortestPathLineClosed(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
            System.out.println("Time of travel : "+temp.lastElement().getTimeToGetHere()+"\n"+"Shortest path line closed: "+"\n"+ParisMetro.toString(temp));}
    }
}