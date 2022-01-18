
public class FloydsAlgorithm
{
    // We select any arbitrary large number to represent infinity
    public static final int infinity = 50000;

    // Our adjacency matrices are 4x4 matrices so this is the size of our matrices
    public static final int numberOfVertices = 4;

    // Program that uses Floyd's algorithm
    public static void main (String[] args)
    {
        int D_matrix[][] = {{0,infinity,-2,infinity},
                {5,0,4,infinity},
                {infinity,infinity,0,3},
                {infinity,-1,infinity,0}};

        char S_matrix[][] = {{'a','b','c','d','e'},
                {'a','b','c','d','e'},
                {'a','b','c','d','e'},
                {'a','b','c','d','e'}};

        FloydsAlgorithm exec = new FloydsAlgorithm();
        exec.allShortestPaths(D_matrix, S_matrix);
    }

    public void allShortestPaths(int D_matrix[][], char S_matrix[][])
    {
        // We create two more matrices so we can modify the entries.
        int D_matrix2[][] = new int[numberOfVertices][numberOfVertices];
        char S_matrix2[][] = new char[numberOfVertices][numberOfVertices];

        int i;
        int j;
        int k;

        char[] letter = new char[] { 'a', 'b', 'c', 'd','e'};

        // We initialize the matrices with the values from the D matrix and the S matrix
        for (i = 0; i < numberOfVertices; i++)
        {
            for (j = 0; j < numberOfVertices; j++)
            {
                D_matrix2[i][j] = D_matrix[i][j];
                S_matrix2[i][j] = S_matrix[i][j];
            }
        }

        // This for loop outputs the first matrix D0 in the sequence of matrices D0,...,Dn
        System.out.println("D0=");

        for (i = 0; i < numberOfVertices; i++)
        {
            for (j = 0; j < numberOfVertices; j++)
            {
                if (D_matrix2[i][j] == infinity)
                {
                    System.out.print("INF\t");
                }
                else
                {
                    System.out.print(D_matrix2[i][j] + "\t");
                }
            }

            System.out.println();
        }

        System.out.println();

        // This for loop outputs the first matrix S0 in the sequence of matrices S0,...,Sn
        System.out.println("S0=");

        for (i = 0; i < numberOfVertices; i++)
        {
            for (j = 0; j < numberOfVertices; j++)
            {
                System.out.print(S_matrix2[i][j] + "\t");
            }

            System.out.println();
        }

        System.out.println();

        // This for loop outputs the matrices D1...Dn in D0,...,Dn and S1...Sn in S0,...,Sn
        for (k = 0; k < numberOfVertices; k++)
        {
            System.out.println("D" + (k + 1) + " =");

            // This outer for loop is for the D matrix; we iterate through the first row of the matrix starting at the first vertex (source vertex)
            for (i = 0; i < numberOfVertices; i++)
            {
                // We select all of the vertices which are reachable from the source vertex
                for (j = 0; j < numberOfVertices; j++)
                {
                    /* If D_matrix2[i][k] + D_matrix2[k][j] is less than D_matrix2[i][j] that means that there is a shorter path available so we update the
					paths in both the D and S matrices and we do this with all pairs of vertices. */
                    if (D_matrix2[i][k] + D_matrix2[k][j] < D_matrix2[i][j])
                    {
                        D_matrix2[i][j] = D_matrix2[i][k] + D_matrix2[k][j];
                        S_matrix2[i][j] = letter[k];
                    }
                    if (D_matrix2[i][j] == infinity || (D_matrix2[i][j] == infinity - 3))
                    {
                        System.out.print("INF\t");
                    }
                    else
                    {
                        System.out.print(D_matrix2[i][j] + "\t");
                    }
                }
                System.out.println();
            }

            System.out.println();

            // This outer loop is for the S matrix; we do the same as above except we are updating the values of the S matrix with the shortest path
            System.out.println("S" + (k + 1) + " =");

            for (i = 0; i < numberOfVertices; i++)
            {
                for (j = 0; j < numberOfVertices; j++)
                {
                    if (D_matrix2[i][k] + D_matrix2[k][j] < D_matrix2[i][j])
                    {

                        System.out.print(S_matrix2[i][j]+"\t");
                    }
                    else
                    {
                        System.out.print(S_matrix2[i][j]+"\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
