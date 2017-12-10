package graphSearch;

import java.util.ArrayList;

public class Node {
	   
    String strValue ="";
    public ArrayList <Node> neighb = new ArrayList <Node>()  ;
    boolean visited = false;
   //constructor
   public  Node( String  name)
   {
   strValue = name;
   }
  

   public void setVisited (boolean bVis)
   {
     visited  = bVis;
   }
  
   public boolean wasVisited()
   {
     return visited ;
   }
  
   public String getName()
   {
     return strValue;
   }

   public void addNeighbour(Node n)
   {
     neighb.add(n);
   }



}

