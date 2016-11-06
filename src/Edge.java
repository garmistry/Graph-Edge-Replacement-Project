/**
 * Created by sagarmistry on 10/24/16.
 */
public class Edge {
    public Vertex V1, V2;
    public int weight;
    // Initialization of an Edge Object. Using Weight 1 for standard unweighted patterns.
    public Edge(Vertex v1, Vertex v2){
        this(v1,v2,1);
    }
    public Edge(Vertex v1, Vertex v2, int weight){
        this.V1 = v1;
        this.V2 = v2;
        this.weight = weight;
    }

    public Vertex getV1(){
        return this.V1;
    }

    public Vertex getV2(){
        return this.V2;
    }

    public int getWeight(){
        return this.weight;
    }

    public void setWeight(int newWeight){
        this.weight = newWeight;
    }

    public Vertex getNeighbor(Vertex currVertex){
        if (currVertex.equals(V1)){
            return V1;
        }
        else if(currVertex.equals(V2)){
            return V2;
        }
        return null;
    }

    public int compareTo(Edge other){
        return this.weight - other.weight;
    }

    public String toString(){
        return "( V1: "+ V1.getVertexName() +" , V2: " + V2.getVertexName()+ "), Weight: "+ weight;
    }

    public int hashCode(){
        return(V1.getVertexName() + V2.getVertexName()).hashCode();
    }

    public boolean equals(Edge other){
        return other.V1.equals(this.V1) && other.V2.equals(this.V2);
    }

}
