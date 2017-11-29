package assignment4;

import java.lang.String;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Vector;

public class inputData{

    public static void input() throws FileNotFoundException{
        
     Scanner inputSc = new Scanner (new FileReader("C:/Users/Aleks048/Downloads/studies_programming/git/all_programming/CSI2110_Algorithms/assignment4/assignment4/src/main/java/assignment4/parisSubway.txt")); 
     String numOfVertEdg = inputSc.nextLine();

     String [] arr= numOfVertEdg.split(" ");

     Graph.verticesArr = new Vertex[Integer.parseInt(arr[0])];//create an array to hold the vertices

     while (inputSc.hasNextLine()){
         
         String temp = inputSc.nextLine();

         if (temp.equals("$")){break;}

         String [] tempArr = new String[2];//create array of components of the vertex
         tempArr[0]=temp.substring(0,4);
         tempArr[1]=temp.substring(4,temp.length());

         Vertex tempV = new Vertex (tempArr[0],tempArr[1]);//(id, name)
         Graph.verticesArr[Integer.parseInt(tempV.getId())]= tempV;//put into array of vertices

         Graph.vertices.add(tempV);//add vertex to the graph
         
     }
    

     while(inputSc.hasNextLine()){
        String temp = inputSc.nextLine();

        String [] tempArr = temp.split(" ");//create array of components of the edge
        Edge tempEdge  = new Edge (Graph.verticesArr[Integer.parseInt(tempArr[0])],Graph.verticesArr[Integer.parseInt(tempArr[1])],Integer.parseInt(tempArr[2]));//create a new edge
       
        Graph.edges.add(tempEdge); //add edge to the graph
        
        Graph.verticesArr[Integer.parseInt(tempArr[0])].addEdgeOut(tempEdge);//add edge to the outgoing of a vertex
        Graph.verticesArr[Integer.parseInt(tempArr[1])].addEdgeIn(tempEdge);//add edge incoming of the vertex
     }
    
    }
    public static void renewData(){
        try{
            inputData.input();
            }
            catch (FileNotFoundException e){
                System.out.println("It's not the file you're looking for.");
            }
        ;
    } 

