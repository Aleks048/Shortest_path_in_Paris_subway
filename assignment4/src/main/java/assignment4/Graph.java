package assignment4;
//import assignment4.Graph.Vertex;
import java.util.Iterator;
import java.util.Vector;
import java.util.Stack;

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

    /**
     * Returns a list of stations in a specified line in the form of a vector.
     *
     * @param vertexID  identification number of a station.
     * @return          vector of stations in the line that the specified line belong to.
     */
    static public Vector<Vertex> getLine (int vertexID) {

        Vertex currentStation = verticesArr[vertexID];
        Vector<Vertex> line = new Vector<Vertex>();
        Vertex nextStation = null, previousStation = null;

        for (Edge e:currentStation.getEdgesOut()) {
            if (e.getTime() != -1 && e.getStart() == currentStation) {
                nextStation = e.getFinish();
                break;
            } else {
                nextStation = null;
            }
        }

        for (Edge e:currentStation.getEdgesIn()) {
            if ((e.getTime() != -1) && (e.getFinish() == currentStation) && (e.getStart() != nextStation)) {
                previousStation = e.getStart();
                break;
            } else {
                previousStation = null;
            }
        }

        if (previousStation != null) { line.addAll(getPrevious(currentStation, previousStation, nextStation)); }
        line.add(currentStation);
        if (previousStation != null) { line.addAll(getComingUp(currentStation, previousStation, nextStation)); }
        return line;
    }

    /**
     * Recursive method to get all the stations that are coming up on the same line.
     *
     * @param   currentStation  starting station.
     * @return                  vector of all the forthcoming stations on the starting station's line.
     */
    static private Vector<Vertex> getComingUp (Vertex currentStation, Vertex previousStation, Vertex nextStation){

        Vector<Vertex> comingUp = new Vector<Vertex>();

        while (nextStation != null) {

            for (Edge e:currentStation.getEdgesOut()) {
                if (e.getTime() != -1 && e.getStart() == currentStation && e.getFinish() != previousStation) {
                    nextStation = e.getFinish();
                    break;
                } else {
                    nextStation = null;
                }
            }

            if (nextStation != null) { comingUp.add(nextStation); }
            previousStation = currentStation;
            currentStation = nextStation;
        }

        return comingUp;

    }

    /**
     * Method returns all the stations that exist before the current station on the same line.
     *
     * @param currentStation starting station.
     * @param previousStation station before the starting station.
     * @param nextStation station after the starting station.
     * @return  vector of all the previous stations.
     */
    static private Vector<Vertex> getPrevious (Vertex currentStation, Vertex previousStation, Vertex nextStation) {

        Vector<Vertex> previous = new Vector<Vertex>();
        Stack<Vertex> tempStack = new Stack<Vertex>();

        while (previousStation != null) {

            for (Edge e:currentStation.getEdgesIn()) {
                if (e.getTime() != -1 && e.getFinish() == currentStation && e.getStart() != nextStation) {
                    previousStation = e.getStart();
                    break;
                } else {
                    previousStation = null;
                }
            }

            if (previousStation != null) { tempStack.push(previousStation); }
            nextStation = currentStation;
            currentStation = previousStation;
        }

        while (!tempStack.empty()) {
            previous.add(tempStack.pop());
        }
        return previous;
    }

    /**
     * This method disables a given line.
     *
     * @param line  a station in the disabled line.
     */
    static private void disableLine(Vector<Vertex> line) {
        Iterator<Vertex> itr = line.iterator();
        while(itr.hasNext()){
            itr.next().disableVertex();
        }
    }

    /**
     * This method enables a given line.
     *
     * @param line  a station in the disabled line.
     */
    static private void enableLine(Vector<Vertex> line) {
        Iterator<Vertex> itr = line.iterator();
        while(itr.hasNext()){
            itr.next().enableVertex();
        }
    }

}