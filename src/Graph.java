

import java.util.*;

public class Graph {
    private HashMap<String, Vertex> vertices;
    private HashMap<Integer, Edge> edges;
    private int[][] matrix;

    public Graph(){
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();
        this.matrix = new int[5][5];

    }

    public Graph(ArrayList<Vertex> vertices){
        this.vertices = new HashMap<String,Vertex>();
        this.edges = new HashMap<Integer, Edge>();
        this.matrix = new int[vertices.size()][vertices.size()];

        for(Vertex v: vertices){
            this.vertices.put(v.getVertexName(), v);
        }
    }



    public boolean addEdge( Vertex v1, Vertex v2){
        return addEdge(v1,v2,1);
    }


    public boolean addEdge(Vertex v1, Vertex v2, int weight){
        if(v1.equals(v2)){
            return false;
        }

        //ensures the Edge is not in the Graph
        Edge newEdge= new Edge(v1, v2, weight);
        if(edges.containsKey(newEdge.hashCode())){
            return false;
        }

        //and that the Edge isn't already incident to one of the vertices
        else if(v1.hasEdge(newEdge) || v2.hasEdge(newEdge)){
            return false;
        }

        edges.put(newEdge.hashCode(), newEdge);
        v1.addEdge(newEdge);
        v2.addEdge(newEdge);
        matrix[Integer.parseInt(v1.getVertexName())][Integer.parseInt(v2.getVertexName())] = 1;

        return true;
    }

    public boolean containsEdge(Edge edge){
        if (edge.getV1() == null || edge.getV2() == null) {
            return false;
        }
        return this.edges.containsKey(edge.hashCode());
    }

    public Edge removeEdge(Edge edge){
        edge.getV1().removeNeighborEdge(edge);
        edge.getV2().removeNeighborEdge(edge);
        return this.edges.remove(edge.hashCode());
    }

    public boolean containsVertex(Vertex currVertex){
        if(this.vertices.get(currVertex.getVertexName()) != null) {
            return true;
        }
        return false;
    }

    public Vertex getVertex(String name){
        return vertices.get(name);
    }

    public boolean addVertex(Vertex vertex, boolean overwriteExisting){
        Vertex current = this.vertices.get(vertex.getVertexName());
        if(current != null){
            if(!overwriteExisting){
                return false;
            }
            while(current.edgeNeighborhoodSize() > 0){
                this.removeEdge(current.getNeighborEdge(0));
            }
        }
        vertices.put(vertex.getVertexName(), vertex);
        System.out.println(Integer.parseInt(vertex.getVertexName()));
        return true;
    }

    public boolean initializeMatrix(int size){
        for(int x = 0; x<size; x++){
            for( int y = 0; y<size; y++){
                this.matrix[x][y] = 0;
            }
        }
        return true;
    }

    public Vertex removeVertex(String label){
        Vertex v = vertices.remove(label);

        while(v.edgeNeighborhoodSize() > 0){
            this.removeEdge(v.getNeighborEdge((0)));
        }

        return v;
    }

    public Set<String> vertexKeys(){
        return this.vertices.keySet();
    }
    public Set<Edge> getEdges(){
        return new HashSet<Edge>(this.edges.values());
    }
}

