package bellmanford;
/**
 *
 * @author NSTG
 */
import java.util.*;

public class BellmanFord {
   public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int n;
        int matrix[][] = new int[100][100];
        int sourceNode = 0;
        int distance[] = new int[100];

        System.out.print("Bellman Ford for Single Source Shortest path\n");
             
        System.out.print("Enter number of nodes: ");
        n = scan.nextInt();
        System.out.println();
        

        System.out.println("Enter the matrix: ");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(i+" "+j+": ");
                matrix[i][j] = scan.nextInt();
                if(matrix[i][j] == 0){
                    matrix[i][j] = 555;
                }
            }
            System.out.println();
        }
        
        System.out.println("Enter source node(node numbering starting from 0): ");
        sourceNode = scan.nextInt();
        System.out.println();
                     
        for(int i = 0; i < n; i++){
            distance[i] = 555;
        }
        
        distance[sourceNode] = 0;
   
        for(int j = 0; j < n; j++){
            for(int k = 0; k < n; k++){
                if(matrix[j][k] != 555){
                    if(distance[k] > distance[j] + matrix[j][k]){
                        distance[k] = distance[j] + matrix[j][k];
                    }
                }
            }
        }
               
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] != 555){
                    if (distance[j] > distance[i] + matrix[i][j]){
                        System.out.println("The Graph contains negative egde cycle");
                    }
                }
            }
        }
        
        System.out.println("Shortest distance starting from source as "+sourceNode+"\n");
        for (int i = 0; i < n; i++){
            System.out.println("Distance  from " + sourceNode + " to "
                      + i + " is " + distance[i]);
        }
    } 
}
