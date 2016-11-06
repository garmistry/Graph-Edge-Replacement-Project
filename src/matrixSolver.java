import java.util.*;

/**
 * Created by sagarmistry on 11/6/16.
 */
class Tuple<String,Int>{
    public final String x;
    public final Int y;
    public Tuple(String id, Int weight){
        this.x = id;
        this.y = weight;
    }
    public String getID(){
        return this.x;
    }
    public Int getWeight(){
        return this.y;
    }
}

public class matrixSolver {

    public static int[][] initMatrix(){
        int[][] array = new int[5][5];
        for(int[] row : array){
            Arrays.fill(row,0);
        }
        array[0][1] = 1;
        array[0][2] = 1;
        array[1][0] = 1;
        array[1][3] = 1;
        array[2][0] = 1;
        array[2][3] = 1;
        array[2][4] = 1;
        array[3][1] = 1;
        array[3][2] = 1;
        array[4][2] = 1;


        return array;
    }

    public static int[][] replaceEdges(int[][] array, int failedNode){
        List<Integer> connectedEdges = new ArrayList<Integer>();
        for(int x = 0; x<array.length; x++){                      // Find all nodes connected to the failed Node and store into arraylist
            if(array[failedNode][x] == 1){
                connectedEdges.add(x);
            }
            array[failedNode][x] = 0;
        }
        for(int y = 0; y<connectedEdges.size(); y++){
            int currentNode = connectedEdges.get(y);
            if(checkRow(array,currentNode) == 1 && array[currentNode][failedNode] == 1){
                System.out.println("CurrentNode "+ currentNode + " failedNode "+failedNode);
            }
        }
        return array;
    }
    public static int checkRow(int[][] array, int currentNode){
        int counter = 0;
        for(int x = 0; x<array.length; x++){
            if(array[currentNode][x] == 1){
               counter++;
            }
        }
        return counter;
    }
    public static void main(String args[]) {
        int[][] array = initMatrix();
        int[][] alteredArray = replaceEdges(array, 2);
    }
}