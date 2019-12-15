import java.util.*;

public class Graph{
        private int[][] adjmatrix;
        public Graph(int vertices){
            adjmatrix = new int[vertices][vertices];
        }

        public void addEdge(int v1, int v2){
            adjmatrix[v1][v2] = 1;
        }

        public List<Integer> neighbors(int vertex) throws Exception{
            if(vertex<0 || vertex>=adjmatrix.length)
                throw new Exception("Vertex is out of bounds");
            List<Integer> list = new LinkedList<Integer>();
            for(int i=0; i<adjmatrix[vertex].length; i++){
                if(adjmatrix[vertex][i] == 1)
                    list.add(i);
            }

            return list;
        }

        public int findzero(int[] a){
            for(int i=0; i<a.length; i++){
                if(a[i] == 0)
                    return i;
            }
            return -1;
        }

        public List<Integer> topologicalSort(){
            List<Integer> list = new LinkedList<Integer>();

            int[] sum = new int[adjmatrix.length];
            for(int i=0; i<adjmatrix.length; i++)
                for(int j=0; j<adjmatrix[i].length; j++)
                    sum[i] += adjmatrix[j][i];

            for(int count=0; count<adjmatrix.length; count++){
                int next = findzero(sum);
                list.add(next);
                sum[next] = -1;
                for(int i=0; i<sum.length; i++)
                    sum[i] -= adjmatrix[next][i];
            }

            return list;
        }

        public int[][] getAdjacencyMatix(){
            return adjmatrix;
        }
    }