    public static void main (String args[]){
        //line from station ID testing

        //1st line PASSED
        /*
        System.out.println("Line 1:");
        System.out.println("1st end");
        System.out.println(Graph.toString(Graph.sameLine(66)));
        System.out.println("2nd end");
        System.out.println(Graph.toString(Graph.sameLine(130)));
        System.out.println("middle");
        System.out.println(Graph.toString(Graph.sameLine(119)));
        */
        //2nd line passed
        /*
        System.out.println("Line 2:");
        System.out.println("1st end");
        System.out.println(Graph.toString(Graph.sameLine(256)));
        System.out.println("2nd end");
        System.out.println(Graph.toString(Graph.sameLine(213)));
        System.out.println("middle");
        System.out.println(Graph.toString(Graph.sameLine(239)));
        */ 
        //3rd line  passed
        /*
        System.out.println("Line 3:");
        System.out.println("1st end");
        System.out.println(Graph.toString(Graph.sameLine(251)));
        System.out.println("2nd end");
        System.out.println(Graph.toString(Graph.sameLine(114)));
        System.out.println("middle");
        System.out.println(Graph.toString(Graph.sameLine(38)));
        */
        //3rd extra line passed
        /*
        System.out.println("Line 3extra:");
        System.out.println("1st end");
        System.out.println(Graph.toString(Graph.sameLine(116)));
        System.out.println("2nd end");
        System.out.println(Graph.toString(Graph.sameLine(279)));
        System.out.println("middle");
        System.out.println(Graph.toString(Graph.sameLine(233)));
        */
         //4th line passed
        /*
        System.out.println("Line 4:");
        System.out.println("1st end");
        System.out.println(Graph.toString(Graph.sameLine(268)));
        System.out.println("2nd end");
        System.out.println(Graph.toString(Graph.sameLine(262)));//??
        System.out.println("middle");
        System.out.println(Graph.toString(Graph.sameLine(342)));
        */
         //5th line passed
        /*
        System.out.println("Line 5:");
        System.out.println("1st end");
        System.out.println(Graph.toString(Graph.sameLine(28)));
        System.out.println("2nd end");
        System.out.println(Graph.toString(Graph.sameLine(242)));
        System.out.println("middle");
        System.out.println(Graph.toString(Graph.sameLine(134)));
        */
         //6th line passed
        /*
        System.out.println("Line 6:");
        System.out.println("1st end");
        System.out.println(Graph.toString(Graph.sameLine(57)));
        System.out.println("2nd end");
        System.out.println(Graph.toString(Graph.sameLine(214)));
        System.out.println("middle");
        System.out.println(Graph.toString(Graph.sameLine(23)));
        */
         //7th line passed
       /*
        System.out.println("Line 7:");
        System.out.println("1st end");
        System.out.println(Graph.toString(Graph.sameLine(152)));
        System.out.println("2nd end");
        System.out.println(Graph.toString(Graph.sameLine(363)));
        System.out.println("middle");
        System.out.println(Graph.toString(Graph.sameLine(149)));
        */
         //7th extra line PASSED
        /*
        System.out.println("Line 7extra:");
        System.out.println("1st end");
        System.out.println(Graph.toString(Graph.sameLine(170)));
        System.out.println("2nd end");
        System.out.println(Graph.toString(Graph.sameLine(280)));
        System.out.println("middle");
        System.out.println(Graph.toString(Graph.sameLine(31)));
        */
         //8th line passed
        /*
        System.out.println("Line 8:");
        System.out.println("1st end");
        System.out.println(Graph.toString(Graph.sameLine(240)));
        System.out.println("2nd end");
        System.out.println(Graph.toString(Graph.sameLine(89)));
        System.out.println("middle");
        System.out.println(Graph.toString(Graph.sameLine(225)));
        */
        //9th line passed
        /*
        System.out.println("Line 9:");
        System.out.println("1st end");
        System.out.println(Graph.toString(Graph.sameLine(253)));
        System.out.println("2nd end");
        System.out.println(Graph.toString(Graph.sameLine(181)));
        System.out.println("middle");
        System.out.println(Graph.toString(Graph.sameLine(291)));
        */
         //10th line PASSED
        /*
        System.out.println("Line 10:");
        System.out.println("1st end");
        System.out.println(Graph.toString(Graph.sameLine(37)));
        System.out.println("2nd end");
        System.out.println(Graph.toString(Graph.sameLine(117)));
        System.out.println("middle");
        System.out.println(Graph.toString(Graph.sameLine(201)));
        */
         //11th line passed
        /*
        System.out.println("Line 11:");
        System.out.println("1st end");
        System.out.println(Graph.toString(Graph.sameLine(68)));
        System.out.println("2nd end");
        System.out.println(Graph.toString(Graph.sameLine(183)));
        System.out.println("middle");
        System.out.println(Graph.toString(Graph.sameLine(283)));
        */
         //12th line passed
        /*
        System.out.println("Line 12:");
        System.out.println("1st end");
        System.out.println(Graph.toString(Graph.sameLine(276)));
        System.out.println("2nd end");
        System.out.println(Graph.toString(Graph.sameLine(178)));
        System.out.println("middle");
        System.out.println(Graph.toString(Graph.sameLine(325)));
        */
         //13th line PASSED
        /*
        System.out.println("Line 13:");
        System.out.println("1st end");
        System.out.println(Graph.toString(Graph.sameLine(319)));
        System.out.println("2nd end");
        System.out.println(Graph.toString(Graph.sameLine(72)));
        System.out.println("middle");
         System.out.println(Graph.toString(Graph.sameLine(39)));
       */
         //14th line passed
        /*
        System.out.println("Line 14:");
        System.out.println("1st end");
        System.out.println(Graph.toString(Graph.sameLine(24)));
        System.out.println("2nd end");
        System.out.println(Graph.toString(Graph.sameLine(176)));
        System.out.println("middle");
        System.out.println(Graph.toString(Graph.sameLine(22)));
        */
        Vertex temp = Graph.shortestPath(92, 41);
        System.out.println(temp.getTimeToGetHere()+Graph.toString(temp.getPathToHere()));
    } 
}