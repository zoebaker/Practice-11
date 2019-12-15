public class Judge {

    public int findJudge(int N, int[][] trust){
            Graph graph = new Graph(N);

            for(int row=0; row<trust.length; row++){

                int person_trusting = trust[row][0] - 1;
                int person_who_is_bring_trusted = trust[row][1] - 1;

                graph.addEdge(person_trusting, person_who_is_bring_trusted);
            }


            int[][] adjacency_matrix = graph.getAdjacencyMatix();
            for(int person=0; person<adjacency_matrix.length; person++){
                if(checkPerson(adjacency_matrix[person], person, adjacency_matrix)){
                    return person + 1;
                }
            }

            return -1;
        }

        public boolean isRowEmpty(int[] row){
            boolean empty = true;

            for(int i=0; i<row.length; i++){
                if(row[i] == 1)
                    empty = false;
            }

            return empty;
        }


        public boolean isColFull(int col, int[][] a){
            boolean full = true;

            for(int i=0; i<col; i++){
                if(a[i][col] == 0)
                    full = false;
            }

            if(a[col][col]!=0)
                full = false;

            for(int j=col+1; j<a.length; j++){
                if(a[j][col] == 0)
                    full = false;
            }

            return full;
        }

        public boolean checkPerson(int[] row, int col, int[][]a){
            return isRowEmpty(row) && isColFull(col, a);
        }

        public static void main(String[] args) {
            Judge judge = new Judge();
            int[][] example_1 = {{1,2}};
            int answer1 = judge.findJudge(2, example_1);

            int[][] example_2 = {{1,3}, {2,3}};
            int answer2 = judge.findJudge(3, example_2);

            int[][] example_5 = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4,3}};
            int answer5 = judge.findJudge(4, example_5);

            int[][] example_3 = {{1, 3}, {2, 3}, {3,1}};
            int answer3 = judge.findJudge(3, example_3);

            int[][] example_4 = {{1,2},{2,3}};
            int answer4 = judge.findJudge(3, example_4);


            System.out.println (answer1);

            System.out.println (answer2);

            System.out.println(answer3);

            System.out.println(answer4);

            System.out.println(answer5);




        }

    }

