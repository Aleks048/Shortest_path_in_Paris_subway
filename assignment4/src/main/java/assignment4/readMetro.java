package assignment4;

import java.lang.String;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Vector;

public class readMetro{
    static String pathToFile="";

    private static void input() throws FileNotFoundException{   

     Scanner inputSc = new Scanner (new FileReader(pathToFile)); 
     String numOfVertEdg = inputSc.nextLine();

     String [] arr= numOfVertEdg.split(" ");

     ParisMetro.verticesArr = new Vertex[Integer.parseInt(arr[0])];//create an array to hold the vertices

     while (inputSc.hasNextLine()){
         
         String temp = inputSc.nextLine();

         if (temp.equals("$")){break;}

         String [] tempArr = new String[2];//create array of components of the vertex
         tempArr[0]=temp.substring(0,4);
         tempArr[1]=temp.substring(4,temp.length());

         Vertex tempV = new Vertex (tempArr[0],tempArr[1]);//(id, name)
         ParisMetro.verticesArr[Integer.parseInt(tempV.getId())]= tempV;//put into array of vertices

         ParisMetro.vertices.add(tempV);//add vertex to the ParisMetro
         
     }
    

     while(inputSc.hasNextLine()){
        String temp = inputSc.nextLine();

        String [] tempArr = temp.split(" ");//create array of components of the edge
        Edge tempEdge  = new Edge (ParisMetro.verticesArr[Integer.parseInt(tempArr[0])],ParisMetro.verticesArr[Integer.parseInt(tempArr[1])],Integer.parseInt(tempArr[2]));//create a new edge
       
        ParisMetro.edges.add(tempEdge); //add edge to the ParisMetro
        
        ParisMetro.verticesArr[Integer.parseInt(tempArr[0])].addEdgeOut(tempEdge);//add edge to the outgoing of a vertex
        ParisMetro.verticesArr[Integer.parseInt(tempArr[1])].addEdgeIn(tempEdge);//add edge incoming of the vertex
     }
    
    }
    public static void renewData(String path){
        pathToFile=path;
        try{
            readMetro.input();
            }
            catch (FileNotFoundException e){
                System.out.println("It's not the file you're looking for.");
            }
        ;
    } 

    public static void main (String args[]){
       // readMetro.renewData("C:/Users/Aleks048/Downloads/studies_programming/git/all_programming/CSI2110_Algorithms/assignment4/assignment4/src/main/java/assignment4/parisSubway.txt");

        //line from station ID testing

        //1st line PASSED
        /*
        System.out.println("Line 1:");
        System.out.println("1st end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(66)));
        System.out.println("2nd end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(130)));
        System.out.println("middle");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(119)));
        */
        //2nd line passed
        /*
        System.out.println("Line 2:");
        System.out.println("1st end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(256)));
        System.out.println("2nd end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(213)));
        System.out.println("middle");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(239)));
        */ 
        //3rd line  passed
        /*
        System.out.println("Line 3:");
        System.out.println("1st end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(251)));
        System.out.println("2nd end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(114)));
        System.out.println("middle");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(38)));
        */
        //3rd extra line passed
        /*
        System.out.println("Line 3extra:");
        System.out.println("1st end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(116)));
        System.out.println("2nd end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(279)));
        System.out.println("middle");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(233)));
        */
         //4th line passed
        /*
        System.out.println("Line 4:");
        System.out.println("1st end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(268)));
        System.out.println("2nd end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(262)));//??
        System.out.println("middle");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(342)));
        */
         //5th line passed
        /*
        System.out.println("Line 5:");
        System.out.println("1st end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(28)));
        System.out.println("2nd end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(242)));
        System.out.println("middle");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(134)));
        */
         //6th line passed
        /*
        System.out.println("Line 6:");
        System.out.println("1st end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(57)));
        System.out.println("2nd end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(214)));
        System.out.println("middle");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(23)));
        */
         //7th line passed
       /*
        System.out.println("Line 7:");
        System.out.println("1st end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(152)));
        System.out.println("2nd end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(363)));
        System.out.println("middle");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(149)));
        */
         //7th extra line PASSED
        /*
        System.out.println("Line 7extra:");
        System.out.println("1st end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(170)));
        System.out.println("2nd end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(280)));
        System.out.println("middle");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(31)));
        */
         //8th line passed
        /*
        System.out.println("Line 8:");
        System.out.println("1st end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(240)));
        System.out.println("2nd end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(89)));
        System.out.println("middle");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(225)));
        */
        //9th line passed
        /*
        System.out.println("Line 9:");
        System.out.println("1st end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(253)));
        System.out.println("2nd end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(181)));
        System.out.println("middle");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(291)));
        */
         //10th line PASSED
        /*
        System.out.println("Line 10:");
        System.out.println("1st end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(37)));
        System.out.println("2nd end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(117)));
        System.out.println("middle");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(201)));
        */
         //11th line passed
        /*
        System.out.println("Line 11:");
        System.out.println("1st end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(68)));
        System.out.println("2nd end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(183)));
        System.out.println("middle");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(283)));
        */
         //12th line passed
        /*
        System.out.println("Line 12:");
        System.out.println("1st end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(276)));
        System.out.println("2nd end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(178)));
        System.out.println("middle");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(325)));
        */
         //13th line PASSED
        /*
        System.out.println("Line 13:");
        System.out.println("1st end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(319)));
        System.out.println("2nd end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(72)));
        System.out.println("middle");
         System.out.println(ParisMetro.toString(ParisMetro.sameLine(39)));
       */
         //14th line passed
        /*
        System.out.println("Line 14:");
        System.out.println("1st end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(24)));
        System.out.println("2nd end");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(176)));
        System.out.println("middle");
        System.out.println(ParisMetro.toString(ParisMetro.sameLine(22)));
        */

    //Shortest path tests
    
       // Vector<Vertex> temp = ParisMetro.shortestPath(126,250);
      //  System.out.println(temp.lastElement().getTimeToGetHere()+ParisMetro.toString(temp));
      //  Vector<Vertex> tempDisable = ParisMetro.shortestPathLineClosed(5, 4,30);
      //  System.out.println(tempDisable.lastElement().getTimeToGetHere()+ParisMetro.toString(tempDisable));
    } 
}