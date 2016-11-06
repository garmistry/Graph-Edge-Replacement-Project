
import java.util.ArrayList;

/**
 * Created by sagarmistry on 10/24/16.
 */
public class Vertex {
    public ArrayList<Edge> edgeArrayList;
    public String nodeLabel;

    public Vertex(String name){
        this.nodeLabel = name;
        this.edgeArrayList = new ArrayList<Edge>();
    }

    // If there is an edge already in the list equal, return. Else add to the Vertex's list
    public void addEdge(Edge edge){
        if(this.edgeArrayList.contains(edge)){
            return ;
        }
        this.edgeArrayList.add(edge);
    }

    // Check to see if the vertex contains the edge
    public boolean hasEdge(Edge otherEdge){
        return this.edgeArrayList.contains(otherEdge);
    }
    // get the edge at the given index
    public Edge getNeighborEdge(int index){
        return this.edgeArrayList.get(index);
    }

    Edge removeNeighborEdge(int index){
        System.out.println("Removing Edge " + this.getNeighborEdge(index) + "at index " + index);
       return this.edgeArrayList.remove(index);
    }

    public void removeNeighborEdge(Edge edge){
        this.edgeArrayList.remove(edge);
    }


    public int edgeNeighborhoodSize(){
        return this.edgeArrayList.size();
    }

    public String getVertexName(){
        return this.nodeLabel;
    }

    public String nodeToString(){
        return "Vertex " + nodeLabel;
    }

    public int nodeHashCode(){
        return this.nodeLabel.hashCode();
    }


    public ArrayList<Edge> getNeighbors(){
       return new ArrayList<Edge>(this.edgeArrayList);
   }
}
